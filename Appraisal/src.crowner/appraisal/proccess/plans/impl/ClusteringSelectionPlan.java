package appraisal.proccess.plans.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entities.dataset.Cluster;
import entities.dataset.Dataset;
import entities.dataset.Tuple;
import entities.results.ClusteringResult;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.RegressionResult;
import entities.results.SelectionResult;

import appraisal.proccess.plans.Plan;
import appraisal.proccess.stages.ClusteringStage;
import appraisal.proccess.stages.RegressionStage;
import appraisal.proccess.stages.SelectionStage;


public class ClusteringSelectionPlan extends Plan
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ClusteringSelectionPlan.class);
	
	//
	// Atributos
	// 
	ClusteringStage clusteringStage;
	SelectionStage selectionStage;
	RegressionStage regressionStage;
	
	//
	// GC Limit
	//
	boolean gcenabled;
	int gclimit;
	int gccount;
	
	public ClusteringSelectionPlan (ClusteringStage clusteringStage, SelectionStage selectionStage, RegressionStage regressionStage)
	{
		this.clusteringStage = clusteringStage;
		this.selectionStage = selectionStage;		
		this.regressionStage = regressionStage;		
		
		// Lê arquivo de propriedades
		ResourceBundle properties = ResourceBundle.getBundle("appraisal.strategies");
		String limit = properties.getString("gc.limit");
		
		if (limit.equals("none"))
		{
			gclimit = -1;			
		}
		else
		{
			gcenabled=true;
			gclimit = Integer.parseInt(limit);
			gccount = 1;
		}
	}

	
	//
	// Método Principal
	//
	
	public PlanResult runPlan(Dataset dataset, String regressionColumn, Dataset originalColumn)
	{
		LOGGER.info("## PLANO DE CLUSTERIZAÇÃO, SELEÇÃO E REGRESSÃO ##");
		LOGGER.info(">> Etapa de Clusterização: "+clusteringStage.getClass().getSimpleName());
		LOGGER.info(">> Etapa de Seleção: "+selectionStage.getClass().getSimpleName());
		LOGGER.info(">> Etapa de Regressão: "+regressionStage.getClass().getSimpleName());

		// Variável de retorno
		PlanResult planResult = new PlanResult(clusteringStage.getClass().getSimpleName(),
											   selectionStage.getClass().getSimpleName(),
											   regressionStage.getClass().getSimpleName());
		
		// 1. Monta as colunas selecionadas
		List<String> columns = dataset.getColumns();
		columns.remove(regressionColumn);
		
		// 3. Prepara Clusterização
		clusteringStage.resetCombinations(2,dataset.splitTrainTest(regressionColumn)[0].getTupleCount(),1);
		
		do
		{
			// Marca tempo
			long start = System.currentTimeMillis();
			
			// 3.1. Trata valores ausentes
			dataset.pairWiseDeletion(columns);
			
			// 3.2. Realiza clusterização
			ClusteringResult cr = clusteringStage.run(dataset, regressionColumn);
			
			// 4. Prepara Seleção
			selectionStage.resetCombinations(1,dataset.getColumnCount()-2,1);
			
			do
			{
				// Marca tempo
				if (start==0) start = System.currentTimeMillis();
				
				// 5. Prepara Regressão
				regressionStage.resetCombinations(1,cr.getMostTrainTupleCount(regressionColumn),1);
				Map<Integer,RegressionResult> clustersCacheRegression = new HashMap<Integer,RegressionResult>();
				
				do
				{
					// 5.1. Realiza regressão
					List<Cluster> clusters = cr.getClusters();
					
					// Marca tempo
					if (start==0) start = System.currentTimeMillis();
					
					Dataset finalTrainDataset = new Dataset(regressionColumn);
					Dataset finalTargetDataset = new Dataset(regressionColumn);
					
					boolean validInstance = true;
					
					for (int i=0 ; i<clusters.size() ; i++) 
					{	
						Cluster cluster = clusters.get(i);
						
						if (!validateCluster(cluster,regressionColumn))
						{
							validInstance = false;
							break;
						}
						
						if (!cluster.isEmpty())
						{
							Dataset clusterDataset = cluster.getClusterDataset();
							
							Dataset pcaDataset = clusterDataset.copyDataset();
							pcaDataset.removeColumn(regressionColumn);
							
							// 4.2. Etapa de seleção
							SelectionResult selectionResult = selectionStage.run(pcaDataset);
							List<String> selectedColumns = selectionResult.getAttributes();
											
							// 4.3. Etapa de Regressão
							Dataset[] splitDataset = clusterDataset.splitTrainTest(regressionColumn);
								
							Dataset trainDataset = splitDataset[0];
							Dataset targetDataset = splitDataset[1];
												
							if (trainDataset.getTupleCount() <=1)
							{
								validInstance = false;
								break;
							}
													
							RegressionResult rr = regressionStage.run(selectedColumns, regressionColumn, trainDataset, targetDataset);
							
							if (rr == null)
								rr = clustersCacheRegression.get(i);
							else
							{
								clustersCacheRegression.put(i,rr);
							}	
							
							finalTargetDataset.mergeDataset(rr.getTargetDataRegression());
							finalTrainDataset.mergeDataset(rr.getTrainDataRegression());							
						}
					}
					
					// Marca tempo
					long end = System.currentTimeMillis();
					String rrId = regressionStage.getPresentCombination()+";"+selectionStage.getPresentCombination()+";"+clusteringStage.getPresentCombination();
					LOGGER.debug("("+((double)(end-start)/1000)+"s) \t"+rrId);
									
					if (validInstance)
					{
						RegressionResult rr = new RegressionResult(finalTrainDataset,finalTargetDataset);
						planResult.addInstance(new InstanceResult(rrId,rr,end-start));
						
						// 5. Se há mais de um, compara o melhor
						if (planResult.getResults().size() > 1)
							planResult.dropWorstResults(originalColumn);
					}
							
					start=0;		
					
					// Controla garbage collection
					if (gcenabled)
					{
						if (gccount < gclimit)
						{
							gccount++;
						}
						else
						{
							gccount=1;
							System.gc();
							LOGGER.debug("Forcing garbage collection...");
						}
					}	
				}
				while(regressionStage.nextCombination());
			}
			while(selectionStage.nextCombination());
		}
		while(clusteringStage.nextCombination());
		
		return planResult;
	}
	
	private boolean validateCluster(Cluster cluster,String regressionColumn) 
	{
		if (cluster.isEmpty())
			return true;
		
		Dataset dataset = cluster.getClusterDataset();
		
		for (Iterator<Tuple> iter = dataset.getTuples(); iter.hasNext();)
		{
			Tuple tuple = iter.next();
			
			if (!tuple.hasNullValues())
				return true;
		}
		
		return false;
	}
}
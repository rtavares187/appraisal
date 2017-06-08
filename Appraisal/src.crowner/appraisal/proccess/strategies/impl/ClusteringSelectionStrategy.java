package appraisal.proccess.strategies.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import appraisal.proccess.plans.Plan;
import appraisal.proccess.plans.impl.ClusteringSelectionPlan;
import appraisal.proccess.stages.ClusteringStage;
import appraisal.proccess.stages.RegressionStage;
import appraisal.proccess.stages.SelectionStage;
import appraisal.proccess.stages.impl.AvgStage;
import appraisal.proccess.stages.impl.BkPropStage;
import appraisal.proccess.stages.impl.KMeansStage;
import appraisal.proccess.stages.impl.KnnStage;
import appraisal.proccess.stages.impl.PcaStage;
import appraisal.proccess.stages.impl.PsoStage;
import appraisal.proccess.strategies.Strategy;
import appraisal.writer.ResultWriter;
import entities.dataset.Dataset;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.StrategyResult;


public class ClusteringSelectionStrategy implements Strategy 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ClusteringSelectionStrategy.class);
	
	// Atributos
	boolean pso;
	boolean kmeans;
	boolean knn;
	boolean bkprop;
	boolean avg;
		
	public ClusteringSelectionStrategy(boolean pso,	boolean kmeans,	boolean knn, boolean bkprop, boolean avg)
	{
		this.pso = pso;
		this.kmeans = kmeans;
		this.knn = knn;
		this.bkprop = bkprop;
		this.avg = avg;
	}
	
	public StrategyResult runStrategy(Dataset originalColumn, Dataset fullDataset, String regressionColumn) 
	{
		LOGGER.info("### ESTRATÉGIA DE CLUSTERIZAÇÃO, SELEÇÃO E REGRESSÃO ###");
		LOGGER.info("Montando diferentes planos de execução");

		// Montando etapas
		List<ClusteringStage> clusteringStages = new ArrayList<ClusteringStage>();
		if (kmeans)	clusteringStages.add(new KMeansStage());
		if (pso) clusteringStages.add(new PsoStage());
		
		List<SelectionStage> selectionStages = new ArrayList<SelectionStage>();
		selectionStages.add(new PcaStage());
				
		List<RegressionStage> regressionStages = new ArrayList<RegressionStage>();
		if (knn) regressionStages.add(new KnnStage());
		if (bkprop) regressionStages.add(new BkPropStage());
		if (avg) regressionStages.add(new AvgStage());
						
		// Montando planos
		List<Plan> plans = new ArrayList<Plan>();
		
		for (ClusteringStage clusteringStage : clusteringStages) 
		{
			for (SelectionStage selectionStage : selectionStages)
			{
				for (RegressionStage regressionStage : regressionStages)
				{
					ClusteringSelectionPlan plan = new ClusteringSelectionPlan(clusteringStage,selectionStage,regressionStage);
					plans.add(plan);
				}
			}
		}
				
		// Executando os planos
		List<PlanResult> planResults = new ArrayList<PlanResult>();
		
		for (Plan plan : plans) 
		{
			PlanResult planResult = plan.runPlan(fullDataset.copyDataset(), regressionColumn, originalColumn);
			planResults.add(planResult);
			
			// Verifica a melhor instância
			InstanceResult best = planResult.getResults().get(0);
			LOGGER.debug("Tempo: "+(planResult.getTime())+"s");
			LOGGER.debug("Instância: "+best.getId());
			LOGGER.debug("Resultado: "+best.getRegressionResult().getTargetDataRegression());
			
			// Escreve resultados parciais no disco
			ResultWriter.writeCrudeResults(new StrategyResult("clustering.selection.regression",planResults) );
			
			// Limpa a memória
			System.gc();
		}
		
		// Consolidando os planos na estratégia
		StrategyResult strategyResult = new StrategyResult("clustering.selection.regression",planResults);
				
		// Retorno
		return strategyResult;
	}
}
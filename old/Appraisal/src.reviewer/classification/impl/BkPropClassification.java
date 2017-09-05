package classification.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;
import entities.dataset.Tuple;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.StrategyResult;

public class BkPropClassification
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(BkPropClassification.class);
	
	// Número de Ciclos
	private static int cycles;
	
	static
	{
		ResourceBundle properties = ResourceBundle.getBundle("classification.classificator");
		cycles = Integer.parseInt(properties.getString("bkprop.cycles"));
	}
	
	public static void crossValidate(Dataset codifiedDataset,List<StrategyResult> regressionResults,String regressionColumn,Dataset targetDataset)
	{
		LOGGER.info("### VALIDAÇÃO ###");
		LOGGER.info(">> Treinando a rede...");
		
		// ##################### //
		//    	  TREINO 		 //
		// ##################### //	
		
		// 1. Divide os dados codificados para treinamento
		Dataset[] splitDatasets = splitCodifiedTrainTest(codifiedDataset,targetDataset);
		
		Dataset trainInputDataset = splitDatasets[2];
		Dataset trainOutputDataset = splitDatasets[3];
		Dataset targetInputDataset = splitDatasets[0];
		Dataset targetOutputDataset = splitDatasets[1];
				
		// 2. Calcula valores máximos e mínimos
		DatabaseHandler handler = MySQLHandler.getInstance();
		double maxValue = handler.getMaxValue(codifiedDataset.getColumns());
		double minValue = handler.getMinValue(codifiedDataset.getColumns());
		
		// BKPROP - Recupera parâmetros
		Integer inputNeurons = trainInputDataset.getColumnCount();
		Integer hiddenNeurons = (inputNeurons*2)-1;
		Integer outputNeurons = trainOutputDataset.getColumnCount();
		
		Double  learningRate = 0.5;
		Double  momentum = 0.7;
		
		// BKPROP - Processa o BkProp com os parâmetros dados
		BkPropModel bkPropModel = new BkPropModel(cycles,learningRate,momentum,inputNeurons,hiddenNeurons,outputNeurons,maxValue,minValue);
		BkPropAlgorithm bkPropAlgorithm = new BkPropAlgorithm(bkPropModel);
		
		// Treina a rede
		bkPropAlgorithm.trainNetwork(trainInputDataset, trainOutputDataset);

		LOGGER.info(">> Consultando a rede...");
		
		// ##################### //
		//    	  TESTE 		 //
		// ##################### //

		for (StrategyResult strategyResult : regressionResults) 
		{
			for (PlanResult planResult : strategyResult.getPlanResults())
			{
				// Recupera melhor instância
				InstanceResult instanceResult = planResult.getResults().get(0);
				
				// Monta dataset query dataset
				Dataset queryDataset = makeQueryDataset(instanceResult, regressionColumn, codifiedDataset, targetInputDataset);
				
				// Consulta a rede
				Dataset resultDataset = bkPropAlgorithm.queryNetwork(queryDataset);		
				
				// Calcula o índice de crossFolder
				float crossFolder = calculateCrossFolderIndex(targetOutputDataset, resultDataset);
				instanceResult.addCrossFolder(crossFolder);
				
				LOGGER.debug(planResult.getId()+": \t "+crossFolder*100+"%");
			}			
		}		
	}

	private static float calculateCrossFolderIndex(Dataset targetOutputDataset, Dataset resultDataset) 
	{
		int crossFolder = 0;
		int totalTuples = targetOutputDataset.getTupleCount();
		
		Iterator<Tuple> originalIterator = targetOutputDataset.getTuples(); 
		Iterator<Tuple> regressionIterator = resultDataset.getTuples();
		
		while (originalIterator.hasNext()) 
		{
			Tuple originalTuple = originalIterator.next();
			Tuple regressionTuple = regressionIterator.next();
						
			List<Number> originalValues = originalTuple.getValues();
			List<Number> regressionValues = regressionTuple.getValues();
			
			for (int i = 0; i < originalValues.size(); i++) 
			{
				Number originalValue = originalValues.get(i);
				Number regressionValue = regressionValues.get(i); 
				
				if (!originalValue.equals(regressionValue))
				{
					crossFolder++;
					break;
				}
			}
		}
		
		return ((float)crossFolder/totalTuples);
	}

	private static Dataset makeQueryDataset(InstanceResult instanceResult, String regressionColumn, Dataset codifiedDataset, Dataset targetInputDataset) 
	{	
		// Recupera coluna regredida		
		Dataset 	   regressionDataset = instanceResult.getRegressionResult().getTargetDataRegression();
		
		// Compõe dataset de consulta
		Dataset queryDataset = new Dataset(targetInputDataset.getColumns());
		
		Iterator<Tuple> originalIterator = targetInputDataset.getTuples(); 
		Iterator<Tuple> regressionIterator = regressionDataset.getTuples();
		
		while (originalIterator.hasNext()) 
		{
			List<String> columns = queryDataset.getColumns();
		
			Tuple originalTuple = originalIterator.next();
			Tuple regressionTuple = regressionIterator.next();					

			int id = originalTuple.getId();
			List<Number> tupleValues = new ArrayList<Number>();
			
			for (String column : columns) 
			{
				if (column.equals(regressionColumn))
				{
					tupleValues.add(regressionTuple.getValue(0));
				}
				else
				{
					tupleValues.add(originalTuple.getValue(column));
				}
			}
			
			Tuple newTuple = new Tuple(id,tupleValues);
			queryDataset.addTuple(newTuple);
		}
		return queryDataset;
	}

	private static Dataset[] splitCodifiedTrainTest(Dataset codifiedDataset,Dataset train)
	{
		List<String> inputColumns = new ArrayList<String>();
		List<String> outputColumns = new ArrayList<String>();
		
		List<String> allColumns = codifiedDataset.getColumns();
			
		for (String column : allColumns) 
		{
			if (column.startsWith("class"))
			{
				outputColumns.add(column);
			}
			else
			{
				inputColumns.add(column);
			}
		}
		
		Dataset trainInputDataset = new Dataset(inputColumns);
		Dataset trainOutputDataset = new Dataset(outputColumns);
		
		Dataset targetInputDataset = new Dataset(inputColumns);
		Dataset targetOutputDataset = new Dataset(outputColumns);
		
		Iterator<Tuple> targetIterator = train.getTuples();
		Iterator<Tuple> codifiedIterator = codifiedDataset.getTuples();
		
		while(codifiedIterator.hasNext())
		{
			if (targetIterator.hasNext())
			{				
				Tuple targetTuple = targetIterator.next();
				int   targetId = targetTuple.getId();
										
				Tuple codifiedTuple = codifiedIterator.next();
				int   codifiedId = codifiedTuple.getId();
							
				while(codifiedId < targetId)
				{
					List<Number> inputValues = new ArrayList<Number>();
					List<Number> outputValues = new ArrayList<Number>();
					
					for (String column : inputColumns)
					{
						Number value = codifiedTuple.getDoubleValue(column);
						inputValues.add(value);
					}
					
					for (String column : outputColumns)
					{
						Number value = codifiedTuple.getDoubleValue(column);
						outputValues.add(value);
					}
					
					Tuple inputTuple = new Tuple(codifiedId,inputValues);
					Tuple outputTuple = new Tuple(codifiedId,outputValues);
					
					trainInputDataset.addTuple(inputTuple);
					trainOutputDataset.addTuple(outputTuple);
					
					codifiedTuple = codifiedIterator.next();
					codifiedId = codifiedTuple.getId();
				}
				
				List<Number> inputValues = new ArrayList<Number>();
				List<Number> outputValues = new ArrayList<Number>();
				
				for (String column : inputColumns)
				{
					Number value = codifiedTuple.getDoubleValue(column);
					inputValues.add(value);
				}
				
				for (String column : outputColumns)
				{
					Number value = codifiedTuple.getDoubleValue(column);
					outputValues.add(value);
				}
				
				Tuple inputTuple = new Tuple(codifiedId,inputValues);
				Tuple outputTuple = new Tuple(codifiedId,outputValues);
				
				targetInputDataset.addTuple(inputTuple);
				targetOutputDataset.addTuple(outputTuple);
			}
			else
			{
				Tuple codifiedTuple = codifiedIterator.next();
				int   codifiedId = codifiedTuple.getId();
							
				List<Number> inputValues = new ArrayList<Number>();
				List<Number> outputValues = new ArrayList<Number>();
				
				for (String column : inputColumns)
				{
					Number value = codifiedTuple.getDoubleValue(column);
					inputValues.add(value);
				}
				
				for (String column : outputColumns)
				{
					Number value = codifiedTuple.getDoubleValue(column);
					outputValues.add(value);
				}
				
				Tuple inputTuple = new Tuple(codifiedId,inputValues);
				Tuple outputTuple = new Tuple(codifiedId,outputValues);
				
				trainInputDataset.addTuple(inputTuple);
				trainOutputDataset.addTuple(outputTuple);
				
				if (codifiedIterator.hasNext())
				{
					codifiedTuple = codifiedIterator.next();
					codifiedId = codifiedTuple.getId();
				}
			}
		}
		
		return new Dataset[]{trainInputDataset,trainOutputDataset,targetInputDataset,targetOutputDataset};
	}
}
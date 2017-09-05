package comite.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import comite.Comite;

import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;
import entities.dataset.Tuple;
import entities.results.RegressionResult;


public class BkPropComite implements Comite 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(BkPropComite.class);
	
	// Número de Ciclos
	int cycles;
	
	public BkPropComite()
	{
		ResourceBundle properties = ResourceBundle.getBundle("comite.comite");
		cycles = Integer.parseInt(properties.getString("bkprop.cycles"));
	}
	
	public RegressionResult run(String regressionColumn, Dataset fullDataset, List<Dataset> trainSuggestions, List<Dataset> targetSuggestions) 
	{
		LOGGER.info("### COMITE DE REGRESSÃO ###");
		LOGGER.info(">> Treinando a rede...");
		
		// 1. Prepara conjuntos de dados
		Dataset[] split = fullDataset.splitTrainTest(regressionColumn);
		
		Dataset trainDataset = split[0];
		Dataset targetDataset = split[1];
				
		Dataset trainRegressionColumn = trainDataset.copyColumn(regressionColumn);
		trainDataset.removeColumn(regressionColumn);
		
		// 2. Calcula valores máximos e mínimos
		DatabaseHandler handler = MySQLHandler.getInstance();
		double maxValue = handler.getMaxValue(fullDataset.getColumns());
		double minValue = handler.getMinValue(fullDataset.getColumns());
				
		// 3. Monta lista com dados do Dataset combinado
		List<String> inputColumns = makeColumnsList(regressionColumn, trainSuggestions, trainDataset);
				
		// 4. Combina os dados originais com as sugestões
		Dataset inputDataset = combineDatasets(inputColumns, trainDataset, trainSuggestions);
		Dataset teachDataset = trainRegressionColumn;
		
		Dataset queryDataset = combineDatasets(inputColumns, targetDataset, targetSuggestions);
		
		// BKPROP - Recupera parâmetros
		Integer inputNeurons = trainDataset.getColumnCount()+trainSuggestions.size();
		Integer hiddenNeurons = (inputNeurons*2)-1;
		Integer outputNeurons = 1;
		
		Double  learningRate = 0.5;
		Double  momentum = 0.7;
		
		// BKPROP - Processa o BkProp com os parâmetros dados
		BkPropModel bkPropModel = new BkPropModel(cycles,learningRate,momentum,inputNeurons,hiddenNeurons,outputNeurons,maxValue,minValue);
		BkPropAlgorithm bkPropAlgorithm = new BkPropAlgorithm(bkPropModel);
		
		// Treina a rede
		bkPropAlgorithm.trainNetwork(inputDataset, teachDataset);
		
		// Regride os conjuntos de teste e treino
		LOGGER.info(">> Consultando a rede...");
		Dataset regressionDataset = bkPropAlgorithm.queryNetwork(queryDataset);

		RegressionResult rr = new RegressionResult(new Dataset(regressionColumn),regressionDataset);
		
		LOGGER.debug("Resultado: "+rr.getTargetDataRegression().toString());
		
		return rr;		
	}

	private Dataset combineDatasets(List<String> inputColumns, Dataset trainDataset, List<Dataset> trainSuggestions) {
		Iterator<Tuple> originalIterator = trainDataset.getTuples(); 
		List<Iterator<Tuple>> suggestionsIterators = new ArrayList<Iterator<Tuple>>();
		
		for (int i=0;i<trainSuggestions.size();i++) 
		{
			suggestionsIterators.add(trainSuggestions.get(i).getTuples());
		}
		
		// Consolida a base de treino
		Dataset inputDataset = new Dataset(inputColumns);
		
		for (int i=0;i<trainDataset.getTupleCount();i++)
		{
			// Recupera Tuples
			Tuple originalTuple = originalIterator.next();
			List<Tuple> suggestionTuple = new ArrayList<Tuple>();
			
			for (Iterator<Tuple> iterator : suggestionsIterators) 
			{
				suggestionTuple.add(iterator.next());
			}
			
			// Monta ID
			int id = originalTuple.getId();
			
			// Monta Valores
			List<Number> newValues = new ArrayList<Number>();
			newValues.addAll(originalTuple.getValues());
			
			for (Tuple tuple : suggestionTuple) 
			{
				newValues.addAll(tuple.getValues());
			}
			
			Tuple newTuple = new Tuple(id,newValues);
			inputDataset.addTuple(newTuple);
		}
		return inputDataset;
	}

	private List<String> makeColumnsList(String regressionColumn, List<Dataset> trainSuggestions, Dataset trainDataset) {
		List<String> inputColumns = new ArrayList<String>();
		inputColumns.addAll(trainDataset.getColumns());
		
		for (int i=0;i<trainSuggestions.size();i++) 
		{
			inputColumns.add(regressionColumn+""+i);
		}
		return inputColumns;
	}
}
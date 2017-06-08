package appraisal.proccess.stages.impl;

import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.DynamicPropertiesCombiner;
import entities.dataset.Dataset;
import entities.results.RegressionResult;

import appraisal.algorithms.knn.KnnAlgorithm;
import appraisal.algorithms.knn.KnnModel;
import appraisal.proccess.stages.RegressionStage;


public class KnnStage extends RegressionStage
{
	// Logger
	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(KnnStage.class);
	
	public KnnStage()
	{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("appraisal.knn");
		propertiesCombiner = new DynamicPropertiesCombiner(resourceBundle,
														"knn.k",
														"knn.distance");
	}
	
	public RegressionResult run(List<String> columns, String regressionColumn, Dataset trainDataset, Dataset targetDataset) 
	{
		// Recupera parâmetros
		Integer k = propertiesCombiner.getIntegerProperty("knn.k");
		String  distance = propertiesCombiner.getStringProperty("knn.distance");
		String  strategy = propertiesCombiner.getStringProperty("knn.strategy");
		
		// Testa por uma configuração inválida
		if (k > trainDataset.getTupleCount())
			return null;
		
		// Processa o KNN com os parâmetros dados
		KnnModel 	  knnModel 		= new KnnModel(k,strategy,distance);
		KnnAlgorithm  knnAlgorithm  = new KnnAlgorithm(knnModel);
		
		RegressionResult rr = knnAlgorithm.regress(columns, regressionColumn, trainDataset, targetDataset);
		
		return rr;
	}
}
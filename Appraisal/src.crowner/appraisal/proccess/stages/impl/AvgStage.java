package appraisal.proccess.stages.impl;

import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.DynamicPropertiesCombiner;
import entities.dataset.Dataset;
import entities.results.RegressionResult;

import appraisal.algorithms.avg.AvgAlgorithm;
import appraisal.algorithms.avg.AvgModel;
import appraisal.proccess.stages.RegressionStage;


public class AvgStage extends RegressionStage
{
	// Logger
	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(AvgStage.class);
	
	public AvgStage()
	{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("appraisal.avg");
		propertiesCombiner = new DynamicPropertiesCombiner(resourceBundle,
														"avg.type",
														"avg.disturb");
														
	}
	
	public RegressionResult run(List<String> columns, String regressionColumn, Dataset trainDataset, Dataset targetDataset) 
	{
		// Recupera parâmetros
		String  type = propertiesCombiner.getStringProperty("avg.type");
		boolean disturb = propertiesCombiner.getBooleanProperty("avg.disturb");
		
		// Trata valores ausentes nas colunas
		trainDataset.pairWiseDeletion(columns);
		targetDataset.pairWiseDeletion(columns);
		
		// Processa o AVG com os parâmetros dados
		AvgModel 	  avgModel 		= new AvgModel(type,disturb);
		AvgAlgorithm  avgAlgorithm  = new AvgAlgorithm(avgModel);
		
		RegressionResult rr = avgAlgorithm.regress(regressionColumn, trainDataset, targetDataset);
		
		return rr;
	}
}
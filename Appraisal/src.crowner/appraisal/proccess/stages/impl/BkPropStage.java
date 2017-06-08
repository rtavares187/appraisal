package appraisal.proccess.stages.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.DynamicPropertiesCombiner;

import appraisal.algorithms.bkprop.BkPropAlgorithm;
import appraisal.algorithms.bkprop.BkPropModel;
import appraisal.proccess.stages.RegressionStage;

import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;
import entities.results.RegressionResult;


public class BkPropStage extends RegressionStage
{
	// Logger
	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(BkPropStage.class);
	
	public BkPropStage()
	{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("appraisal.bkprop");
		propertiesCombiner = new DynamicPropertiesCombiner(resourceBundle,
														"bkprop.cycles",
														"bkprop.learningRate",
														"bkprop.momentum");
	}
	
	public RegressionResult run(List<String> selectedColumns, String regressionColumn, Dataset trainDataset, Dataset targetDataset) 
	{
		// Calcula valores máximos e mínimos
		List<String> numericColumns = new ArrayList<String>(selectedColumns);
		numericColumns.add(regressionColumn);
		
		DatabaseHandler handler = MySQLHandler.getInstance();
		double maxValue = handler.getMaxValue(numericColumns);
		double minValue = handler.getMinValue(numericColumns);
		
		// Recupera parâmetros
		Integer inputNeurons = selectedColumns.size();
		Integer hiddenNeurons = (inputNeurons*2)-1;
		Integer outputNeurons = 1;
		
		Integer cycles = propertiesCombiner.getIntegerProperty("bkprop.cycles");
		Double  learningRate = propertiesCombiner.getDoubleProperty("bkprop.learningRate");
		Double  momentum = propertiesCombiner.getDoubleProperty("bkprop.momentum");
		
		// Prepara os dados
		Dataset inputDataset = trainDataset.copyDataset(selectedColumns);
		Dataset outputDataset = trainDataset.copyColumn(regressionColumn);
		Dataset queryDataset = targetDataset.copyDataset(selectedColumns);
		
		// Trata valores ausentes
		inputDataset.pairWiseDeletion(selectedColumns);
		queryDataset.pairWiseDeletion(selectedColumns);
		
		// Processa o BkProp com os parâmetros dados
		BkPropModel bkPropModel = new BkPropModel(cycles,learningRate,momentum,inputNeurons,hiddenNeurons,outputNeurons,maxValue,minValue);
		BkPropAlgorithm bkPropAlgorithm = new BkPropAlgorithm(bkPropModel);
		
		// Treina a rede
		bkPropAlgorithm.trainNetwork(inputDataset, outputDataset);
		
		// Regride os conjuntos de teste e treino
		Dataset targetRegressionDataset;
		Dataset trainRegressionDataset;
		
		if (!queryDataset.isEmpty())
			targetRegressionDataset = bkPropAlgorithm.queryNetwork(queryDataset);
		else
			targetRegressionDataset = new Dataset(regressionColumn);
		
		if (!inputDataset.isEmpty())
			trainRegressionDataset = bkPropAlgorithm.queryNetwork(inputDataset);
		else
			trainRegressionDataset = new Dataset(regressionColumn);
			
		RegressionResult rr = new RegressionResult(trainRegressionDataset,targetRegressionDataset);
		return rr;		
	}
}
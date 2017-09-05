package appraisal.proccess.stages.impl;

import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.DynamicPropertiesCombiner;
import common.ValuedAttribute;
import entities.dataset.Dataset;
import entities.results.SelectionResult;

import appraisal.algorithms.pca.PcaAlgorithm;
import appraisal.proccess.stages.SelectionStage;


public class PcaStage extends SelectionStage
{
	// Logger
	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(PcaStage.class);
	
	List<ValuedAttribute<String>> attributes;
	
	public PcaStage()
	{
		ResourceBundle pcaResourceBundle = ResourceBundle.getBundle("appraisal.pca");
		propertiesCombiner = new DynamicPropertiesCombiner(pcaResourceBundle,
																"pca.columns");
	}
	
	public SelectionResult run(Dataset dataset) 
	{
		//
		// 1. Processa o método, se necessário
		//	
		
		if (attributes == null)
		{
			attributes = new PcaAlgorithm().evaluate(dataset);
		}
		
		//
		// 2. Recupera os parâmetros e retorna a seleção
		//
		
		//Integer columnCount = propertiesCombiner.getIntegerProperty("pca.columns");
		//return new SelectionResult(attributes.subList(0,columnCount));
		
		return new SelectionResult(attributes);
	}
}
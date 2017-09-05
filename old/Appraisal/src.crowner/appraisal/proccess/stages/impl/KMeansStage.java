package appraisal.proccess.stages.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.DynamicPropertiesCombiner;

import appraisal.algorithms.kmeans.KMeansAlgorithm;
import appraisal.algorithms.kmeans.KMeansModel;
import appraisal.proccess.stages.ClusteringStage;

import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Cluster;
import entities.dataset.Dataset;
import entities.results.ClusteringResult;


public class KMeansStage extends ClusteringStage
{
	// Logger
	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(KMeansStage.class);
	
	public KMeansStage()
	{
		ResourceBundle kmeansResourceBundle = ResourceBundle.getBundle("appraisal.kmeans");
		propertiesCombiner = new DynamicPropertiesCombiner(kmeansResourceBundle,
														"kmeans.centroids",
														"kmeans.iterations",
														"kmeans.initial",
														"kmeans.distance");
	}
		
	public ClusteringResult run(Dataset dataset, String regressionColumn)
	{
		List<String> columns = dataset.getColumns();
		columns.remove(regressionColumn);
		return run(dataset, regressionColumn, columns);
	}

	public ClusteringResult run(Dataset dataset, String regressionColumn, List<String> columns) 
	{
		// Calcula valores máximos e mínimos
		List<String> numericColumns = new ArrayList<String>(columns);
		numericColumns.add(regressionColumn);
		
		DatabaseHandler handler = MySQLHandler.getInstance();
		double maxValue = handler.getMaxValue(numericColumns);
		double minValue = handler.getMinValue(numericColumns);
		
		// Recupera parâmetros
		int centroids = propertiesCombiner.getIntegerProperty("kmeans.centroids");
		int iterations = propertiesCombiner.getIntegerProperty("kmeans.iterations");
		String initial = propertiesCombiner.getStringProperty("kmeans.initial");
		String distance = propertiesCombiner.getStringProperty("kmeans.distance");
						
		// Roda o algoritmo
		KMeansModel kmeansModel = new KMeansModel(centroids,iterations,initial,distance,maxValue,minValue);
		KMeansAlgorithm kmeans = new KMeansAlgorithm(kmeansModel);
		
		List<Cluster> clusterList = kmeans.clusterize(columns,dataset);
		return new ClusteringResult(clusterList);
	}
}
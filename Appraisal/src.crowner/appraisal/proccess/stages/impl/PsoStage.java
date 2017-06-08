package appraisal.proccess.stages.impl;

import java.util.List;
import java.util.ResourceBundle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.DynamicPropertiesCombiner;

import appraisal.algorithms.pso.PsoAlgorithm;
import appraisal.algorithms.pso.PsoModel;
import appraisal.proccess.stages.ClusteringStage;

import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Cluster;
import entities.dataset.Dataset;
import entities.results.ClusteringResult;


public class PsoStage extends ClusteringStage
{
	// Logger
	@SuppressWarnings("unused")
	private static final Log LOGGER = LogFactory.getLog(PcaStage.class);
				
	public PsoStage()
	{
		ResourceBundle psoResourceBundle = ResourceBundle.getBundle("appraisal.pso");
		propertiesCombiner = new DynamicPropertiesCombiner(psoResourceBundle,
														"pso.centroids",
														"pso.iterations",
														"pso.particles");
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
		DatabaseHandler handler = MySQLHandler.getInstance();
		double maxValue = handler.getMaxValue(columns);
		double minValue = handler.getMinValue(columns);
		
		// Recupera parâmetros
		int centroidCount = propertiesCombiner.getIntegerProperty("pso.centroids");
		int iterations = propertiesCombiner.getIntegerProperty("pso.iterations");
		int particles = propertiesCombiner.getIntegerProperty("pso.particles");
				
		// Roda o algoritmo
		PsoModel psoModel = new PsoModel(centroidCount,iterations,particles,minValue,maxValue);
		PsoAlgorithm psoAlgorithm = new PsoAlgorithm(psoModel);
		
		List<Cluster> clusterList = psoAlgorithm.clusterize(columns,dataset);
		return new ClusteringResult(clusterList);
	}
}
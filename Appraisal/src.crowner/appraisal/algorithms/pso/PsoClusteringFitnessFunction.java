package appraisal.algorithms.pso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entities.dataset.Cluster;
import entities.dataset.ColumnCentroid;
import entities.dataset.Dataset;
import entities.dataset.Tuple;
import entities.dataset.TupleCentroid;


import net.sourceforge.jswarm_pso.FitnessFunction;

public class PsoClusteringFitnessFunction extends FitnessFunction
{
	Dataset dataset;
	List<String> selectedColumns;	
	
	public PsoClusteringFitnessFunction(List<String> selectedColumns, Dataset dataset)
	{
		this.dataset=dataset;	
		this.selectedColumns=selectedColumns;
	}
	
	@Override
	public double evaluate(double[] position)
	{
		// Monta centróides a serem avaliados
		List<TupleCentroid> centroids = new ArrayList<TupleCentroid>();

		int attributeIndex = 0;
		
		TupleCentroid clusterCentroid = new TupleCentroid();
		
		for (int i = 0; i < position.length; i++) 
		{
			ColumnCentroid columnCentroid = new ColumnCentroid(selectedColumns.get(attributeIndex),position[i]);
			clusterCentroid.addColumnCentroid(columnCentroid);
			
			if (attributeIndex == selectedColumns.size()-1)
			{
				centroids.add(clusterCentroid);
				clusterCentroid = new TupleCentroid();
				
				attributeIndex=0;
			}
			else
			{
				attributeIndex++;
			}
		}

		//
		// Distribui tuplas da base em um sistema de clusters, segundo
		// os centróides gerados
		//
		Collection<Cluster> clustersList = distributeTuples(dataset,centroids);
		
		//
		// Avalia distribuição atual
		//		
		return evaluateDistributionFitness(clustersList);				
	}

	private Collection<Cluster> distributeTuples(Dataset dataset, List<TupleCentroid> centroids)
	{
		Map<TupleCentroid,Cluster> clusterMap = new HashMap<TupleCentroid, Cluster>();

		// 1. Calcula distância Euclidiana entre os centróides
		// e as tuplas, e aloca as tuplas aos centróides de menor
		// distância

		// Para cada TUPLA
		for (Iterator<Tuple> tuples = dataset.getTuples(); tuples.hasNext();)
		{
			// Recupera a tupla
			Tuple tuple = tuples.next();
			
			// Descobre o conjunto de centróides mais próximo
			TupleCentroid nearestCentroid = findNearestCentroid(tuple,centroids);
			
			// Popula o cluster associado ao centróide com a tupla atual
			Cluster nearestCluster = clusterMap.get(nearestCentroid);
			
			if (nearestCluster == null)
			{
				nearestCluster = new Cluster(dataset.getColumns(),nearestCentroid);
				clusterMap.put(nearestCentroid,nearestCluster);
			}
			
			nearestCluster.getClusterDataset().addTuple(tuple);
		}

		return clusterMap.values();
	}
	
	private TupleCentroid findNearestCentroid(Tuple tuple, List<TupleCentroid> clusterCentroids) 
	{
		Double nearestDistance = null;
		TupleCentroid nearestCentroid = null;
		
		for (TupleCentroid centroid : clusterCentroids) 
		{
			double centroidDistance = calculateTupleCentroidDistance(tuple,centroid);
			
			if (nearestDistance == null || centroidDistance < nearestDistance)
			{
				nearestDistance = centroidDistance;
				nearestCentroid = centroid;
			}			
		}
		
		return nearestCentroid;
	}
	
	private double evaluateDistributionFitness(Collection<Cluster> clusterList)
	{
		// Calcula grau de aptidão da solução atual
		int centroidSum = 0;
		
		for (Cluster cluster : clusterList) 
		{
			Iterator<Tuple> tuples = cluster.getClusterDataset().getTuples();
			
			int tupleSum = 0;
			
			while(tuples.hasNext())
			{			
				Tuple tuple = tuples.next();
				tupleSum += calculateTupleCentroidDistance(tuple,cluster.getClusterCentroid());				
			}
			
			centroidSum += tupleSum/cluster.getClusterDataset().getTupleCount();
		} 
		
//		for (Cluster cluster : clusterList) 
//		{
//			Iterator<Tuple> tuples = cluster.getClusterDataset().getTuples();
//			
//			while(tuples.hasNext())
//			{			
//				int tupleSum = 0;
//				
//				Tuple tuple = tuples.next();
//				tupleSum += calculateTupleCentroidDistance(tuple,cluster.getClusterCentroid());
//				
//				centroidSum += tupleSum/PsoTestCase.tupleCount;
//			}
//		} 
		
		return centroidSum/clusterList.size();		
	}

	public double calculateTupleCentroidDistance(Tuple tuple,TupleCentroid centroid)
	{		
		List<Number> tupleValues = tuple.getValues();
		
		int squareDistance = 0;
		
		for (String column : selectedColumns) 
		{
			double centroidValue = centroid.getCentroids().get(selectedColumns.indexOf(column)).getCentroidValue();
			double attributeValue = tupleValues.get(dataset.getColumns().indexOf(column)).doubleValue();
			
			squareDistance += (attributeValue - centroidValue)*(attributeValue - centroidValue);			
		}
		
		return Math.sqrt(squareDistance);
	}	
}

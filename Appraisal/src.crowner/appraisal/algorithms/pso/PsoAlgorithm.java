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


import junit.framework.TestCase;
import net.sourceforge.jswarm_pso.FitnessFunction;
import net.sourceforge.jswarm_pso.Particle;
import net.sourceforge.jswarm_pso.Swarm;

public class PsoAlgorithm extends TestCase
{
	public static int centroidCount;
	public static int attributeCount;
	
	private int iterations;
	private int particles;
	
	private double maxValue;
	private double minValue;
	
	Dataset dataset;
	List<String> selectedColumns;
	
	public PsoAlgorithm(PsoModel psoModel)
	{
		centroidCount = psoModel.getCentroidCount();
		iterations = psoModel.getIterations();
		particles = psoModel.getParticles();
		maxValue = psoModel.getMaxValue();
		minValue = psoModel.getMinValue();
	}
	
	public List<Cluster> clusterize(List<String> selectedColumns,Dataset dataset)
	{
		this.dataset=dataset;
		this.selectedColumns = selectedColumns;
		attributeCount = selectedColumns.size();
		
		Particle sampleParticle = new PsoParticle();
		FitnessFunction fitnessf = new PsoClusteringFitnessFunction(selectedColumns,dataset);
		
		fitnessf.setMaximize(false);
		
		Swarm swarm = new Swarm(particles,sampleParticle,fitnessf);

		swarm.setMinPosition(minValue);
		swarm.setMaxPosition(maxValue);
						
		for( int i = 0; i < iterations ; i++ ) 
			swarm.evolve();

		double solution[] = swarm.getBestPosition();	
		
		// Monta centróides finais
		List<TupleCentroid> centroids = new ArrayList<TupleCentroid>();

		int attributeIndex = 0;
		
		TupleCentroid clusterCentroid = new TupleCentroid();
		
		for (int i = 0; i < solution.length; i++) 
		{
			ColumnCentroid columnCentroid = new ColumnCentroid(selectedColumns.get(attributeIndex),solution[i]);
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
		// Distribui tuplas da base no sistema final de clusters
		//
		Collection<Cluster> clustersList = distributeTuples(dataset,centroids);
		return new ArrayList<Cluster>(clustersList);		
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
		
		// 2. Trata centróides vazios
		for(TupleCentroid centroid : centroids)
		{
			if(!clusterMap.containsKey(centroid))
				clusterMap.put(centroid,new Cluster(dataset.getColumns(),centroid));
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
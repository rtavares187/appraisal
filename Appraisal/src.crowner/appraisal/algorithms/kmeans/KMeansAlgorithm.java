package appraisal.algorithms.kmeans;

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



public class KMeansAlgorithm 
{
	KMeansModel kmeansModel;
	
	Dataset dataset;
	List<String> selectedColumns;
	
	public KMeansAlgorithm(KMeansModel kmeansModel)
	{
		this.kmeansModel = kmeansModel;
	}
	
	public List<Cluster> clusterize(List<String> selectedColumns, Dataset dataset) 
	{
		this.dataset=dataset;
		this.selectedColumns = selectedColumns;
		
		//
		// 1. Recupera parâmetros
		//
		int    centroidCount = kmeansModel.getCentroids();
		String initialMode	 = kmeansModel.getInitital();
		
		//
		// 2. Roda algoritmo 
		//
		List<TupleCentroid> centroids = initializeCentroids(centroidCount,initialMode,dataset);
		List<Cluster> clusters = distributeTuples(dataset, centroids);
		
		for(int i=0 ; i<kmeansModel.getIterations() ; i++)
		{
			List<TupleCentroid> newCentroids = updateCentroids(clusters);
			List<Cluster> newClusters = distributeTuples(dataset, newCentroids);

			boolean stable = stableClusters(clusters,newClusters);
			
			centroids = newCentroids;
			clusters = newClusters;				

			if (stable)
				break;
		}
		
		//
		// 3. Constrói resultado
		//
		
		return new ArrayList<Cluster>(clusters);
	}
	
	private boolean stableClusters(List<Cluster> clusters,List<Cluster> otherClusters)
	{
		for (int i = 0; i < clusters.size(); i++) 
		{
			Cluster cluster = clusters.get(i);
			Cluster otherCluster = otherClusters.get(i);
			
			Dataset data = cluster.getClusterDataset();
			Dataset otherData = otherCluster.getClusterDataset();
			
			if (!data.equals(otherData))
			{
				return false;
			}
		} 
		
		return true;
	}
	
	private List<TupleCentroid> initializeCentroids(int centroidCount, String initialMode, Dataset dataset)
	{
		List<TupleCentroid> centroids = new ArrayList<TupleCentroid>();
		
		if (initialMode.equals("firstTuples"))
		{
			int count = 0;
			
			for (Iterator<Tuple> tuples = dataset.getTuples(); tuples.hasNext() && count<centroidCount; count++) 
			{
				Tuple 		 tuple = tuples.next();
				List<Number> values = tuple.getValues(selectedColumns);
				
				TupleCentroid tupleCentroid = new TupleCentroid();
				
				for (int i = 0; i < values.size(); i++) 
				{
					ColumnCentroid columnCentroid = new ColumnCentroid(selectedColumns.get(i),values.get(i).doubleValue());
					tupleCentroid.addColumnCentroid(columnCentroid);
				}
				
				centroids.add(tupleCentroid);
			}			
		}
		else if (initialMode.equals("random"))
		{
			double max = kmeansModel.getMaxValue();
			double min = kmeansModel.getMinValue();
			
			for (int i=0; i<centroidCount; i++) 
			{
				TupleCentroid tupleCentroid = new TupleCentroid();
				
				for (int j=0; j<selectedColumns.size(); j++) 
				{
					String column = selectedColumns.get(j);
					double value  = (Math.random()*(max-min+1))+min;
					
					ColumnCentroid columnCentroid = new ColumnCentroid(column,value);
					tupleCentroid.addColumnCentroid(columnCentroid);
				}
				
				centroids.add(tupleCentroid);
			}	
		}
		else
		{
			throw new UnsupportedOperationException("Configuração inválida de kmeans.initial - "+initialMode);
		}
		
		return centroids;
	}
	
	private List<TupleCentroid> updateCentroids(Collection<Cluster> clusters)
	{
		List<TupleCentroid> centroids = new ArrayList<TupleCentroid>();
		
		for (Cluster cluster : clusters) 
		{
			TupleCentroid centroid = new TupleCentroid();
			double[] 	  medianValues = new double[selectedColumns.size()];
			
			// Varre o dataset
			Dataset clusterDataset = cluster.getClusterDataset();
					
			for (Iterator<Tuple> tuples = clusterDataset.getTuples() ; tuples.hasNext();)
			{
				Tuple tuple = tuples.next();
				
				for (int i=0; i<selectedColumns.size() ; i++) 
				{
					String column = selectedColumns.get(i);
					double value  = tuple.getDoubleValue(column);
					
					medianValues[i] += value/clusterDataset.getTupleCount();
				}
			}
			
			// Cria os centroides das colunas
			for (int i=0; i<selectedColumns.size() ; i++) 
			{
				String column = selectedColumns.get(i);
				double value  = medianValues[i];
				
				ColumnCentroid columnCentroid = new ColumnCentroid(column,value);
				centroid.addColumnCentroid(columnCentroid);
			}
			
			centroids.add(centroid);
		}
		
		return centroids;
	}
	
	private List<Cluster> distributeTuples(Dataset dataset, List<TupleCentroid> centroids)
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

		// 3. Monta lista de clusters
		List<Cluster> clusters = new ArrayList<Cluster>();
		
		for (TupleCentroid centroid : centroids) 
		{
			clusters.add(clusterMap.get(centroid));
		}
		
		return clusters;		
	}
	
	private TupleCentroid findNearestCentroid(Tuple tuple, List<TupleCentroid> clusterCentroids) 
	{
		Double nearestDistance = null;
		TupleCentroid nearestCentroid = null;
		
		for (TupleCentroid centroid : clusterCentroids) 
		{
			String distanceType = kmeansModel.getDistance();
			double centroidDistance; 
			
			if (distanceType.equals("euclidian"))
				centroidDistance = euclidianDistance(tuple,centroid);
			else if (distanceType.equals("manhattan"))
				centroidDistance = manhattanDistance(tuple,centroid);
			else
				throw new UnsupportedOperationException("Invalid value for property knn.distance - "+distanceType);
						
			if (nearestDistance == null || centroidDistance < nearestDistance)
			{
				nearestDistance = centroidDistance;
				nearestCentroid = centroid;
			}			
		}
		
		return nearestCentroid;
	}

	public double manhattanDistance(Tuple tuple,TupleCentroid centroid)
	{		
		List<Number> tupleValues = tuple.getValues();
		
		double distance = 0;
		
		for (String column : selectedColumns) 
		{
			double centroidValue = centroid.getCentroids().get(selectedColumns.indexOf(column)).getCentroidValue();
			double attributeValue = tupleValues.get(dataset.getColumns().indexOf(column)).doubleValue();
			
			double d = (attributeValue - centroidValue);
			
			distance += d<0 ? d*-1 : d; 
		}
		
		return distance;
	}
	
	public double euclidianDistance(Tuple tuple,TupleCentroid centroid)
	{		
		List<Number> tupleValues = tuple.getValues();
		
		double squareDistance = 0;
		
		for (String column : selectedColumns) 
		{
			double centroidValue = centroid.getCentroids().get(selectedColumns.indexOf(column)).getCentroidValue();
			double attributeValue = tupleValues.get(dataset.getColumns().indexOf(column)).doubleValue();
			
			squareDistance += (attributeValue - centroidValue)*(attributeValue - centroidValue);			
		}
		
		return Math.sqrt(squareDistance);
	}
}
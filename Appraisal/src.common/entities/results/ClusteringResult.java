package entities.results;

import java.util.List;

import entities.dataset.Cluster;



public class ClusteringResult 
{
	List<Cluster> clusters;
	
	public ClusteringResult(List<Cluster> clusters)
	{
		this.clusters = clusters;
	}

	/**
	 * @return the clusters
	 */
	public List<Cluster> getClusters() {
		return clusters;
	}

	/**
	 * @param clusters the clusters to set
	 */
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	
	public int getMostTupleCount()
	{
		int tupleCount = 0;
		
		for (Cluster cluster : clusters) 
		{
			int temp = cluster.getClusterDataset().getTupleCount();
			
			if (temp > tupleCount)
				tupleCount = temp;
		}
		
		return tupleCount;
	}
	
	public int getMostTrainTupleCount(String originalColumn)
	{
		int tupleCount = 0;
		
		for (Cluster cluster : clusters) 
		{
			int temp = cluster.getClusterDataset().splitTrainTest(originalColumn)[0].getTupleCount();
			
			if (temp > tupleCount)
				tupleCount = temp;
		}
		
		return tupleCount;
	}
		
	@Override
	public String toString()
	{
		String result="";
		
		for (Cluster cluster : clusters) 
		{
			result+="\n";
			result+=cluster.toString();		
		}
		
		return result;
	}
}
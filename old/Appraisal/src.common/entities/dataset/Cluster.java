package entities.dataset;

import java.util.Iterator;
import java.util.List;

public class Cluster
{
	private TupleCentroid clusterCentroid;
	private Dataset clusterDataset;
	
	public Cluster(List<String> columns, TupleCentroid clusterCentroid)
	{
		this.clusterCentroid = clusterCentroid;
		this.clusterDataset = new Dataset(columns);		
	}
		
	public TupleCentroid getClusterCentroid() {
		return clusterCentroid;
	}
	public void setClusterCentroid(TupleCentroid clusterCentroid) {
		this.clusterCentroid = clusterCentroid;
	}
	public Dataset getClusterDataset() {
		return clusterDataset;
	}
	public void setClusterDataset(Dataset clusterDataset) {
		this.clusterDataset = clusterDataset;
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		result+="Centroid: "+getClusterCentroid()+"\n";
		
		for(Iterator<Tuple> tuples = getClusterDataset().getTuples(); tuples.hasNext(); )
		{
			result+="Tuples: "+tuples.next()+"\n";
		}		
		
		return result;
	}

	public boolean isEmpty() 
	{
		return clusterDataset.isEmpty();
	}	
}
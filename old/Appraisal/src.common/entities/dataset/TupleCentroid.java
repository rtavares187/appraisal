package entities.dataset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TupleCentroid
{
	private List<ColumnCentroid> centroids = new ArrayList<ColumnCentroid>();

	public List<ColumnCentroid> getCentroids() 
	{
		return centroids;
	}

	public double[] getCentroidsValues() 
	{
		double[] values = new double[centroids.size()];
				
		for (int i=0 ; i<centroids.size() ; i++) 
		{
			values[i]=(centroids.get(i).getCentroidValue());
		}
		
		return values;
	}

	public void addColumnCentroid(ColumnCentroid centroid) 
	{
		centroids.add(centroid);
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(
				"centroids", centroids).toString();
	}	
}
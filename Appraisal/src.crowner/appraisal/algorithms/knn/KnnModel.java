package appraisal.algorithms.knn;


public class KnnModel
{
	//
	// Attributes
	//
	
	private Integer k;
	private String  distance;
	private String  strategy;

	public KnnModel(Integer k, String strategy, String distance) 
	{
		super();
		this.k = k;
		this.strategy = strategy;
		this.distance = distance;
	}

	public Integer getK() {
		return k;
	}

	public void setK(Integer k) {
		this.k = k;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
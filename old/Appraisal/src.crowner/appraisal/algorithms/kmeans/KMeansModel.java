package appraisal.algorithms.kmeans;


public class KMeansModel
{
	//
	// Attributes
	//
	
	private Integer centroids;
	private Integer iterations;
	private String  initital;
	private String  distance;
	
	private double maxValue;
	private double minValue;
	
	public KMeansModel(Integer centroids, Integer iterations, String  initital, String distance) 
	{
		super();
		this.centroids = centroids;
		this.initital = initital;
		this.iterations = iterations;
		this.distance = distance;
	}

	public KMeansModel(Integer centroids, Integer iterations, String  initital, String distance, double maxValue, double minValue) 
	{
		super();
		this.centroids = centroids;
		this.initital = initital;
		this.iterations = iterations;
		this.distance = distance;
		this.maxValue = maxValue;
		this.minValue = minValue;
	}

	
	public Integer getCentroids() {
		return centroids;
	}

	public void setCentroids(Integer centroids) {
		this.centroids = centroids;
	}

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(Integer iterations) {
		this.iterations = iterations;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getInitital() {
		return initital;
	}

	public void setInitital(String initital) {
		this.initital = initital;
	}
	
	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}
	
	
}
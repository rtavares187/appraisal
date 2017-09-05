package entities.results;

import entities.dataset.Dataset;

public class RegressionResult 
{
	private Dataset trainDataRegression;
	private Dataset targetDataRegression;
		
	public RegressionResult(Dataset trainSetRegression, Dataset regressSetRegression) 
	{
		super();
		this.trainDataRegression = trainSetRegression;
		this.targetDataRegression = regressSetRegression;
	}

	public Dataset getTargetDataRegression() {
		return targetDataRegression;
	}

	public void setTargetDataRegression(Dataset regressSetRegression) {
		this.targetDataRegression = regressSetRegression;
	}

	public Dataset getTrainDataRegression() {
		return trainDataRegression;
	}

	public void setTrainDataRegression(Dataset trainSetRegression) {
		this.trainDataRegression = trainSetRegression;
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		result += trainDataRegression.toString();
		result += targetDataRegression.toString();
		
		return result;
	}
}
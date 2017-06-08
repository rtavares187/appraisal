package entities.results;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.dataset.Dataset;

public class PlanResult 
{
	private static String errorMeasure;
	private static double errorE; // e+, fator de incremento no divisor do RAD
	
	static
	{
		ResourceBundle properties = ResourceBundle.getBundle("appraisal.strategies");
		errorMeasure = properties.getString("error.measure");
		errorE = Double.parseDouble(properties.getString("error.e"));
	}
	
	private String id;
	private double time;
	private double medianTime;
	private int    count;
	private List<InstanceResult> instanceResults;
	
	public PlanResult(String... stages)
	{
		id = "";
		
		for (int i = 0; i < stages.length; i++) 
		{
			String stage = stages[i];
			id += stage.replaceAll("Stage","").toLowerCase();
			
			if (i < stages.length-1)
				id += ".";
		}
		
		instanceResults = new ArrayList<InstanceResult>();
	}
	
	public void addInstance(InstanceResult instanceResult)
	{
		count++;
		time += (double)instanceResult.getTime()/1000;
		instanceResults.add(instanceResult);
	}
		
	public List<InstanceResult> getResults()
	{
		return instanceResults;
	}
	
	public String getId()
	{
		return id;
	}	
	
	public double getTime()
	{
		return time;
	}
	
	public double getMedianTime()
	{
		if (medianTime == 0)
			return time/count;
		else
			return medianTime;
	}

	public void setTime(double time)
	{
		this.time=time;
	}
	
	public void setMedianTime(double medianTime)
	{
		this.medianTime=medianTime;
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		for (InstanceResult instanceResult : instanceResults) 
		{
			result+=instanceResult.toString();
		}
		
		return result;
	}
		
	public InstanceResult bestInstanceByTrainDeviation(Dataset originalColumn)
	{
		double minDeviation = 100;
		InstanceResult bestInstance = null;
		
		// Para cada plano
		for (InstanceResult instance : instanceResults) 
		{
			// Calcula o desvio da base regredida para a base original
			RegressionResult rr = instance.getRegressionResult();
				
			Dataset trainDataset   = rr.getTrainDataRegression();
			double  trainDeviation;
			
			if (errorMeasure.equals("ad"))
			{
				trainDeviation = originalColumn.distance(trainDataset);
			}							
			else if (errorMeasure.equals("rad"))
			{
				trainDeviation = originalColumn.relativeDeviation(trainDataset);
			}
			else if (errorMeasure.equals("sim"))
			{
				trainDeviation = originalColumn.maxMinDistance(trainDataset);
			}
			else if (errorMeasure.equals("e+"))
			{
				trainDeviation = originalColumn.relativeDeviation(trainDataset,errorE);
			}
			else
			{
				throw new IllegalArgumentException("Invalid value for property error.measure - "+errorMeasure);
			}
			
			if (trainDeviation < minDeviation)
			{
				minDeviation = trainDeviation;
				bestInstance = instance;
			}
		}
		
		if (bestInstance == null)
			return instanceResults.get(0);
		else
			return bestInstance;
	}
	
	public InstanceResult bestInstanceByTargetDeviation(Dataset originalColumn)
	{
		double minDeviation = 100;
		InstanceResult bestInstance = null;
		
		// Para cada plano
		for (InstanceResult instance : instanceResults) 
		{
			// Calcula o desvio da base regredida para a base original
			RegressionResult rr = instance.getRegressionResult();
				
			Dataset targetDataset = rr.getTargetDataRegression();
			
			double targetDeviation;
			
			if (errorMeasure.equals("ad"))
			{
				targetDeviation = originalColumn.distance(targetDataset);	
			}							
			else if (errorMeasure.equals("rad"))
			{
				targetDeviation = originalColumn.relativeDeviation(targetDataset);
			}
			else if (errorMeasure.equals("sim"))
			{
				targetDeviation = originalColumn.maxMinDistance(targetDataset);
			}
			else if (errorMeasure.equals("e+"))
			{
				targetDeviation = originalColumn.relativeDeviation(targetDataset,errorE);
			}
			else
			{
				throw new IllegalArgumentException("Invalid value for property error.measure - "+errorMeasure);
			}
			
			if (targetDeviation < minDeviation)
			{
				minDeviation = targetDeviation;
				bestInstance = instance;
			}
		}
				
		if (bestInstance == null)
			return instanceResults.get(0);
		else
			return bestInstance;
	}
	
	public InstanceResult bestInstanceByTotalDeviation(Dataset originalColumn)
	{
		double minDeviation = 100;
		InstanceResult bestInstance = null;
		
		// Para cada plano
		for (InstanceResult instance : instanceResults) 
		{
			// Calcula o desvio da base regredida para a base original
			RegressionResult rr = instance.getRegressionResult();
				
			Dataset trainDataset = rr.getTrainDataRegression();
			Dataset targetDataset = rr.getTargetDataRegression();
			
			double trainDeviation;
			double targetDeviation;
			
			if (errorMeasure.equals("ad"))
			{
				trainDeviation = originalColumn.distance(trainDataset);
				targetDeviation = originalColumn.distance(targetDataset);	
			}							
			else if (errorMeasure.equals("rad"))
			{
				trainDeviation = originalColumn.relativeDeviation(trainDataset);
				targetDeviation = originalColumn.relativeDeviation(targetDataset);
			}
			else if (errorMeasure.equals("sim"))
			{
				trainDeviation = originalColumn.maxMinDistance(trainDataset);
				targetDeviation = originalColumn.maxMinDistance(targetDataset);
			}
			else if (errorMeasure.equals("e+"))
			{
				trainDeviation = originalColumn.relativeDeviation(trainDataset,errorE);
				targetDeviation = originalColumn.relativeDeviation(targetDataset,errorE);
			}
			else
			{
				throw new IllegalArgumentException("Invalid value for property error.measure - "+errorMeasure);
			}
					
			double totalDeviation = (trainDeviation+targetDeviation)/2;
			
			if (totalDeviation < minDeviation)
			{
				minDeviation = totalDeviation;
				bestInstance = instance;
			}
		}
		
		if (bestInstance == null)
			return instanceResults.get(0);
		else
			return bestInstance;
	}

	public InstanceResult dropWorstResults(Dataset originalColumn) 
	{
		InstanceResult iresult = bestInstanceByTargetDeviation(originalColumn);
		
		List<InstanceResult> result = getResults();
		result.clear();
		result.add(iresult);
		
		return iresult;
	}
}
package appraisal.algorithms.avg;

import java.util.Iterator;

import entities.dataset.Dataset;
import entities.dataset.Tuple;
import entities.results.RegressionResult;



public class AvgAlgorithm 
{
	AvgModel avgModel;
	
	public AvgAlgorithm(AvgModel knnModel)
	{
		this.avgModel = knnModel;
	}
	
	public RegressionResult regress(String regressColumn, Dataset trainData, Dataset targetData) 
	{
		//
		// 1. Calcula média 
		// 
		double mean = 0;
		
		if (avgModel.getType().equals("arithmetic"))
		{
			for (Iterator<Tuple> trainTuples = trainData.getTuples(); trainTuples.hasNext();) 
			{
				double value = trainTuples.next().getDoubleValue(regressColumn);
				mean+=value;				
			}
		}
		else
		{
			throw new UnsupportedOperationException("Invalida parameter avg.type - "+avgModel.getType());
		}
		
		mean /= trainData.getTupleCount();
				
		//
		// 2. Regride base alvo 
		//
		
		Dataset trainRegressionData = new Dataset(regressColumn);
		Dataset targetRegressionData = new Dataset(regressColumn);
		
		for (Iterator<Tuple> targetTuples = targetData.getTuples(); targetTuples.hasNext();) 
		{
			// Recupera tupla a ser regredida
			Tuple targetTuple = targetTuples.next();
			
			// Cria tupla
			Tuple regressTuple;
			
			if (avgModel.getDisturb())
			{
				if(Math.random() > 0.5)
					regressTuple = new Tuple(targetTuple.getId(),mean+mean*Math.random());
				else
					regressTuple = new Tuple(targetTuple.getId(),mean-mean*Math.random());
			}
			else
			{
				regressTuple = new Tuple(targetTuple.getId(),mean);
			}
			
			targetRegressionData.addTuple(regressTuple);
		}
		
		//
		// 1. Regride base de treino
		//
		
		for (Iterator<Tuple> trainTuples = trainData.getTuples(); trainTuples.hasNext();) 
		{
			// Recupera tupla a ser regredida
			Tuple trainTuple = trainTuples.next();
			
			// Cria tupla com o valor regredido
			Tuple regressTuple;
			
			if (avgModel.getDisturb())
			{
				if(Math.random() > 0.5)
					regressTuple = new Tuple(trainTuple.getId(),mean+mean*Math.random());
				else
					regressTuple = new Tuple(trainTuple.getId(),mean-mean*Math.random());
			}
			else
			{
				regressTuple = new Tuple(trainTuple.getId(),mean);
			}
			
			
			trainRegressionData.addTuple(regressTuple);
		}
		
		RegressionResult rr = new RegressionResult(trainRegressionData,targetRegressionData);
		return rr;
	}
}
package appraisal.algorithms.pca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.math.array.LinearAlgebra;
import org.math.array.StatisticSample;
import org.math.array.linearalgebra.EigenvalueDecomposition;

import common.ValuedAttribute;
import entities.dataset.Dataset;


public class PcaAlgorithm 
{
	public List<ValuedAttribute<String>> evaluate(Dataset pcaDataset) 
	{
		double[][] dataMatrix = pcaDataset.toMatrixInverse();
		return evaluate(pcaDataset.getColumns(),dataMatrix);
	}
	
	@SuppressWarnings("unchecked")
	public List<ValuedAttribute<String>> evaluate(List<String> attributeNames,double[][] data)
	{
		// Normaliza os dados
		double[] dataMean = new double[data.length];
		                               
		for (int i = 0; i < dataMean.length; i++) 
		{
			dataMean[i] = StatisticSample.mean(data[i]);			
		}
		                               
		for (int i = 0; i < data.length; i++) 
		{
			double[] attribute = data[i];
			
			for (int j = 0; j < attribute.length; j++) 
			{
				attribute[j] = attribute[j]-dataMean[i];				
			}		
		}
				
		// Calcula cô-variancia
		double[][] covarianceMatrix = new double[data.length][data.length];
		
		for (int i = 0; i < data.length; i++) 
		{
			for (int j = 0; j < data.length; j++) 
			{
				covarianceMatrix[i][j] = StatisticSample.covariance(data[i],data[j]); 				
			}		
		}
						
		// Calcula matriz e valores de igualdade
		EigenvalueDecomposition eigen = LinearAlgebra.eigen(covarianceMatrix);
		
		double[] eigenValues = eigen.get1DRealD();
					
		// Monta resultados
		List<ValuedAttribute<String>> attributes = new ArrayList<ValuedAttribute<String>>();
		
		for (int i = 0; i < attributeNames.size(); i++) 
		{
			ValuedAttribute<String> attribute = new ValuedAttribute<String>(eigenValues[i],attributeNames.get(i));
			attributes.add(attribute);
		}
		
		Collections.sort(attributes);
		Collections.reverse(attributes);
		
		return attributes;
	}
}
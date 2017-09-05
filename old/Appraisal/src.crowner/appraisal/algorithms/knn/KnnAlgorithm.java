package appraisal.algorithms.knn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import common.ValuedAttribute;
import entities.dataset.Dataset;
import entities.dataset.Tuple;
import entities.results.RegressionResult;



public class KnnAlgorithm 
{
	KnnModel knnModel;
	
	public KnnAlgorithm(KnnModel knnModel)
	{
		this.knnModel = knnModel;
	}
	
	public RegressionResult regress(List<String> selectedColumns, String regressColumn, Dataset trainData, Dataset targetData) 
	{
		Dataset trainRegressionData = new Dataset(regressColumn);
		Dataset targetRegressionData = new Dataset(regressColumn);
				
		//
		// 1. Regride base alvo 
		//
		
		for (Iterator<Tuple> targetTuples = targetData.getTuples(); targetTuples.hasNext();) 
		{
			// Recupera tupla a ser regredida
			Tuple targetTuple = targetTuples.next();
			
			// Calcula vizinhos mais próximos 
			List<Tuple> nearestNeighbors = getNeighbors(selectedColumns,targetTuple,trainData);
			
			// Infere valor de regressão a partir do valor dos vizinhos
			Number regressedAttribute = classificateNumeric(regressColumn, nearestNeighbors);
						
			// Cria tupla
			Tuple regressedTuple = new Tuple(targetTuple.getId(),regressedAttribute);
			targetRegressionData.addTuple(regressedTuple);
		}
		
		//
		// 1. Regride base de treino
		//
		
		for (Iterator<Tuple> trainTuples = trainData.getTuples(); trainTuples.hasNext();) 
		{
			// Recupera tupla a ser regredida
			Tuple trainTuple = trainTuples.next();
			
			// Calcula vizinhos mais próximos 
			List<Tuple> nearestNeighbors = getNeighbors(selectedColumns,trainTuple,trainData);
			
			// Infere valor de regressão a partir do valor dos vizinhos
			Number regressedAttribute = classificateNumeric(regressColumn, nearestNeighbors);
									
			// Cria tupla com o valor regredido
			Tuple regressTuple = new Tuple(trainTuple.getId(),regressedAttribute);
			trainRegressionData.addTuple(regressTuple);
		}
		
		RegressionResult rr = new RegressionResult(trainRegressionData,targetRegressionData);
		return rr;
	}
	
	public RegressionResult regress(String regressionAttributeName, Dataset trainData, Dataset targetData)
	{
		Dataset trainRegressionData = new Dataset(regressionAttributeName);
		Dataset targetRegressionData = new Dataset(regressionAttributeName);
				
		//
		// 1. Regride base alvo 
		//
		
		for (Iterator<Tuple> targetTuples = targetData.getTuples(); targetTuples.hasNext();) 
		{
			// Recupera tupla a ser regredida
			Tuple targetTuple = targetTuples.next();
			
			// Calcula vizinhos mais próximos 
			List<Tuple> nearestNeighbors = getNeighbors(targetTuple,trainData);
			
			// Infere valor de regressão a partir do valor dos vizinhos
			Number regressedAttribute = classificateNumeric(regressionAttributeName, nearestNeighbors);
			
			// Cria tupla
			Tuple regressedTuple = new Tuple(targetTuple.getId(),regressedAttribute);
			targetRegressionData.addTuple(regressedTuple);
		}
		
		//
		// 1. Regride base de treino
		//
		
		for (Iterator<Tuple> trainTuples = trainData.getTuples(); trainTuples.hasNext();) 
		{
			// Recupera tupla a ser regredida
			Tuple trainTuple = trainTuples.next();
			
			// Calcula vizinhos mais próximos 
			List<Tuple> nearestNeighbors = getNeighbors(trainTuple,trainData);
			
			// Infere valor de regressão a partir do valor dos vizinhos
			Number regressValue = classificateNumeric(regressionAttributeName, nearestNeighbors);
			
			// Cria tupla com o valor regredido
			List<Number> regressValueList = new ArrayList<Number>();
			List<String> regressNameList = new ArrayList<String>();
			
			regressValueList.add(regressValue);
			regressNameList.add(regressionAttributeName);
			
			Tuple regressTuple = new Tuple(trainTuple.getId(),regressValueList);
			trainRegressionData.addTuple(regressTuple);
		}
		
		RegressionResult rr = new RegressionResult(trainRegressionData,targetRegressionData);
		return rr;
	}

	@SuppressWarnings("unchecked")
	public List<Tuple> getNeighbors(List<String> selectedColumns, Tuple regressTuple,Dataset trainData)
	{
		List<ValuedAttribute<Tuple>> neighbors = new ArrayList<ValuedAttribute<Tuple>>();
		
		// Para cada tupla disponível no conjunto de treino
		for (Iterator<Tuple> trainTuples = trainData.getTuples(); trainTuples.hasNext();) 
		{
			// Calcula a distância entre a tupla a ser regredida e a tupla de treino
			Tuple 		 trainTuple 	   	   = trainTuples.next();
			List<Number> trainAttributes 	   = trainTuple.getValues(selectedColumns);
			List<Number> regressAttributes     = regressTuple.getValues(selectedColumns);
			
			// Se for a própria tupla não adiciona
			if (trainTuple.getId() == regressTuple.getId())
				continue;
			
			String distanceType = knnModel.getDistance();
			double distance; 
			
			if (distanceType.equals("euclidian"))
				distance = calculateEuclidianDistance(regressAttributes,trainAttributes);
			else if (distanceType.equals("manhattan"))
				distance = calculateManhattanDistance(regressAttributes,trainAttributes);
			else
				throw new UnsupportedOperationException("Invalid value for property knn.distance - "+distanceType);
			
			ValuedAttribute<Tuple> neighbor = new ValuedAttribute<Tuple>(distance,trainTuple);
			neighbors.add(neighbor);
		}		
		
		// Ordena as tuplas
		Collections.sort(neighbors);
		
		// Seleciona as K mais próximas
		List<Tuple> nearestNeighbors = new ArrayList<Tuple>();
		
		for (int i=0; i<knnModel.getK() ; i++)
		{
			if (i < neighbors.size())
				nearestNeighbors.add(neighbors.get(i).getAttribute());
		}
		
		return nearestNeighbors;
	}

	
	public List<Tuple> getNeighbors(Tuple regressTuple,Dataset trainData)
	{
		// TODO: Verificar casos em que o cálculo da distância euclidiana se
		// repete...
		SortedMap<Double,Tuple> sampleDistancesMap = new TreeMap<Double,Tuple>();
		
		// Para cada tupla disponível no conjunto de treino
		for (Iterator<Tuple> trainTuples = trainData.getTuples(); trainTuples.hasNext();) 
		{
			// Calcula a distância entre a tupla a ser regredida e a tupla de treino
			Tuple 		 trainTuple 	   	   = trainTuples.next();
			List<Number> trainAttributes 	   = trainTuple.getValues();
			List<Number> regressAttributes     = regressTuple.getValues();
			
			String distanceType = knnModel.getDistance();
			double distance; 
			
			if (distanceType.equals("euclidian"))
				distance = calculateEuclidianDistance(regressAttributes,trainAttributes);
			else if (distanceType.equals("manhattan"))
				distance = calculateManhattanDistance(regressAttributes,trainAttributes);
			else
				throw new UnsupportedOperationException("Invalid value for property knn.distance - "+distanceType);

			sampleDistancesMap.put(distance,trainTuple);
		}		
		
		int keyCount = 0;
		Set<Double> sampleDistanceKeys = sampleDistancesMap.keySet();
		
		List<Tuple> nearestNeighbors = new ArrayList<Tuple>();
				
		for (Iterator<Double> iter = sampleDistanceKeys.iterator(); keyCount++ != knnModel.getK();) 
		{
			Double  sampleDistance = iter.next();
			Tuple	sampleData     = sampleDistancesMap.get(sampleDistance);
			
			nearestNeighbors.add(sampleData);	
		}

		return nearestNeighbors;
	}
	
	public double classificateNumeric(String regressionAttributeName, List<Tuple> nearestNeighbors)
	{		
		double sum = 0;
		
		for (Tuple neighbor : nearestNeighbors) 
		{
			double classe = neighbor.getDoubleValue(regressionAttributeName);
			sum +=classe;
		}
		
		return sum/nearestNeighbors.size();
	}
	
	private double calculateEuclidianDistance(List<Number> queryAttributes,List<Number> sampleAttributes) 
	{
		/* 
		 * Distância Euclidiana
		 * 
		 * d^2 = (sample1 - query1)^2 + (sample2 - query2)^2 + ... + (sampleN - queryN )^2  
		 * 
		 * http://en.wikipedia.org/wiki/Euclidean_distance
		 * http://people.revoledu.com/kardi/tutorial/Similarity/EuclideanDistance.html
		 */
		
		double squareDistance = 0;
		 
		for (int i = 0; i < queryAttributes.size(); i++) 
		{
			double queryAttr  = (Double)queryAttributes.get(i);
			double sampleAttr = (Double)sampleAttributes.get(i);
			
			squareDistance += (sampleAttr - queryAttr) * (sampleAttr - queryAttr);			
		}		
				
		return Math.sqrt(squareDistance);
	}
	
	private double calculateManhattanDistance(List<Number> queryAttributes,List<Number> sampleAttributes) 
	{
		/* 
		 * Distância Manhattan
		 * 
		 * d = |sample1 - query1| + |sample2 - query2| + ... + |sampleN - queryN|  
		 */
		
		double distance = 0;
		 
		for (int i = 0; i < queryAttributes.size(); i++) 
		{
			double queryAttr  = (Double)queryAttributes.get(i);
			double sampleAttr = (Double)sampleAttributes.get(i);
			
			double d = (sampleAttr - queryAttr);
			
			distance += d<0 ? d*-1 : d; 			
		}		
				
		return distance;
	}
}

/*
 * Implementação do algoritmo de knn em apenas duas dimensões, utilizado para fins de aprendizado.
 * 
 * Tutorial:
 * Teknomo, Kardi. K-Nearest Neighbors Tutorial, 08/2006. http://people.revoledu.com/kardi/tutorial/KNN/index.html
 *

class KnnAlgorithm2D 
{
	public String knn(int k, int queryVarA, int queryVarB, List<Integer> samplesVarA, List<Integer> samplesVarB, List<String> samplesClass)
	{
		
		// 1. Monta mapa de distâncias
		//  
		// Key<Integer>  - Valor da distância
		// Value<String> - Nome da classe 
		 
		SortedMap<Integer,String> sampleDistancesMap = new TreeMap<Integer,String>();
		
		for (int i=0;i<samplesClass.size();i++) 
		{
			String 	sampleClass = samplesClass.get(i);
			int 	sampleVarA  = samplesVarA.get(i);
			int 	sampleVarB  = samplesVarB.get(i);
			
			int euclidianDistance = calculateEuclidianDistance(queryVarA,queryVarB,sampleVarA,sampleVarB);

			sampleDistancesMap.put(euclidianDistance,sampleClass);
		}				
		
		// 2. Monta mapa de incidência de classes a
		//    partir dos k-menores resultados
		// 
		// Key<String>    - Nome da Classe
		// Value<Integer> - Contagem de incidências 
				  
		Map<String,Integer> classIncidencesMap = new HashMap<String,Integer>();
		
		int keyCount = 0;
		Set<Integer> sampleDistanceKeys = sampleDistancesMap.keySet();
		
		for (Iterator<Integer> iter = sampleDistanceKeys.iterator(); keyCount++ != k;) 
		{
			Integer sampleDistance = iter.next();
			String  sampleClass = sampleDistancesMap.get(sampleDistance);
			
			int classIncidence;
			
			if (classIncidencesMap.containsKey(sampleClass))
			{
				classIncidence = classIncidencesMap.get(sampleClass) + 1;
			}
			else
			{
				classIncidence = 1;
			}
			
			classIncidencesMap.put(sampleClass,classIncidence);		
		}
		
		// 3. Itera sobre o mapa de inciências para descobrir 
		//    a classe vencedora
			
		String  majorClass 	   = "";
		Integer majorIncidence = 0;

		Set<String> classIncidencesMapKeys = classIncidencesMap.keySet();
		
		for (String className : classIncidencesMapKeys) 
		{
			int classIncidence = classIncidencesMap.get(className);
						
			if (classIncidence > majorIncidence)
			{
				majorIncidence = classIncidence;
				majorClass = className;				
			}	
		}		
		
		return majorClass;
	}	
}

 *
 */
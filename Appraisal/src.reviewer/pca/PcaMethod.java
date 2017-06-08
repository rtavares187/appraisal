package pca;

import java.util.ResourceBundle;

import junit.framework.TestCase;
import appraisal.proccess.stages.impl.PcaStage;
import context.AppraisalContext;
import database.DatabaseException;
import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;
import entities.results.SelectionResult;

public class PcaMethod extends TestCase 
{
	String database;
	
	public PcaMethod() 
	{
		try
		{
			// 	1. Carrega contexto
			AppraisalContext.initializeContext();
			
			// Lê arquivo de propriedades
			ResourceBundle properties = ResourceBundle.getBundle("pca.pcamethod");
			database = properties.getString("database");
		}
		catch(Exception e){}
	}
	
	public void test() throws DatabaseException
	{
		PcaStage pca = new PcaStage();
		
		DatabaseHandler databaseHandler = MySQLHandler.getInstance();
		databaseHandler.selectDatabase(database);
		
		Dataset dataset = databaseHandler.toDataset();
		
		SelectionResult rr = pca.run(dataset);
		System.out.println(rr);
	}
	
	public static void main(String[] args) throws Exception
	{
		new PcaMethod().test();
	}	
}

//package pca;
//
//import java.util.List;
//import java.util.ResourceBundle;
//
//import junit.framework.TestCase;
//
//import org.math.array.LinearAlgebra;
//import org.math.array.StatisticSample;
//import org.math.array.linearalgebra.EigenvalueDecomposition;
//
//import Jama.Matrix;
//import appraisal.proccess.stages.impl.PcaStage;
//
//import common.NumberFormatters;
//import common.ValuedAttribute;
//
//import context.AppraisalContext;
//import entities.dataset.Dataset;
//import entities.dataset.Tuple;
//
//public class PcaMethod extends TestCase 
//{
//	String database;
//	
//	public PcaMethod() 
//	{
//		try
//		{
//			// 	1. Carrega contexto
//			AppraisalContext.initializeContext();
//			
//			// Lê arquivo de propriedades
//			ResourceBundle properties = ResourceBundle.getBundle("pca.pcamethod");
//			database = properties.getString("database");
//		}
//		catch(Exception e){}
//	}
//	
////	public void test() throws DatabaseException
////	{
////		PcaStage pca = new PcaStage();
////		
////		DatabaseHandler databaseHandler = MySQLHandler.getInstance();
////		databaseHandler.selectDatabase(database);
////		
////		Dataset dataset = databaseHandler.toDataset();
////		
////		evaluate(dataset);		
////	}
//	
//	public void test() throws Exception
//	{
//		// 3. Cria etapa de bkprop
//		PcaStage pca = new PcaStage();
//		
//		Dataset dataset = new Dataset("col1","col2");		
//		dataset.addTuple(new Tuple(0,2.4,2.5));
//		dataset.addTuple(new Tuple(1,0.7,0.5));
//		dataset.addTuple(new Tuple(2,2.9,2.2));
//		dataset.addTuple(new Tuple(3,2.2,1.9));
//		dataset.addTuple(new Tuple(4,3.0,3.1));
//		dataset.addTuple(new Tuple(5,2.7,2.3));
//		dataset.addTuple(new Tuple(6,1.6,2));
//		dataset.addTuple(new Tuple(7,1.1,1));
//		dataset.addTuple(new Tuple(8,1.6,1.5));
//		dataset.addTuple(new Tuple(9,0.9,1.1));		 
//
//		evaluate(dataset);
//				
//		dataset = new Dataset("col2","col1");
//		dataset.addTuple(new Tuple(0,2.5,2.4));
//		dataset.addTuple(new Tuple(1,0.5,0.7));
//		dataset.addTuple(new Tuple(2,2.2,2.9));
//		dataset.addTuple(new Tuple(3,1.9,2.2));
//		dataset.addTuple(new Tuple(4,3.1,3.0));
//		dataset.addTuple(new Tuple(5,2.3,2.7));
//		dataset.addTuple(new Tuple(6,2,1.6));
//		dataset.addTuple(new Tuple(7,1,1.1));
//		dataset.addTuple(new Tuple(8,1.5,1.6));
//		dataset.addTuple(new Tuple(9,1.1,0.9));			
//		
//		evaluate(dataset);		
//	}	
//	
//	public static void main(String[] args) throws Exception
//	{
//		new PcaMethod().test();
//	}
//	
//	
//	public List<ValuedAttribute<String>> evaluate(Dataset pcaDataset) 
//	{
//		double[][] dataMatrix = pcaDataset.toMatrixInverse();
//		return evaluate(pcaDataset.getColumns(),dataMatrix);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<ValuedAttribute<String>> evaluate(List<String> attributeNames,double[][] data)
//	{
//		// Normaliza os dados
//		double[] dataMean = new double[data.length];
//		                               
//		for (int i = 0; i < dataMean.length; i++) 
//		{
//			dataMean[i] = StatisticSample.mean(data[i]);			
//		}
//		                               
//		for (int i = 0; i < data.length; i++) 
//		{
//			double[] attribute = data[i];
//			
//			for (int j = 0; j < attribute.length; j++) 
//			{
//				attribute[j] = attribute[j]-dataMean[i];				
//			}		
//		}
//				
//		// Calcula cô-variancia
//		double[][] covarianceMatrix = new double[data.length][data.length];
//		
//		for (int i = 0; i < data.length; i++) 
//		{
//			for (int j = 0; j < data.length; j++) 
//			{
//				covarianceMatrix[i][j] = StatisticSample.covariance(data[i],data[j]); 				
//			}		
//		}
//						
//		// Calcula matriz e valores de igualdade
//		math2(covarianceMatrix);
//		
////		// Monta resultados
////		List<ValuedAttribute<String>> attributes = new ArrayList<ValuedAttribute<String>>();
////		
////		for (int i = 0; i < attributeNames.size(); i++) 
////		{
////			ValuedAttribute<String> attribute = new ValuedAttribute<String>(eigenValues[i],attributeNames.get(i));
////			attributes.add(attribute);
////		}
////		
////		Collections.sort(attributes);
////		Collections.reverse(attributes);
//		
//		return null;
//	}
//
//	private void math2(double[][] covarianceMatrix) 
//	{
//		Matrix matrix = new Matrix(covarianceMatrix);
//		Jama.EigenvalueDecomposition eigen = new Jama.EigenvalueDecomposition(matrix);
//		
//		double[] eigenValues = eigen.getRealEigenvalues();
//		Matrix dd = eigen.getV();
//		Matrix eigenValues2 = eigen.getD();
//				
//		System.out.println();
//		printMatrix(dd);
//		System.out.println();
//		printMatrix(eigenValues2);
//		System.out.println();
//		printVector(eigenValues);
//	}
//	
//	private void math1(double[][] covarianceMatrix) 
//	{
//		EigenvalueDecomposition eigen = LinearAlgebra.eigen(covarianceMatrix);
//		
//		double[] eigenValues = eigen.get1DRealD();
//		double[][] dd = eigen.getV();
//		double[][] eigenValues2 = eigen.getRealD();
//				
//		System.out.println();
//		printMatrix(dd);
//		System.out.println();
//		printMatrix(eigenValues2);
//		System.out.println();
//		printVector(eigenValues);
//	}
//	
//	private void printVector(double[] d) 
//	{
//		for (double e : d) 
//		{
//			System.out.print(e+"\t");				
//		}
//		System.out.println();							
//	}
//	
//	private void printMatrix(Matrix m)
//	{
//		printMatrix(m.getArray());
//	}
//	
//	private void printMatrix(double[][] d) 
//	{
//		for (double[] es : d) 
//		{
//			for (double e : es) 
//			{
//				System.out.print(NumberFormatters.decimalFormatter.format(e)+"\t");				
//			}
//			System.out.println();			
//		}		
//	}
//	
//}
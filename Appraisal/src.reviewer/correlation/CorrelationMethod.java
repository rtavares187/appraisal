package correlation;

import java.util.ResourceBundle;

import junit.framework.TestCase;

import org.math.array.StatisticSample;

import common.NumberFormatters;

import pca.PcaMethod;

import context.AppraisalContext;
import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;

public class CorrelationMethod extends TestCase
{
	String database;
	
	public CorrelationMethod() 
	{
		try
		{
			// 	1. Carrega contexto
			AppraisalContext.initializeContext();
			
			// Lê arquivo de propriedades
			ResourceBundle properties = ResourceBundle.getBundle("correlation.correlation");
			database = properties.getString("database");
		}
		catch(Exception e){}
	}
	
	public void test() throws Exception
	{
		DatabaseHandler databaseHandler = MySQLHandler.getInstance();
		databaseHandler.selectDatabase(database);
		
		Dataset dataset = databaseHandler.toDataset();
		
		double[][] d = dataset.toMatrix();
						
		double[][] cor = StatisticSample.correlation(d);
		
		System.out.println(dataset.getColumns());
		printMatrix(cor);				
	}
	
	private void printMatrix(double[][] d) 
	{
		for (double[] es : d) 
		{
			for (double e : es) 
			{
				System.out.print(NumberFormatters.decimalFormatter.format(e)+"\t");				
			}
			System.out.println();			
		}		
	}
	
	public static void main(String[] args) throws Exception
	{
		new PcaMethod().test();
	}
}
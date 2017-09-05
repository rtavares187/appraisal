package classification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import comite.ComiteContext;

import classification.impl.BkPropClassification;
import classification.writer.ResultWriter;
import context.AppraisalContext;
import database.DatabaseException;
import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.RegressionResult;
import entities.results.StrategyResult;

public class ClassificationMethod 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ClassificationMethod.class);
	
	//
	// Atributos
	//
	ResourceBundle properties;	// Arquivo fonte de propriedades
				
	//
	// Construtor
	//
	public ClassificationMethod()
	{
		try
		{
			// Lê arquivo de propriedades
			properties = ResourceBundle.getBundle("classification.classificator");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void run() throws IOException
	{
		// Infra-Estrutura
		DatabaseHandler databaseHandler = MySQLHandler.getInstance();
				
		//
		// 1. Recupera parâmetros principais
		//
		String resultsPath = getStringProperty("results.path");
		String originalDatabase = getStringProperty("original.database");
		String codifiedDatabase = getStringProperty("codified.database");
		String codifiedEconomicDatabase = getStringProperty("codified.economic.database");
		String regressionData = getStringProperty("regression.database");
		String regressionColumn = getStringProperty("regression.column");		
		
		LOGGER.info("Base Original: "+originalDatabase);
		LOGGER.info("Base Codificada: "+codifiedDatabase);
		LOGGER.info("Base Codificada Econômica: "+codifiedEconomicDatabase);
				
		String[] percents = getStringProperty("regression.percents").split(",");
		
		for (String percent : percents)
		{
			String regressionDatabase = regressionData+"_"+percent;
			ComiteContext.setRegressionDatabase(regressionDatabase);
		
			LOGGER.info("**************************************");
			LOGGER.info("**************************************");
			LOGGER.info("Base de Regressão: "+regressionDatabase);
			LOGGER.info("Coluna de Regressão: "+regressionColumn);
			
			Dataset originalDataset;
			Dataset codifiedDataset;
			Dataset codifiedEconomicDataset;
			Dataset regressionDataset;
		
			//
			// 2. Recupera as bases do banco
			//
			try 
			{
				databaseHandler.selectDatabase(originalDatabase);
				originalDataset = databaseHandler.toDataset();
				
				databaseHandler.selectDatabase(codifiedDatabase);
				codifiedDataset = databaseHandler.toDataset();
				
				databaseHandler.selectDatabase(codifiedEconomicDatabase);
				codifiedEconomicDataset = databaseHandler.toDataset();
				
				databaseHandler.selectDatabase(regressionDatabase);
				regressionDataset = databaseHandler.toDataset();
			}
			catch (DatabaseException e) 
			{
				e.printStackTrace();
				return;
			}
				
			// 3. Recupera resultados dos arquivos
			List<StrategyResult> results = readFromFiles(new File(resultsPath+"//"+regressionDatabase),regressionColumn);	
			
			try 
			{
				databaseHandler.selectDatabase(originalDatabase);			
			}
			catch (DatabaseException e) 
			{
				e.printStackTrace();
				return;
			}
			
			// 4. Valida os resultados
			runValidation(databaseHandler, codifiedDatabase, codifiedEconomicDatabase, regressionColumn, codifiedDataset, codifiedEconomicDataset, regressionDataset, results);
	
			// 5.  Escreve resultados no disco
			ResultWriter.writeErrorMarginResultsExcel(regressionDatabase,results, regressionColumn, originalDataset);
		}
	}

	private void runValidation(DatabaseHandler databaseHandler, String codifiedDatabase, String codifiedEconomicDatabase, String regressionColumn, Dataset codifiedDataset, Dataset codifiedEconomicDataset, Dataset regressionDataset, List<StrategyResult> results) 
	{
		try
		{
			databaseHandler.selectDatabase(codifiedDatabase);
			BkPropClassification.crossValidate(codifiedDataset, results, regressionColumn, regressionDataset.splitTrainTest(regressionColumn)[0]);
			databaseHandler.selectDatabase(codifiedEconomicDatabase);
			BkPropClassification.crossValidate(codifiedEconomicDataset, results, regressionColumn, regressionDataset.splitTrainTest(regressionColumn)[0]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private List<StrategyResult> readFromFiles(File resultsDirectory,String regressionColumn) throws IOException 
	{
		String[] resultsDirectoryList = resultsDirectory.list();
		List<StrategyResult> results = new ArrayList<StrategyResult>();
		
		for (String strategy : resultsDirectoryList) 
		{
			File strategyDirectory = new File(resultsDirectory.getAbsolutePath()+"//"+strategy);
			
			if (strategyDirectory.isDirectory())
			{
				String[] strategyDirectoryList = strategyDirectory.list();
				
				for (String plan : strategyDirectoryList) 
				{
					File planDirectory = new File(strategyDirectory.getAbsolutePath()+"//"+plan);
					
					File targetDatasetFile =  new File(planDirectory.getAbsolutePath()+"//targetRegression.txt");
					File trainDatasetFile =  new File(planDirectory.getAbsolutePath()+"//trainRegression.txt");
					File metaFile = new File(planDirectory.getAbsolutePath()+"//meta.txt");
					
					Dataset targetDataset = new Dataset(targetDatasetFile,regressionColumn);
					Dataset trainDataset = new Dataset(trainDatasetFile,regressionColumn);
					
					BufferedReader reader = new BufferedReader(new FileReader(metaFile));
					
					String instanceId = reader.readLine().split(":")[1];
					double planTime = Double.parseDouble(reader.readLine().split(":")[1]);
					double planMedianTime = Double.parseDouble(reader.readLine().split(":")[1]);
					
					RegressionResult rr = new RegressionResult(trainDataset,targetDataset);
					
					InstanceResult ir = new InstanceResult(instanceId,rr);
					
					PlanResult pr = new PlanResult(plan);
					pr.addInstance(ir);
					pr.setTime(planTime);
					pr.setMedianTime(planMedianTime);
					
					StrategyResult sr = new StrategyResult(strategy);
					sr.addPlanResult(pr);
					
					results.add(sr);
																				
				}
			}
		}
		return results;
	}
	
	//////////////////////////////////////////////////////
	// Métodos auxiliares para extração de propriedades //
	//////////////////////////////////////////////////////
	private String getStringProperty(String propertyName) 
	{
		return properties.getString(propertyName);		
	}	

	/////////////////
	// Método main //
	/////////////////
	public static void main(String[] args)
	{
		LOGGER.info("Inicializando...");
		
		// 1. Carrega contexto
		AppraisalContext.initializeContext();

		try 
		{
			new ClassificationMethod().run();
		}
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
	}	
}
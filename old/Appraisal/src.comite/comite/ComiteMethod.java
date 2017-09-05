package comite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import comite.impl.BkPropComite;
import comite.writer.ResultWriter;

import context.AppraisalContext;
import database.DatabaseException;
import database.DatabaseHandler;
import database.MySQLHandler;
import entities.dataset.Dataset;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.RegressionResult;
import entities.results.StrategyResult;

public class ComiteMethod 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ComiteMethod.class);
	
	//
	// Atributos
	//
	ResourceBundle properties;	// Arquivo fonte de propriedades
				
	//
	// Construtor
	//
	public ComiteMethod()
	{
		try
		{
			// Lê arquivo de propriedades
			properties = ResourceBundle.getBundle("comite.comite");
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
		String resultsPath        = getStringProperty("results.path");
		String regressionData     = getStringProperty("regression.database");
		String regressionColumn   = getStringProperty("regression.column");		
		
		String[] percents		  = getStringProperty("regression.percents").split(",");
		
		for (String percent : percents)
		{
			String regressionDatabase = regressionData+"_"+percent;
			ComiteContext.setRegressionDatabase(regressionDatabase);
			
			LOGGER.info("**************************************");
			LOGGER.info("**************************************");
			LOGGER.info("Base de Regressão: "+regressionDatabase);
			LOGGER.info("Coluna de Regressão: "+regressionColumn);
			
			Dataset regressionDataset;
			
			//
			// 2. Recupera as bases do banco
			//
			try 
			{
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
			
			// 4. Executa o comite
			runComite(regressionDatabase, regressionColumn, regressionDataset, results);
		}						
	}

	private void runComite(String regressionDatabase, String regressionColumn, Dataset regressionDataset, List<StrategyResult> results) 
	{	
		// Marca tempo
		long start = System.currentTimeMillis();
					
		// Roda o ComiteMethod
		List<Dataset> trainSuggestions = new ArrayList<Dataset>();
		List<Dataset> targetSuggestions = new ArrayList<Dataset>();
		
		for (StrategyResult sresult : results) 
		{
			for(PlanResult presult : sresult.getPlanResults())
			{
				InstanceResult rr = presult.getResults().get(0);
				trainSuggestions.add(rr.getRegressionResult().getTrainDataRegression());
				targetSuggestions.add(rr.getRegressionResult().getTargetDataRegression());
			}				
		}
		
		Comite comite = new BkPropComite();
		RegressionResult rr = comite.run(regressionColumn, regressionDataset, trainSuggestions, targetSuggestions);
		
		// Marca tempo
		long end = System.currentTimeMillis();
		
		StrategyResult comiteSr = new StrategyResult("comite");
		PlanResult planSr = new PlanResult(new String[]{"comite"});
		InstanceResult instaceSr = new InstanceResult("comite",rr,end-start);
		
		planSr.addInstance(instaceSr);
		comiteSr.addPlanResult(planSr);
					
		// Escreve resultados no disco
		ResultWriter.writeCrudeResults(comiteSr);
		
		// Adiciona na lista geral
		results.add(comiteSr);
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
					if (plan.equals("comite"))
						continue;
					
					if (!Boolean.parseBoolean(properties.getString(plan)))
						continue;
						
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
			new ComiteMethod().run();
		}
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
	}	
}
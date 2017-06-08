package appraisal.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entities.dataset.Dataset;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.StrategyResult;

public class ResultWriter 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ResultWriter.class);
	
	// Constantes
	private static String resultsPath;
	private static String regressionDatabase;
	
	static
	{
		// Lê arquivo de propriedades
		ResourceBundle properties = ResourceBundle.getBundle("appraisal.strategies");
		resultsPath = properties.getString("results.path");		
		regressionDatabase = properties.getString("regression.database");		
	}
		
	public static void writeCrudeResults(List<StrategyResult> srs)
	{
		for (StrategyResult result : srs) 
		{
			writeCrudeResults(result);
		}
	}
	
	public static void writeCrudeResults(StrategyResult sr)
	{
		// 1. Cria o diretório raiz
		File rootDir = new File(resultsPath);
		if (!rootDir.exists())rootDir.mkdir();

		//	1. Cria o diretório do database
		File dataDir = new File(rootDir.getAbsolutePath()+"//"+regressionDatabase);
		if (!dataDir.exists())dataDir.mkdir();
		
		// 2. Cria o diretório da estratégia
		File strategyDir = new File(dataDir.getAbsolutePath()+"\\"+sr.getStrategyId());
		if (!strategyDir.exists())strategyDir.mkdir();
		
		// 3. PARA cada plano
		List<PlanResult> planResults = sr.getPlanResults();
		
		for (PlanResult planResult : planResults) 
		{
			// 3.1. Cria o diretório do plano
			File resultsDir = new File(strategyDir.getAbsolutePath()+"\\"+planResult.getId());
			if (!resultsDir.exists())resultsDir.mkdir();
			
			InstanceResult instanceResult = planResult.getResults().get(0);
							
			// 4.2. Cria os arquivos de resultado 
			LOGGER.debug("Persisting - "+planResult.getId());
			
			File metaFile = new File(resultsDir.getAbsolutePath()+"\\meta.txt");
			File trainRegressionFile = new File(resultsDir.getAbsolutePath()+"\\trainRegression.txt");
			File targetRegressionFile = new File(resultsDir.getAbsolutePath()+"\\targetRegression.txt");
						
			Dataset trainDataset = instanceResult.getRegressionResult().getTrainDataRegression();
			Dataset targetDataset = instanceResult.getRegressionResult().getTargetDataRegression();
			
			trainDataset.toFile(trainRegressionFile);
			targetDataset.toFile(targetRegressionFile);
			
			try
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(metaFile));
				
				writer.append("id:"+instanceResult.getId());
				writer.newLine();
				writer.append("time:"+planResult.getTime());
				writer.newLine();
				writer.append("median_time:"+planResult.getMedianTime());
				
				writer.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
package classification.writer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entities.dataset.Dataset;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.RegressionResult;
import entities.results.StrategyResult;

public class ResultWriter 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ResultWriter.class);
	
	// Constantes
	private static String resultsPath;
	
	private static double errorE; // e+, fator de incremento no divisor do RAD
	private static List<String> errorMeasures;
	
	static
	{
		// Lê arquivo de propriedades
		ResourceBundle properties = ResourceBundle.getBundle("classification.classificator");
		resultsPath = properties.getString("results.path");
		
		String[] measures = properties.getString("error.measure").split(",");
		errorMeasures = new ArrayList<String>();
		
		for (String measure : measures) 
		{
			errorMeasures.add(measure);
		}
		
		errorE = Double.parseDouble(properties.getString("error.e"));
	}
	
	public static void writeErrorMarginResultsExcel(String regressionDatabase,List<StrategyResult> strategyResults,String regressionColumn,Dataset originalDataset)
	{
		// 1. Cria o diretório raiz
		File rootDir = new File(resultsPath);
		if (!rootDir.exists())rootDir.mkdir();
		
		//	1. Cria o diretório do database
		File dataDir = new File(rootDir.getAbsolutePath()+"//"+regressionDatabase);
		if (!dataDir.exists())dataDir.mkdir();
		
		try 
		{
			// 1. Create a new workbook
			WritableWorkbook workbook = Workbook.createWorkbook(new File(dataDir.getAbsolutePath()+"\\"+regressionDatabase+".xls"));

			// 2. Create a new worksheet
			WritableSheet deviationSheet = workbook.createSheet("Deviation", 0);
			WritableSheet legendSheet = workbook.createSheet("Legend", 1);
			
			// 3. Create the header data cells
			makeHeaders(deviationSheet);
						
			// 4. Create the body
			makeBody(strategyResults, regressionColumn, originalDataset, deviationSheet, legendSheet);
			
			workbook.write();
		    workbook.close();
		    
		    new ResultAdapter().adapt(new File(dataDir.getAbsolutePath()+"\\"+regressionDatabase+".new.xls"),new File(dataDir.getAbsolutePath()+"\\"+regressionDatabase+".xls"));
		} 
		catch (WriteException e) 
		{		
			e.printStackTrace();
		}
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void makeBody(List<StrategyResult> strategyResults, String regressionColumn, Dataset originalDataset, WritableSheet deviationSheet, WritableSheet legendSheet) throws WriteException, RowsExceededException 
	{
		Dataset originalColumn = originalDataset.copyColumn(regressionColumn);
		
		int rowCount = 1;
		
		int planCode = 0;
		int instanceCode = 0;
		int strategyCode = 0;
		
		// Formatos de escrita
		WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.FLOAT);
		WritableCellFormat percentFloatFormat = new WritableCellFormat (NumberFormats.PERCENT_FLOAT);
		
		// Para cada estratégia
		for (StrategyResult strategyResult : strategyResults) 
		{
			List<PlanResult> planResults = strategyResult.getPlanResults();
			
			// Para cada plano
			for (PlanResult planResult : planResults) 
			{
				List<InstanceResult> instanceResults = planResult.getResults();
									
				for (InstanceResult result : instanceResults) 
				{
					// Calcula o desvio da base regredida para a base original
					RegressionResult rr = result.getRegressionResult();
					
					Dataset trainDataset = rr.getTrainDataRegression();
					Dataset targetDataset = rr.getTargetDataRegression();
					
					int columnTrace2 = 0;
					
					for(String errorMeasure : errorMeasures)
					{
						double trainDeviation = 0;
						double targetDeviation = 0;
						
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
						else if (errorMeasure.equals("mse"))
						{
							trainDeviation = originalColumn.meanSquareError(trainDataset);
							targetDeviation = originalColumn.meanSquareError(targetDataset);
						}
						else if (errorMeasure.equals("rmse"))
						{
							trainDeviation = Math.sqrt(originalColumn.meanSquareError(trainDataset));
							targetDeviation = Math.sqrt(originalColumn.meanSquareError(targetDataset));
						}
												
						double totalDeviation = (trainDeviation+targetDeviation)/2;
						
						String code;
						
						if (instanceResults.size()>1)
						{
							code = "S"+strategyCode+"P"+planCode+"I"+instanceCode;
						}
						else
						{
							code = "S"+strategyCode+"P"+planCode;
						}
						
						// Adiciona na planilha de desvio
						deviationSheet.addCell(new Label(0,rowCount,code));
						
						if (errorMeasure.equals("ad"))
						{
							deviationSheet.addCell(new jxl.write.Number(columnTrace2+1,rowCount,trainDeviation,floatFormat));
							deviationSheet.addCell(new jxl.write.Number(columnTrace2+2,rowCount,targetDeviation,floatFormat));
							deviationSheet.addCell(new jxl.write.Number(columnTrace2+3,rowCount,totalDeviation,floatFormat));
							
							columnTrace2+=3;
						}
						else if (errorMeasure.equals("rad") || errorMeasure.equals("sim") || errorMeasure.equals("e+") ||
								 errorMeasure.equals("mse") || errorMeasure.equals("rmse"))
						{
							deviationSheet.addCell(new jxl.write.Number(columnTrace2+1,rowCount,trainDeviation/100,percentFloatFormat));
							deviationSheet.addCell(new jxl.write.Number(columnTrace2+2,rowCount,targetDeviation/100,percentFloatFormat));
							deviationSheet.addCell(new jxl.write.Number(columnTrace2+3,rowCount,totalDeviation/100,percentFloatFormat));
							
							columnTrace2+=3;
						}				
							
						// Adiciona na planilha de legendas
						legendSheet.addCell(new Label(0,rowCount-1,code));
						legendSheet.addCell(new Label(1,rowCount-1,planResult.getId()+" || "+result.getId()));
					}
						
					deviationSheet.addCell(new jxl.write.Number(columnTrace2+1,rowCount,result.getCrossFolder().get(0),percentFloatFormat));
					deviationSheet.addCell(new jxl.write.Number(columnTrace2+2,rowCount,result.getCrossFolder().get(1),percentFloatFormat));
					deviationSheet.addCell(new jxl.write.Number(columnTrace2+3,rowCount,planResult.getMedianTime(),floatFormat));
					deviationSheet.addCell(new jxl.write.Number(columnTrace2+4,rowCount,planResult.getTime(),floatFormat));
					
					rowCount++;
					instanceCode++;
														
					LOGGER.debug("Plan: "+result.getId());
				}		
				
				instanceCode=0;
				planCode++;
			}				
			
			planCode=0;
			strategyCode++;
		}
	}

	private static void makeHeaders(WritableSheet deviationSheet) throws WriteException, RowsExceededException 
	{
		deviationSheet.addCell(new Label(0,0,"Code"));
		
		// 4. Column trace
		int columnTrace = 0;
		
		for(String errorMeasure : errorMeasures)
		{
			if (errorMeasure.equals("ad"))
			{
				deviationSheet.addCell(new Label(columnTrace+1,0,"Train AD"));
				deviationSheet.addCell(new Label(columnTrace+2,0,"Target AD"));
				deviationSheet.addCell(new Label(columnTrace+3,0,"Total AD"));
				
				columnTrace+=3;
			}
			if (errorMeasure.equals("rad"))
			{
				deviationSheet.addCell(new Label(columnTrace+1,0,"Train RAD"));
				deviationSheet.addCell(new Label(columnTrace+2,0,"Target RAD"));
				deviationSheet.addCell(new Label(columnTrace+3,0,"Total RAD"));
				
				columnTrace+=3;
			}
			if (errorMeasure.equals("sim"))
			{
				deviationSheet.addCell(new Label(columnTrace+1,0,"Train Sim"));
				deviationSheet.addCell(new Label(columnTrace+2,0,"Target Sim"));
				deviationSheet.addCell(new Label(columnTrace+3,0,"Total Sim"));
				
				columnTrace+=3;
			}
			if (errorMeasure.equals("e+"))
			{
				deviationSheet.addCell(new Label(columnTrace+1,0,"Train E+"));
				deviationSheet.addCell(new Label(columnTrace+2,0,"Target E+"));
				deviationSheet.addCell(new Label(columnTrace+3,0,"Total E+"));
				
				columnTrace+=3;
			}
			if (errorMeasure.equals("mse"))
			{
				deviationSheet.addCell(new Label(columnTrace+1,0,"Train MSE"));
				deviationSheet.addCell(new Label(columnTrace+2,0,"Target MSE"));
				deviationSheet.addCell(new Label(columnTrace+3,0,"Total MSE"));
				
				columnTrace+=3;
			}
			if (errorMeasure.equals("rmse"))
			{
				deviationSheet.addCell(new Label(columnTrace+1,0,"Train RMSE"));
				deviationSheet.addCell(new Label(columnTrace+2,0,"Target RMSE"));
				deviationSheet.addCell(new Label(columnTrace+3,0,"Total RMSE"));
				
				columnTrace+=3;
			}
		}	
		
		deviationSheet.addCell(new Label(columnTrace+1,0,"Bin Valid"));
		deviationSheet.addCell(new Label(columnTrace+2,0,"Eco Valid"));
		deviationSheet.addCell(new Label(columnTrace+3,0,"Time Median"));
		deviationSheet.addCell(new Label(columnTrace+4,0,"Time Total"));
	}
	
}
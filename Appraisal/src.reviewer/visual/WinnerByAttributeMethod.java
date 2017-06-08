package visual;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class WinnerByAttributeMethod extends RunnerMethod 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(WinnerByAttributeMethod.class);
	
	Map<String,Integer> radStrategiesWinsMap;
	Map<String,Integer> mseStrategiesWinsMap;
	
	String actualAttribute = "";
	
	public WinnerByAttributeMethod()
	{
		resetMaps();
	}
	
	@Override
	protected void foundAttribute(String database, String attribute, File attributeDir) throws Exception
	{
		String attributeName = attribute.split("_")[2];
		
		if (!attributeName.equals(actualAttribute))
		{
			if (!actualAttribute.equals(""))
			{
				// Monta o gráfico
				DefaultPieDataset radDataset = new DefaultPieDataset();
				DefaultPieDataset mseDataset = new DefaultPieDataset();
		        
				for (Entry<String,Integer> entry : radStrategiesWinsMap.entrySet())
				{
					radDataset.setValue(entry.getKey(),entry.getValue());					
				}
				
				for (Entry<String,Integer> entry : mseStrategiesWinsMap.entrySet())
				{
					mseDataset.setValue(entry.getKey(),entry.getValue());					
				}
				
				JFreeChart radChart = ChartFactory.createPieChart3D(actualAttribute, radDataset, false, false, false);
		        PiePlot3D  radPlot  = (PiePlot3D) radChart.getPlot();
		        radPlot.setForegroundAlpha(0.6f);
		        radPlot.setCircular(true);
		        
		        JFreeChart mseChart = ChartFactory.createPieChart3D(actualAttribute, mseDataset, false, false, false);
		        PiePlot3D  msePlot  = (PiePlot3D) mseChart.getPlot();
		        msePlot.setForegroundAlpha(0.6f);
		        msePlot.setCircular(true);
		        
				File graphsDir = new File("C:\\Documents and Settings\\005486\\piecharts");
				if (!graphsDir.exists())graphsDir.mkdir();
				
				File databaseDir = new File("C:\\Documents and Settings\\005486\\piecharts\\"+database);
				if (!databaseDir.exists())databaseDir.mkdir();

		        ChartUtilities.saveChartAsJPEG(new File(databaseDir.getAbsolutePath()+"\\"+actualAttribute+"_rad.png"),radChart,560,295);
				ChartUtilities.saveChartAsJPEG(new File(databaseDir.getAbsolutePath()+"\\"+actualAttribute+"_mse.png"),mseChart,560,295);
				
			}
			
			resetMaps();
			actualAttribute = attributeName;
			LOGGER.info("Reading "+actualAttribute+" FROM "+database);
		}
		
		if (attribute.contains("10"))
		{
			System.out.println("10");
		}
		if (attribute.contains("20"))
		{
			System.out.println("20");
		}
		if (attribute.contains("30"))
		{
			System.out.println("30");
		}
		if (attribute.contains("40"))
		{
			System.out.println("40");
		}
		if (attribute.contains("50"))
		{
			System.out.println("50");
		}
				
		// 1. Monta workbook do excel
		File 	 file 	  = new File(attributeDir.getAbsolutePath()+"//"+attribute+".new.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet 	 sheet 	  = workbook.getSheet("Results");
		
		// 2. Cria uma lista com os cabeçalhos
		Cell[] 		 headers 	 = sheet.getRow(1);
		List<String> headersList = new ArrayList<String>();
		
		for (Cell cell : headers) 
		{
			headersList.add(cell.getContents());			
		}
		
		// 3. Recupera posições importantes
		int STRAT_POSITION = headersList.indexOf("Estratégia");
		int PLAN_POSITION = headersList.indexOf("Plano");
		int RAD_POSITION = headersList.indexOf("Target RAD");
		int MSE_POSITION = headersList.indexOf("Target MSE");
		
		// 5. Guarda e ordena os resultados
		List<WBAResult> radResults = new ArrayList<WBAResult>();
		List<WBAResult> mseResults = new ArrayList<WBAResult>();
		
		for (int i=2;i<sheet.getRows();i++)
		{
			Cell[] cells = sheet.getRow(i);
			
			String plan  = cells[PLAN_POSITION].getContents();
			String strat = cells[STRAT_POSITION].getContents();
			String rad   = cells[RAD_POSITION].getContents().replaceAll("%","").replaceAll(",",".");
			String mse   = cells[MSE_POSITION].getContents().replaceAll("%","").replaceAll(",",".");
			
			radResults.add(new WBAResult(plan,strat,Double.parseDouble(rad)));
			mseResults.add(new WBAResult(plan,strat,Double.parseDouble(mse)));								
		}	
					
		Collections.sort(radResults);
		Collections.sort(mseResults);
		
		WBAResult radWinner = radResults.get(0);
		WBAResult mseWinner = mseResults.get(0);
		
		String radStratWinner = radWinner.getStrat();
		String mseStratWinner = mseWinner.getStrat();
		
		radStrategiesWinsMap.put(radStratWinner,radStrategiesWinsMap.get(radStratWinner)+1);
		mseStrategiesWinsMap.put(mseStratWinner,mseStrategiesWinsMap.get(mseStratWinner)+1);
				
		workbook.close();
	}
	
	public static void main(String[] args)
	{
		try 
		{
			new WinnerByAttributeMethod().start(new File("C:\\Documents and Settings\\005486\\kdd\\iris"));
		}
		catch (Exception e) 
		{		
			e.printStackTrace();
		}
	}
	
	@Override
	protected void foundDatabase(String database, File databaseDir) throws Exception 
	{			
	}
	
	private void resetMaps() 
	{
		radStrategiesWinsMap = new HashMap<String, Integer>();
		mseStrategiesWinsMap = new HashMap<String, Integer>();
		radStrategiesWinsMap.put("C",0);
		radStrategiesWinsMap.put("R",0);
		radStrategiesWinsMap.put("CR",0);
		radStrategiesWinsMap.put("SR",0);
		radStrategiesWinsMap.put("CSR",0);
		radStrategiesWinsMap.put("SCR",0);	
		mseStrategiesWinsMap.put("C",0);
		mseStrategiesWinsMap.put("R",0);
		mseStrategiesWinsMap.put("CR",0);
		mseStrategiesWinsMap.put("SR",0);
		mseStrategiesWinsMap.put("CSR",0);
		mseStrategiesWinsMap.put("SCR",0);
	}
}

class WBAResult implements Comparable<WBAResult>
{
	private String plan;
	private String strat;
	private double erro;
	
	public WBAResult(String plan, String strat,double erro) {
		super();
		this.plan = plan;
		this.strat=strat;
		this.erro = erro;
	}
	
	public String getStrat() {
		return strat;
	}
	public void setStrat(String strat) {
		this.strat = strat;
	}
	public double getErro() {
		return erro;
	}
	public void setErro(double erro) {
		this.erro = erro;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public int compareTo(final WBAResult other) {
		return new CompareToBuilder().append(erro,
				other.erro).toComparison();
	}
}
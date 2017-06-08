package visual;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ErrorByPlanMethod extends RunnerMethod 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(ErrorByPlanMethod.class);
	
	@Override
	protected void foundDatabase(String database, File databaseDir) throws Exception 
	{			
	}
	
	@Override
	protected void foundAttribute(String database, String attribute, File attributeDir) throws Exception
	{
		LOGGER.info("Reading "+attribute+" FROM "+database);
		
		// 1. Monta workbook do excel
		File file = new File(attributeDir.getAbsolutePath()+"//"+attribute+".new.xls");
		if (!file.exists())return;
		
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
		int PLAN_POSITION = headersList.indexOf("Plano");
		int RAD_POSITION = headersList.indexOf("Target RAD");
		int MSE_POSITION = headersList.indexOf("Target MSE");
		
		// 5. Guarda e ordena os resultados
		List<Result> radResults = new ArrayList<Result>();
		List<Result> mseResults = new ArrayList<Result>();
		
		for (int i=2;i<sheet.getRows();i++)
		{
			Cell[] cells = sheet.getRow(i);
			
			String plan = cells[PLAN_POSITION].getContents();
			String rad  = cells[RAD_POSITION].getContents().replaceAll("%","").replaceAll(",",".");
			String mse  = cells[MSE_POSITION].getContents().replaceAll("%","").replaceAll(",",".");
			
			radResults.add(new Result(plan,Double.parseDouble(rad)));
			mseResults.add(new Result(plan,Double.parseDouble(mse)));								
		}	
		
		// 4. Monta o gráfico
		JFreeChart			   radChart;
		JFreeChart			   mseChart;
		DefaultCategoryDataset radDataset = new DefaultCategoryDataset();
		DefaultCategoryDataset mseDataset = new DefaultCategoryDataset();
		
		Collections.sort(radResults);
		Collections.sort(mseResults);
		
		for (Result result : radResults)
		{
			radDataset.setValue(result.getErro(),result.getPlan(),"");					
		}	
		
		for (Result result : mseResults)
		{
			mseDataset.setValue(result.getErro(),result.getPlan(),"");					
		}	
		
		radChart = ChartFactory.createBarChart3D(attribute,"","Erro (%)", radDataset, PlotOrientation.VERTICAL, true, true, false );
		mseChart = ChartFactory.createBarChart3D(attribute,"","Erro (%)", mseDataset, PlotOrientation.VERTICAL, true, true, false );

		File graphsDir = new File("C:\\Documents and Settings\\005486\\charts");
		if (!graphsDir.exists())graphsDir.mkdir();
		
		File databaseDir = new File("C:\\Documents and Settings\\005486\\charts\\"+database);
		if (!databaseDir.exists())databaseDir.mkdir();
		
		ChartUtilities.saveChartAsJPEG(new File(databaseDir.getAbsolutePath()+"\\"+attribute+"_rad.png"),radChart,560,295);
		ChartUtilities.saveChartAsJPEG(new File(databaseDir.getAbsolutePath()+"\\"+attribute+"_mse.png"),mseChart,560,295);
		
		workbook.close();
	}
	
	public static void main(String[] args)
	{
		try {
			new ErrorByPlanMethod().start(new File("C:\\Documents and Settings\\005486\\kdd\\iris"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Result implements Comparable<Result>
{
	private String plan;
	private double erro;
	
	public Result(String plan, double erro) {
		super();
		this.plan = plan;
		this.erro = erro;
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
	
	public int compareTo(final Result other) {
		return new CompareToBuilder().append(erro,
				other.erro).toComparison();
	}
}
package visual;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphTest extends TestCase 
{	
	public void test() throws IOException
	{
		System.out.print("Starting report generation");		
		
		// Variáveis do chart
		System.out.print("Initializing dataset");
		
		JFreeChart			   chart;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.setValue(Math.random()*20,"R","petallength_10");
		dataset.setValue(Math.random()*20,"CR","petallength_10");
		dataset.setValue(Math.random()*20,"SR","petallength_10");
		dataset.setValue(Math.random()*20,"SCR","petallength_10");
		dataset.setValue(Math.random()*20,"CSR","petallength_10");
//		dataset.setValue(Math.random()*20,"R","20");
//		dataset.setValue(Math.random()*20,"CR","20");
//		dataset.setValue(Math.random()*20,"SR","20");
//		dataset.setValue(Math.random()*20,"SCR","20");
//		dataset.setValue(Math.random()*20,"CSR","20");
//		dataset.setValue(Math.random()*20,"R","30");
//		dataset.setValue(Math.random()*20,"CR","30");
//		dataset.setValue(Math.random()*20,"SR","30");
//		dataset.setValue(Math.random()*20,"SCR","30");
//		dataset.setValue(Math.random()*20,"CSR","30");
//		dataset.setValue(Math.random()*20,"R","40");
//		dataset.setValue(Math.random()*20,"CR","40");
//		dataset.setValue(Math.random()*20,"SR","40");
//		dataset.setValue(Math.random()*20,"SCR","40");
//		dataset.setValue(Math.random()*20,"CSR","40");
//		dataset.setValue(Math.random()*20,"R","50");
//		dataset.setValue(Math.random()*20,"CR","50");
//		dataset.setValue(Math.random()*20,"SR","50");
//		dataset.setValue(Math.random()*20,"SCR","50");
//		dataset.setValue(Math.random()*20,"CSR","50");
		
		chart = ChartFactory.createBarChart3D("Petallength FULL","Porcentagens","Erro", dataset, PlotOrientation.VERTICAL, true, true, false );
		
		ChartUtilities.saveChartAsJPEG(new File("C:\\Documents and Settings\\005486\\Desktop\\a.png"),chart,560,295);
	}
}
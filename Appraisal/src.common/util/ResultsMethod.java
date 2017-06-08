package util;


import java.io.File;

import junit.framework.TestCase;
import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;

import com.sun.org.apache.regexp.internal.RE;

public class ResultsMethod extends TestCase 
{
	public void test() throws Exception
	{
		File newFile = new File("C:\\test.xls");
		File oldFile = new File("C:\\iris_mcar_petallength_10.xls");
		
		// Cria os Workbooks
		Workbook 		 oldWorkbook = Workbook.getWorkbook(oldFile);
		WritableWorkbook newWorkbook = Workbook.createWorkbook(newFile);
		
		// Cria os Sheets
		Sheet 		  oldDeviationSheet = oldWorkbook.getSheet("Deviation");
		Sheet 		  oldLegendSheet 	= oldWorkbook.getSheet("Legend");
		WritableSheet newResultsSheet 	= newWorkbook.createSheet("Results",0);
		
		// Parte Inicial
		createLegendHeaders(newResultsSheet);
		transpondLegens(oldLegendSheet,newResultsSheet);
		
		// Parte Final
		createDeviationHeaders(newResultsSheet,oldDeviationSheet);
		transpondDeviations(newResultsSheet,oldDeviationSheet);
						
		// Fecha a sheet
		newWorkbook.write();
		newWorkbook.close();
		oldWorkbook.close();
	}

	private void transpondDeviations(WritableSheet newResultsSheet, Sheet oldDeviationSheet) throws Exception 
	{
		for (int i=1; i<oldDeviationSheet.getColumns() ; i++)
		{
			copyColumn(newResultsSheet, oldDeviationSheet, 1);
			copyColumn(newResultsSheet, oldDeviationSheet, 2);
			copyColumn(newResultsSheet, oldDeviationSheet, 3);
			copyColumn(newResultsSheet, oldDeviationSheet, 4);
			copyColumn(newResultsSheet, oldDeviationSheet, 5);
			copyColumn(newResultsSheet, oldDeviationSheet, 6);
			copyColumn(newResultsSheet, oldDeviationSheet, 7);			
		}
	}

	private void copyColumn(WritableSheet newResultsSheet, Sheet oldDeviationSheet, int column) throws WriteException, RowsExceededException 
	{
		// Train Results
		Cell[] oldCells = oldDeviationSheet.getColumn(column);
		
		// Copia o cabeçalho
		WritableCellFormat headerFormat = new WritableCellFormat();
		headerFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
		headerFormat.setAlignment(Alignment.CENTRE);
		headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		headerFormat.setWrap(true);
		
		String header = oldCells[0].getContents();
		newResultsSheet.addCell(new Label(10+(column-1),1,header,headerFormat));		
		
		// Copia os valores
		WritableCellFormat cellFormat = new WritableCellFormat(oldCells[1].getCellFormat());
		cellFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
				
		for (int i = 1; i < oldCells.length; i++) 
		{
			Cell oldCell = oldCells[i];
			
			String bruteContent = oldCell.getContents();
			double finalContent;
			
			try
			{
				if (bruteContent.contains("%"))
					finalContent = Double.parseDouble(oldCell.getContents().replace("%","").replace(",","."))/100;
				else
					finalContent = Double.parseDouble(oldCell.getContents().replace(",","."));
				
				newResultsSheet.addCell(new Number(10+(column-1),1+i,finalContent,cellFormat));
			}
			catch(Exception e)
			{
				newResultsSheet.addCell(new Label(10+(column-1),1+i,"",cellFormat));
			}
		}
	}

	private void createDeviationHeaders(WritableSheet newResultsSheet, Sheet oldDeviationSheet)
	{
		// Cria as colunas no novo Sheet
		CellView colView = new CellView();colView.setSize(2350);
		newResultsSheet.setColumnView(10,colView);
		newResultsSheet.setColumnView(11,colView);
		newResultsSheet.setColumnView(12,colView);
		newResultsSheet.setColumnView(13,colView);
		newResultsSheet.setColumnView(14,colView);
		newResultsSheet.setColumnView(15,colView);
		newResultsSheet.setColumnView(16,colView);		
	}

	private void transpondLegens(Sheet oldLegendSheet,WritableSheet newResultsSheet) throws Exception
	{
		Cell[] oldCells = oldLegendSheet.getColumn(1);
		
		// PARA cada célula do original
		for (int i = 0; i < oldCells.length; i++) 
		{
			// Recupera os detalhes da célula
			Cell oldCell = oldCells[i];
			String[] oldCellContentsSplit = StringUtils.split(oldCell.getContents()," || ");
			
			String planName = oldCellContentsSplit[0];
			String planDetails = oldCellContentsSplit[1];
			
			// Preenche os valores na planilha nova
			WritableCellFormat integerCellFormat = new WritableCellFormat(NumberFormats.INTEGER);
			integerCellFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
			integerCellFormat.setAlignment(Alignment.CENTRE);
			integerCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			
			WritableCellFormat centerTextCellFormat = new WritableCellFormat(NumberFormats.TEXT);
			centerTextCellFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
			centerTextCellFormat.setAlignment(Alignment.CENTRE);
			centerTextCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			
			WritableCellFormat leftTextCellFormat = new WritableCellFormat(NumberFormats.TEXT);
			leftTextCellFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
			leftTextCellFormat.setAlignment(Alignment.LEFT);
			leftTextCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			
			// Número da Coluna
			newResultsSheet.addCell(new Number(0,2+i,(i+1),integerCellFormat));

			// Nome da Estratégia
			newResultsSheet.addCell(new Label(1,2+i,translatePlanStrat(planName),centerTextCellFormat));
			
			// Nome do Plano
			newResultsSheet.addCell(new Label(2,2+i,planName,leftTextCellFormat));
			
			// Colunas PCA
			if (planDetails.contains("pca.columns"))
				newResultsSheet.addCell(new Number(3,2+i,extractPca(planDetails),integerCellFormat));
			else
				newResultsSheet.addCell(new Label(3,2+i,"",integerCellFormat));
			
			// Kmeans Centroids
			if (planDetails.contains("kmeans.centroids"))
				newResultsSheet.addCell(new Number(4,2+i,extractCentroids(planDetails),integerCellFormat));
			else
				newResultsSheet.addCell(new Label(4,2+i,"",integerCellFormat));
			
			// Kmeans Distance
			if (planDetails.contains("kmeans.distance"))
				newResultsSheet.addCell(new Label(5,2+i,extractDistance(planDetails,"kmeans"),centerTextCellFormat));
			else
				newResultsSheet.addCell(new Label(5,2+i,"",centerTextCellFormat));

			// Knn Neighbors
			if (planDetails.contains("knn.k"))
				newResultsSheet.addCell(new Number(6,2+i,extractNeighbors(planDetails),integerCellFormat));
			else
				newResultsSheet.addCell(new Label(6,2+i,"",integerCellFormat));

			// Kmeans Distance
			if (planDetails.contains("knn.distance"))
				newResultsSheet.addCell(new Label(7,2+i,extractDistance(planDetails,"knn"),centerTextCellFormat));
			else
				newResultsSheet.addCell(new Label(7,2+i,"",centerTextCellFormat));

			// Avg Disturb
			if (planDetails.contains("avg.disturb"))
				newResultsSheet.addCell(new Label(8,2+i,extractDisturb(planDetails),centerTextCellFormat));
			else
				newResultsSheet.addCell(new Label(8,2+i,"",centerTextCellFormat));
			
			// Espaço em branco
			newResultsSheet.addCell(new Label(9,2+i,"",centerTextCellFormat));
			
		}
	}

	private String extractDisturb(String planDetails) throws Exception
	{
		RE R1 = new RE("(avg.disturb)(=)([:alpha:]*)");
		
		R1.match(planDetails);		
		return R1.getParen(3);
	}

	private int extractNeighbors(String planDetails) throws Exception
	{
		RE R1 = new RE("(knn.k)(=)([:digit:]*)");
		
		R1.match(planDetails);		
		return Integer.parseInt(R1.getParen(3));
	}

	private String extractDistance(String planDetails, String method) throws Exception 
	{
		RE R1 = new RE("("+method+".distance)(=)([:alpha:]*)");
		
		R1.match(planDetails);		
		return R1.getParen(3);
	}

	private int extractCentroids(String planDetails) throws Exception 
	{
		RE R1 = new RE("(kmeans.centroids)(=)([:digit:]*)");
		
		R1.match(planDetails);		
		return Integer.parseInt(R1.getParen(3));
	}

	private int extractPca(String planDetails) throws Exception
	{
		RE R1 = new RE("(pca.columns)(=)([:digit:]*)");
		
		R1.match(planDetails);		
		return Integer.parseInt(R1.getParen(3));
	}

	private String translatePlanStrat(String planName)
	{
		if (planName.equals("comite"))
		{
			return ("C");
		}
		else if (planName.startsWith("avg") || 
			planName.startsWith("knn") || 
			planName.startsWith("bkprop"))
		{
			return ("R");
		}
		else if (planName.startsWith("pca")) 
		{
			if (planName.contains("kmeans")|| 
				planName.contains("pso"))
			{
				return ("SCR");
			}
			else
			{
				return ("SR");
			}
		}
		else
		{
			if (planName.contains("pca"))
			{
				return ("CSR");
			}
			else
			{
				return ("CR");
			}
		}			
	}

	private void createLegendHeaders(WritableSheet resultsSheet) throws WriteException, RowsExceededException 
	{
		// Cria as colunas no novo Sheet
		CellView col1 = new CellView();col1.setSize(1525);
		CellView col2 = new CellView();col2.setSize(2460);
		CellView col3 = new CellView();col3.setSize(4490);
		CellView col4 = new CellView();col4.setSize(2250);
		CellView col5 = new CellView();col5.setSize(2525);
		CellView col6 = new CellView();col6.setSize(2460);
		CellView col7 = new CellView();col7.setSize(2250);
		CellView col8 = new CellView();col8.setSize(2375);
		CellView col9 = new CellView();col9.setSize(2800);
		CellView col10 = new CellView();col10.setSize(1000);
		resultsSheet.setColumnView(0,col1);
		resultsSheet.setColumnView(1,col2);
		resultsSheet.setColumnView(2,col3);
		resultsSheet.setColumnView(3,col4);
		resultsSheet.setColumnView(4,col5);
		resultsSheet.setColumnView(5,col6);
		resultsSheet.setColumnView(6,col7);
		resultsSheet.setColumnView(7,col8);
		resultsSheet.setColumnView(8,col9);
		resultsSheet.setColumnView(9,col10);
		
		// Escreve cabeçalhos
		WritableCellFormat headerFormat = new WritableCellFormat();
		headerFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
		headerFormat.setAlignment(Alignment.CENTRE);
		headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		headerFormat.setWrap(true);
				
		WritableCell header0 = new Label(0,1,"Col",headerFormat);
		WritableCell header1 = new Label(1,1,"Estratégia",headerFormat);
		WritableCell header2 = new Label(2,1,"Plano",headerFormat);
		WritableCell header3 = new Label(3,1,"Colunas PCA",headerFormat);
		WritableCell header4 = new Label(4,1,"Centróides",headerFormat);
		WritableCell header5 = new Label(5,1,"Distância K-Means",headerFormat);
		WritableCell header6 = new Label(6,1,"Vizinhos K-NN",headerFormat);
		WritableCell header7 = new Label(7,1,"Distância K-NN",headerFormat);
		WritableCell header8 = new Label(8,1,"Perturbação Média",headerFormat);
		WritableCell header9 = new Label(9,1,"",headerFormat);
						
		resultsSheet.addCell(header0);
		resultsSheet.addCell(header1);
		resultsSheet.addCell(header2);
		resultsSheet.addCell(header3);
		resultsSheet.addCell(header4);
		resultsSheet.addCell(header5);
		resultsSheet.addCell(header6);
		resultsSheet.addCell(header7);
		resultsSheet.addCell(header8);
		resultsSheet.addCell(header9);
	}
}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;


public class Consolidador {
	
	//private static final String PASTA_RAIZ = "W:\\CEFET\\workflow\\gitAppraisal\\appraisal\\exec\\resultado";
	private static final String PASTA_RAIZ = "W:\\CEFET\\workflow\\gitAppraisal\\appraisal\\exec\\resultado_old";
	
	private static final String PASTA_CONSOLIDADO = PASTA_RAIZ + "\\consolidado";
	
	public static void main(String[] args) {
		
		try{
		
			final List<Execucao> lstExecIrirs = new ArrayList<Execucao>();
			
			addIris(lstExecIrirs);
			
			Thread irisTh = new Thread(){
				
				@Override
				public void run(){
					
					execute(lstExecIrirs);
					
				}
				
			};
			
			final List<Execucao> lstExecPima = new ArrayList<Execucao>();
			
			addPima(lstExecPima);
			
			Thread pimaTh = new Thread(){
				
				@Override
				public void run(){
					
					execute(lstExecPima);
					
				}
				
			};
			
			final List<Execucao> lstExecBC = new ArrayList<Execucao>();
			
			addBC(lstExecBC);
			
			Thread bcTh = new Thread(){
				
				@Override
				public void run(){
					
					execute(lstExecBC);
					
				}
				
			};
			
			irisTh.start();
			pimaTh.start();
			bcTh.start();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	private static void execute(List<Execucao> lstExecucao){
		
		try{
			
			String url = "jdbc:mysql://localhost:3306/";
			String username = "root";
			String password = "root@123";
	
			Connection connection = DriverManager.getConnection(url, username, password);
			
			List<Execucao> lstExecArq = new ArrayList<Execucao>();
			
			for(Execucao execucao : lstExecucao){
				
				Statement stmt = connection.createStatement();
				
				//ResultSet rs = stmt.executeQuery(execucao.getBaseSQL());
				
				List<String> idsOr = getIdsOriginais(execucao);
				ResultSet rs = stmt.executeQuery(execucao.getBaseSQL2(idsOr));
				
				while(rs.next())
					execucao.getHashIdValor().put(rs.getLong(1), rs.getDouble(2));
					
				lstExecArq.add(execucao);
				
			}
			
			File pastaConsolidado = new File(PASTA_CONSOLIDADO);
			if(!pastaConsolidado.exists())
				pastaConsolidado.mkdir();
			
			for(Execucao execucao : lstExecArq){
				
				//System.out.println("Execução: " + execucao.getId_ex() + "_" + execucao.getBd_campo() + "_" + execucao.getBd_table_alvo_percentual());
				//System.out.println("Arquivo: " + PASTA_CONSOLIDADO + "\\" + execucao.getId_ex() + "_mcar_" 
				//								+ execucao.getBd_campo() + "_consolidado.xlsx");
				
				File file = new File(PASTA_CONSOLIDADO + "\\" + execucao.getId_ex() + "_mcar_" 
												+ execucao.getBd_campo() + "_consolidado.xlsx");
				
				String fileRPrefix = null;
				
				if("iris".equals(execucao.getId_ex()))
					fileRPrefix = "iris";
				
				else if("pima".equals(execucao.getId_ex()))
					fileRPrefix = "pima";
				
				else if("breastcancer".equals(execucao.getId_ex()))
					fileRPrefix = "breast_cancer";
				
				if(!file.exists()){
					
					//System.out.println("Arquivo: Criou arquivo");
					
					file.createNewFile();
				
					InputStream in = ClassLoader.class.getResourceAsStream("/consolidado_modelo_" + fileRPrefix.replaceAll("_", "") + ".xlsx");
						
					OutputStream out = new FileOutputStream(file);
			        byte[] buf = new byte[1024];
			        int len;
			        while((len=in.read(buf))>0){
			            out.write(buf,0,len);
			        }
			        out.close();
			        in.close();
			        
				}
				
		        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		        
		        String baseFileName = null;
		        
		        if("breast_cancer".equals(fileRPrefix))
		        	baseFileName = PASTA_RAIZ + "\\" + fileRPrefix + "_mcar_" + execucao.getBd_campo() + "_";
		        	
		        else
		        	baseFileName = PASTA_RAIZ + "\\" + fileRPrefix + "_mcar_" + execucao.getBd_campo().replace("_", "") + "_";
		        
		        if(baseFileName.indexOf("seruminsulin") != -1)
		        	baseFileName = baseFileName.replaceAll("seruminsulin", "seruminsulim");
		        
		        List<File> lstFileRead = new ArrayList<File>();
		        
		        // clustering.regression
		        
		        	// kmeans.avg
		        
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\clustering.regression\\kmeans.avg\\targetRegression.txt"));
		        	
		        	// kmeans.bkprop
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\clustering.regression\\kmeans.bkprop\\targetRegression.txt"));
		        
		        	// kmeans.knn
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\clustering.regression\\kmeans.knn\\targetRegression.txt"));
		        
		        // clustering.selection.regression
		        
		        	// kmeans.pca.avg
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\clustering.selection.regression\\kmeans.pca.avg\\targetRegression.txt"));
		        
		        	// kmeans.pca.bkprop
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\clustering.selection.regression\\kmeans.pca.bkprop\\targetRegression.txt"));
		        
		        	// kmeans.pca.knn
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\clustering.selection.regression\\kmeans.pca.knn\\targetRegression.txt"));
		        
		        // regression
		        
		        	// avg
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\regression\\avg\\targetRegression.txt"));
		        
		        	// bkprop
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\regression\\bkprop\\targetRegression.txt"));
		        
		        	// knn
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\regression\\knn\\targetRegression.txt"));
		        
		        // selection.clustering.regression
		        
		        	// pca.kmeans.avg
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\selection.clustering.regression\\pca.kmeans.avg\\targetRegression.txt"));
		        
		        	// pca.kmeans.bkprop
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\selection.clustering.regression\\pca.kmeans.bkprop\\targetRegression.txt"));
		        
		        	// pca.kmeans.knn
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\selection.clustering.regression\\pca.kmeans.knn\\targetRegression.txt"));
		        
		        // selection.regression
		        
		        	// pca.bkprop
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\selection.regression\\pca.bkprop\\targetRegression.txt"));
		        
		        	// pca.knn
		        		
		        		lstFileRead.add(new File(baseFileName + execucao.getBd_table_alvo_percentual()
		        				+ "\\selection.regression\\pca.knn\\targetRegression.txt"));
		        
	    		Integer sheetPos = null;
	            
	            if("10".equals(execucao.getBd_table_alvo_percentual()))
	            	sheetPos = 0;
					
				else if("20".equals(execucao.getBd_table_alvo_percentual()))
					sheetPos = 1;
					
				else if("30".equals(execucao.getBd_table_alvo_percentual()))
					sheetPos = 2;
					
				else if("40".equals(execucao.getBd_table_alvo_percentual()))
					sheetPos = 3;
					
				else if("50".equals(execucao.getBd_table_alvo_percentual()))
					sheetPos = 4;
	        	
	            /*
	            try{
	            
	            	if(workbook.getSheetName(sheetPos).indexOf("#campo#") != -1)
	            		workbook.setSheetName(sheetPos, workbook.getSheetName(sheetPos).replaceAll("#campo#", execucao.getBd_campo().replace("_", "")));
	            
	            }catch(Exception e){
	            }
	            */
	            	
	            Sheet sheet = workbook.getSheetAt(sheetPos);
	            
	            int lineStart = 1;
	            
	            Iterator<Long> itidValor = execucao.getHashIdValor().keySet().iterator();
	            
	            while(itidValor.hasNext()){
	            	
	            	lineStart++;
	            	
	            	Long id = itidValor.next();
	            	Double valor = execucao.getHashIdValor().get(id);
	            	
	            	Row row = sheet.getRow(lineStart);
	            	
	            	Cell cel = row.getCell(0);
	    			cel.setCellValue(id);
	    			
	    			cel = row.getCell(1);
	    			cel.setCellValue(valor);
	            	
	            }
	            
	            //System.out.println("Arquivo: Incluiu Ids e valores originais");
		        		
		        for(File targetFile : lstFileRead){
		        	
		        	//System.out.println("Lendo arquivo: " + targetFile.getPath());
		        	
		        	Scanner scan = new Scanner(targetFile);
					
		        	lineStart = 1;
		            
		        	Integer celPos = null;
		        	
		        	// clustering.regression
			        
		        	// kmeans.avg
		        
		        		if(targetFile.getPath().contains("clustering.regression\\kmeans.avg")) //C3
		        			celPos = 2;
		        	
		        	// kmeans.bkprop
		        		
		        		else if(targetFile.getPath().contains("clustering.regression\\kmeans.bkprop")) //E3
		        			celPos = 4;
		        
		        	// kmeans.knn
		        		
		        		else if(targetFile.getPath().contains("clustering.regression\\kmeans.knn")) //G3
		        			celPos = 6;
		        		
		        // clustering.selection.regression
		        
		        	// kmeans.pca.avg
		        		
		        		else if(targetFile.getPath().contains("clustering.selection.regression\\kmeans.pca.avg")) //I3
		        			celPos = 8;
		        
		        	// kmeans.pca.bkprop
		        		
		        		else if(targetFile.getPath().contains("clustering.selection.regression\\kmeans.pca.bkprop")) //K3
		        			celPos = 10;
		        		
		        	// kmeans.pca.knn
		        		
		        		else if(targetFile.getPath().contains("clustering.selection.regression\\kmeans.pca.knn")) //M3
		        			celPos = 12;
		        
		        // regression
		        
		        	// avg
		        		
		        		else if(targetFile.getPath().contains("regression\\avg")) //O3
		        			celPos = 14;
		        
		        	// bkprop
		        		
		        		else if(targetFile.getPath().contains("regression\\bkprop")) //Q3
		        			celPos = 16;
		        
		        	// knn
		        		
		        		else if(targetFile.getPath().contains("regression\\knn")) //S3
		        			celPos = 18;
		        
		        // selection.clustering.regression
		        
		        	// pca.kmeans.avg
		        		
		        		else if(targetFile.getPath().contains("selection.clustering.regression\\pca.kmeans.avg")) //U3
		        			celPos = 20;
		        
		        	// pca.kmeans.bkprop
		        		
		        		else if(targetFile.getPath().contains("selection.clustering.regression\\pca.kmeans.bkprop")) //W3
		        			celPos = 22;
		        	
		        	// pca.kmeans.knn
		        		
		        		else if(targetFile.getPath().contains("selection.clustering.regression\\pca.kmeans.knn")) //Y3
		        			celPos = 24;
		        
		        // selection.regression
		        
		        	// pca.bkprop
		        		
		        		else if(targetFile.getPath().contains("selection.regression\\pca.bkprop")) //AA3
		        			celPos = 26;
		        		
		        	// pca.knn
		        		
		        		else if(targetFile.getPath().contains("selection.regression\\pca.knn")) //AC3
		        			celPos = 28;
					
		        	
		        	while(scan.hasNextLine()){
						
		        		//System.out.println("Linha :" + lineStart);
		        		
		        		lineStart++;
		        		
						String line = scan.nextLine();
						if("".equals(line.trim()))
							continue;
						
						String valor = line.substring(line.indexOf("	") + 1);
						//valor = valor.replaceAll("\\.", "\\,");
						
						Cell cell = sheet.getRow(lineStart).getCell(celPos);
	        			cell.setCellValue(new Double(valor));
						
					}
		        	
		        	//sheet.autoSizeColumn(celPos);
		        	sheet.setColumnWidth(celPos, sheet.getColumnWidth(celPos) + 4);
		        	
		        	//sheet.autoSizeColumn(celPos + 1);
		        	sheet.setColumnWidth(celPos + 1, sheet.getColumnWidth(celPos + 1) + 4);
		        	
					scan.close();
		        	
		        }
		        
		        XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
		        FileOutputStream fileOut = new FileOutputStream(file);
			    workbook.write(fileOut);
			    fileOut.close();
			    
			    //System.out.println("Salvou stream no arquivo");
		        		
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	private static List<String> getIdsOriginais(Execucao execucao) throws Exception {
		
		List<String> idsOr = new ArrayList<String>();
		
		String fileRPrefix = null;
		
		if("iris".equals(execucao.getId_ex()))
			fileRPrefix = "iris";
		
		else if("pima".equals(execucao.getId_ex()))
			fileRPrefix = "pima";
		
		else if("breastcancer".equals(execucao.getId_ex()))
			fileRPrefix = "breast_cancer";
		
		String baseFileName = null;
        
        if("breast_cancer".equals(fileRPrefix))
        	baseFileName = PASTA_RAIZ + "\\" + fileRPrefix + "_mcar_" + execucao.getBd_campo() + "_";
        	
        else
        	baseFileName = PASTA_RAIZ + "\\" + fileRPrefix + "_mcar_" + execucao.getBd_campo().replace("_", "") + "_";
        
        if(baseFileName.indexOf("seruminsulin") != -1)
        	baseFileName = baseFileName.replaceAll("seruminsulin", "seruminsulim");
		
        Scanner scan = new Scanner(new File(baseFileName + execucao.getBd_table_alvo_percentual() + "\\clustering.regression\\kmeans.avg\\targetRegression.txt"));
        
        while(scan.hasNextLine()){
        	
        	String line = scan.nextLine();
			if("".equals(line.trim()))
				continue;
			
			String id = line.substring(5, (line.indexOf("	") + 1));
        	
			idsOr.add(id);
			
        }
        
        scan.close();
        
        return idsOr;
		
	}
	
	private static void addIris(List<Execucao> lstExecucao){
		
		// --- petal_length --- //
		
		lstExecucao.add(new Execucao("iris", "petal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petallength", "10", "iris_mcar_petallength", "10"));
		
		lstExecucao.add(new Execucao("iris", "petal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petallength", "20", "iris_mcar_petallength", "20"));
		
		lstExecucao.add(new Execucao("iris", "petal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petallength", "30", "iris_mcar_petallength", "30"));
		
		lstExecucao.add(new Execucao("iris", "petal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petallength", "40", "iris_mcar_petallength", "40"));
		
		lstExecucao.add(new Execucao("iris", "petal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petallength", "50", "iris_mcar_petallength", "50"));
		
		// --- petal_width --- //
		
		lstExecucao.add(new Execucao("iris", "petal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petalwidth", "10", "iris_mcar_petalwidth", "10"));
		
		lstExecucao.add(new Execucao("iris", "petal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petalwidth", "20", "iris_mcar_petalwidth", "20"));
		
		lstExecucao.add(new Execucao("iris", "petal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petalwidth", "30", "iris_mcar_petalwidth", "30"));
		
		lstExecucao.add(new Execucao("iris", "petal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petalwidth", "40", "iris_mcar_petalwidth", "40"));
		
		lstExecucao.add(new Execucao("iris", "petal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_petalwidth", "50", "iris_mcar_petalwidth", "50"));
		
		// --- sepal_length --- //
		
		lstExecucao.add(new Execucao("iris", "sepal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepallength", "10", "iris_mcar_sepallength", "10"));
		
		lstExecucao.add(new Execucao("iris", "sepal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepallength", "20", "iris_mcar_sepallength", "20"));
		
		lstExecucao.add(new Execucao("iris", "sepal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepallength", "30", "iris_mcar_sepallength", "30"));
		
		lstExecucao.add(new Execucao("iris", "sepal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepallength", "40", "iris_mcar_sepallength", "40"));
		
		lstExecucao.add(new Execucao("iris", "sepal_length", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepallength", "50", "iris_mcar_sepallength", "50"));
		
		// --- sepal_width --- //
		
		lstExecucao.add(new Execucao("iris", "sepal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepalwidth", "10", "iris_mcar_sepalwidth", "10"));
		
		lstExecucao.add(new Execucao("iris", "sepal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepalwidth", "20", "iris_mcar_sepalwidth", "20"));
		
		lstExecucao.add(new Execucao("iris", "sepal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepalwidth", "30", "iris_mcar_sepalwidth", "30"));
		
		lstExecucao.add(new Execucao("iris", "sepal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepalwidth", "40", "iris_mcar_sepalwidth", "40"));
		
		lstExecucao.add(new Execucao("iris", "sepal_width", "jb_iris_plants", "iris_plants", 
				"jb_iris_mcar_sepalwidth", "50", "iris_mcar_sepalwidth", "50"));
		
	}
	
	private static void addPima(List<Execucao> lstExecucao){
		
		// --- age --- //
		
		lstExecucao.add(new Execucao("pima", "age", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_age", "10", "pima_mcar_age", "10"));
		
		lstExecucao.add(new Execucao("pima", "age", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_age", "20", "pima_mcar_age", "20"));
		
		lstExecucao.add(new Execucao("pima", "age", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_age", "30", "pima_mcar_age", "30"));
		
		lstExecucao.add(new Execucao("pima", "age", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_age", "40", "pima_mcar_age", "40"));
		
		lstExecucao.add(new Execucao("pima", "age", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_age", "50", "pima_mcar_age", "50"));
		
		// --- blood_pressure --- //
		
		lstExecucao.add(new Execucao("pima", "blood_pressure", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bloodpressure", "10", "pima_mcar_bloodpressure", "10"));
		
		lstExecucao.add(new Execucao("pima", "blood_pressure", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bloodpressure", "20", "pima_mcar_bloodpressure", "20"));
		
		lstExecucao.add(new Execucao("pima", "blood_pressure", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bloodpressure", "30", "pima_mcar_bloodpressure", "30"));
		
		lstExecucao.add(new Execucao("pima", "blood_pressure", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bloodpressure", "40", "pima_mcar_bloodpressure", "40"));
		
		lstExecucao.add(new Execucao("pima", "blood_pressure", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bloodpressure", "50", "pima_mcar_bloodpressure", "50"));
		
		// --- body_mass --- //
		
		lstExecucao.add(new Execucao("pima", "body_mass", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bodymass", "10", "pima_mcar_bodymass", "10"));
		
		lstExecucao.add(new Execucao("pima", "body_mass", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bodymass", "20", "pima_mcar_bodymass", "20"));
		
		lstExecucao.add(new Execucao("pima", "body_mass", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bodymass", "30", "pima_mcar_bodymass", "30"));
		
		lstExecucao.add(new Execucao("pima", "body_mass", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bodymass", "40", "pima_mcar_bodymass", "40"));
		
		lstExecucao.add(new Execucao("pima", "body_mass", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_bodymass", "50", "pima_mcar_bodymass", "50"));
		
		// --- glucose_concentration --- //
		
		lstExecucao.add(new Execucao("pima", "glucose_concentration", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_glucoseconcentration", "10", "pima_mcar_glucoseconcentration", "10"));
		
		lstExecucao.add(new Execucao("pima", "glucose_concentration", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_glucoseconcentration", "20", "pima_mcar_glucoseconcentration", "20"));
		
		lstExecucao.add(new Execucao("pima", "glucose_concentration", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_glucoseconcentration", "30", "pima_mcar_glucoseconcentration", "30"));
		
		lstExecucao.add(new Execucao("pima", "glucose_concentration", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_glucoseconcentration", "40", "pima_mcar_glucoseconcentration", "40"));
		
		lstExecucao.add(new Execucao("pima", "glucose_concentration", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_glucoseconcentration", "50", "pima_mcar_glucoseconcentration", "50"));
		
		// --- pedigree_function --- //
		
		lstExecucao.add(new Execucao("pima", "pedigree_function", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pedigreefunction", "10", "pima_mcar_pedigreefunction", "10"));
		
		lstExecucao.add(new Execucao("pima", "pedigree_function", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pedigreefunction", "20", "pima_mcar_pedigreefunction", "20"));
		
		lstExecucao.add(new Execucao("pima", "pedigree_function", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pedigreefunction", "30", "pima_mcar_pedigreefunction", "30"));
		
		lstExecucao.add(new Execucao("pima", "pedigree_function", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pedigreefunction", "40", "pima_mcar_pedigreefunction", "40"));
		
		lstExecucao.add(new Execucao("pima", "pedigree_function", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pedigreefunction", "50", "pima_mcar_pedigreefunction", "50"));
		
		// --- pregnancy_times --- //
		
		lstExecucao.add(new Execucao("pima", "pregnancy_times", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pregnancytimes", "10", "pima_mcar_pregnancytimes", "10"));
		
		lstExecucao.add(new Execucao("pima", "pregnancy_times", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pregnancytimes", "20", "pima_mcar_pregnancytimes", "20"));
		
		lstExecucao.add(new Execucao("pima", "pregnancy_times", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pregnancytimes", "30", "pima_mcar_pregnancytimes", "30"));
		
		lstExecucao.add(new Execucao("pima", "pregnancy_times", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pregnancytimes", "40", "pima_mcar_pregnancytimes", "40"));
		
		lstExecucao.add(new Execucao("pima", "pregnancy_times", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_pregnancytimes", "50", "pima_mcar_pregnancytimes", "50"));
		
		// --- serum_insulin --- //
		
		lstExecucao.add(new Execucao("pima", "serum_insulin", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_seruminsulim", "10", "pima_mcar_seruminsulim", "10"));
		
		lstExecucao.add(new Execucao("pima", "serum_insulin", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_seruminsulim", "20", "pima_mcar_seruminsulim", "20"));
		
		lstExecucao.add(new Execucao("pima", "serum_insulin", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_seruminsulim", "30", "pima_mcar_seruminsulim", "30"));
		
		lstExecucao.add(new Execucao("pima", "serum_insulin", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_seruminsulim", "40", "pima_mcar_seruminsulim", "40"));
		
		lstExecucao.add(new Execucao("pima", "serum_insulin", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_seruminsulim", "50", "pima_mcar_seruminsulim", "50"));
		
		// --- skin_fold_thickness --- //
		
		lstExecucao.add(new Execucao("pima", "skin_fold_thickness", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_skinfoldthickness", "10", "pima_mcar_skinfoldthickness", "10"));
		
		lstExecucao.add(new Execucao("pima", "skin_fold_thickness", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_skinfoldthickness", "20", "pima_mcar_skinfoldthickness", "20"));
		
		lstExecucao.add(new Execucao("pima", "skin_fold_thickness", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_skinfoldthickness", "30", "pima_mcar_skinfoldthickness", "30"));
		
		lstExecucao.add(new Execucao("pima", "skin_fold_thickness", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_skinfoldthickness", "40", "pima_mcar_skinfoldthickness", "40"));
		
		lstExecucao.add(new Execucao("pima", "skin_fold_thickness", "jb_pima_indians", "pima_indians", 
				"jb_pima_mcar_skinfoldthickness", "50", "pima_mcar_skinfoldthickness", "50"));
		
	}
	
	private static void addBC(List<Execucao> lstExecucao){
		
		// --- bare_nuclei --- //
		
		lstExecucao.add(new Execucao("breastcancer", "bare_nuclei", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bare_nuclei", "10", "breast_cancer_mcar_bare_nuclei", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "bare_nuclei", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bare_nuclei", "20", "breast_cancer_mcar_bare_nuclei", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "bare_nuclei", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bare_nuclei", "30", "breast_cancer_mcar_bare_nuclei", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "bare_nuclei", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bare_nuclei", "40", "breast_cancer_mcar_bare_nuclei", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "bare_nuclei", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bare_nuclei", "50", "breast_cancer_mcar_bare_nuclei", "50"));
		
		// --- bland_chromatin --- //
		
		lstExecucao.add(new Execucao("breastcancer", "bland_chromatin", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bland_chromatin", "10", "breast_cancer_mcar_bland_chromatin", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "bland_chromatin", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bland_chromatin", "20", "breast_cancer_mcar_bland_chromatin", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "bland_chromatin", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bland_chromatin", "30", "breast_cancer_mcar_bland_chromatin", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "bland_chromatin", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bland_chromatin", "40", "breast_cancer_mcar_bland_chromatin", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "bland_chromatin", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_bland_chromatin", "50", "breast_cancer_mcar_bland_chromatin", "50"));
		
		// --- clump_thickness --- //
		
		lstExecucao.add(new Execucao("breastcancer", "clump_thickness", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_clump_thickness", "10", "breast_cancer_mcar_clump_thickness", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "clump_thickness", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_clump_thickness", "20", "breast_cancer_mcar_clump_thickness", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "clump_thickness", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_clump_thickness", "30", "breast_cancer_mcar_clump_thickness", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "clump_thickness", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_clump_thickness", "40", "breast_cancer_mcar_clump_thickness", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "clump_thickness", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_clump_thickness", "50", "breast_cancer_mcar_clump_thickness", "50"));
		
		// --- marginal_adhesion --- //
		
		lstExecucao.add(new Execucao("breastcancer", "marginal_adhesion", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_marginal_adhesion", "10", "breast_cancer_mcar_marginal_adhesion", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "marginal_adhesion", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_marginal_adhesion", "20", "breast_cancer_mcar_marginal_adhesion", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "marginal_adhesion", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_marginal_adhesion", "30", "breast_cancer_mcar_marginal_adhesion", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "marginal_adhesion", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_marginal_adhesion", "40", "breast_cancer_mcar_marginal_adhesion", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "marginal_adhesion", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_marginal_adhesion", "50", "breast_cancer_mcar_marginal_adhesion", "50"));
		
		// --- mitoses --- //
		
		lstExecucao.add(new Execucao("breastcancer", "mitoses", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_mitoses", "10", "breast_cancer_mcar_mitoses", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "mitoses", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_mitoses", "20", "breast_cancer_mcar_mitoses", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "mitoses", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_mitoses", "30", "breast_cancer_mcar_mitoses", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "mitoses", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_mitoses", "40", "breast_cancer_mcar_mitoses", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "mitoses", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_mitoses", "50", "breast_cancer_mcar_mitoses", "50"));
		
		// --- normal_nucleoli --- //
		
		lstExecucao.add(new Execucao("breastcancer", "normal_nucleoli", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_normal_nucleoli", "10", "breast_cancer_mcar_normal_nucleoli", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "normal_nucleoli", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_normal_nucleoli", "20", "breast_cancer_mcar_normal_nucleoli", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "normal_nucleoli", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_normal_nucleoli", "30", "breast_cancer_mcar_normal_nucleoli", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "normal_nucleoli", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_normal_nucleoli", "40", "breast_cancer_mcar_normal_nucleoli", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "normal_nucleoli", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_normal_nucleoli", "50", "breast_cancer_mcar_normal_nucleoli", "50"));
		
		// --- single_epithelial_cell_size --- //
		
		lstExecucao.add(new Execucao("breastcancer", "single_epithelial_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_single_epithelial_cell_size", "10", "breast_cancer_mcar_single_epithelial_cell_size", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "single_epithelial_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_single_epithelial_cell_size", "20", "breast_cancer_mcar_single_epithelial_cell_size", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "single_epithelial_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_single_epithelial_cell_size", "30", "breast_cancer_mcar_single_epithelial_cell_size", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "single_epithelial_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_single_epithelial_cell_size", "40", "breast_cancer_mcar_single_epithelial_cell_size", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "single_epithelial_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_single_epithelial_cell_size", "50", "breast_cancer_mcar_single_epithelial_cell_size", "50"));
		
		// --- uniformity_of_cell_shape --- //
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_shape", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_shape", "10", "breast_cancer_mcar_uniformity_of_cell_shape", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_shape", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_shape", "20", "breast_cancer_mcar_uniformity_of_cell_shape", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_shape", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_shape", "30", "breast_cancer_mcar_uniformity_of_cell_shape", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_shape", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_shape", "40", "breast_cancer_mcar_uniformity_of_cell_shape", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_shape", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_shape", "50", "breast_cancer_mcar_uniformity_of_cell_shape", "50"));
		
		// --- uniformity_of_cell_size --- //
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_size", "10", "breast_cancer_mcar_uniformity_of_cell_size", "10"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_size", "20", "breast_cancer_mcar_uniformity_of_cell_size", "20"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_size", "30", "breast_cancer_mcar_uniformity_of_cell_size", "30"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_size", "40", "breast_cancer_mcar_uniformity_of_cell_size", "40"));
		
		lstExecucao.add(new Execucao("breastcancer", "uniformity_of_cell_size", "jb_breast_cancer", "breast_cancer", 
				"jb_breast_cancer_mcar_uniformity_of_cell_size", "50", "breast_cancer_mcar_uniformity_of_cell_size", "50"));
		
	}

}

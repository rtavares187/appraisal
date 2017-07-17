package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class NumberingFile {

	public static void main(String[] args) {
		
		try{
			
			boolean header = true;
			
			String sfileOriginal = "W:\\CEFET\\workflow\\gitAppraisal\\appraisal\\Bases\\pima_indians\\pima-indians-diabetes.data.csv";
			File fileOriginal = new File(sfileOriginal);
			
			String dfileNumerada = "W:\\CEFET\\workflow\\gitAppraisal\\appraisal\\Bases\\pima_indians\\pima-indians-diabetes.data.numerada.csv";
			File fileNumerada = new File(dfileNumerada);
			
			if(!fileNumerada.exists())
				fileNumerada.createNewFile();
			
			Scanner scan = new Scanner(fileOriginal);
			FileWriter fw = new FileWriter(fileNumerada.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
			
			if(header){
				
				bw.write("id," + scan.nextLine());
				bw.newLine();
				
			}
				
			int id = 0;
            
			while(scan.hasNextLine()){
				
				bw.write(++id + "," + scan.nextLine());
				bw.newLine();
				
			}
			
			bw.close();
			scan.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

}

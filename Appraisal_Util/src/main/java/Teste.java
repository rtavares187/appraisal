import java.io.File;
import java.util.Scanner;


public class Teste {

	public static void main(String[] args) {
		
		try{
			
			"1.467".replaceAll("\\.", "\\,");
			
			File fTeste = new File("W:\\CEFET\\workflow\\gitAppraisal\\appraisal\\exec\\resultado\\iris_mcar_petallength_10\\clustering.regression\\kmeans.avg\\targetRegression.txt");
			
			Scanner scan = new Scanner(fTeste);
			
			while(scan.hasNextLine()){
				
				String line = scan.nextLine();
				if("".equals(line.trim()))
					continue;
				
				System.out.println(line.substring(line.indexOf("	") + 1));
				
			}
				
			scan.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}

}

package eraser;

import java.io.InputStream;

/**
 * 
 * @author rtavares
 *
 */
public class Teste {
	
	public static void main(String[] args){
		
		try{
		
			Process exec = Runtime.getRuntime().exec(new String[]{"cmd.exe",
				"/c", 
				"mysqldump -u root --password=root@123 jb_appraisal | mysql -u root --password=root@123 jb_appraisal_mcar"});
		    
		    if(exec.waitFor()==0)
		    {
		        //normally terminated, a way to read the output
		        InputStream inputStream = exec.getInputStream();
		        byte[] buffer = new byte[inputStream.available()];
		        inputStream.read(buffer);
	
		        String str = new String(buffer);
		        System.out.println(str);
		    }
		    else
		    {
		        // abnormally terminated, there was some problem
		                    //a way to read the error during the execution of the command
		        InputStream errorStream = exec.getErrorStream();
		        byte[] buffer = new byte[errorStream.available()];
		        errorStream.read(buffer);
	
		        String str = new String(buffer);
		        System.out.println(str);
	
		    }
		    
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
}

package eraser;

import java.util.ResourceBundle;

/**
 * 
 * @author rtavares - Rodrigo Tavares
 *
 */
public class ReplicatorMethodByDump extends ReplicatorMethod {
	
	public static void replicate(String originalDatabaseName,String destinationDatabaseName) throws Exception {
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("eraser");
		
		String login = resourceBundle.getString("database.replication.user.login");
		String pwd = resourceBundle.getString("database.replication.user.password");
		
		String instruction = "mysqldump -u "
		+ login
		+ " --password="
		+ pwd
		+ " " + originalDatabaseName
		+ " | mysql -u "
		+ login 
		+ " --password="
		+ pwd
		+ " " + destinationDatabaseName;
		
		Process exec = Runtime.getRuntime().exec(new String[]{"cmd.exe","/c", instruction});
	    
	    if(exec.waitFor()!=0)
	    	throw new Exception("Error executing mysqldump");
		
	}
	
}

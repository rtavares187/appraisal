package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

public class ReplicatorMethod 
{
	public static void main(String[] args) throws IOException
	{	
		// 1. Lê arquivo de propriedades
		ResourceBundle resourceBundle = ResourceBundle.getBundle("javabramining.components.mining.timewarp.replicator");
		
		// 2. Recupera arquivo com a base Original
		String originalDir = resourceBundle.getString("database.dir");
		String databaseName = resourceBundle.getString("database.name");
		
		File cleanDatabaseDirectory = new File(originalDir+"/"+databaseName);
		
		// 3. Cria diretório de destino
		String destinationDir = resourceBundle.getString("destination.dir");
		File   destinationDirectory = new File(destinationDir);
		
		if (!destinationDirectory.exists())
			destinationDirectory.mkdir();		
				
		// 3. Lista os atributos a serem combinados
		String[] attributes = resourceBundle.getString("replication").split(",");
		String[] dirtTypes = new String[]{"mcar","mar","nmar"};
		
		for (String attribute : attributes) 
		{
			for (int i=10;i<=50;i+=10)
			{
				for (String dirt : dirtTypes) 
				{
					// Cria novo diretório				
					String newDatabaseName = databaseName.replaceAll("clean","")+dirt+"_"+attribute+"_"+i;
					File   newDatabaseDirectory = new File(destinationDir+"\\"+newDatabaseName);
					
					newDatabaseDirectory.mkdir();
					
					String[] originalFiles = cleanDatabaseDirectory.list();
					
					for (String originalFileName : originalFiles) 
					{
						File originalFile = new File(cleanDatabaseDirectory.getAbsolutePath()+"//"+originalFileName);
						
						if(originalFileName.startsWith(databaseName.replaceAll("jb_","")))
						{
							File newFile = new File(newDatabaseDirectory.getAbsolutePath()+"//"+originalFileName.replaceAll(databaseName.replaceAll("jb_",""), newDatabaseName.replaceAll("jb_","")));
							copy(originalFile,newFile);						
						}
						else
						{
							File newFile = new File(newDatabaseDirectory.getAbsolutePath()+"//"+originalFile.getName());
							copy(originalFile,newFile);
						}
					}
				}
			}			
		}
	}
	
	public static void copy(File src, File dst) throws IOException 
	{
		dst.createNewFile();
		
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
    
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}

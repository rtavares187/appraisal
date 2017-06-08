package eraser;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class ReplicatorMethod 
{
	public static void replicate(String originalDatabaseName,String destinationDatabaseName) throws Exception
	{
		// 1. Lê arquivo de propriedades
		ResourceBundle resourceBundle = ResourceBundle.getBundle("eraser");
		
		// 2. Recupera arquivo com a base Original
		String originalDir = resourceBundle.getString("database.dir");
		File   cleanDatabaseDirectory = new File(originalDir+"/"+originalDatabaseName);
		
		// 3. Cria novo diretório				
		File   newDatabaseDirectory = new File(originalDir+"/"+destinationDatabaseName);
		newDatabaseDirectory.mkdir();

		// 3. Copia e renomeia os arquivos
		String[] originalFiles = cleanDatabaseDirectory.list();
		
		for (String originalFileName : originalFiles) 
		{
			File originalFile = new File(cleanDatabaseDirectory.getAbsolutePath()+"//"+originalFileName);
			
			if(originalFileName.startsWith(originalDatabaseName.replaceAll("jb_","")))
			{
				File newFile = new File(newDatabaseDirectory.getAbsolutePath()+"//"+originalFileName.replaceAll(originalDatabaseName.replaceAll("jb_",""), destinationDatabaseName.replaceAll("jb_","")));
				copy(originalFile,newFile);						
			}
			else
			{
				File newFile = new File(newDatabaseDirectory.getAbsolutePath()+"//"+originalFile.getName());
				copy(originalFile,newFile);
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

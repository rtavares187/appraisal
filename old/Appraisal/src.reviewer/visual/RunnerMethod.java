package visual;

import java.io.File;

public abstract class RunnerMethod 
{
	protected abstract void foundDatabase(String database,File databaseDir) throws Exception;
	protected abstract void foundAttribute(String database,String attribute,File attributeDir) throws Exception;
	
	public void start(File rootPath) throws Exception
	{
		String[] databases = rootPath.list();
		
		for (String database : databases) 
		{
			File databaseDir = new File(rootPath.getAbsolutePath()+"//"+database);
			if (!databaseDir.exists())continue;
			foundDatabase(database,databaseDir);
				
			String[] attributes = databaseDir.list();
					
			for (String attribute : attributes) 
			{
				File attributeDir = new File(databaseDir.getAbsolutePath()+"//"+attribute);
				if (!attributeDir.exists())continue;
				foundAttribute(database,attribute,attributeDir);								
			}						
		}
	}
}

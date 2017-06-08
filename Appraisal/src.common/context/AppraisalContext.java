package context;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppraisalContext 
{
	private static ApplicationContext jbContext;
		
	public static void initializeContext()
	{
		String   springPath = new File("").getAbsolutePath()+"/appraisal-context.xml";
		String[] paths      = new String[]{springPath};
	        
	    jbContext = new FileSystemXmlApplicationContext(paths);
	}
	
	public static Object getBean(String beanName)
	{
		return(jbContext.getBean(beanName));
	}
}

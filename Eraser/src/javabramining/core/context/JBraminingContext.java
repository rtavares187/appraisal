package javabramining.core.context;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JBraminingContext 
{
	
	private static ApplicationContext jbContext;
		
	public static void initializeContext()
	{
		String   springPath = new File("").getAbsolutePath()+"/jb-spring.xml";
		String[] paths      = new String[]{springPath};
	        
	    jbContext = new FileSystemXmlApplicationContext(paths);
	}
	
	public static Object getBean(String beanName)
	{
		return(jbContext.getBean(beanName));
	}
	
}

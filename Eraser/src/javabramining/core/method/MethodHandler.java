package javabramining.core.method;

import java.util.HashMap;
import java.util.Map;

import javabramining.core.catalog.CatalogHandler;
import javabramining.core.database.DatabaseHandler;
import javabramining.core.events.EventHandler;
import javabramining.core.events.Message;
import javabramining.core.kdd.KDDInput;
import javabramining.core.kdd.KDDMethod;
import javabramining.core.kdd.KDDMethodException;
import javabramining.core.kdd.KDDOutput;

public class MethodHandler 
{
	private KDDInput           input;
	private KDDOutput          output;
	private Map<String,Object> parameters; 
	
	private KDDMethod    	   method;
	
	public MethodHandler(String componentName) throws KDDMethodException
	{
		try 
		{
			method	   = (KDDMethod)Class.forName(CatalogHandler.getInstance().getComponentMethodPath(componentName)).newInstance();
			parameters = new HashMap<String,Object>();
			
			DatabaseHandler database = DatabaseHandler.getInstance();
			
			input	   = new KDDInput(database,parameters);
			output     = new KDDOutput();
		}
		catch (Exception e) 
		{		
			throw new KDDMethodException("Unable to invoke method",e);
		}
	}
		
	public void invoke() throws KDDMethodException
	{
		try
		{
			method.run(input,output);
		}
		catch(RuntimeException e)
		{
			throw new KDDMethodException("BinaryCodificationMethod threw an RuntimeException",e);
		}
		
		Message message = new Message("methodProcessing");
		message.setAttribute("output",output.getTextResult());
		
		EventHandler.getInstance().notify(message);
	}
	
	public void addParameter(String name,Object value)
	{
		parameters.put(name,value);
	}	
}

package javabramining.core.kdd;

import java.util.Map;

import javabramining.core.database.DatabaseHandler;

public class KDDInput 
{
	// Handler to Target Database
	private DatabaseHandler database;
	
	// Map with Input Parameters
	private Map<String,Object> parameters;
	
	// Constructor BinaryCodificationMethod
	public KDDInput(DatabaseHandler database,Map<String,Object> parameters)
	{
		this.database=database;
		this.parameters=parameters;
	}

	// Métodos de Manipulação
	public DatabaseHandler getDatabaseHandler() 
	{
		return database;
	}
	
	public Object getParameter(String name)
	{
		return parameters.get(name);
	}
}

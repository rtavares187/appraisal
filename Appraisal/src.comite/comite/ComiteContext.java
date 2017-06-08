package comite;

import java.util.ResourceBundle;

public class ComiteContext 
{
	// Constantes
	private static String resultsPath;
	private static String regressionDatabase;
	
	static
	{
		// Lê arquivo de propriedades
		ResourceBundle properties = ResourceBundle.getBundle("comite.comite");
		resultsPath = properties.getString("results.path");					
	}
	
	public static String getResultsPath()
	{
		return resultsPath;
	}
	
	public static String getRegressionDatabase()
	{
		return regressionDatabase;
	}
	
	public static void setRegressionDatabase(String regressionDatabase)
	{
		ComiteContext.regressionDatabase = regressionDatabase;
	}
}

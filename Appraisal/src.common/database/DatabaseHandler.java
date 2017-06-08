/*
 * Projeto JavaBraMining
 * NUPAC - UNIVERCIDADE
 *  
 * Desenvolvedor:
 * 	Rafael Castaneda Ribeiro
 * 
 * Orientadores:
 * 	Prof. Cláudia Ferlin	
 * 	Prof. Ronaldo Ribeiro Goldschmitd
 */
 
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import context.AppraisalContext;
import entities.dataset.Dataset;



public abstract class DatabaseHandler
{       	
	public static DatabaseHandler getInstance()
	{
		return (DatabaseHandler) AppraisalContext.getBean("databaseHandler");
	}
		
	public abstract void dropDatabase(String database) throws DatabaseException; 
    public abstract void selectDatabase(String database) throws DatabaseException; 
    public abstract void createDatabase(String database) throws DatabaseException; 
    public abstract ResultSet queryDatabase(String query) throws SQLException ;
    public abstract void updateDatabase(String query) throws SQLException ;
    public abstract Connection getConnection() throws DatabaseException; 
    public abstract List<String> listDatabases() throws DatabaseException; 
    public abstract Map<String,Object> getMetaData() throws DatabaseException; 		
	public abstract String getSelectedDatabaseName();
	public abstract String getPrimaryKeyName();
	public abstract List<String> getNumericAttributes();
	
	public abstract Double getMinValue(List<String> columns);
	public abstract Double getMaxValue(List<String> columns);
	
	public abstract Dataset toDataset();
	public abstract Dataset toDataset(List<String> numericColumns);
}
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
 
package javabramining.core.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javabramining.core.context.JBraminingContext;

public abstract class DatabaseHandler
{       	
	public static DatabaseHandler getInstance()
	{
		return (DatabaseHandler) JBraminingContext.getBean("databaseHandler");
	}
		
	public abstract void dropDatabase(String database) throws DatabaseException;
	public abstract void dropDatabaseIfExists(String database) throws DatabaseException;
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
	public abstract void renameTable(String database, String oldTable, String newTable) throws DatabaseException;
	
	public abstract Double getMinValue(List<String> columns);
	public abstract Double getMaxValue(List<String> columns);
	
	public abstract boolean checkReplication(String originalDatabase, String originalTable, 
			String destinationDatabase, String destinationTable) throws DatabaseException;
	
	public abstract Integer getTupleCount(String table) throws DatabaseException;
	
}
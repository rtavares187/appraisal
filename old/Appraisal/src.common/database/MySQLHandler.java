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
 * 
 */
 
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.sql.DataSource;

import entities.dataset.Dataset;
import entities.dataset.Tuple;


/**
 *	Classe MySQLHandler
 *
 *	Classe que oferece uma API para manipulação de databases MySQL.
 *
 *	@author: rafaelcastaneda@brfree.com.br
 *  @version: 1.1  
 */

public class MySQLHandler extends DatabaseHandler
{   
    private String	    selectedDatabse;  
    private Connection  connection;
	
    public void setDataSource(DataSource dataSource) throws SQLException
	{    	
		connection=dataSource.getConnection();
		connection.setAutoCommit(false);			
	}
	    	
    public Connection getConnection() throws DatabaseException 
    {
        if (selectedDatabse == null)
		{
			throw new DatabaseException ("No database selected");
		}
		
		return connection;
	}
    
	public void dropDatabase(String database) throws DatabaseException 
    {
		try 
        {
		    Statement stmt = connection.createStatement();
                        
            String query = "";
            
            query += "DROP DATABASE jb_";
            query += database;
            
            stmt.executeUpdate(query);
            
            if ( (selectedDatabse!=null) && (selectedDatabse.equals(database)) )
            {
				selectedDatabse=null;
            }
            else
            {
				selectedDatabse=database;
            }
			
            stmt.close();
			connection.commit();
        } 
        catch (SQLException e) 
        {
            throw new DatabaseException("Error while removing database '"+database+"'",e);            
        }
	}
	
	public void selectDatabase(String database) throws DatabaseException 
    {
    	try
        {
			Statement stmt = connection.createStatement();    	            
    		
            String query = "";
    		
            query += "USE jb_";
    		query += database;
    		
            stmt.executeUpdate(query);
    		
            selectedDatabse=database;
    		
            stmt.close();
			connection.commit();
        }
        catch(SQLException e)
        {
            throw new DatabaseException("Error while selecting database '"+database+"'",e);          
        }
   	}
	public void createDatabase(String database) throws DatabaseException 
    {
	    try
        {
			Statement stmt = connection.createStatement(ResultSet.CONCUR_UPDATABLE,1);
    	         	
            String query = "";
    		
            query += "CREATE DATABASE jb_";
    		query += database;
    		
            stmt.executeUpdate(query);
    		
            query = "";
    		query += "USE jb_";
    		query += database;
    		
            stmt.executeUpdate(query);
    		stmt.close();
			connection.commit();
        }
        catch(SQLException e)
        {
			if ((e.getMessage()).endsWith("database exists"))
			{
				throw new DatabaseException("Error while creating database '"+database+"' - Database already exists",e);						
			}
			else
			{
				throw new DatabaseException("Error while creating database '"+database+"'",e);
			}
        }
	}
	public List<String> listDatabases() throws DatabaseException 
    {
		ArrayList<String> lista = new ArrayList<String>(10);
		
	    try
        {
	        Statement stmt = connection.createStatement();
    		
            String query = "SHOW databases";
    		
            ResultSet rs = stmt.executeQuery(query);
    		    
    		
            while(rs.next())
    		{
    			String banco = rs.getString(1);
    			
    			if(banco.startsWith("jb_"))
    			{
    				banco=banco.substring(3);
    				lista.add(banco);
    			}
    		}
			
			stmt.close();
			connection.commit();
        }
        catch(SQLException e)
        {
            throw new DatabaseException("Error while retrieving databases",e);
        }
		
		return lista;
	}
	
	public Map<String,Object> getMetaData() throws DatabaseException 
    {
		if (selectedDatabse==null)
		{
			throw new DatabaseException("No database selected");
		}
        		
        // Variáveis de Informação
		String 				   nome = selectedDatabse;
		int					   linhas = 0;
		int 				   qtdColunas = 0;
		int					   tamanho = 0;
		Date				   dataCriacao = null;
		Date				   dataModificacao = null;
		HashMap<String,Object> metaDados = new HashMap<String,Object>();
		HashMap<String,String> tipos   = new HashMap<String,String>();
		
        // Obtendo Primeira Parte
        try
        {
            Statement stmt 	= connection.createStatement();
            ResultSet 	rs 	= stmt.executeQuery("SHOW TABLE STATUS FROM jb_"+nome);                    
            
            if (rs.next())
            {
                linhas 			= rs.getInt("Rows");
                tamanho 		= rs.getInt("Data_length");
                dataCriacao		= rs.getDate("Create_time");
                dataModificacao = rs.getDate("Update_time");
            }
            
            // Obtendo Segunda Parte
            rs = stmt.executeQuery("SELECT * FROM "+nome);
            ResultSetMetaData rsmt = rs.getMetaData();              
            
            qtdColunas = rsmt.getColumnCount();
		
            for (int i=1;i<=qtdColunas;i++)
            {
                // Recuperando Nome da Coluna
                String nomeColuna=rsmt.getColumnName(i);
			
                // Recuperando Tipo da Coluna
                String tipoColuna;
			
                int coluna = rsmt.getColumnType(i);
                
                if (coluna == Types.VARCHAR)
                {
                    tipoColuna = "VARCHAR";
                }
                else if (coluna == Types.DATE)
                {
                    tipoColuna = "DATE";
                }
                else if (coluna == Types.INTEGER || coluna == Types.SMALLINT)
                {
                    tipoColuna = "INTEGER";
                }
                else if (coluna == Types.FLOAT)
                {
                    tipoColuna = "FLOAT";
                }
                else if (coluna == Types.DOUBLE)
                {
                    tipoColuna = "DOUBLE";
                }
                else if (coluna == Types.BOOLEAN)
                {
                    tipoColuna = "BOOLEAN";
                }
                else 
                {
                    tipoColuna = "UNKNOWN";
                }
                
                tipos.put(nomeColuna,tipoColuna);                 
            }
			
			stmt.close();
			connection.commit();
        }
		catch(SQLException e)
        {          		 
            throw new DatabaseException("Error while retrieving database metadata",e);
        }
        
        // Preenchendo metaDados
		metaDados.put("name",nome);
		metaDados.put("lines",new Integer(linhas));
		metaDados.put("columns",new Integer(qtdColunas));
		metaDados.put("size",new Integer(tamanho));
		metaDados.put("creationDate",dataCriacao);
		metaDados.put("modificationDate",dataModificacao);
		metaDados.put("types",tipos);				
			
        return metaDados;
	}
	
	public String getSelectedDatabaseName() 
	{
		return selectedDatabse;
	}

	public ResultSet queryDatabase(String query) throws SQLException 
	{
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		return stmt.executeQuery(query);
	}
	public void updateDatabase(String query) throws SQLException 
	{
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(query);		
	}
	
	public String getPrimaryKeyName()
	{
		String pk = null;
		
		try 
		{
			DatabaseMetaData data = connection.getMetaData();
			ResultSet rs = data.getPrimaryKeys("jb_"+getSelectedDatabaseName(),null,getSelectedDatabaseName());
			rs.next();				
			
			pk = rs.getString("COLUMN_NAME");					
		}
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
		
		return pk;		
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getNumericAttributes() 
	{
		List<String> numericAttributes = new ArrayList<String>();
		
		try 
		{
			Map<String,String> attributes = (Map<String,String>)this.getMetaData().get("types");
			attributes.remove(this.getPrimaryKeyName());
			
			Set<String> attributeNames = attributes.keySet();
			
			for (String attributeName : attributeNames) 
			{
				String attributeType = attributes.get(attributeName);
				
				if (attributeType.equals("INTEGER") || attributeType.equals("DOUBLE"))
					numericAttributes.add(attributeName);
			}
		}
		catch (DatabaseException e) 
		{		
			e.printStackTrace();
		}
		
		return numericAttributes;
	}

	@Override
	public Double getMaxValue(List<String> columns) 
	{
		// 1. Monta a query
		StringBuilder queryBuilder = new StringBuilder("SELECT ");
		
		for (String attributeName : columns)
		{
			queryBuilder.append("MAX("+attributeName+"),");
		}
		
		queryBuilder.deleteCharAt(queryBuilder.length()-1);
		queryBuilder.append(" FROM "+getSelectedDatabaseName());
		
		String query = queryBuilder.toString();
		
		// 2. Roda a query
		try
		{
			ResultSet rs = queryDatabase(query);
			rs.next();
			
			// 3. Descobre o valor máximo
			Double maxValue = null;
			
			for (String column : columns)
			{
				double value = rs.getDouble(columns.indexOf(column)+1);
				
				if (maxValue == null || value > maxValue)
					maxValue = value;
			}
			
			return maxValue;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Double getMinValue(List<String> columns) 
	{
		// 1. Monta a query
		StringBuilder queryBuilder = new StringBuilder("SELECT ");
		
		for (String attributeName : columns)
		{
			queryBuilder.append("MIN("+attributeName+"),");
		}
		
		queryBuilder.deleteCharAt(queryBuilder.length()-1);
		queryBuilder.append(" FROM "+getSelectedDatabaseName());
		
		String query = queryBuilder.toString();
		
		// 2. Roda a query
		try
		{
			ResultSet rs = queryDatabase(query);
			rs.next();
			
			// 3. Descobre o valor máximo
			Double maxValue = null;
			
			for (String column : columns)
			{
				double value = rs.getDouble(columns.indexOf(column)+1);
				
				if (maxValue == null || value < maxValue)
					maxValue = value;
			}
			
			return maxValue;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	///////////////////////////////////////
	// Métodos para recuperação de dados //
	///////////////////////////////////////
	@Override
	public Dataset toDataset() 
	{
		return toDataset(getNumericAttributes());
	}
	
	public Dataset toDataset(List<String> numericColumns) 
	{
		// Chave primária
		String pkAttributeName = getPrimaryKeyName();
		
		// Conjunto de treino e teste
		Dataset fullDataset = new Dataset(numericColumns);
				
		// Composição da query
		StringBuilder queryBuilder = new StringBuilder("SELECT ");
		
		for (String column : numericColumns) 
		{
			queryBuilder.append(column);
			queryBuilder.append(",");
		}
		
		queryBuilder.append(pkAttributeName);
				
		queryBuilder.append(" FROM ");
		queryBuilder.append(getSelectedDatabaseName());

		String query = queryBuilder.toString();
		
		// Processamento da query
		try
		{
			ResultSet rs = queryDatabase(query);
			
			while(rs.next())
			{	
				// 1. Recupera os atributos
				List<Number> tupleAttributes  = new ArrayList<Number>();
				
				for (String attribute : numericColumns) 
				{
					String attributeValue = rs.getString(attribute);
					
					if (attributeValue == null)
					{
						tupleAttributes.add(null);
					}
					else
					{					
						tupleAttributes.add(Double.parseDouble(attributeValue));
					}
				}
				
				Integer idAttributeValue = rs.getInt(pkAttributeName);
				fullDataset.addTuple(new Tuple(idAttributeValue,tupleAttributes));										
			}								
		}
		catch (SQLException e) 
		{
			e.printStackTrace();			
		}
						
		return fullDataset;
	}
}
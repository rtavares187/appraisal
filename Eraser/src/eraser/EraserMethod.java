package eraser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

import javabramining.core.database.DatabaseException;
import javabramining.core.database.DatabaseHandler;
import javabramining.core.kdd.KDDInput;
import javabramining.core.kdd.KDDMethod;
import javabramining.core.kdd.KDDMethodException;
import javabramining.core.kdd.KDDOutput;

@SuppressWarnings("unchecked")
public class EraserMethod implements KDDMethod
{
	public void run(KDDInput input, KDDOutput output) throws KDDMethodException 
	{		
		// Copiando Bases
		String   originalDatabase   = (String)input.getParameter("originalDatabase");
		String   destinationDatabase   = (String)input.getParameter("destinationDatabase");
		
		DatabaseHandler dbHandler    = input.getDatabaseHandler();
		
		try
		{
			
			//ReplicatorMethod.replicate("jb_"+originalDatabase,"jb_"+destinationDatabase);
			
			/**
			 * 11/04/2017 - rtavares
			 * 
			 * Apagando o database novo caso exista e chamando a nova classe com metodo de 
			 * copia pelo mysql e nao por arquivo.
			 * 
			 */
			
			dbHandler.dropDatabaseIfExists(destinationDatabase);
			dbHandler.createDatabase(destinationDatabase);
			
			ReplicatorMethodByDump.replicate("jb_"+originalDatabase,"jb_"+destinationDatabase);
			
			boolean replication = dbHandler.checkReplication("jb_" + originalDatabase, originalDatabase, "jb_"+destinationDatabase, originalDatabase);
			
			if(!replication)
				throw new Exception("Database replication error.");
			
			dbHandler.renameTable("jb_"+destinationDatabase, originalDatabase, destinationDatabase);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Unable to generate new database!");
			e.printStackTrace();
			return;
		}
		
		// Recuperando Entradas
		String   method 			= (String)input.getParameter("method");
		int      percentual 		= (Integer)input.getParameter("percentual");
		
		String   dirtScope 			= (String)input.getParameter("dirtScope");
		
		try 
		{
			dbHandler.selectDatabase(destinationDatabase);			
		}
		catch (DatabaseException e) 
		{
			JOptionPane.showMessageDialog(null,"Unable to access new database!");
			e.printStackTrace();
			return;
		}
		
		System.out.println(input.getParameter("dirtScope"));
		
		try
		{
			if (method.equals("mcar") && dirtScope.equals("column"))
			{
				
				System.out.println("#### mcar - column");
				
				String[] selectedAttributes	= (String[])input.getParameter("selectedAttributes");
				
				for (String attribute : selectedAttributes) 
				{
					
					//int tuples = (Integer) dbHandler.getMetaData().get("lines");
					int tuples = dbHandler.getTupleCount("jb_" + destinationDatabase + "." + destinationDatabase);
					
					int limit  = tuples*percentual/100;
					
					System.out.println("tuples = " + tuples);
					System.out.println("percentual = " + percentual);
					
					String query = "UPDATE "+dbHandler.getSelectedDatabaseName()+" SET "+attribute+"=null WHERE "+attribute+" is not NULL ORDER BY RAND() LIMIT "+limit;
					
					System.out.println("#### attribute = " + attribute +  " query = " + query);
					
					dbHandler.updateDatabase(query);	
					
					System.out.println("#### executou - attribute = " + attribute);
					
				}
				
				dbHandler.getConnection().commit();
				
				JOptionPane.showMessageDialog(null,"Done!");
				
			}
			else if (method.equals("mcar") && dirtScope.equals("cell"))
			{
				
				System.out.println("#### mcar - cell");
				
				//int tuples = (Integer) dbHandler.getMetaData().get("lines");
				int tuples = dbHandler.getTupleCount("jb_" + destinationDatabase + "." + destinationDatabase);
				
				int columns =  dbHandler.getNumericAttributes().size(); 
				
				int totalCells = tuples*columns;
				int dirtCells = totalCells*percentual/100;
				int dirtCount = 1;
								
				System.out.println("Tuples:"+tuples);
				System.out.println("Columns:"+columns);
				System.out.println("TotalCells:"+totalCells);
				System.out.println("DirtCells:"+dirtCells);
				
				String[] selectedAttributes	= (String[])input.getParameter("selectedAttributes");
						
				Random random = new Random(System.currentTimeMillis());
				
				while (dirtCount < dirtCells) 
				{
					String attribute = selectedAttributes[random.nextInt(selectedAttributes.length)];
					
					String query = "UPDATE "+dbHandler.getSelectedDatabaseName()+" SET "+attribute+"=null WHERE "+attribute+" is not null ORDER BY RAND() LIMIT 1";
					System.out.println("#### attribute = " + attribute +  " query = " + query);
					
					dbHandler.updateDatabase(query);	
					
					System.out.println("#### executou - attribute = " + attribute);
					
					dirtCount++;
				}	
				
				dbHandler.getConnection().commit();
				
				String log = "Done!";
				
				log+="\nTuples:"+tuples;
				log+="\nColumns:"+columns;
				log+="\nTotal Cells:"+totalCells;
				log+="\nDirt Cells:"+dirtCells;
				
				JOptionPane.showMessageDialog(null,log);
			}
			else if (method.equals("nmr"))
			{
				Map<String,List<String>> nmr_rulesMap = (Map<String,List<String>>)input.getParameter("rules");
				Set<String> attributeSet = nmr_rulesMap.keySet();
				
				for (String attribute : attributeSet) 
				{
					String 		 query;
					boolean 	 firstFilter;
					List<String> rules = nmr_rulesMap.get(attribute);
					
					// 1. Descobre número de entradas no banco
					query = "SELECT count(*) FROM "+dbHandler.getSelectedDatabaseName()+" ";
					
					firstFilter = true;
					
					for (String rule : rules) 
					{
						if (firstFilter)
						{
							query+="WHERE "+rule;
							firstFilter = false;
						}
						else					
							query+=" AND "+rule;
					}
														
					ResultSet rset;
					
					rset = dbHandler.queryDatabase(query);
					rset.next();
					
					int tuples = rset.getInt(1); 
					int limit  = tuples*percentual/100;
						
					// 2. Executa update no banco
					query = "UPDATE "+dbHandler.getSelectedDatabaseName()+" SET "+attribute+"=null ";					 
					
					firstFilter = true;
					
					for (String rule : rules) 
					{
						if (firstFilter)
						{
							query+="WHERE "+rule;
							firstFilter = false;
						}
						else					
							query+=" AND "+rule;
					}
					
					query+= " ORDER BY RAND() LIMIT "+limit;
									
					dbHandler.updateDatabase(query);					
				}
			}	
			else if (method.equals("mar"))
			{
				Map<String,List<String>> mar_rulesMap = (Map<String,List<String>>)input.getParameter("rules");
				Set<String> attributeSet = mar_rulesMap.keySet();
				
				for (String attribute : attributeSet) 
				{
					String 		 query;
					boolean 	 firstFilter;
					List<String> rules = mar_rulesMap.get(attribute);
					
					// 1. Descobre número de entradas no banco
					query = "SELECT count(*) FROM "+dbHandler.getSelectedDatabaseName()+" ";
					
					firstFilter = true;
					
					for (String rule : rules) 
					{
						if (firstFilter)
						{
							query+="WHERE "+rule;
							firstFilter = false;
						}
						else					
							query+=" AND "+rule;
					}
														
					ResultSet rset;
					
					rset = dbHandler.queryDatabase(query);
					rset.next();
					
					int tuples = rset.getInt(1); 
					int limit  = tuples*percentual/100;
					
					// 2. Executa update no banco
					query = "UPDATE "+dbHandler.getSelectedDatabaseName()+" SET "+attribute+"=null "; 
				
					firstFilter = true;
					
					for (String rule : rules) 
					{
						if (firstFilter)
						{
							query+="WHERE "+rule;
							firstFilter = false;
						}
						else					
							query+=" AND "+rule;
					}
				
					query+= " ORDER BY RAND() LIMIT "+limit;
								
					dbHandler.updateDatabase(query);					
				}
			}	
		}		
		catch (DatabaseException e) 
		{
			throw new KDDMethodException("Unable to manipulate database data",e);
		}
		catch (SQLException e) 
		{
			throw new KDDMethodException("Unable to manipulate database data",e);
		}
	}
}

package eraser;

import java.awt.JobAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import javabramining.core.database.DatabaseException;
import javabramining.core.database.DatabaseHandler;
import javabramining.core.database.MySQLHandler;
import javabramining.core.kdd.KDDMethodException;
import javabramining.core.method.MethodHandler;
import javabramining.core.userinterface.KDDScreen;
import javabramining.core.userinterface.KDDScreenException;
import javabramining.core.userinterface.SwingHandler;
import thinlet.Thinlet;


public class EraserScreen extends KDDScreen
{
	Object mcar_attributeList;
	Object mcar_selectedAttributeList;
	
	Object nmr_valueTextfield; 
	Object nmr_operationCombobox; 
	Object nmr_rulesList;
	Object nmr_attributeList;
	
	Object mar_attributeList;
	Object mar_attributeCombobox; 
	Object mar_operationCombobox; 
	Object mar_valueTextfield; 
	Object mar_rulesList;
	
	Object databaseCombo;
	Object destinationDatabaseField;
	
	Object cellTargetCheckBox;
	Object columnTargetCheckBox;
	
	List<String> columns = new ArrayList<String>();
	
	Map<String,List<String>> nmr_rulesMap = new HashMap<String,List<String>>();
	Map<String,List<String>> mar_rulesMap = new HashMap<String,List<String>>();
	
	@Override
	protected String getXulFile() 
	{
		return("/eraser/eraserScreen.xul");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void initialize() throws KDDScreenException 
	{		
		SwingHandler swHandler = SwingHandler.getInstance();
		DatabaseHandler DBHandler = MySQLHandler.getInstance();
		
		// 1. Características da Tela
		setWidth(380);
		setHeight(530);
		setTitle("Data Eraser");
		
		// 2. Recupera Objetos Principais
		mcar_attributeList = thinlet.find(screen,"mcar_attributeList");
		mcar_selectedAttributeList = thinlet.find(screen,"mcar_selectedAttributeList");
		nmr_attributeList = thinlet.find(screen,"nmr_attributeList");
		nmr_valueTextfield = thinlet.find(screen,"nmr_valueTextfield"); 
		nmr_operationCombobox = thinlet.find(screen,"nmr_operationCombobox"); 
		nmr_rulesList = thinlet.find(screen,"nmr_rulesList");
		mar_attributeList = thinlet.find(screen,"mar_attributeList");
		mar_attributeCombobox = thinlet.find(screen,"mar_attributeCombobox"); 
		mar_operationCombobox = thinlet.find(screen,"mar_operationCombobox"); 
		mar_valueTextfield = thinlet.find(screen,"mar_valueTextfield"); 
		mar_rulesList = thinlet.find(screen,"mar_rulesList");
		databaseCombo = thinlet.find(screen,"databaseCombo");
		cellTargetCheckBox = thinlet.find(screen,"cellTargetCheckBox");
		columnTargetCheckBox = thinlet.find(screen,"columnTargetCheckBox");
		destinationDatabaseField  = thinlet.find(screen,"destinationDatabaseField");
		
		// 3. Lista bases
		try 
		{
			List<String> databases = DBHandler.listDatabases();
			
			for (String databaseName : databases )
			{
				Object databaseItem = Thinlet.create("choice");
				thinlet.setString(databaseItem,"text",databaseName);
				thinlet.add(databaseCombo,databaseItem);
			}
		}
		catch (DatabaseException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void clean() 
	{
			
	}

	@Override
	protected void refresh() 
	{
			
	}
		
	public void databaseSelected()
	{
		SwingHandler swHandler = SwingHandler.getInstance();
		
		// 3. Obtendo Informações do Banco 	
		DatabaseHandler DBHandler;
		Map<String,Object> metaData;
		Map<String,String> metaDataColumns;
			
		String selectedDataset = thinlet.getString(thinlet.getSelectedItem(databaseCombo),"text");
		
		try
		{
			// Recuperando Handler para Banco de Dados
			DBHandler = DatabaseHandler.getInstance();
			
			DBHandler.selectDatabase(selectedDataset);
			
			// Obtendo mapa de meta-dados, e a partir dele, o 
			// mapa de colunas por tipos
			metaData = DBHandler.getMetaData();
			metaDataColumns = (Map)metaData.get("types");
		}
		catch(DatabaseException e)
		{			
			swHandler.displayMessage("Error initializing KDD method.");			
			e.printStackTrace();	
			return;
		}		
				
		String primaryKey = DBHandler.getPrimaryKeyName();
		
		// Adicionando Item de Lista à Lista
		thinlet.removeAll(mcar_attributeList);
		thinlet.removeAll(nmr_attributeList);
		thinlet.removeAll(mar_attributeList);
		
		// PARA cada coluna
		for (String column : metaDataColumns.keySet())
		{				
			if (column.equals(primaryKey))
				continue;
			
			Object mcar_item = Thinlet.create("item");
			thinlet.setString(mcar_item,"text",column);
			thinlet.add(mcar_attributeList,mcar_item);
						
			Object nmr_item = Thinlet.create("item");
			thinlet.setString(nmr_item,"text",column);
			thinlet.add(nmr_attributeList,nmr_item);
			
			Object mar_item = Thinlet.create("item");
			thinlet.setString(mar_item,"text",column);
			thinlet.add(mar_attributeList,nmr_item);
			
			columns.add(column);
		}			
	}
	
	public void slider(String method)
	{
		Object slider = thinlet.find(method+"_slider");
		Object label = thinlet.find(method+"_sliderlabel");
		
		int value = thinlet.getInteger(slider,"value");
		
		String valueString = value < 10 ? "0"+value+"%" : value+"%"; 
		
		thinlet.setString(label,"text",valueString);		
	}
	
	public void add()
	{
		Object[] selectedItems = thinlet.getSelectedItems(mcar_attributeList);
		
		for (Object item : selectedItems) 
		{
			thinlet.remove(item);
			thinlet.add(mcar_selectedAttributeList,item);		
		}		
	}
	
	public void addAll()
	{
		Object[] selectedItems = thinlet.getItems(mcar_attributeList);
		
		for (Object item : selectedItems) 
		{
			thinlet.remove(item);
			thinlet.add(mcar_selectedAttributeList,item);		
		}	
	}
	
	public void remove()
	{
		Object[] selectedItems = thinlet.getSelectedItems(mcar_selectedAttributeList);
		
		for (Object item : selectedItems) 
		{
			thinlet.remove(item);
			thinlet.add(mcar_attributeList,item);		
		}
	}
	
	public void removeAll()
	{
		Object[] selectedItems = thinlet.getItems(mcar_selectedAttributeList);
		
		for (Object item : selectedItems) 
		{
			thinlet.remove(item);
			thinlet.add(mcar_attributeList,item);		
		}	
	}
		
	public void mar_attributeSelected()
	{
		// Limpa regras e combobox
		thinlet.removeAll(mar_rulesList);
		thinlet.removeAll(mar_attributeCombobox);
		
		// Recupera atributo selecionado
		String attribute = thinlet.getString(thinlet.getSelectedItem(mar_attributeList),"text");
		
		// Se o atributo possui regras, adiciona-as no painel
		if (mar_rulesMap.containsKey(attribute))
		{
			List<String> rulesList = mar_rulesMap.get(attribute);
			
			for (String rule : rulesList) 
			{
				Object item = Thinlet.create("item");
				
				thinlet.setString(item,"text",rule);				
				thinlet.add(mar_rulesList,item);
			}									
		}
		
		// Compõe as escolhas sem o atributo atual
		for (String column : columns) 
		{
			if (column.equals(attribute))
				continue;
			
			Object mar_choice = Thinlet.create("choice");
			thinlet.setString(mar_choice,"text",column);
			thinlet.add(mar_attributeCombobox,mar_choice);
		}		
		
		thinlet.setString(mar_attributeCombobox,"text","");
	}
	
	public void nmr_addRule()
	{
		String attribute = thinlet.getString(thinlet.getSelectedItem(nmr_attributeList),"text");
		String operator = thinlet.getString(thinlet.getSelectedItem(nmr_operationCombobox),"text");
		String value = thinlet.getString(nmr_valueTextfield,"text");
		
		// Cria a Regra
		String rule = attribute+operator+value;		
		
		// Adiciona na interface		
		Object item = Thinlet.create("item");		
		thinlet.setString(item,"text",rule);		
		thinlet.add(nmr_rulesList,item);
		
		// Adiciona no mapa
		List<String> rules = nmr_rulesMap.get(attribute);
		
		if (rules==null)
		{
			rules = new ArrayList<String>();
			nmr_rulesMap.put(attribute,rules);
		}
		
		rules.add(rule);		
	}
	
	public void mar_addRule()
	{
		String attribute = thinlet.getString(thinlet.getSelectedItem(mar_attributeList),"text");
		String attributeRule = thinlet.getString(thinlet.getSelectedItem(mar_attributeCombobox),"text");
		String operator = thinlet.getString(thinlet.getSelectedItem(mar_operationCombobox),"text");
		String value = thinlet.getString(mar_valueTextfield,"text");
		
		// Cria a Regra
		String rule = attributeRule+operator+value;		
		
		// Adiciona na interface		
		Object item = Thinlet.create("item");		
		thinlet.setString(item,"text",rule);	
		thinlet.add(mar_rulesList,item);
		
		// Adiciona no mapa
		List<String> rules = mar_rulesMap.get(attribute);
		
		if (rules==null)
		{
			rules = new ArrayList<String>();
			mar_rulesMap.put(attribute,rules);
		}
		
		rules.add(rule);
	}
	
	public void nmr_removeRule()
	{
		String attribute = thinlet.getString(thinlet.getSelectedItem(nmr_attributeList),"text");		
		int    ruleIndex = thinlet.getSelectedIndex(nmr_rulesList);
		
		// Se houver regra selecionada
		if (ruleIndex >= 0)
		{
			// Remove da interface
			Object selectedItem = thinlet.getSelectedItem(nmr_rulesList);
			thinlet.remove(selectedItem);
			
			// Remove do mapa
			List<String> rulesList = nmr_rulesMap.get(attribute);
			rulesList.remove(ruleIndex);
			
			// Se não há mais regras, limpa o mapa
			if (rulesList.isEmpty())
				nmr_rulesMap.remove(attribute);
		}		
	}
	
	public void nmr_removeAllRules()
	{
		String attribute = thinlet.getString(thinlet.getSelectedItem(nmr_attributeList),"text");		
				
		// Remove da interface
		thinlet.removeAll(nmr_rulesList);
		
		// Remove do mapa
		nmr_rulesMap.remove(attribute);
	}
	
	public void mar_removeRule()
	{
		String attribute = thinlet.getString(thinlet.getSelectedItem(mar_attributeList),"text");		
		int    ruleIndex = thinlet.getSelectedIndex(mar_rulesList);
		
		// Se houver regra selecionada
		if (ruleIndex >= 0)
		{
			// Remove da interface
			Object selectedItem = thinlet.getSelectedItem(mar_rulesList);
			thinlet.remove(selectedItem);
			
			// Remove do mapa
			List<String> rulesList = mar_rulesMap.get(attribute);
			rulesList.remove(ruleIndex);
			
			// Se não há mais regras, limpa o mapa
			if (rulesList.isEmpty())
				mar_rulesMap.remove(attribute);
		}		
	}
	
	public void mar_removeAllRules()
	{
		String attribute = thinlet.getString(thinlet.getSelectedItem(mar_attributeList),"text");		
				
		// Remove da interface
		thinlet.removeAll(mar_rulesList);
		
		// Remove do mapa
		mar_rulesMap.remove(attribute);
	}
	
	public void ok(String method) 
	{
		Object slider     			= thinlet.find(method+"_slider");
		int    percentual 			= thinlet.getInteger(slider,"value");
		String destinationDatabase 	= thinlet.getString(destinationDatabaseField,"text");
		String originalDatabase 	= thinlet.getString(thinlet.getSelectedItem(databaseCombo),"text");
				
		if (destinationDatabase.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Destination Database Cannot be Blank!");
			return;
		}
					
		// Invocando Método
		try 
		{
			MethodHandler mh = new MethodHandler("Eraser");
			mh.addParameter("method", method);
			mh.addParameter("percentual",percentual);
			mh.addParameter("originalDatabase",originalDatabase);
			mh.addParameter("destinationDatabase",destinationDatabase);

			if (method.equals("mcar"))
			{
				Object[] selectedItems = thinlet.getItems(mcar_selectedAttributeList);
				String[] selectedAttributes = new String[selectedItems.length];
				
				for (int i = 0; i < selectedItems.length; i++) 
				{
					selectedAttributes[i] = thinlet.getString(selectedItems[i],"text");
				}
				
				String dirtScope;
				
				if (thinlet.getBoolean(cellTargetCheckBox,"selected"))
					dirtScope = "cell";
				else
					dirtScope = "column";
				
				mh.addParameter("dirtScope", dirtScope);
				mh.addParameter("selectedAttributes", selectedAttributes);			
			}	
			else if (method.equals("nmr"))
			{
				mh.addParameter("rules",nmr_rulesMap);					
			}
			else if (method.equals("mar"))
			{
				mh.addParameter("rules",mar_rulesMap);			
			}
			
			mh.invoke();			
		} 
		catch (KDDMethodException e) 
		{
			SwingHandler.getInstance().displayMessage("Unable to process method");
			e.printStackTrace();
		}
	}
	
	public void cancel()
	{
		// Fechando
		close();
	}
}
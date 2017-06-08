package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class DynamicPropertiesCombiner
{
	ResourceBundle properties;
	
	int propertyCounter = 0;
	
	String dynamicProperty;
	
	List<Map<String,String>> staticPropertiesList;
	List<Map<String,String>> dynamicPropertiesList;
	
	public DynamicPropertiesCombiner(ResourceBundle properties,String... propertiesNames)
	{
		this.properties = properties;
		staticPropertiesList = new ArrayList<Map<String,String>>();
		
		List<String> pQueues = new ArrayList<String>(propertiesNames.length);
		
		for (int i = 0; i < propertiesNames.length; i++) 
		{
			String propertyName = propertiesNames[i];
			pQueues.add(propertyName);
		}
		
		combiner(pQueues,new ArrayList<String>(),new ArrayList<String>());
	}
		
	protected void combiner(List<String> pQueues, List<String> pValues, List<String> pFilled)
	{
		if (pQueues.isEmpty())
		{
			Map<String,String> propertiesMap = new HashMap<String,String>();
			
			for (int i=0 ; i<pValues.size() ; i++) 
			{
				String pFill = pFilled.get(i);
				String pValue = pValues.get(i);
								
				propertiesMap.put(pFill,pValue);
			}
			
			staticPropertiesList.add(propertiesMap);
		}
		else
		{
			String pQueue = pQueues.get(0);
			String pValue = properties.getString(pQueue);

			if (pValue.contains(";"))
			{
				String[] split = pValue.split(";");

				double base = Double.parseDouble(split[0]);
				double top  = Double.parseDouble(split[1]);
				int    incr = Integer.parseInt(split[2]);

				for (double j = base ; j <= top ; j += incr )
				{
					List<String> pQueuesNew = new ArrayList<String>(pQueues.subList(0,pQueues.size()));
					List<String> pValuesNew = new ArrayList<String>(pValues.subList(0,pValues.size()));
					List<String> pFilledNew = new ArrayList<String>(pFilled.subList(0,pFilled.size()));

					pQueuesNew.remove(pQueue);
					pValuesNew.add(String.valueOf(j));
					pFilledNew.add(pQueue);

					combiner(pQueuesNew,pValuesNew,pFilledNew);
				}				 
			}
			else if (pValue.contains(","))
			{
				String[] split = pValue.split(",");

				for (String value : split) 
				{
					List<String> pQueuesNew = new ArrayList<String>(pQueues.subList(0,pQueues.size()));
					List<String> pValuesNew = new ArrayList<String>(pValues.subList(0,pValues.size()));
					List<String> pFilledNew = new ArrayList<String>(pFilled.subList(0,pFilled.size()));

					pQueuesNew.remove(pQueue);
					pValuesNew.add(value);
					pFilledNew.add(pQueue);

					combiner(pQueuesNew,pValuesNew,pFilledNew);
				}				 
			}
			else if (pValue.contains("all"))
			{
				dynamicProperty = pQueue;		
				
				List<String> pQueuesNew = new ArrayList<String>(pQueues.subList(0,pQueues.size()));
				
				pQueuesNew.remove(pQueue);
				
				combiner(pQueuesNew,pValues,pFilled);
			}
			else
			{
				List<String> pQueuesNew = new ArrayList<String>(pQueues.subList(0,pQueues.size()));
				List<String> pValuesNew = new ArrayList<String>(pValues.subList(0,pValues.size()));
				List<String> pFilledNew = new ArrayList<String>(pFilled.subList(0,pFilled.size()));

				pQueuesNew.remove(pQueue);
				pValuesNew.add(pValue);
				pFilledNew.add(pQueue);

				combiner(pQueuesNew,pValuesNew,pFilledNew);
			}
		} 
	}
	
	public void resetCombinations()
	{
		dynamicPropertiesList = staticPropertiesList;
		propertyCounter=0;
	}
	
	public void resetCombinations(int base, int top, int incr) 
	{
		// Definindo propriedade ALL pra etapa de KNN
		List<Object> dynamicPropertyValues = new ArrayList<Object>();
		
		for (double j = base ; j <= top ; j += incr )
		{
			dynamicPropertyValues.add(j);			
		}	
	
		resetCombinations(dynamicPropertyValues);
	}
	
	public void resetCombinations(List<Object> dinamicPropertyValues) 
	{
		if (dynamicProperty == null)
		{
			resetCombinations();
			return;
		}
		
		dynamicPropertiesList = new ArrayList<Map<String,String>>();
		
		for (Map<String,String> staticProperties : staticPropertiesList) 
		{
			for (Object dinamicPropertyValue : dinamicPropertyValues) 
			{
				// Cria nova combinação
				Map<String,String> newPropertyMap = new TreeMap<String,String>();
				
				// Adiciona propriedade dinâmica
				String newPropertyName = dynamicProperty;
				String newPropertyValue = String.valueOf(dinamicPropertyValue);
					
				newPropertyMap.put(newPropertyName, newPropertyValue);
				
				// Recplica as propriedades estáticas
				Set<Entry<String,String>> staticPropertiesEntries = staticProperties.entrySet();
				
				for (Entry<String, String> staticPropertyEntry : staticPropertiesEntries) 
				{
					String staticPropertyName = staticPropertyEntry.getKey();
					String staticPropertyValue = staticPropertyEntry.getValue();
					
					newPropertyMap.put(staticPropertyName, staticPropertyValue);
				}		
				
				// Adiciona no mapa dinâmico
				dynamicPropertiesList.add(newPropertyMap);
			}			
		}	
		
		propertyCounter=0;		
	}
	
	public void print()
	{
		for (Map<String,String> propertiesMap : dynamicPropertiesList) 
		{
			Set<Entry<String,String>> propertyNames = propertiesMap.entrySet();

			for (Entry<String, String> entry : propertyNames) 
			{
				System.out.print(entry.getKey()+"="+entry.getValue()+"\t");
			}

			System.out.println();
		}
	}
	
	public boolean nextCombination()
	{
		if (propertyCounter < dynamicPropertiesList.size()-1)
		{
			propertyCounter++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getPresentCombination()
	{
		String dirPiece = "";
		
		Set<String> propNames = getPropertiesNames();
		
		for (String propName : propNames) 
		{
			dirPiece += "["+propName+"="+getStringProperty(propName)+"]";
		}				
		
		return dirPiece;
	}
	
	public Set<String> getPropertiesNames()
	{
		return dynamicPropertiesList.get(propertyCounter).keySet();
	}
	
	public boolean getBooleanProperty(String propertyName) 
	{
		String property = dynamicPropertiesList.get(propertyCounter).get(propertyName);
		return Boolean.parseBoolean(property);
	}
	
	public Integer getIntegerProperty(String propertyName) 
	{
		String property = dynamicPropertiesList.get(propertyCounter).get(propertyName);
		return (int)Double.parseDouble(property);
	}
	
	public Double getDoubleProperty(String propertyName) 
	{
		String property = dynamicPropertiesList.get(propertyCounter).get(propertyName);
		return Double.parseDouble(property);
	}
	
	public String getStringProperty(String propertyName) 
	{
		return dynamicPropertiesList.get(propertyCounter).get(propertyName);
	}
}
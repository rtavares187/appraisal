package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Map.Entry;

public class PropertiesCombiner
{
	ResourceBundle properties;
	
	int propertyCounter = 0;
	List<Object> allProperty;
	List<Map<String,String>> propertiesList;
	
	public PropertiesCombiner(ResourceBundle properties,String... propertiesNames)
	{
		this.properties = properties;
		propertiesList = new ArrayList<Map<String,String>>();
		
		List<String> pQueues = new ArrayList<String>(propertiesNames.length);
		
		for (int i = 0; i < propertiesNames.length; i++) 
		{
			String propertyName = propertiesNames[i];
			pQueues.add(propertyName);
		}
		
		combiner(pQueues,new ArrayList<String>(),new ArrayList<String>());
	}
	
	public PropertiesCombiner(ResourceBundle properties,List<Object> allProperty,String... propertiesNames)
	{
		this.allProperty = allProperty; 
		this.properties = properties;
		propertiesList = new ArrayList<Map<String,String>>();
		
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
			
			propertiesList.add(propertiesMap);
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
				for (Object value : allProperty) 
				{
					List<String> pQueuesNew = new ArrayList<String>(pQueues.subList(0,pQueues.size()));
					List<String> pValuesNew = new ArrayList<String>(pValues.subList(0,pValues.size()));
					List<String> pFilledNew = new ArrayList<String>(pFilled.subList(0,pFilled.size()));

					pQueuesNew.remove(pQueue);
					pValuesNew.add(String.valueOf(value));
					pFilledNew.add(pQueue);

					combiner(pQueuesNew,pValuesNew,pFilledNew);
				}				 
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

	public void print()
	{
		for (Map<String,String> propertiesMap : propertiesList) 
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
		if (propertyCounter < propertiesList.size()-1)
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
		return propertiesList.get(propertyCounter).keySet();
	}
	
	public boolean getBooleanProperty(String propertyName) 
	{
		String property = propertiesList.get(propertyCounter).get(propertyName);
		return Boolean.parseBoolean(property);
	}
	
	public Integer getIntegerProperty(String propertyName) 
	{
		String property = propertiesList.get(propertyCounter).get(propertyName);
		return (int)Double.parseDouble(property);
	}
	
	public Double getDoubleProperty(String propertyName) 
	{
		String property = propertiesList.get(propertyCounter).get(propertyName);
		return Double.parseDouble(property);
	}
	
	public String getStringProperty(String propertyName) 
	{
		return propertiesList.get(propertyCounter).get(propertyName);
	}

	public void resetCombinations() 
	{
		propertyCounter=0;		
	}
}
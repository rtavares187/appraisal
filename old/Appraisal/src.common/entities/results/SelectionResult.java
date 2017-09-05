package entities.results;

import java.util.ArrayList;
import java.util.List;

import common.ValuedAttribute;



public class SelectionResult 
{
	List<ValuedAttribute<String>> attributes;
	
	public SelectionResult(List<ValuedAttribute<String>> attributes) {
		this.attributes = attributes;
	}

	public List<String> getAttributes() 
	{
		List<String> attrs = new ArrayList<String>();
		
		for (ValuedAttribute<String> attribute : attributes) 
		{
			attrs.add(attribute.getAttribute());
		}
		
		return attrs;
	}
	
	public List<ValuedAttribute<String>> getValuedAttributes() 
	{
		return attributes;
	}
	
	public List<String> getAttributes(int count) 
	{
		List<String> attrs = new ArrayList<String>();
		
		for (int i=0 ; i<count ; i++) 
		{
			attrs.add(attributes.get(i).getAttribute());
		}
		
		return attrs;
	}

	public void setAttributes(List<ValuedAttribute<String>> columns) {
		this.attributes = columns;
	}
	
	public String toString()
	{
		String result = "";
		
		for (ValuedAttribute attribute : attributes) 
		{
			result+="["+attribute.getAttribute()+" | "+attribute.getAttributeValue()+"]";			
		}
		
		return result;
	}
}
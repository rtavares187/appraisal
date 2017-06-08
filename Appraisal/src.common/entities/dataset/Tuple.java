package entities.dataset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Tuple implements Comparable
{
	private int id;
	private List<String> columns;
	private List<Number> values;
	
	public Tuple(int id, List<Number> values)
	{
		this.id=id;
		this.values = new ArrayList<Number>();
		
		for (Number attribute : values) 
		{
			this.values.add(attribute);
		}
	}
	
	public Tuple(int id, Number... values)
	{
		this.id=id;
		this.values = new ArrayList<Number>();
		
		for (Number attribute : values) 
		{
			this.values.add(attribute);
		}
	}
	
	public Tuple(int id, Number value)
	{
		this.id=id;
		this.values = new ArrayList<Number>();
		this.values.add(value);
	}
	
	protected void setColumns(List<String> columns) 
	{
		this.columns = columns;
	}
	
	protected Number removeAttribute(String column) 
	{
		Number removedAttribute = values.remove(columns.indexOf(column));
		return removedAttribute;
	}
	
	public Tuple copyTuple() 
	{
		List<Number> newAttributeValues = new ArrayList<Number>();
		
		for (Number attributeValue : values) 
		{
			newAttributeValues.add(attributeValue);
		}
		
		return new Tuple(new Integer(getId()),newAttributeValues);
	}
	
	public int getId()
	{
		return id;
	}
	
	public boolean hasNullValues() 
	{
		for (Number number : values) 
		{
			if (number==null)
				return true;
		}
		
		return false;
	}
	
	public boolean hasNullValues(List<String> columns) 
	{
		for (String column : columns) 
		{
			if (values.get(this.columns.indexOf(column))==null)
				return true;
		}
		
		return false;
	}
	
	public List<Number> getValues()
	{
		return values;
	}
	
	public List<Number> getValues(List<String> columns)
	{
		List<Number> values = new ArrayList<Number>();
		
		for (String attribute : columns) 
		{
			values.add(getValue(attribute));
		}
		
		return values;
	}
	
	
	public Number getValue(int columnIndex)
	{
		return values.get(columnIndex);
	}
	
	public Number getValue(String column)
	{
		int index = columns.indexOf(column);
		return values.get(index);
	}

	public Double getDoubleValue(int columnIndex)
	{
		return values.get(columnIndex).doubleValue();
	}
	
	public Double getDoubleValue(String column)
	{
		return values.get(columns.indexOf(column)).doubleValue();
	}
	
	public Integer getIntegerValue(int columnIndex)
	{
		return values.get(columnIndex).intValue();
	}
	
	public Integer getIntegerValue(String column)
	{
		return values.get(columns.indexOf(column)).intValue();
	}
	
	public int compareTo(final Object other) {
		Tuple castOther = (Tuple) other;
		return new CompareToBuilder().append(id, castOther.id).toComparison();
	}
	
	public String toString()
	{
		String result = "" ;
		
		result+="ID = "+getId();
		
		List<Number> values = getValues();
		
		for (Number number : values) 
		{
			result+=("\t"+number);
		}	
		
		return result;
	}

	public boolean equals(final Object other) {
		if (!(other instanceof Tuple))
			return false;
		Tuple castOther = (Tuple) other;
		return new EqualsBuilder().append(id, castOther.id).append(columns,
				castOther.columns).append(values, castOther.values).isEquals();
	}	
}
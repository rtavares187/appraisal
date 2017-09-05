package common;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ValuedAttribute<VALUE> implements Comparable 
{
	private double attributeValue;
	private VALUE attribute;
	
	/**
	 * @param attributeName
	 * @param attributeValue
	 */
	public ValuedAttribute(double attributeName, VALUE attributeValue) {
		super();
		this.attributeValue = attributeName;
		this.attribute = attributeValue;
	}
	
	/**
	 * @return the attributeName
	 */
	public double getAttributeValue() {
		return attributeValue;
	}

	/**
	 * @param attributeName the attributeName to set
	 */
	public void setAttributeValue(double attributeName) {
		this.attributeValue = attributeName;
	}

	/**
	 * @return the attributeValue
	 */
	public VALUE getAttribute() {
		return attribute;
	}

	/**
	 * @param attributeValue the attributeValue to set
	 */
	public void setAttribute(VALUE attributeValue) {
		this.attribute = attributeValue;
	}
	
	public int compareTo(final Object other) {
		ValuedAttribute castOther = (ValuedAttribute) other;
		return new CompareToBuilder().append(attributeValue,
				castOther.attributeValue).toComparison();
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("attribute", attribute).append(
				"attributeValue", attributeValue).toString();
	}

	
}
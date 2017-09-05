package appraisal.algorithms.pca;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PcaAttribute implements Comparable 
{
	private String attributeName;
	private Double attributeValue;
	
	/**
	 * @param attributeName
	 * @param attributeValue
	 */
	public PcaAttribute(String attributeName, Double attributeValue) {
		super();
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}
	
	/**
	 * @return the attributeName
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * @param attributeName the attributeName to set
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * @return the attributeValue
	 */
	public Double getAttributeValue() {
		return attributeValue;
	}

	/**
	 * @param attributeValue the attributeValue to set
	 */
	public void setAttributeValue(Double attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public int compareTo(final Object other) {
		PcaAttribute castOther = (PcaAttribute) other;
		return new CompareToBuilder().append(attributeValue,
				castOther.attributeValue).toComparison();
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(
				"attributeName", attributeName).append("attributeValue",
				attributeValue).toString();
	}	
}
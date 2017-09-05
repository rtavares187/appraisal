package entities.dataset;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ColumnCentroid
{
	private String column;
	private double centroidValue;

	public ColumnCentroid(String column, double centroidValue) 
	{
		this.column = column;
		this.centroidValue = centroidValue;
	}

	public double getCentroidValue() {
		return centroidValue;
	}

	public void setCentroidValue(double centroidValue) {
		this.centroidValue = centroidValue;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(
				"column", column).append("centroidValue", centroidValue)
				.toString();
	}	
}	
package javabramining.core.catalog.metadata;

import org.apache.commons.lang.builder.ToStringBuilder;

public class MinComponentInfo extends ComponentInfo
{
	//
	// Fields
	//
	
	private String dataType;

	//
	// Constructors
	//

	public MinComponentInfo(String name, String kddScreenPath, String kddMethodPath,String dataType,OperationInfo operation) 
	{
		super(name,kddScreenPath,kddMethodPath,operation);
		this.dataType = dataType;
	}

	//
	// Accessors
	//
	
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	//
	// Others
	//
	
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"dataType", dataType).toString();
	}
}

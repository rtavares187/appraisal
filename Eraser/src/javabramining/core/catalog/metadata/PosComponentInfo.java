package javabramining.core.catalog.metadata;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PosComponentInfo extends ComponentInfo 
{
	//
	// Fields
	//
	
	private String resultType;

	//
	// Constructors
	//

	public PosComponentInfo(String name, String kddScreenPath, String kddMethodPath,String resultType,OperationInfo operation) 
	{
		super(name,kddScreenPath,kddMethodPath,operation);
		this.resultType = resultType;
	}

	//
	// Accessors
	//
	
	public String getResultType() {
		return resultType;
	}

	public void setResultType(String dataType) {
		this.resultType = dataType;
	}
	
	//
	// Others
	//
	
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"dataType", resultType).toString();
	}
}

package javabramining.core.catalog.metadata;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Rafael Castaneda Ribeiro 
 *
 * E-Mail: rafaelcastaneda@brfree.com.br
 * 
 */
public abstract class ComponentInfo
{
	//
	// Fields
	//
	
	private String name;
	private String kddScreenPath;
	private String kddMethodPath;
	
	private OperationInfo operationInfo;
	
	//
	// Constructrors
	//
	
	public ComponentInfo() {
	}


	public ComponentInfo(String name, String kddScreenPath, String kddMethodPath,OperationInfo operationInfo) {
		this.name = name;
		this.kddScreenPath = kddScreenPath;
		this.kddMethodPath = kddMethodPath;
		this.operationInfo = operationInfo;
	}

	//
	// Accessors
	//
	
	public String getKddMethodPath() {
		return kddMethodPath;
	}


	public void setKddMethodPath(String kddMethodPath) {
		this.kddMethodPath = kddMethodPath;
	}


	public String getKddScreenPath() {
		return kddScreenPath;
	}


	public void setKddScreenPath(String kddScreenPath) {
		this.kddScreenPath = kddScreenPath;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	//
	// Others
	//
	
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append(
				"kddScreenPath", kddScreenPath).append("kddMethodPath",
				kddMethodPath).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(name).toHashCode();
	}


	public boolean equals(final Object other) {
		if (!(other instanceof ComponentInfo))
			return false;
		ComponentInfo castOther = (ComponentInfo) other;
		return new EqualsBuilder().append(name, castOther.name).isEquals();
	}

	public OperationInfo getOperationInfo() {
		return operationInfo;
	}


	public void setOperationInfo(OperationInfo operationInfo) {
		this.operationInfo = operationInfo;
	}		
	
	
}


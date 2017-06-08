package javabramining.core.catalog.metadata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rafael Castaneda Ribeiro 
 *
 * E-Mail: rafaelcastaneda@brfree.com.br
 * 
 */
public class StageInfo
{
	public static final String  PRE_PROCESSING = "Pre-Processing";
	public static final String	MINING		   = "Mining";
	public static final String  POS_PROCESSING = "Pos-Processing";
	
	private final String name;

	private final Map<String,OperationInfo> operations = new HashMap<String,OperationInfo>();
	
	public StageInfo(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public OperationInfo[] getOperations()
	{		
		Object[]  entries   = (operations.values()).toArray();
		OperationInfo[] operations  = new OperationInfo[entries.length];
		
		for (int i=0;i<entries.length;i++)
		{
			operations[i]=(OperationInfo)entries[i];
		}
		
		return operations;
	}
	
	public void addOperation (OperationInfo operation)
	{
		operations.put(operation.getName(),operation);
	}
	
	public void removeOperation (String operationName)
	{
		operations.remove(operationName);
	}
	
	public boolean hasOperation (String operationName)
	{
		return (operations.containsKey(operationName));
	}
	
	public OperationInfo getOperation (String operationName)
	{
		return (operations.get(operationName));
	}
}

package javabramining.core.catalog.metadata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rafael Castaneda Ribeiro 
 *
 * E-Mail: rafaelcastaneda@brfree.com.br
 * 
 */
public class OperationInfo
{
	//
	// Fields
	//
	
	private final String name;
	private final Map<String,ComponentInfo> componentsMap = new HashMap<String,ComponentInfo>();
		
	private StageInfo stageInfo;
	
	//
	// Constructors
	//
	
	public OperationInfo(String name, StageInfo stageInfo)
	{
		this.name = name;
		this.stageInfo = stageInfo;
	}
	
	//
	// Accessors
	//
	
	public String getName()
	{
		return name;
	}
	
	public ComponentInfo[] getComponents()
	{
		Object[] entries  = (componentsMap.values()).toArray();
		ComponentInfo[] components   = new ComponentInfo[entries.length];
		
		for (int i=0;i<entries.length;i++)
		{
			components[i]=(ComponentInfo)entries[i];
		}
		
		return components; 
	}
	
	public void addComponent (ComponentInfo component)
	{
		componentsMap.put(component.getName(),component);
	}
	
	public void removeComponent (String componentName)
	{	
		componentsMap.remove(componentName);
	}
	
	public boolean hasComponent (String componentName)
	{
		return (componentsMap.containsKey(componentName));
	}
	
	public ComponentInfo getComponent (String componentName)
	{
		return (componentsMap.get(componentName));
	}

	public StageInfo getStageInfo() {
		return stageInfo;
	}

	public void setStageInfo(StageInfo stageInfo) {
		this.stageInfo = stageInfo;
	}	
}


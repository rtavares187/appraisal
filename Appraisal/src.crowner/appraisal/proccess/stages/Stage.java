package appraisal.proccess.stages;

import common.DynamicPropertiesCombiner;

public abstract class Stage 
{
	protected DynamicPropertiesCombiner propertiesCombiner;
	
	public void resetCombinations(int base,int top, int incr)
	{
		propertiesCombiner.resetCombinations(base,top,incr);
	}
	
	public void resetCombinations()
	{
		propertiesCombiner.resetCombinations();
	}
	
	public boolean nextCombination()
	{
		return propertiesCombiner.nextCombination();
	}
	
	public DynamicPropertiesCombiner getPropertiesCombiner()
	{
		return propertiesCombiner;
	}
	
	public String getPresentCombination() 
	{
		return propertiesCombiner.getPresentCombination();
	}
}
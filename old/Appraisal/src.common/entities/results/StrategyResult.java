package entities.results;

import java.util.ArrayList;
import java.util.List;

import entities.dataset.Dataset;

public class StrategyResult 
{
	private String strategyId;
	private List<PlanResult> planResults;
	
	public StrategyResult(String strategyName) 
	{ 
		super();
		this.strategyId = strategyName; 	
		planResults = new ArrayList<PlanResult>();
	}
	
	public StrategyResult(String strategyId,List<PlanResult> planResults) 
	{
		super();
		this.strategyId = strategyId;	
		this.planResults = planResults;
	}
	
	public void addPlanResult(PlanResult planResult)
	{
		planResults.add(planResult);
	}
	
	public String getStrategyId()
	{
		return strategyId;
	}
	
	public List<PlanResult> getPlanResults() 
	{
		return planResults;
	}	
	
	public void dropWorstResults(Dataset originalColumn)
	{
		for(PlanResult presult : planResults)
		{
			presult.dropWorstResults(originalColumn);			
		}			
	}
	

	
	@Override
	public String toString()
	{
		String result="";
		
		result +="### Strategy: "+strategyId+" \n";
		
		for (PlanResult planResult : planResults) 
		{
			result += planResult.toString();
		}
		
		return result;
	}
}
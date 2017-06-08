package appraisal.proccess.plans;

import entities.dataset.Dataset;
import entities.results.PlanResult;

public abstract class Plan 
{
	public abstract PlanResult runPlan(Dataset fullDataset, String regressionColumn, Dataset originalColumn);
}
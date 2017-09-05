package appraisal.proccess.strategies;

import entities.dataset.Dataset;
import entities.results.StrategyResult;

public interface Strategy 
{ 
	public StrategyResult runStrategy(Dataset originalColumn, Dataset fullDataset, String regressionColumn);
}

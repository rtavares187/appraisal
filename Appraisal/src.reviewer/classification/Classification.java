package classification;

import java.util.List;

import entities.dataset.Dataset;
import entities.results.StrategyResult;



public interface Classification 
{
	public int checkClassification(Dataset codifiedDataset,List<StrategyResult> regressionResults);
}
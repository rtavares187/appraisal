package appraisal.proccess.stages;

import entities.dataset.Dataset;
import entities.results.SelectionResult;

public abstract class SelectionStage extends Stage
{
	public abstract SelectionResult run(Dataset fullDataset);
}

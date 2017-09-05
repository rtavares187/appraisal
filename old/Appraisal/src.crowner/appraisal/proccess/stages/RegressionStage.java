package appraisal.proccess.stages;

import java.util.List;

import entities.dataset.Dataset;
import entities.results.RegressionResult;



public abstract class RegressionStage extends Stage
{
	public abstract RegressionResult run(List<String> columns, String regressionColumn,Dataset trainDataset,Dataset targetDataset);
}

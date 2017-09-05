package appraisal.proccess.stages;

import java.util.List;

import entities.dataset.Dataset;
import entities.results.ClusteringResult;



public abstract class ClusteringStage extends Stage
{
	public abstract ClusteringResult run(Dataset fullDataser, String regressionColumn);
	public abstract ClusteringResult run(Dataset fullDataser, String regressionColumn, List<String> columns);
}

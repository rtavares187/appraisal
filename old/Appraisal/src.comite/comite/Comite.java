package comite;

import java.util.List;

import entities.dataset.Dataset;
import entities.results.RegressionResult;

public interface Comite
{
	public RegressionResult run(String regressionColumn, Dataset fullDataset, List<Dataset> trainSuggestions, List<Dataset> targetSuggestions);
}
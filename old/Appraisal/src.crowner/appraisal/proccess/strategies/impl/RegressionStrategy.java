package appraisal.proccess.strategies.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import appraisal.proccess.plans.Plan;
import appraisal.proccess.plans.impl.RegressionPlan;
import appraisal.proccess.stages.RegressionStage;
import appraisal.proccess.stages.impl.AvgStage;
import appraisal.proccess.stages.impl.BkPropStage;
import appraisal.proccess.stages.impl.KnnStage;
import appraisal.proccess.strategies.Strategy;
import appraisal.writer.ResultWriter;
import entities.dataset.Dataset;
import entities.results.InstanceResult;
import entities.results.PlanResult;
import entities.results.StrategyResult;


public class RegressionStrategy implements Strategy 
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(RegressionStrategy.class);
	
	public StrategyResult runStrategy(Dataset originalColumn, Dataset fullDataset, String regressionColumn) 
	{
		LOGGER.info("### ESTRATÉGIA DE REGRESSÃO SIMPLES ###");
		LOGGER.info("Montando diferentes planos de execução");
			
		// Montando etapas
		List<RegressionStage> regressionStages = new ArrayList<RegressionStage>();
		regressionStages.add(new AvgStage());
		regressionStages.add(new KnnStage());
		regressionStages.add(new BkPropStage());
		
		// Montando planos
		List<Plan> plans = new ArrayList<Plan>();
		
		for (RegressionStage regressionStage : regressionStages) 
		{
			RegressionPlan plan = new RegressionPlan(regressionStage);
			plans.add(plan);
		}
				
		// Executando os planos
		List<PlanResult> planResults = new ArrayList<PlanResult>();
		
		for (Plan plan : plans) 
		{
			PlanResult planResult = plan.runPlan(fullDataset.copyDataset(), regressionColumn, originalColumn);
			planResults.add(planResult);
			
			// Verifica a melhor instância
			InstanceResult best = planResult.getResults().get(0);
			LOGGER.debug("Tempo: "+(planResult.getTime())+"s");
			LOGGER.debug("Instância: "+best.getId());
			LOGGER.debug("Resultado: "+best.getRegressionResult().getTargetDataRegression());
			
			// Escreve resultados parciais no disco
			ResultWriter.writeCrudeResults(new StrategyResult("regression",planResults) );
			
			// Limpa a memória
			System.gc();
		}
		
		// Consolidando os planos na estratégia
		StrategyResult strategyResult = new StrategyResult("regression",planResults);
				
		// Retorno
		return strategyResult;
	}
}
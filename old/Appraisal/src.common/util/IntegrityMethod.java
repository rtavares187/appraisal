package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class IntegrityMethod extends TestCase 
{
	public void test()
	{
		File rootFile = new File("C:\\Documents and Settings\\005486\\kdd\\breast\\breast.full");
		checkDatabase(rootFile);			
	}

	private void checkDatabase(File rootDir)
	{
		String[] databaseDirs = rootDir.list();
		
		for (String databaseDir : databaseDirs) 
		{
			if (!(new File(rootDir.getAbsolutePath()+"//"+databaseDir).isDirectory()))
				continue;
			
			boolean error = checkStrategies(new File(rootDir.getAbsolutePath()+"//"+databaseDir));
			
			if (error)
			{
				System.out.println("IN DATABASE \t "+databaseDir);
				System.out.println("-------------------------------------------------");
				
				System.out.println();
			}
		}
	}
	
	private boolean checkStrategies(File databaseDir) 
	{
		boolean error = false;
		
		String[] strategiesDir = databaseDir.list();
		List<String> strategies = new ArrayList<String>(strategiesDir.length);
		
		for (String strategyDir : strategiesDir) 
		{
			strategies.add(strategyDir);
		}
		
		if (!strategies.contains("regression"))
		{
			System.out.println("MISSING \t regression");
			error=true;
		}
		else
		{
			error=checkRegressionPlans(new File(databaseDir.getAbsolutePath()+"//regression"));
			
			if(error)
				System.out.println("IN STRATEGY \t regression");
		}
		
		if (!strategies.contains("selection.regression"))
		{
			System.out.println("MISSING \t selection.regression");
			error=true;
		}	
		else
		{
			error=checkSelectionPlans(new File(databaseDir.getAbsolutePath()+"//selection.regression"));
			
			if(error)
				System.out.println("IN STRATEGY \t selection.regression");
		}
		
		if (!strategies.contains("clustering.regression"))
		{
			System.out.println("MISSING \t clustering.regression");
			error=true;
		}	
		else
		{
			error=checkClusteringPlans(new File(databaseDir.getAbsolutePath()+"//clustering.regression"));
			
			if(error)
				System.out.println("IN STRATEGY \t clustering.regression");
		}
		
		if (!strategies.contains("selection.clustering.regression"))
		{
			System.out.println("MISSING \t selection.clustering.regression");
			error=true;
		}
		else
		{
			error=checkSelectionClusteringPlans(new File(databaseDir.getAbsolutePath()+"//selection.clustering.regression"));
			
			if(error)
				System.out.println("IN STRATEGY \t selection.clustering.regression");
		}
		
		if (!strategies.contains("clustering.selection.regression"))
		{
			System.out.println("MISSING \t clustering.selection.regression");
			error=true;
		}
		else
		{
			error=checkClusteringSelectionPlans(new File(databaseDir.getAbsolutePath()+"//clustering.selection.regression"));
			
			if(error)
				System.out.println("IN STRATEGY \t clustering.selection.regression");
		}
		

		if (!strategies.contains("comite"))
		{
			System.out.println("MISSING \t comite");
			error=true;
		}
		
		File resultsFile = new File(databaseDir.getAbsolutePath()+"\\"+databaseDir.getName()+".new.xls");
		
		if (!resultsFile.exists())
		{
			System.out.println("MISSING \t validation");
			error=true;			
		}
		
		return error;
	}

	private boolean checkRegressionPlans(File strategyDir) 
	{
		boolean error = false;
		
		String[] plansDir = strategyDir.list();
		List<String> plans = new ArrayList<String>(plansDir.length);
		
		for (String planDir : plansDir) 
		{
			plans.add(planDir);
		}
		
		if (!plans.contains("avg"))
		{
			System.out.println("MISSING \t avg");
			error=true;
		}	
		
		if (!plans.contains("knn"))
		{
			System.out.println("MISSING \t knn");
			error=true;
		}
		
		if (!plans.contains("bkprop"))
		{
			System.out.println("MISSING \t bkprop");
			error=true;
		}
		
		return error;
	}
	
	private boolean checkSelectionPlans(File strategyDir) 
	{
		boolean error = false;
		
		String[] plansDir = strategyDir.list();
		List<String> plans = new ArrayList<String>(plansDir.length);
		
		for (String planDir : plansDir) 
		{
			plans.add(planDir);
		}
		
		if (!plans.contains("pca.knn"))
		{
			System.out.println("MISSING \t pca.knn");
			error=true;
		}
		
		if (!plans.contains("pca.bkprop"))
		{
			System.out.println("MISSING \t pca.bkprop");
			error=true;
		}
		
		return error;
	}
	
	private boolean checkClusteringPlans(File strategyDir) 
	{
		boolean error = false;
		
		String[] plansDir = strategyDir.list();
		List<String> plans = new ArrayList<String>(plansDir.length);
		
		for (String planDir : plansDir) 
		{
			plans.add(planDir);
		}
		
		if (!plans.contains("kmeans.avg"))
		{
			System.out.println("MISSING \t kmeans.avg");
			error=true;
		}	
		
		if (!plans.contains("kmeans.knn"))
		{
			System.out.println("MISSING \t kmeans.knn");
			error=true;
		}
		
		if (!plans.contains("kmeans.bkprop"))
		{
			System.out.println("MISSING \t kmeans.bkprop");
			error=true;
		}
				
		return error;
	}
	
	private boolean checkSelectionClusteringPlans(File strategyDir) 
	{
		boolean error = false;
		
		String[] plansDir = strategyDir.list();
		List<String> plans = new ArrayList<String>(plansDir.length);
		
		for (String planDir : plansDir) 
		{
			plans.add(planDir);
		}
		
		if (!plans.contains("pca.kmeans.avg"))
		{
			System.out.println("MISSING \t pca.kmeans.avg");
			error=true;
		}	
		
		if (!plans.contains("pca.kmeans.knn"))
		{
			System.out.println("MISSING \t pca.kmeans.knn");
			error=true;
		}
		
		if (!plans.contains("pca.kmeans.bkprop"))
		{
			System.out.println("MISSING \t pca.kmeans.bkprop");
			error=true;
		}
		
		return error;
	}
	
	private boolean checkClusteringSelectionPlans(File strategyDir) 
	{
		boolean error = false;
		
		String[] plansDir = strategyDir.list();
		List<String> plans = new ArrayList<String>(plansDir.length);
		
		for (String planDir : plansDir) 
		{
			plans.add(planDir);
		}
		
		if (!plans.contains("kmeans.pca.avg"))
		{
			System.out.println("MISSING \t pca.kmeans.avg");
			error=true;
		}	
		
		if (!plans.contains("kmeans.pca.knn"))
		{
			System.out.println("MISSING \t pca.kmeans.knn");
			error=true;
		}
		
		if (!plans.contains("kmeans.pca.bkprop"))
		{
			System.out.println("MISSING \t pca.kmeans.bkprop");
			error=true;
		}
				
		return error;
	}
}

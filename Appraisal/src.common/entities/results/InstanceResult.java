package entities.results;

import java.util.ArrayList;
import java.util.List;

public class InstanceResult 
{
	private String id;							// Combinação das propriedades
	private long time;						// Tempo de execução
	private List<Float> crossFolder;			// Índice de erro de validação
	private RegressionResult regressionResult;	// Resultado da regressão do plano
	
	/**
	 * @param id
	 * @param rr
	 */
	public InstanceResult(String id, RegressionResult rr) 
	{
		super();
		this.id = id;
		this.regressionResult = rr;
		
		crossFolder = new ArrayList<Float>();
	}
	public InstanceResult(String id, RegressionResult rr,long time) 
	{
		super();
		this.id = id;
		this.time = time;
		this.regressionResult = rr;
		
		crossFolder = new ArrayList<Float>();
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the rr
	 */
	public RegressionResult getRegressionResult() {
		return regressionResult;
	}
	/**
	 * @param rr the rr to set
	 */
	public void setRegressionResult(RegressionResult rr) {
		this.regressionResult = rr;
	}
	
	/**
	 * @return the crossFolder
	 */
	public List<Float> getCrossFolder() {
		return crossFolder;
	}
	/**
	 * @param crossFolder the crossFolder to set
	 */
	public void addCrossFolder(Float crossFolder) {
		this.crossFolder.add(crossFolder);
	}
	
	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString()
	{
		String result = "";
		
		result += "- Plan: "+id+"\n";
		result += regressionResult.toString();
		
		return result;
	}
}
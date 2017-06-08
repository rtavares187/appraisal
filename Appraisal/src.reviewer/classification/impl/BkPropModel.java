package classification.impl;

public class BkPropModel 
{
	//
	// Attributes
	//
	
	private int cycles;
	private double momentum;
	private double learningRate;
		
	private int inputNeurons; 
	private int hiddenNeurons;
	private int outputNeurons;
		
	private double maxValue;
	private double minValue;
	
	//
	// Accessors
	//
	
	/**
	 * @param cycles
	 * @param momentum
	 * @param learningRate
	 * @param inputNeurons
	 * @param hiddenNeurons
	 * @param outputNeurons
	 */
	public BkPropModel(int cycles, double learningRate, double momentum, int inputNeurons, int hiddenNeurons, int outputNeurons, double maxValue, double minValue) 
	{
		super();
		this.cycles = cycles;
		this.momentum = momentum;
		this.learningRate = learningRate;
		this.inputNeurons = inputNeurons;
		this.hiddenNeurons = hiddenNeurons;
		this.outputNeurons = outputNeurons;
		this.maxValue = maxValue;
		this.minValue = minValue;
	}
	
	
	public int getCycles() {
		return cycles;
	}
	public void setCycles(int cycles) {
		this.cycles = cycles;
	}
	public int getHiddenNeurons() {
		return hiddenNeurons;
	}
	public void setHiddenNeurons(int hiddenNeurons) {
		this.hiddenNeurons = hiddenNeurons;
	}
	public int getInputNeurons() {
		return inputNeurons;
	}
	public void setInputNeurons(int inputNeurons) {
		this.inputNeurons = inputNeurons;
	}
	public double getLearningRate() {
		return learningRate;
	}
	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}
	public double getMomentum() {
		return momentum;
	}
	public void setMomentum(double momentum) {
		this.momentum = momentum;
	}
	public int getOutputNeurons() {
		return outputNeurons;
	}
	public void setOutputNeurons(int outputNeurons) {
		this.outputNeurons = outputNeurons;
	}	
	public double getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
	public double getMinValue() {
		return minValue;
	}
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}
	
}
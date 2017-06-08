package appraisal.algorithms.pso;

public class PsoModel 
{
	public int centroidCount;
	
	private int iterations;
	private int particles;
	
	private double maxValue;
	private double minValue;
	
	public PsoModel(int centroidCount, int iterations, int particles, double maxValue, double minValue) {
		super();
		this.centroidCount = centroidCount;
		this.iterations = iterations;
		this.particles = particles;
		this.maxValue = maxValue;
		this.minValue = minValue;
	}

	/**
	 * @return the centroidCount
	 */
	public int getCentroidCount() {
		return centroidCount;
	}

	/**
	 * @param centroidCount the centroidCount to set
	 */
	public void setCentroidCount(int centroidCount) {
		this.centroidCount = centroidCount;
	}

	/**
	 * @return the iterations
	 */
	public int getIterations() {
		return iterations;
	}

	/**
	 * @param iterations the iterations to set
	 */
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	/**
	 * @return the maxValue
	 */
	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the minValue
	 */
	public double getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the particles
	 */
	public int getParticles() {
		return particles;
	}

	/**
	 * @param particles the particles to set
	 */
	public void setParticles(int particles) {
		this.particles = particles;
	}
}
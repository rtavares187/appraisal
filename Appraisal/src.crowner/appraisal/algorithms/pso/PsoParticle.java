package appraisal.algorithms.pso;

import net.sourceforge.jswarm_pso.Particle;

public class PsoParticle extends Particle 
{
	public PsoParticle() 
	{
		super(PsoAlgorithm.attributeCount*PsoAlgorithm.centroidCount); 
	} 
}
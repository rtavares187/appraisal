package javabramining.core.catalog.metadata;

public class KDDInfo  
{
	private final StageInfo	preProcessing  = new StageInfo(StageInfo.PRE_PROCESSING);
	private final StageInfo	mining		   = new StageInfo(StageInfo.MINING);
	private final StageInfo posProcessing  = new StageInfo(StageInfo.POS_PROCESSING);
	
	public StageInfo[] getStages()
	{
		StageInfo[] etapas = new StageInfo[3];
		
		etapas[0] = preProcessing;
		etapas[1] = mining;
	    etapas[2] = posProcessing;
	    
	    return etapas;
	}
	
	public StageInfo getStage (String stage)
	{
		if (stage.equals(StageInfo.PRE_PROCESSING))
		{
				return preProcessing;
		}
		else if (stage.equals(StageInfo.MINING))
	    {
	    	return mining;
	    }
		else if (stage.equals(StageInfo.POS_PROCESSING))
	    {
	    	return posProcessing;	
	    }
		
		return null;
	}
}

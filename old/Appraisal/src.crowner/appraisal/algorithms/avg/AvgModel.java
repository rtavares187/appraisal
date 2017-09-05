package appraisal.algorithms.avg;


public class AvgModel
{
	//
	// Attributes
	//
	
	private String  type;
	private boolean disturb;

	public AvgModel(String type, boolean disturb) 
	{
		super();
		this.disturb = disturb;
		this.type = type;
	}

	public boolean getDisturb() {
		return disturb;
	}

	public void setDisturb(boolean disturb) {
		this.disturb = disturb;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
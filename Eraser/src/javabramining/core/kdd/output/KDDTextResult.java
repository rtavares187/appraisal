package javabramining.core.kdd.output;

public class KDDTextResult extends KDDResult 
{
	private StringBuilder result;
	
	public KDDTextResult()
	{
		result = new StringBuilder();
	}
	
	public void append(String text)
	{
		result.append(text);
	}
	
	public void append(Number number)
	{
		result.append(number);
	}
	
	public void append(Object object)
	{
		result.append(object);
	}
	
	public void reset()
	{
		result = new StringBuilder();
	}
	
	@Override
	public String toString()
	{
		return(result.toString());
	}
}

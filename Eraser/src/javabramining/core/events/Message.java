package javabramining.core.events;

import java.util.HashMap;
import java.util.Map;

/**
 *	This class represents a Message. A message it´s written by an {@link Agent}
 *	on the {@link Board}, adressed to a determined group. The Board notifies 
 *	other Agents which have declared their interest on the target group.
 *  A message has several items:
 *	<ul>
 *	<li> The date it was written </li>
 *	<li> It´s priority level </li>
 *	<li> The group it was destinated </li>
 *	<li> The Agent that wrote it </li>
 *	<li> A textual content </li>
 *	</ul>
 *	<p>
 *	The class offers several methods for recovering and setting such
 *	information. 
 */
public class Message
{
	private String   			content;
	private Map<String,Object>  registers;

	public Message(String content)
	{	    
	    this.content = content;
	    registers = new HashMap<String,Object>();
	}

	public void setContent(String content) {
		this.content = content;
	}   
	
    public String getContent()
    {
        return this.content;
    }
    
   /**
     * Set an attribute. If the attribute already exists, it´s updated.
     * 
     * @param name  The attribute name
     * @param value  The attribute value
     */    
    public void setAttribute(String name, Object value)
    {    	
    	registers.put(name, value);
    }  
    
    /**
     * Recover an attribute for the giving name. 
     * 
     * @param name  The attribute name
     */   
    public Object getAttribute(String name) 
    {
    	//SE existir o register solicitado
    	if (registers.containsKey(name))
    	{
    		return (registers.get(name));
    	}
    	//SENÃO
    	else
    	{
    		return null;
    	}	
    }
}

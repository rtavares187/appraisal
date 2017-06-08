/**
 * 
 */
package javabramining.core.events;

import java.util.concurrent.CopyOnWriteArrayList;

import javabramining.core.context.JBraminingContext;

/**
 * @author Administrador
 */
public class EventHandler
{
	//
	// Fields
	//

	private static CopyOnWriteArrayList<EventListener> eventListeners = new CopyOnWriteArrayList<EventListener>();

	//
	// Singleton
	//
	
	public static EventHandler getInstance()
	{
		return (EventHandler) JBraminingContext.getBean("eventHandler");
	}
	
	//
	// Methods
	//
	
    /**
     * Signs an Agent (Implementing the ContextListener interface), on the 
     * Board, on the special group that notifies changes on the global attributes of the 
     * application.
     *
     * @param listener Listener reference to the implementing Agent 
     */
    public void addEventListener(EventListener listener)
    {
    	eventListeners.add(listener);
    }
    
	/**
	 * Used by the Board to notify a group of listeners that an global attribute
	 * has been created or updated.
	 * 
	 * @param listeners  Array with the target listening agents
	 * @param registerName  The name of the created/updated attribute
	 */
    public void notify(Message message) 
    {
    	for (EventListener listener : eventListeners)
    	{
    		listener.eventNotification(message);
    	}
    }

}

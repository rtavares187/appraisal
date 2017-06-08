package javabramining.core.events;

/**
 * The interface ContextListener must be implemented by an {@link Agent}, 
 * if it wants to join the special messaging group on the {@link Board} that
 * notifies any changes within the application global parameters.
 */
public interface EventListener 
{
	/**
	 * BinaryCodificationMethod that is invoked by the Board to notify an implementing Agent
	 * about the change or creation of an attribute. 
	 * 
	 * @param event  The created or updated attribute.
	 */
    public void eventNotification(Message event);
}

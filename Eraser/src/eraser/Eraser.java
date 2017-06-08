package eraser;

import javax.swing.UIManager;

import javabramining.core.context.JBraminingContext;
import javabramining.core.userinterface.KDDScreen;
import javabramining.core.userinterface.KDDScreenException;
import javabramining.core.userinterface.SwingHandler;

public class Eraser 
{
	public static void main(String[] args) throws Exception
	{
		// Configura o Look-And-Feel
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		JBraminingContext.initializeContext();
		
		SwingHandler swingHandler = SwingHandler.getInstance(); 
		KDDScreen 	 screen 	  = new EraserScreen();
		
		try 
		{
			screen.launchFrame(false);
		}
		catch (KDDScreenException e) 
		{		
			e.printStackTrace();
			swingHandler.displayMessage("User interface error - "+e.getLocalizedMessage());
		} 
	}
}
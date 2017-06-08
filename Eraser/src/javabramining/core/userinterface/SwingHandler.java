/*
 * Projeto JavaBraMining
 * NUPAC - UNIVERCIDADE
 *  
 * Desenvolvedor:
 * 	Rafael Castaneda Ribeiro
 * 
 * Orientadores:
 * 	Prof. Cláudia Ferlin	
 * 	Prof. Ronaldo Ribeiro Goldschmitd
 * 
 */

package javabramining.core.userinterface;

import java.awt.Component;

import javabramining.core.context.JBraminingContext;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *	Classe IUSwing
 *
 *	TODO: Documentar Classe
 *
 *	@author: rafaelcastaneda@brfree.com.br
 *
 *	Data de Criação:
 *	Data de Modificação:
 */

public class SwingHandler
{
	//
	// Singleton
	//
	
	public static SwingHandler getInstance()
	{
		return (SwingHandler) JBraminingContext.getBean("swingHandler");
	}
	
	//
	// Constructor
	//
	
	private SwingHandler()
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{				
			e.printStackTrace();
		}	
	}
	
	//
	// Methods
	//
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null,(message)); 			
 	}
	
	public String browseFile(Component component,String title)
	{			
		JFileChooser chooser = new JFileChooser();
			
		chooser.setDialogTitle(title);
		chooser.showOpenDialog(component);
		    
		return(chooser.getSelectedFile().getPath());					
 	}
}

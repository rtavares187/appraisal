package javabramining.core.userinterface;

import java.awt.Frame;
import java.awt.event.WindowEvent;

import javabramining.core.events.EventHandler;
import javabramining.core.events.Message;

import thinlet.FrameLauncher;
import thinlet.Thinlet;

public abstract class KDDScreen 
{
	// Variáveis de Infra-Estrutura
	protected Object  container;
	protected Object  screen;	 
	protected Thinlet thinlet;
	
	// Variáveis de Configuração
	int width;
	int height;
	String title;
	
	// Construtores
	public KDDScreen()
	{
		title  = "";
		width  = 100;
		height = 100;
	}
	
	// Métodos Abstratos
	protected abstract String getXulFile();
	protected abstract void   clean();
	protected abstract void   refresh(); 
	protected abstract void   initialize() throws KDDScreenException;
	
	// Métodos
	private final Object buildScreen(Thinlet thinlet) throws KDDScreenException
	{
		return(buildScreen(thinlet,null));
	}
	
	public final Object buildScreen(Thinlet thinlet,Object container) throws KDDScreenException
	{
		this.thinlet 	= thinlet;
		this.container  = container;
						
		try 
		{
			screen = thinlet.parse(getXulFile(),this);
			initialize();
		} 
		catch (KDDScreenException e)
		{
			throw new KDDScreenException("Unable to initialize "+getClass().toString().substring(6),e);
		}
		catch (Exception e) 
		{
			throw new KDDScreenException("Unable to parse "+getXulFile(),e);
		}	
		
		return (screen);			
	}	
	
	public final void launchDialog(Thinlet thinlet,boolean modal) throws KDDScreenException
	{		
		this.thinlet = thinlet;
		
		screen     = buildScreen(thinlet);
		container  = Thinlet.create("dialog");
					
		thinlet.setBoolean(container,"modal",modal);
		//thinlet.setBoolean(dialog,"closable",true); // CLOSE BUTTON DOES NOT WORK
		
		thinlet.setInteger(container,"width",width);
		thinlet.setInteger(container,"height",height);
		
		thinlet.setInteger(container,"top",10);
		thinlet.setInteger(container,"bottom",10);
		thinlet.setInteger(container,"right",10);
		thinlet.setInteger(container,"left",10);
		thinlet.setInteger(container,"gap",10);
				
		thinlet.setString(container,"text",title);
		
		thinlet.add(container,screen);
		thinlet.add(container);			
	}
	
	public final void launchFrame(boolean maximize) throws KDDScreenException
	{
		this.thinlet = new Thinlet();
		
		screen 	  = buildScreen(thinlet);
		container = buildFrame(width,height,thinlet);
				
		if(maximize)
			((Frame)container).setExtendedState(Frame.MAXIMIZED_BOTH);
		
		thinlet.add(screen);
	}
			
	public void close()
	{
		EventHandler.getInstance().notify(new Message("eventWindowClosed"));
		
		if (container instanceof Frame)
		{
			try
			{
				((Frame)container).dispose();
			}
			catch(Exception e){}
		}
		else
		{
			thinlet.remove(container);
		}
	}
	
	protected Frame buildFrame(int width,int height,Thinlet thinlet)
	{
		return	(
					new FrameLauncher(title,thinlet,height,width)
					{	
						@Override
						public void windowClosing(WindowEvent e) 
						{										
							e.getWindow().dispose();
						}
					}
				);				
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
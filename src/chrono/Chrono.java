package chrono;

import java.util.logging.Logger;

import javax.swing.JOptionPane;

import scene.frame.SceneFrame;

/**
 * classe permettant de gerer la synchronisation de l'affichage 
 * @author cedric akrou
 * 
 */ 

public class Chrono extends Thread 
{
	public int intervalle_temps = 3;
	private Logger logger = Logger.getLogger(Chrono.class.getName());
	private boolean continueJeu = true;
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		super.run();
		
		while(continueJeu == true)
		{
			SceneFrame.scenePanel.repaint();
			
			try 
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				logger.severe("URGENT !!!!  erreur lors de la synchronisation dans la classe Chrono");
			}
		}
		
		
		if(continueJeu == false)
		{
			JOptionPane.showMessageDialog(null, "CEDRIC AKROU - CEKA", "FIN DU JEU", JOptionPane.ERROR_MESSAGE) ;
		}
		
		
		
	}

	public boolean isContinueJeu() {
		return continueJeu;
	}

	public void setContinueJeu(boolean continueJeu) {
		this.continueJeu = continueJeu;
	}
}

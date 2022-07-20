package gestionMouvement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import scene.frame.SceneFrame;

public class Clavier implements KeyListener{

	int position[] = new int[2];
	
	@Override
	public void keyPressed(KeyEvent g)
	{
		// TODO Auto-generated method stub
		
		int eventCode = g.getKeyCode();
		
		if(eventCode == KeyEvent.VK_RIGHT)
		{
			position[0] = 1;			
			position[1] = 0;
			
			SceneFrame.scenePanel.vaisseau1.setPositionVehicule(position);
			SceneFrame.scenePanel.gestionImage.setDeplacementFondEcran(position);
					
		}
		else if(eventCode == KeyEvent.VK_LEFT)
		{
			position[0] = -1;			
			position[1] = 0;

			if(SceneFrame.scenePanel.vaisseau1.getPositionVehicule()[0] > 0 )
			{
				SceneFrame.scenePanel.vaisseau1.setPositionVehicule(position);
				SceneFrame.scenePanel.gestionImage.setDeplacementFondEcran(position);
			}
						
		}
		else if(eventCode == KeyEvent.VK_DOWN)
		{
			position[0] = 0;			
			position[1] = 2;

			if(SceneFrame.scenePanel.vaisseau1.getPositionVehicule()[1] < 470 )
			{			
				SceneFrame.scenePanel.vaisseau1.setPositionVehicule(position);
				SceneFrame.scenePanel.gestionImage.setDeplacementFondEcran(position);
			}
			
		}
		else if(eventCode == KeyEvent.VK_UP)
		{
			position[0] = 0;			
			position[1] = -2;
			
			if(SceneFrame.scenePanel.vaisseau1.getPositionVehicule()[1] > 0 )
			{
				SceneFrame.scenePanel.vaisseau1.setPositionVehicule(position);
				SceneFrame.scenePanel.gestionImage.setDeplacementFondEcran(position);				
			}

		}
		else if(eventCode == KeyEvent.VK_SPACE)
		{
			position[0] = 2;			
			position[1] = 0;
			
			SceneFrame.scenePanel.vaisseau1.accelerer();
			SceneFrame.scenePanel.gestionImage.setDeplacementFondEcran(position);
		}
		else if(eventCode == KeyEvent.VK_B )
		{
			SceneFrame.scenePanel.vaisseau1.setTire(true);
		}
		

		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		position[0] = 0;			
		position[1] = 0;
		 
		SceneFrame.scenePanel.vaisseau1.setPositionVehicule(position);		
		SceneFrame.scenePanel.vaisseau1.setTire(false);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

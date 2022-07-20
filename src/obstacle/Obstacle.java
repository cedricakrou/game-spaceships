package obstacle;

import java.awt.Image;

import javax.swing.ImageIcon;

import scene.frame.SceneFrame;

/**
 * @author cedricakrou
 * cette classe sert à gerer les obstacles
 */


public class Obstacle {

	protected int[] positionObstacle;
	protected int[] tailleObstacle;
	
	protected ImageIcon iconeObstacle;
	protected Image imageObstacle;


	public Obstacle(int posX, int posY, int tailleX, int tailleY)
	{
		positionObstacle = new int[2];
		tailleObstacle = new int[2];
		
		positionObstacle[0] = posX;
		positionObstacle[1] = posY;
		tailleObstacle[0] = tailleX;
		tailleObstacle[1] = tailleY;
	}
	
	public void deplacementObstacle()
	{
		positionObstacle[0] -= 0.1;
	}

	public void repositionnementObstacle()
	{
		if(this.positionObstacle[0] == 0 )
		{
			this.positionObstacle[0] = 2000 + SceneFrame.scenePanel.vaisseau1.getPositionVehicule()[0] ;
		}
	}

	public Image getImageObstacle() {
		return imageObstacle;
	}

	public void setImageObstacle(Image imageObstacle) {
		this.imageObstacle = imageObstacle;
	}

	public int[] getPositionObstacle() {
		return positionObstacle;
	}

	public void setPositionObstacle(int[] positionObstacle) {
		this.positionObstacle = positionObstacle;
	}

	public int[] getTailleObstacle() {
		return tailleObstacle;
	}

	public void setTailleObstacle(int[] tailleObstacle) {
		this.tailleObstacle = tailleObstacle;
	}
	
	
	
}

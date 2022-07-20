package obstacle;


import javax.swing.ImageIcon;

/**
 * @author cedricakrou
 * cette classe sert à gerer les obstacles precisement les rochers
 */


public class Rocher extends Obstacle 
{

	public Rocher(int posX, int posY) 
	{
		super(posX, posY, 100,  100 );
		// TODO Auto-generated constructor stub
		
		super.iconeObstacle = new ImageIcon(getClass().getResource("/images/rocher/roche.png"));
		super.imageObstacle = super.iconeObstacle.getImage();
	}
		
}

package balle;

import java.awt.Image;

/**
 * @author cedricakrou
 * cette classe sert à gerer la balle
 */

import javax.swing.ImageIcon;

public class Balle 
{
	protected ImageIcon iconeBalle;
	private Image imageBalle;
	
	private int[] positionBalle;
	
	public Balle() 
	{
		iconeBalle = new ImageIcon(getClass().getResource("/images/affichage/balle.jpg"));
		imageBalle = iconeBalle.getImage();
		
		positionBalle = new int[2];
	}
	
	
	public void deplacementBalle()
	{
		positionBalle[0] += 1;
	}
	

	/**
	 * @return the imageBalle
	 */
	public Image getImageBalle() {
		return imageBalle;
	}

	/**
	 * @param imageBalle the imageBalle to set
	 */
	public void setImageBalle(Image imageBalle) {
		this.imageBalle = imageBalle;
	}

	/**
	 * @return the positionBalle
	 */
	public int[] getPositionBalle() {
		return positionBalle;
	}

	/**
	 * @param positionBalle the positionBalle to set
	 */
	public void setPositionBalle(int[] positionBalle) {
		this.positionBalle = positionBalle;
	}

}

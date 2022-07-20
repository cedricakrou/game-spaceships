package scene.panel;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * cette classe sert à gerer l'image de fond et son deplacement
 * @author cedric akrou
 *
 */

public class GestionImageFond
{
	protected ImageIcon iconeFondEcran1;
	private Image imageFondEcran1;
	private int[] positionFondEcran1;
	
	protected ImageIcon iconeFondEcran2;
	private Image imageFondEcran2;
	private int[] positionFondEcran2;
	
	private int[] deplacementFondEcran;

		public GestionImageFond() 
		{
			setDeplacementFondEcran(new int[2]);
			
			positionFondEcran1 = new int[2];
			positionFondEcran1[0] = -50;
			positionFondEcran1[1] = 0;
			
			iconeFondEcran1 = new ImageIcon(getClass().getResource("/images/fondecran/fondEcran1.jpg"));
			imageFondEcran1 = iconeFondEcran1.getImage();
			
			// image de fond 2
			
			positionFondEcran2 = new int[2];
			positionFondEcran2[0] = positionFondEcran1[0] + 750;
			positionFondEcran2[1] = 0;

			iconeFondEcran2 = new ImageIcon(getClass().getResource("/images/fondecran/fondEcran2.jpg"));
			imageFondEcran2 = iconeFondEcran2.getImage();

		}
				

		public Image getImageFondEcran1() {
			return imageFondEcran1;
		}

		public void setImageFondEcran1(Image imageFondEcran1) {
			this.imageFondEcran1 = imageFondEcran1;
		}

		public int[] getPositionFondEcran1() {
			return positionFondEcran1;
		}

		public void setPositionFondEcran1(int[] positionFondEcran1) {
			this.positionFondEcran1 = positionFondEcran1;
		}

		public Image getImageFondEcran2() {
			return imageFondEcran2;
		}

		public void setImageFondEcran2(Image imageFondEcran2) {
			this.imageFondEcran2 = imageFondEcran2;
		}

		public int[] getPositionFondEcran2() {
			return positionFondEcran2;
		}

		public void setPositionFondEcran2(int[] positionFondEcran2) {
			this.positionFondEcran2 = positionFondEcran2;
		}


		public int[] getDeplacementFondEcran() {
			return deplacementFondEcran;
		}


		public void setDeplacementFondEcran(int[] deplacementFondEcran) {
			this.deplacementFondEcran = deplacementFondEcran;
		}
		
		

}

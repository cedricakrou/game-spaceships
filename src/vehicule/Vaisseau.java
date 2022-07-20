package vehicule;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author cedricakrou
 * cette classe sert à gerer les vaisseaux
 */


public class Vaisseau extends Vehicule
{
	private ImageIcon iconeVaisseau;
	private Image imageVaisseau;
	private boolean tire;
	
	public Vaisseau(int posX, int posY, int tailleX, int tailleY) {
		super(posX, posY, tailleX, tailleY);
		// TODO Auto-generated constructor stub
		
		iconeVaisseau = new ImageIcon(getClass().getResource("/images/vaisseau/vaisseauAvant.jpg"));
		imageVaisseau = iconeVaisseau.getImage();
		setTire(false);
				
	}
	
	public void accelerer()
	{
		positionVehicule[0] += 2;
	}
	

	public Image getImageVaisseau() {
		return imageVaisseau;
	}

	public void setImageVaisseau(Image imageVaisseau) {
		this.imageVaisseau = imageVaisseau;
	}

	public boolean isTire() {
		return tire;
	}

	public void setTire(boolean tire) {
		this.tire = tire;
	}

}

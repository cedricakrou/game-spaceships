package scene.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import balle.Balle;
import chrono.Chrono;
import gestionMouvement.Clavier;
import obstacle.Obstacle;
import obstacle.Rocher;
import vehicule.Vaisseau;

/**
 * cette classe sert à dessiner les objets necessaires pour le jeu
 * @author cedricakrou
 *
 */

@SuppressWarnings("serial")
public class ScenePanel extends JPanel 
{
	public GestionImageFond gestionImage;
	public Chrono chrono;
	
	public Vaisseau vaisseau1;
	
	
	// les rochers
	
	public Rocher rocher1;
	public Rocher rocher2;
	public Rocher rocher3;
	public Rocher rocher4;
	public Rocher rocher5;
	public Rocher rocher6;
	public Rocher rocher7;
	public Rocher rocher8;
	public Rocher rocher9;
	public Rocher rocher10;
	public Rocher rocher11;
	public Rocher rocher12;
	public Rocher rocher13;
	public Rocher rocher14;

	// les listes d'obstacles et de de balle
	
	private ArrayList<Obstacle> listeObstacle;
	private ArrayList<Balle> listeBalle;
	
	private ImageIcon iconeCoeur;
	private Image imageCoeur;
	
	int compteurBalle = 0;
	
	String sb = "" + compteurBalle;
	
	
	public ScenePanel()
	{
		gestionImage = new GestionImageFond();
		chrono = new Chrono();
		iconeCoeur = new ImageIcon(getClass().getResource("/images/affichage/coeur.jpg"));
		imageCoeur = iconeCoeur.getImage();
		
		vaisseau1 = new Vaisseau(5,5, 50, 50);
		
		rocher1 = new Rocher(800, 50);
		rocher2 = new Rocher(1100, 250);
		rocher3 = new Rocher(1400, 75);
		rocher4 = new Rocher(1700, 200);
		rocher5 = new Rocher(2080, 50);
		rocher6 = new Rocher(2300, 120);
		rocher7 = new Rocher(2600, 200);
		rocher8 = new Rocher(2800, 50);
		rocher9 = new Rocher(3000, 250);
		rocher10 = new Rocher(3200, 75);
		rocher11 = new Rocher(3400, 200);
		rocher12 = new Rocher(3600, 350);
		rocher13 = new Rocher(3800, 400);
		rocher14 = new Rocher(400, 450);

		
		
		listeObstacle = new ArrayList<Obstacle>();
		listeBalle = new ArrayList<Balle>();
		
		listeObstacle.add(rocher1);
		listeObstacle.add(rocher2);
		listeObstacle.add(rocher3);
		listeObstacle.add(rocher4);
		listeObstacle.add(rocher5);
		listeObstacle.add(rocher6);
		listeObstacle.add(rocher7);
		listeObstacle.add(rocher8);
		listeObstacle.add(rocher9);
		listeObstacle.add(rocher10);
		listeObstacle.add(rocher11);
		listeObstacle.add(rocher12);
		listeObstacle.add(rocher13);
		listeObstacle.add(rocher14);
	
						
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addKeyListener(new Clavier());
		
		chrono.start();
	}
	
	/**
	 * cette methode permet de gerer le deplacement des images de fond
	 */
	
	public void deplacementFondEcran()
	{
		if(this.vaisseau1.getPositionVehicule()[0] >= 0 )
		{
			this.gestionImage.getPositionFondEcran1()[0] -= this.gestionImage.getDeplacementFondEcran()[0];
			this.gestionImage.getPositionFondEcran2()[0] -= this.gestionImage.getDeplacementFondEcran()[0];
		}
		
		if(this.gestionImage.getPositionFondEcran1()[0] == -760)
		{
			this.gestionImage.getPositionFondEcran1()[0] = 760;
		}
		else if(this.gestionImage.getPositionFondEcran1()[0] == 760)
		{
			this.gestionImage.getPositionFondEcran1()[0] = -760;
		}
		else if(this.gestionImage.getPositionFondEcran2()[0] == -760)
		{
			this.gestionImage.getPositionFondEcran2()[0] = 760;
		}
		else if(this.gestionImage.getPositionFondEcran2()[0] == 760)
		{
			this.gestionImage.getPositionFondEcran2()[0] = -760;
		}
	}
	
	/**
	 * fonction servant à la creation des balles
	 */
	
	public void creationBalle()
	{
		
		if(this.vaisseau1.isTire() == true )
		{
			String nomBalle = Balle.class.getName();
			
			int[] posi = new int[2];
			
			try
			{
				Class Classeballe = Class.forName(nomBalle);
				
				Object o = Classeballe.newInstance();
				
				Balle balle = (Balle) o;
				
				posi[0] = this.vaisseau1.getPositionVehicule()[0];
				posi[1] = this.vaisseau1.getPositionVehicule()[1];
				
				balle.setPositionBalle(posi);
				
				this.listeBalle.add(balle);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	
	/**
	 * portion du code servant à dessiner les balles
	 */
	@Override
	protected void paintComponent(Graphics arg0) 
	{
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		
		Graphics g = (Graphics2D) arg0;
		
		creationBalle();
		
		
		deplacementFondEcran();
		
		
		for(int i=0; i < listeObstacle.size() ; i++)
		{
			this.listeObstacle.get(i).deplacementObstacle();
			this.listeObstacle.get(i).repositionnementObstacle();
		}
		
		
		g.drawImage(this.gestionImage.getImageFondEcran1(), this.gestionImage.getPositionFondEcran1()[0], this.gestionImage.getPositionFondEcran1()[1], this.getWidth(), this.getHeight(), null);
		g.drawImage(this.gestionImage.getImageFondEcran2(), this.gestionImage.getPositionFondEcran2()[0], this.gestionImage.getPositionFondEcran2()[1], this.getWidth(), this.getHeight() , null);
	
		for(int i=0; i < this.listeObstacle.size() ; i++)
		{
			if(this.vaisseau1.estProche(this.listeObstacle.get(i)))
			{
				if(this.vaisseau1.CollisionAvant(this.listeObstacle.get(i)) == false)
				{
					g.drawImage(this.vaisseau1.getImageVaisseau(), this.vaisseau1.getPositionVehicule()[0], this.vaisseau1.getPositionVehicule()[1], this.vaisseau1.getTailleVehicule()[0], this.vaisseau1.getTailleVehicule()[0], null);
				}
				else
				{
					this.listeObstacle.get(i).getPositionObstacle()[0] -=  this.vaisseau1.getPositionVehicule()[0] + this.vaisseau1.getTailleVehicule()[0];
				}
			}	
			else
			{
				g.drawImage(this.vaisseau1.getImageVaisseau(), this.vaisseau1.getPositionVehicule()[0], this.vaisseau1.getPositionVehicule()[1], this.vaisseau1.getTailleVehicule()[0], this.vaisseau1.getTailleVehicule()[0], null);
			}
		}
		
		/**
		 * portion du code servant à dessiner les obstacles
		 */
				
		for(int i=0; i < listeObstacle.size() ; i++)
		{
			if(listeObstacle.get(i).getPositionObstacle()[0] > 2 )
			{
				g.drawImage(this.listeObstacle.get(i).getImageObstacle(), this.listeObstacle.get(i).getPositionObstacle()[0] , this.listeObstacle.get(i).getPositionObstacle()[1], this.listeObstacle.get(i).getTailleObstacle()[0], this.listeObstacle.get(i).getTailleObstacle()[1], null);
		
			}
		}
		
		/**
		 * portion du code servant à gerer le deplacement de la balle
		 */
		
		try 
		{
			for(int i=0; i < this.listeBalle.size(); i++)
			{
				this.listeBalle.get(i).deplacementBalle();
				g.drawImage(this.listeBalle.get(i).getImageBalle(), this.listeBalle.get(i).getPositionBalle()[0], this.listeBalle.get(i).getPositionBalle()[1], 20, 20, null);
			}
			System.out.println(listeBalle.size());
		} 
		catch (Exception e)
		{
			e.getMessage();
		}

		
		int posCoeurX = 300;
		
		for(int i=0; i < this.vaisseau1.nombreVie; i++ )
		{
			g.drawImage(imageCoeur, posCoeurX, 2 , 20, 20, null);		
			posCoeurX += 25;
		}
		
		if(this.vaisseau1.nombreVie <= 0)
		{
			try
			{
				chrono.setContinueJeu(false);
			}
			catch(Exception e)
			{
				System.out.println("ERREUR: Lors de la synchronisation de la fin du jeu");
			}
		}
				
	}

}

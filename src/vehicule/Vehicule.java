package vehicule;

import obstacle.Obstacle;

/**
 * cette classe est la superclasse pour construire tous les vehicules comme les vaisseaux
 * @author cedric akrou
 *
 */

public class Vehicule
{
	protected int[] positionVehicule;
	protected int[] tailleVehicule;
	public int nombreVie = 5;
	
	public Vehicule(int posX, int posY, int tailleX, int tailleY)
	{
		positionVehicule = new int[2];
		tailleVehicule = new int[2];
		
		positionVehicule[0] = posX;
		positionVehicule[1] = posY;
		
		tailleVehicule[0] = tailleX;
		tailleVehicule[1] = tailleY;
	}
	
	/**
	 * cete methode sert à detecter les collisions avant d'un vehicule avec tout autre objet
	 * 
	 */
	
	
	public int[] getPositionVehicule() {
		return positionVehicule;
	}

	public void setPositionVehicule(int[] positionVehicule) {
		this.positionVehicule[0] += positionVehicule[0];
		this.positionVehicule[1] += positionVehicule[1];
	}

	public int[] getTailleVehicule() {
		return tailleVehicule;
	}

	public void setTailleVehicule(int[] tailleVehicule) {
		this.tailleVehicule = tailleVehicule;
	}
	
	
	public boolean CollisionAvant(Obstacle obstacle)
	{
		
		if(this.positionVehicule[0] + this.tailleVehicule[0] < obstacle.getPositionObstacle()[0] || this.positionVehicule[0] + this.tailleVehicule[0] > obstacle.getPositionObstacle()[0] + obstacle.getTailleObstacle()[0] || this.positionVehicule[1] + this.tailleVehicule[1] < obstacle.getPositionObstacle()[1] || this.positionVehicule[1] > obstacle.getPositionObstacle()[1] + obstacle.getTailleObstacle()[1] )
		{
			return false;
		}
		else
		{
			this.nombreVie -= 1;
			return true;
		}
	}
	
	public boolean estProche(Obstacle obstacle)
	{
		if( (this.positionVehicule[0] > obstacle.getPositionObstacle()[0] - 10 && this.positionVehicule[0] < obstacle.getPositionObstacle()[0] + obstacle.getTailleObstacle()[0]) || (this.positionVehicule[0] + this.tailleVehicule[0] > obstacle.getPositionObstacle()[0] - 10 && this.positionVehicule[0] + this.tailleVehicule[0] < obstacle.getPositionObstacle()[0] + obstacle.getTailleObstacle()[0] + 10  ) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	

}

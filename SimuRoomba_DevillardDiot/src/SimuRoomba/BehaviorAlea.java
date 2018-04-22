package SimuRoomba;

/**
 * Behavior random : the robot can go in any direction
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class BehaviorAlea extends Behavior{

	
	public BehaviorAlea()
	{
		this.setName("alea");
	}

	/**
	 * L'environnement connait la position du robot et le robot a une vitesse
	 * Nouvelle position du robot p+1 = p + dtv
	 */
	@Override
	public Pos generateNext(Robot rob, Environment e) 
	{
		double dl = Math.random()*rob.getSpeed() * e.getSampleTime() ;
		double dr = Math.random()*rob.getSpeed() * e.getSampleTime() ;
		return Pos.move(dl, dr, 20);
	}



}

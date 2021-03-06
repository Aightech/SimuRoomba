package SensorsRoomba;


import ObjectOnMap.Obstacle;
import SimuRoomba.Robot;
import SimuRoomba.Environment;

/**
 * A bump sensor (SensorObst) detected an obstacle by touching it : distance
 * returned is 0
 * @author Alexis Devillard and Tiphaine Diot
 * 
 */
public class SensorBump extends SensorObst {

	private boolean bumping;

	/**
	 * 2 constructors
	 */
	public SensorBump(Robot r) { 
		super((double) 0, r.getShape().getSize() / 2, (double) 0);
		this.myRob = r;
	}
	
	/**
	 * Place le capteur à une extremité avec angle particulier du robot.
	 * @param r 
	 * @param anglOnRob Un angle ==0 corespond au centre de la face avant du robot.
	 */
	public SensorBump(Robot r, double anglOnRob) {
		super(r.getShape().getSize() / 2 * Math.sin(anglOnRob), r.getShape().getSize()/ 2 * Math.cos(anglOnRob), anglOnRob);
		this.myRob = r;

	}

	/**
	 * getInforSensor() return 0 if bumping (others distances sensors would
	 * return the distance between the obstacle and the robot) Return -1 if no
	 * bumping
	 */
	public Object getInfoSensor() {	return this.bumping;	}

	/**
	 * Function calling the bumping function
	 */
	public boolean eventDetection(Environment env) {
		bumping = isBumping(this.myRob, env);
		return bumping;
	}

	/**
	 * isBumping() is a function which permits to know if the robot has
	 * bumped on a circular obstacle
	 */
	private boolean isBumping(Robot rob, Environment env) 
												
	{
		double xr = rob.getPos().getX();
		double yr = rob.getPos().getY();
		double thetar = rob.getPos().getTheta();

		double dx = this.getPos().getX();
		double dy = this.getPos().getY();

		double ptx = 0;
		double pty = 0;
		double range = Math.toRadians(40);
		double inc = Math.toRadians(0.5);

		for (double dO = -range; dO < range; dO += inc) {
			ptx = xr + dx * Math.cos(thetar + dO) + dy * Math.sin(thetar + dO);
			pty = yr - dx * Math.sin(thetar + dO) + dy * Math.cos(thetar + dO);
			
			//wall detection
			if (ptx < 0 || pty < 0 || ptx > env.getWidth()|| pty > env.getHeigth())
				return true;
			
			//obstacle detection
			for (int i = 0; i < env.nbObst(); i++) 
			{
				Obstacle obst = env.getObst(i);
				if (obst.getShape().isTouching(ptx,pty))
					return true;
			}
		}
		return false;
	}

}

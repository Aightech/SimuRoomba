package SensorsRoomba;

import ObjectOnMap.Durt;
import ObjectOnMap.OnMap;
import ObjectOnMap.Robot;
import SimuRoomba.Environment;

//TODO Finir la classe SensorDurt !!! 

/**
 * Class which represents dust sensors on the robot
 * 
 * @author Alexis Devillard and Tiphaine Diot
 * 
 */
public class SensorDurt extends Sensor {

	/**
	 * Return true if durty zone detected, if not false
	 */

	public SensorDurt(Robot r) {
		/*
		 * this.detectZone[0] = 5; //rayon de détection de 5 cm autour de son
		 * centre this.posOnRob[0] = 15; //Pos selon le repère du robot, X dans
		 * l'axe des roues et Y perpendiculaire this.posOnRob[1] = 0;
		 * this.posOnRob[2] = 0; //The angle of view of the sensor is null for
		 * an basic sensor bump - aligned with the angle of the robot
		 */
	}

	public SensorDurt(Robot r, double anglOnRob, int detectRange,
			double distFromCtr) {
		/*
		 * this.detectZone[0] = detectRange; //the bump sensor detects one
		 * obstacle by touching it. this.posOnRob[0] =
		 * distFromCtr*Math.cos(anglOnRob); //Pos selon le repère du robot, X
		 * dans l'axe des roues et Y perpendiculaire this.posOnRob[1] =
		 * distFromCtr*Math.sin(anglOnRob); this.posOnRob[2] = anglOnRob; //The
		 * angle of view of the sensor is null for an basic sensor bump -
		 * aligned with the angle of the robot
		 */
	}

	@Override
	public Object getInfoSensor() {
		return this.flag;
	}

	/**
	 * If the sensor detect dust, the function is returning true Default : every
	 * dirty zone is circular
	 */
	public boolean eventDetection(Environment env) {
		return circleDust(this.myRob, env);
	}

	/**
	 * circleDust() return a boolean according the fact the sensor detect dust
	 */
	private boolean circleDust(Robot rob, Environment env) {
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

			for (int i = 0; i < env.nbDurt(); i++) {
				Durt drt = env.getDurt(i);
				if (Math.hypot(ptx - drt.getPos().getX(), pty
						- drt.getPos().getY()) < drt.getSize() / 2)
					return true;
			}
		}
		return false;
	}
}

package SensorsRoomba;

import ObjectOnMap.Durt;
import ObjectOnMap.OnMap;
import SimuRoomba.Robot;
import SimuRoomba.Environment;

//TODO Finir la classe SensorDurt !!! EventDetection identique à celle de sensorBump

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
		super((double) 0, r.getShape().getSize(), (double) 0);
		this.myRob = r;
		this.posOnRob.set((double) 0, (double) 0, (double) 0);
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
		return isDirty(this.myRob, env);
	}

	/**
	 * circleDust() return a boolean according the fact the sensor detect dust
	 */
	private boolean isDirty(Robot rob, Environment env) {
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
					return true;
			}
		}
		return false;
	}
}

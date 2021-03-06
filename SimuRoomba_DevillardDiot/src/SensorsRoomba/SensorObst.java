package SensorsRoomba;

import SimuRoomba.Environment;

/**
 * Class representing obstacles sensors on the robot, return a distance to the
 * detected obstacle
 * @author Alexis Devillard and Tiphaine Diot
 * 
 */
public abstract class SensorObst extends Sensor {

	protected double dist;

	public abstract Object getInfoSensor();

	public abstract boolean eventDetection(Environment env);

	public SensorObst(double px, double py, double ptheta) {
		super(px, py, ptheta);
	}

}

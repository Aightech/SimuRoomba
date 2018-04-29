package SensorsRoomba;

import ObjectOnMap.Pos;
import SimuRoomba.Robot;
import SimuRoomba.Environment;

/**
 * Abstract class representing a sensor
 * 
 * @author Alexis Devillard and Tiphaine Diot Attributs: posOnRob, flag,
 *         detectZone; Functions : constructor, getters/setters Abstracts
 *         Functions : getInfoSensor() and eventDetection()
 */
public abstract class Sensor {

	/**
	 * posOnRob : position of the sensor on the robot flag : raise if sensor
	 * touch or see something detectZone : scope of the sensor myRob : the robot
	 * which has the sensor
	 */
	protected Pos posOnRob = new Pos(0, 0, 0);// (dx,dy,dtheta) par rapport au
												// centre du robot
	protected boolean flag;
	protected int[] detectZone;
	protected Robot myRob;

	// default constructor, constructor with a specified position,
	// getters/setters
	public Sensor() {
		Pos posOnRob = new Pos(0, 0, 0);
	}

	public Sensor(double px, double py, double ptheta) {
		Pos posOnRob = new Pos(px, py, ptheta);
	}

	public void setPos(Pos p) {
		this.posOnRob = p;
	}

	public Pos getPos() {
		return this.posOnRob;
	}

	public void setFlag(boolean vl) {
		this.flag = vl;
	}

	public boolean getFlag() {
		return this.flag;
	}

	public void setZone(int[] dz) {
		this.detectZone = dz;
	}

	public int[] getZone() {
		return this.detectZone;
	}

	// Abstracts functions
	public abstract Object getInfoSensor();

	public abstract boolean eventDetection(Environment env);
}

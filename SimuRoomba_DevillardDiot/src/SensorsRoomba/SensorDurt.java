package SensorsRoomba;

import ObjectOnMap.Durt;
import ShapeObjects.Circle;
import SimuRoomba.Robot;
import SimuRoomba.Environment;

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
		this.shape = new Circle(r.getPos(),5);
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
		this.flag = isDirty(this.myRob, env);
		return this.flag;
	}

	/**
	 * isDirty() return a boolean according the fact the sensor detect dust for circle shape
	 */
	private boolean isDirty(Robot rob, Environment env) {
		
		for (int i = 0; i < env.nbDurt(); i++) 
		{
			Durt drt = env.getDurt(i);
			if(this.shape.isTouching(drt.getShape()) )
				return true;
		}
		
		return false;
	}
	
	public String toString(){
		if(this.flag)
			return "Poussière détectée : oui \n";
		else
			return "Poussière détectée : non \n";
	}
}

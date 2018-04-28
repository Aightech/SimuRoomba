package BehaviorRoomba;

import ObjectOnMap.Pos;
import ObjectOnMap.Robot;
import SimuRoomba.Environment;

/**
 * Abstract class representing a behavior
 * 
 * @author Alexis Devillard and Tiphaine Diot Attribute : name - code name for
 *         the behavior Functions in the Behavior Class : setName() and
 *         getName() - getter and setter Abstract functions : generateNext()
 */
public abstract class Behavior {

	// Attributes
	protected String name;

	// Functions
	public void setName(String nm) {
		this.name = nm;
	}

	public String getName() {
		return this.name;
	}

	public abstract Pos generateNext(Robot rob, Environment e);
}

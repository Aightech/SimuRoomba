package SimuRoomba;

import java.util.ArrayList;


/**
 * Class which represents the Roomba
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Robot extends OnMap{

	/**
	 * @attributs: speed, behavior, sensDurt[], sensObst[]
	 */
	
	 

	
	protected double speed;
	protected Behavior behavior;
	protected SensorDurt sensDurts;
	protected ArrayList<SensorObst> sensObsts;
	
	
	/**
	 * Methods : getters, setters, main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setSpeed(double v)
	{
		
	}
	public void setBehavior(Behavior b)
	{
		
	}
	public Behavior getBehavior()
	{
		return this.behavior;
	}
	public Pos generateNext(Environment e)
	{
		return this.behavior.generateNext(this,e);
	}
	
}

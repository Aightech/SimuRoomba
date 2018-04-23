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
	protected ArrayList<SensorObst> sensObsts;
	protected SensorDurt sensDurts;
	
	public Robot()
	{
		super(200,200,0,"Circle");
		this.behavior = new BehaviorAlea();
		this.speed = 30;
	}
	
	/**
	 * Methods : getters, setters, main
	 */
	//public void setPos(Pos p)
	//{
	//	this.posOnMap = p;
	//}

	public void setSpeed(double v)
	{
		this.speed = v;
	}
	public void setBehavior(Behavior b)
	{
		this.behavior = b;
		
	}
	public Pos getPos()
	{
		return this.posOnMap;
	}
	public double getSpeed()
	{
		return this.speed;
	}
	public Behavior getBehavior()
	{
		return this.behavior;
	}
	public Pos generateNext(Environment e)
	{
		this.posOnMap = this.behavior.generateNext(this,e);
		return this.posOnMap;
	}
	
}

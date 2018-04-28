package SimuRoomba;

/**
 * Abstract class representing a sensor
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public abstract class Sensor {

	/**
	 * @attributs: posOnRob, flag, detectZone;
	 */
	protected Pos posOnRob = new  Pos(0,0,0);//(dx,dy,dtheta) par rapport au centre du robot
	protected boolean flag;
	protected int[] detectZone;
	protected Robot myRob;

	
	
	
	public Sensor()
	{
		Pos posOnRob = new  Pos(0,0,0);
	}
	public Sensor(double px, double py, double ptheta)
	{
		Pos posOnRob = new  Pos(px,py,ptheta);
	}
	
	public void setPos(Pos p)
	{
		this.posOnRob = p;
	}
	public Pos getPos()
	{
		return this.posOnRob;
	}
	
	public void setFlag(boolean vl)
	{
		this.flag = vl;
	}
	public boolean getFlag()
	{
		return this.flag;
	}
	public void setZone(int[] dz)
	{
		this.detectZone = dz;
	}
	public int[] getZone()
	{
		return this.detectZone;
	}
	
	public abstract Object getInfoSensor();
	public abstract boolean eventDetection(Environment env);
}

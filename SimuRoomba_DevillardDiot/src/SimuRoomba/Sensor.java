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
	protected double[] posOnRob;
	protected boolean flag;
	protected int[] detectZone;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void setPos(double[] p)
	{
		this.posOnRob = p;
	}
	public double[] getPos()
	{
		return this.posOnRob;
	}
	
	public void setFlag()
	{
		if(flag == true)
			this.flag = false;
		else
			this.flag = true;
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
}

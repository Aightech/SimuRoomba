package SimuRoomba;

/**
 * A bump sensor (SensorObst) detected an obstacle by touching it : distance returned is 0
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class SensorBump extends SensorObst{

	public Object getInfoSensor()
	{
		if(this.flag==true)
			this.dist = 0;
		return this.dist;
	}

}

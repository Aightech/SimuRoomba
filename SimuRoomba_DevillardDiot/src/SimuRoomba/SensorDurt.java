package SimuRoomba;

/**
 * Class which represents dust sensors on the robot
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class SensorDurt extends Sensor{

	/**
	 * Return true if durty zone detected, if not false
	 */
	
	
	public SensorDurt(Robot r)
	{
		/*this.detectZone[0] = 5; //rayon de détection de 5 cm autour de son centre
		this.posOnRob[0] = 15; //Pos selon le repère du robot, X dans l'axe des roues et Y perpendiculaire
		this.posOnRob[1] = 0; 
		this.posOnRob[2] = 0; //The angle of view of the sensor is null for an basic sensor bump - aligned with the angle of the robot
	*/
	}
	public SensorDurt(Robot r, double anglOnRob, int detectRange, double distFromCtr)
	{
		/*this.detectZone[0] = detectRange; //the bump sensor detects one obstacle by touching it.
		this.posOnRob[0] = distFromCtr*Math.cos(anglOnRob); //Pos selon le repère du robot, X dans l'axe des roues et Y perpendiculaire
		this.posOnRob[1] = distFromCtr*Math.sin(anglOnRob); 
		this.posOnRob[2] = anglOnRob; //The angle of view of the sensor is null for an basic sensor bump - aligned with the angle of the robot
	*/
	}
	
	@Override
	public Object getInfoSensor()
	{
		return this.flag;
	}
	public boolean eventDetection(Environment env)
	{
		boolean val = false; 
		
		for(Durt d: env.durts)
		{
			//We have to take in consideration the size/shape of the osbtacle
			switch (d.getShape())
			{
				case "Circle": 
					
					break;
				case "Square":
					break;        
				case "Polygon":
					break;        

			  default:
				  val = false;
			}
		}
		this.setFlag(val);
		return val;
	}
}

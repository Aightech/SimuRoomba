package SimuRoomba;

/**
 * A bump sensor (SensorObst) detected an obstacle by touching it : distance returned is 0
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class SensorBump extends SensorObst{

	/**
	 * The classic constructor places the sensor in the front of the robot. 
	 */
	public SensorBump(Robot r)
	{
		for(int i = 0; i < 2; i++)
			this.detectZone[i] = 0; //the bump sensor detects one obstacle by touching it.
		this.posOnRob[0] = 10; //Pos selon le repère du robot, X dans l'axe des roues et Y perpendiculaire
		this.posOnRob[1] = 0; 
		this.posOnRob[2] = 0; //The angle of view of the sensor is null for an basic sensor bump - aligned with the angle of the robot
	}
	public SensorBump(Robot r, double anglOnRob)
	{
		for(int i = 0; i < 2; i++)
			this.detectZone[i] = 0; //the bump sensor detects one obstacle by touching it.
		this.posOnRob[0] = 10*Math.cos(anglOnRob); //Pos selon le repère du robot, X dans l'axe des roues et Y perpendiculaire
		this.posOnRob[1] = 10*Math.sin(anglOnRob); 
		this.posOnRob[2] = anglOnRob; //The angle of view of the sensor is null for an basic sensor bump - aligned with the angle of the robot
		
	}
	public Object getInfoSensor()
	{
		if(this.flag==true)
			this.dist = 0;
		else
			this.dist = -1;
		return this.dist;
	}

	public boolean eventDetection(Environment env)
	{
		boolean val = false;
		//Wall case
		if( this.posOnRob[0] == 0 || this.posOnRob[1] == 0 || this.posOnRob[0] == env.dim[0] || this.posOnRob[1] == env.dim[1] )
			val = true; //We are at the edge of the environment : we are touching a wall
		
		//Other obstacles case
		for(Obstacle o: env.obstacles)
		{
			//We have to take in consideration the size/shape of the osbtacle
			switch (o.getShape())
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

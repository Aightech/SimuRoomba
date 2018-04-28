package SimuRoomba;

/**
 * Behavior random : the robot can go in any direction
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class BehaviorAlea extends Behavior{

	
	public static void main(String[] args)
	{
		Robot r = new Robot();
		Environment env = new Environment(400,400); 
		long time = System.nanoTime();
		double dt=0;
		int i=0;
		while(i<2)
		{
			dt = (System.nanoTime() - time) / 1e9;
			time=System.nanoTime();
			env.setSampleTime(dt);
			System.out.println("robot : " + r.generateNext(env));
			i++;
		}
		
		
	}
	
	public BehaviorAlea()
	{
		this.setName("alea");
	}

	/**
	 * L'environnement connait la position du robot et le robot a une vitesse
	 * Nouvelle position du robot p+1 = p + dtv
	 */
	@Override
	public Pos generateNext(Robot rob, Environment env) 
	{
		Pos lastPos = rob.getPos().clone();
		Pos newPos = rob.getPos();
		
		
		boolean bumping = false;
		//double lastSpeed[] = new double[] {rob.getSpeed(0),rob.getSpeed(1)};
		
		do{ 
			rob.getPos().set(lastPos.getX(),lastPos.getY(),lastPos.getTheta());
			double v=0;
			for(int i=0;i<2;i++)
			{
				//rob.setSpeed(i,lastSpeed[i]);
				v=rob.getSpeed(i) + Math.random()-0.5;
				v=(Math.abs(v)>rob.getMaxSpeed())?rob.getMaxSpeed():v;
				rob.setSpeed(i, v);
			}
				
			
			
			newPos = rob.move(env.getSampleTime());
			for(int i = 0 ; i < rob.nbObstSensor() ; i++)
			{
				bumping = rob.getObstSensor(i).eventDetection(env);
				
				if(bumping)
					break;
			}
			
		}while(bumping);
		
		
		return newPos;
	}



}

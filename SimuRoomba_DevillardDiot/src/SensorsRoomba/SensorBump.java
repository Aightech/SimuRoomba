package SensorsRoomba;

import ObjectOnMap.Obstacle;
import ObjectOnMap.Robot;
import SimuRoomba.Environment;

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
		super((double)0,r.getSize(),(double)0);	
		this.myRob = r;
		this.posOnRob.set((double)0,r.getSize()/2,(double)0);
	}
	public SensorBump(Robot r, double anglOnRob)
	{
		super(r.getSize()*Math.cos(anglOnRob),r.getSize()*Math.sin(anglOnRob),anglOnRob);	
		this.myRob = r;
		this.posOnRob.set(r.getSize()/2*Math.sin(anglOnRob),r.getSize()/2*Math.cos(anglOnRob),anglOnRob);
		
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
		return isBumping(this.myRob,env);
	}
	
	public boolean isBumping(Robot rob, Environment env)
	{
		double xr = rob.getPos().getX();
		double yr = rob.getPos().getY();
		double thetar = rob.getPos().getTheta();
		
		double dx = this.getPos().getX();
		double dy = this.getPos().getY();
		
		double ptx=0;
		double pty =0;
		double range = Math.toRadians(40);
		double inc = Math.toRadians(0.5);
		
		for(double dO =-range; dO < range ; dO += inc)
		{
			ptx = xr + dx * Math.cos(thetar+dO) + dy*Math.sin(thetar+dO);
			pty = yr - dx * Math.sin(thetar+dO) + dy*Math.cos(thetar+dO);
			if(ptx < 0 || pty < 0 || ptx > env.getWidth()|| pty >env.getHeigth())
				return true;
			
			for(int i=0;i<env.nbObst();i++)
		    {
				Obstacle obst=env.getObst(i);
				if(Math.hypot(ptx - obst.getPos().getX(), pty - obst.getPos().getY()) < obst.getSize()/2)
					return true;
		    }
		}
		return false;
	}
}

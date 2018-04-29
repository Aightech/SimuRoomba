package SimuRoomba;

import SensorsRoomba.*;
import ObjectOnMap.*;
import BehaviorRoomba.*;

import SensorsRoomba.SensorObst;
import SensorsRoomba.SensorDurt;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


/**
 * Class which represents the Roomba
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Robot extends OnMap{
	
	/**
	 * Diametre des roues.
	 */
	protected double wheelSize = 8;
	
	/**
	 * Tableau de la vitesse de rotation de la roue droite et de la roue gauche
	 */
	protected double speed[];
	/**
	 * La vitesse de rotation maximal des deux roues (1m/s==> 1/(2piR) ~= 5tr/s)
	 */
	protected double maxSpeed = 5;//100/Math.PI/this.wheelSize;
	
	
	
	/**
	 * Le comportement du robot.
	 */
	protected Behavior behavior;
	
	/**
	 * la liste des capteurs d'obstacle du robot
	 */
	protected ArrayList<SensorObst> sensObsts;
	
	/**
	 * Le cateur de poussière du robot
	 */
	protected SensorDurt sensDurts;
	
	public Robot()
	{
		super(200,200,0,34);
		this.behavior = new BehaviorAlea();
		this.speed = new double[] {0,1};//[rotation speed of the right wheel, rotation speed of the left wheel]
		this.color = Color.red;//les robots sont rouges (comme ca ils sont plus rapides !...)
		
		this.sensObsts = new ArrayList<SensorObst>();
		//on lui donne trois bumping capteurs fronteaux
		this.sensObsts.add(new SensorBump(this));
		this.sensObsts.add(new SensorBump(this,Math.toRadians(45)));
		this.sensObsts.add(new SensorBump(this,Math.toRadians(-45)));
		
	}
	
	/**
	 * Fait avancé le robot en fonction du lapse de temps donné. Le calcul de la nouvelle position est fait à partir des vitesses de chaque qu'une des roues
	 * @param dt
	 * @return the new position of the robot
	 */
	public Pos move(double dt)
	{
		double vm = wheelSize*Math.PI*(speed[0]+speed[1])/2;
		double thetap = wheelSize/this.getShape().getSize()*(speed[0]-speed[1]);
		double x=posOnMap.getX();
		double y=posOnMap.getY();
		double theta = posOnMap.getTheta();
		//System.out.println(vm);
		if(thetap > 1e-20  || thetap < -1e-20)
		{
			theta +=  thetap*dt;
			
			y += vm/thetap*(Math.sin(theta)-Math.sin(posOnMap.getTheta()));
			x += vm/thetap*(Math.cos(posOnMap.getTheta())-Math.cos(theta));
		}
		else
		{
			x += vm*Math.sin(theta)*dt;
			y += vm*Math.cos(theta)*dt;
		}
			
		
		return this.posOnMap.set(x, y, theta);
	}
	
	/**
	 * Methods : getters, setters, main
	 */
	public void setPos(Pos p){	this.posOnMap = p;	}

	public int nbObstSensor(){	return sensObsts.size();	}	
	
	public SensorObst getObstSensor(int i){	return sensObsts.get(i);	}	
	
	public void setSpeed(int i,double v){	this.speed[i] = v;	}
	
	public void setBehavior(Behavior b){	this.behavior = b;	}
	
	public Pos getPos(){	return this.posOnMap;	}
	
	public double getSpeed(int i){	return this.speed[i];	}
	
	public double getMaxSpeed(){	return this.maxSpeed;	}
	
	public Behavior getBehavior(){	return this.behavior;}
	
	public double getWheelSize(){	return this.wheelSize;}
	
	public Pos generateNext(Environment e)
	{
		this.posOnMap = this.behavior.generateNext(this,e);
		return this.posOnMap;
	}
	
	@Override
	public void display(Graphics g)
	{
		this.shape.display(g,this.color);
		
		Graphics2D g2 = (Graphics2D) g;
	    double dx = 0;
	    double dy = 0;
		  
		double xr = this.posOnMap.getX();
		double yr = this.posOnMap.getY();
		double thetar = this.posOnMap.getTheta();
		  
		  for(int i = 0 ; i < this.sensObsts.size() ; i++)
		  {
			  dx = this.sensObsts.get(i).getPos().getX();
			  dy = this.sensObsts.get(i).getPos().getY();
			  double ptx = xr + dx * Math.cos(thetar) + dy*Math.sin(thetar);
			  double pty = yr - dx * Math.sin(thetar) + dy*Math.cos(thetar);
			  g2.setColor(Color.BLUE);
			  g2.fillOval((int)(ptx-8),(int)( pty-8),16 , 16);
		  }
	}
	
	
}

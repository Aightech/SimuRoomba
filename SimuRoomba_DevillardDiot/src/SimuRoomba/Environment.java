package SimuRoomba;

import java.util.ArrayList;

/**
 * Environment represents the room waiting to be cleaned
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Environment {

	/**
	 * @attributs: obstacles[], durts[], dim, matEnv
	 * 
	 */
	
	protected ArrayList<Obstacle> obstacles;
	protected ArrayList<Durt> durts;
	protected int[] dim;
	protected int[][] mapEnv; 
	protected double sampleTime;
	
	
	

	public Environment(int pwidth, int pheight)
	{
		this.dim = new int[2];
		this.dim[0]=pwidth;
		this.dim[1]=pheight;
		
		this.mapEnv = new int[pheight][pwidth];
		
	}
	
	public int getWidth(){ return this.dim[0];}
	public int getHeigth(){ return this.dim[1];}
	public double getSampleTime(){return this.sampleTime;}
	
	public void setSampleTime(double dt)
	{
		this.sampleTime = dt;
	}
	
	

	public void addObst(Obstacle o){	this.obstacles.add(o);	}
	
	public void delObst(int i){	this.obstacles.remove(i);	}
	
	public Obstacle getObst(int i){	return this.obstacles.get(i);	}
	

	public void addDurt(Durt d){	this.durts.add(d);	}
	
	public void delDurt(int i){	this.durts.remove(i);	}
	
	public Durt getDurt(int i){	return this.durts.get(i);	}
	
	public void setMat()
	{
		
	}
	public int[][] getMat()
	{
		return mapEnv;
		
	}


}

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
	protected int[][] matEnv; 
	protected double sampleTime;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public Environment()
	{
		
	}
	
	public double getSampleTime()
	{
		return this.sampleTime;
	}
	public void setObst(Obstacle o)
	{
		
	}
	public void addObst(Obstacle o)
	{
		
	}
	public void delObst(int i)
	{
		
	}
	public Obstacle getObst(int i)
	{
		return null;
		
	}
	public void setDurt(Durt d)
	{
		
	}
	public void addDurt(Durt d)
	{
		
	}
	public void delDurt(int i)
	{
		
	}
	public Durt getDurt(int i)
	{
		return null;
		
	}
	public void setMat()
	{
		
	}
	public int[][] getMat()
	{
		return matEnv;
		
	}


}

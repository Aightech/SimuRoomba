package SimuRoomba;

import java.util.ArrayList;

import ObjectOnMap.Durt;
import ObjectOnMap.Obstacle;

/**
 * Environment represents the room waiting to be cleaned
 * 
 * @author Alexis Devillard and Tiphaine Diot Attributs: obstacles[], durts[],
 *         dim, matEnv Functions : getters and setters + functions add/delete
 *         for the arrayList
 */
public class Environment {

	/**
	 * obstacles[] contains all the obstacles on the map durts[] contains all
	 * the information about each dirt on the map dim is a int array, dimension
	 * of the map mapEnv[][] matrix of the map sampleTime the frequency of the
	 * simulation
	 */

	protected ArrayList<Obstacle> obstacles;
	protected ArrayList<Durt> durts;
	protected int[] dim = new int[2];
	protected double sampleTime;

	// Constructor
	public Environment(int pwidth, int pheight) {
		this.dim[0] = pwidth;
		this.dim[1] = pheight;


		this.obstacles = new ArrayList<Obstacle>();
		this.durts = new ArrayList<Durt>();

	}

	
	public int getWidth(){ return this.dim[0];}
	public int getHeigth(){ return this.dim[1];}
	public double getSampleTime(){return this.sampleTime;}
	
	public void setSampleTime(double dt){	this.sampleTime = dt;	}
	
	public void addObst(Obstacle o){	this.obstacles.add(o);	}
	
	public void delObst(int i){	this.obstacles.remove(i);	}
	
	public Obstacle getObst(int i){	return this.obstacles.get(i);	}
	
	public int nbObst(){	return this.obstacles.size();	}
	

	public void addDurt(Durt d){	this.durts.add(d);	}
	
	public void delDurt(int i){	this.durts.remove(i);	}
	
	public Durt getDurt(int i){	return this.durts.get(i);	}	
	
	public int nbDurt(){	return this.durts.size();	}


	public String toString(){
		return "Environnement information: taille(" + this.getWidth() + "x" + this.getHeigth() + ") | nb Obstacles: " + this.nbObst() + " | nb Dust:" + this.nbDurt();
	}
}

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
	protected int[] dim;
	protected int[][] mapEnv;
	protected double sampleTime;

	// Constructor
	public Environment(int pwidth, int pheight) {
		this.dim = new int[2];
		this.dim[0] = pwidth;
		this.dim[1] = pheight;

		this.mapEnv = new int[pheight][pwidth];

		this.obstacles = new ArrayList<Obstacle>();
		this.durts = new ArrayList<Durt>();

	}

	// Getters for width, heigth and sample time
	public int getWidth() {
		return this.dim[0];
	}

	public int getHeigth() {
		return this.dim[1];
	}

	public double getSampleTime() {
		return this.sampleTime;
	}

	// Setter for sample time
	public void setSampleTime(double dt) {
		this.sampleTime = dt;
	}

	// Functions which helps to change obstacles[]
	public void addObst(Obstacle o) {
		this.obstacles.add(o);
	}

	public void delObst(int i) {
		this.obstacles.remove(i);
	}

	public Obstacle getObst(int i) {
		return this.obstacles.get(i);
	}

	public int nbObst() {
		return this.obstacles.size();
	}

	// Functions which helps to change durts[]
	public void addDurt(Durt d) {
		this.durts.add(d);
	}

	public void delDurt(int i) {
		this.durts.remove(i);
	}

	public Durt getDurt(int i) {
		return this.durts.get(i);
	}

	public int nbDurt() {
		return this.durts.size();
	}

	// Getter and setter for the matrix
	public void setMat(int[][] e) {
		this.mapEnv = e;
	}

	public int[][] getMat() {
		return mapEnv;

	}

}

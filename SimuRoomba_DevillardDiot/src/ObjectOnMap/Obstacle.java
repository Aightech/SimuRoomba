package ObjectOnMap;

import java.awt.Color;

/**
 * Class representing obstacles visible on the Map, the robot needs to avoid
 * them
 * 
 * @author Alexis Devillard and Tiphaine Diot Class which extends of OnMap, has
 *         2 constructors Just a way to separate obstacle which can not be
 *         overlap and dust which can Obstacles are green
 */
public class Obstacle extends OnMap {

	// Default constructor
	public Obstacle() {
		super(200, 200, 0, 20);
		this.color = Color.green;
	}

	// Constructor with a specified position
	public Obstacle(int px, int py) {
		super(px, py, 0, 20);
		this.color = Color.green;
	}
	
	public String toString() {
		return "Info obstacle:  Pos" + this.posOnMap.toString() + " | taille: 20 | Forme: " + this.shape;
	}

}



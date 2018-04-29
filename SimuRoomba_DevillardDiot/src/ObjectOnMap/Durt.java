package ObjectOnMap;

import java.awt.Color;

/**
 * Durt represents a durty zone which need to be clean by Robot
 * 
 * @author Alexis Devillard and Tiphaine Diot Class which extends of OnMap, has
 *         2 constructors Just a way to separate obstacle which can not be
 *         overlap and dust which can Durt is gray
 */
public class Durt extends OnMap {

	// Default constructor
	public Durt() {
		super(200, 200, 0, 10, "Circle");
		this.color = Color.gray;
	}

	// Constructor with a specified position
	public Durt(int px, int py) {
		super(px, py, 0, 10, "Circle");
		this.color = Color.gray;
	}
	
	public String toString() {
		return "Info poussière:  Pos" + this.posOnMap.toString() + " | taille: 10 | Forme: " + this.shape ;
	}

}


package ObjectOnMap;

import java.awt.Color;
import java.awt.Graphics;

import ShapeObjects.*;

/**
 * Abstract Class OnMap for all objects visible on the map
 * 
 * @author Alexis Devillard et Tiphaine Diot
 * 
 */
public abstract class OnMap {
	/**
	 * The position of the OnMap on the map
	 */
	protected Pos posOnMap;

	/**
	 * The shape of the OnMap
	 */
	protected Shape shape;

	/**
	 * The color of the object
	 */
	protected Color color = Color.pink;

	/**
	 * Methods : constructors
	 */
	public OnMap() {
		// default position
		this.posOnMap = new Pos(0, 0, 0);
		// default shape
		
		//this.size = 40;
		this.shape = new Circle(this.posOnMap,40);
	}

	public OnMap(int px, int py, int ptheta, int psize) {
		// specify the position
		this.posOnMap = new Pos(px, py, ptheta);
		// default shape
		this.shape = new Circle(this.posOnMap,40);
	}

	public OnMap(int px, int py, int ptheta, Shape pshape) {
		// specify the position
		this.posOnMap = new Pos(px, py, ptheta);
		// default shape
		this.shape = pshape;
	}

	/**
	 * Methods : getters, setters, main
	 */
	public void setPos(Pos p) {	this.posOnMap = p;	}

	public Pos getPos() {	return posOnMap;	}

	public Shape getShape() {	return this.shape;	}

	public void setShape(Shape s) {	this.shape = s;	}

	public Color getColor() {	return this.color;	} 
	
	public void display(Graphics g){	this.shape.display(g,this.color);	}

}

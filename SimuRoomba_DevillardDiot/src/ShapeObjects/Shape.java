package ShapeObjects;

import java.awt.Color;
import java.awt.Graphics;

import ObjectOnMap.Pos;

/**
 * Abstract class for a shape
 * @author Alexis Devillard and Tiphaine Diot
 * Attribute : size Abstract
 * Functions : display(), isTouching()
 */
public abstract class Shape {

	/**
	 * Size of the shape, its position and name of the shape
	 */
	protected double size;
	protected Pos pos;
	protected String name;
	
	public double getSize(){	return this.size;	}
	public String getName(){	return this.name;	}
	public Pos getPos(){ return this.pos;	}
	public abstract void display(Graphics g, Color color);
	
	public abstract boolean isTouching(double px, double py);
	public abstract boolean isTouching(Shape shape);
}

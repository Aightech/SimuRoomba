package ShapeObjects;

import java.awt.Color;
import java.awt.Graphics;

import ObjectOnMap.Pos;

/**
 * Abstract class for a shape
 * 
 * @author Alexis Devillard and Tiphaine Diot Attribute : size Abstract
 *         functions : display()
 */
public abstract class Shape {

	/**
	 * Size of the shape
	 */
	protected double size;
	protected Pos pos;
	
	public double getSize(){	return this.size;	}

	public abstract void display(Graphics g, Color color);
	
	public abstract boolean isTouching(double px, double py);
}

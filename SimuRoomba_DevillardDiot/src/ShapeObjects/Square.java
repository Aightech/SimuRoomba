package ShapeObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ObjectOnMap.Pos;

public class Square extends Shape {

	public Square(Pos position, double psize)
	{
		this.size = psize;
		this.pos = position;
		this.name = "Square";
	}
	@Override
	public void display(Graphics g, Color color) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRect((int)(pos.getX()-size/2),(int)( pos.getY()-size/2),(int)size,(int)size);

	}
	@Override
	public boolean isTouching(double px, double py) {
		return false;
		// TODO Auto-generated method stub
		
	}

}

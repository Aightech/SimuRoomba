package ShapeObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ObjectOnMap.Pos;

public class Circle extends Shape {

	public Circle(Pos position, double psize)
	{
		this.size = psize;
		this.pos = position;
		this.name = "Circle";
	}
	@Override
	public void display(Graphics g, Color color) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillOval((int)(pos.getX()-size/2),(int)( pos.getY()-size/2),(int)size,(int)size);

	}
	@Override
	public boolean isTouching(double px, double py) {
		 if(Math.hypot(px - this.pos.getX(), py- this.pos.getY()) < this.size / 2)
			 return true;
		 else
			 return false;
		
	}

}

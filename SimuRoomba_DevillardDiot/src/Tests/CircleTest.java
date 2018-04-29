package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ObjectOnMap.Pos;
import ShapeObjects.Circle;
import ShapeObjects.Shape;

public class CircleTest extends Circle {

	@Test
	public void testIsTouching() {
		Shape circle = new Circle(new Pos(0,0,0),20);
		assertEquals(true,circle.isTouching(0, 0));
		assertEquals(true,circle.isTouching(10, 0));
		assertEquals(true,circle.isTouching(-10, 0));
		assertEquals(true,circle.isTouching(0, 5));
		assertEquals(true,circle.isTouching(2.5, -2.5));
		
		assertEquals(false,circle.isTouching(11, 0));
		assertEquals(false,circle.isTouching(0, 11));
		assertEquals(false,circle.isTouching(-10, -10));
	}

}

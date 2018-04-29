package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import BehaviorRoomba.BehaviorAlea;
import SimuRoomba.Environment;
import SimuRoomba.Robot;

public class BehaviorAleaTest extends BehaviorAlea {

	@Test
	public void testGenerateNext() 
	{
		Robot r = new Robot();
		Environment env = new Environment(400, 400);
		int i = 0;
		env.setSampleTime(0.1);
		while (i++ < 10) 
		{	
			System.out.println("robot : " + r.generateNext(env));
		}
		assertEquals(true,true);
	}

}

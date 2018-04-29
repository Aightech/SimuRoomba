package SimuRoomba;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe de tests pour le robot
 * @author Alexis Devillard et Tiphaine Diot
 *
 */

public class RobotTest extends Robot {

	@Test
	public void testMoveForward() 
	{
		Robot rob = new Robot();
		double initialY = rob.getPos().getY();
		double initialX = rob.getPos().getX();
		double initialTheta = rob.getPos().getTheta();
		
		rob.setSpeed(0, 1);//right wheel rotation speed = 1tr/s
		rob.setSpeed(1, 1);//left wheel rotation speed = 1tr/s
		
		rob.move(1);//move during 1s
		
		// we should have move forward (Y) from the perimiter of the wheel
		assertEquals(initialY + rob.getWheelSize()*Math.PI, rob.getPos().getY(),0.001);
		assertEquals(initialX, rob.getPos().getX(),0.001);
		assertEquals(initialTheta, rob.getPos().getTheta(),0.001);
		
		
		rob.setSpeed(0, -1);//right wheel rotation speed = 1tr/s
		rob.setSpeed(1, -1);//left wheel rotation speed = 1tr/s
		
		rob.move(1);//move during 1s
		
		// we should have move to our initial position
		assertEquals(initialY, rob.getPos().getY(),0.001);
		assertEquals(initialX, rob.getPos().getX(),0.001);
		assertEquals(initialTheta, rob.getPos().getTheta(),0.001);
	}

	@Test
	public void testGenerateNext() {
		Robot r = new Robot();
		Environment env = new Environment(400,400); 
		int i=0;
		while(i<10)
		{
			env.setSampleTime(0.1);
			System.out.println("robot : " + r.generateNext(env));
			i++;
		}
	}

}

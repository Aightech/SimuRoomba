package BehaviorRoomba;

import ObjectOnMap.Pos;
import SimuRoomba.Robot;
import SimuRoomba.Environment;

/**
 * Behavior random : the robot can go in any direction
 * 
 * @author Alexis Devillard and Tiphaine Diot Attribute : name from the Behavior
 *         abstract class Functions in the Behavior Class : sBehaviorAlea()
 *         (Constructor) and generateNext()
 */
public class BehaviorAlea extends Behavior {

	// Main, useful to control correctly how works the class
	public static void main(String[] args) {
		Robot r = new Robot();
		Environment env = new Environment(400, 400);
		long time = System.nanoTime();
		double dt = 0;
		int i = 0;
		while (i < 2) {
			dt = (System.nanoTime() - time) / 1e9;
			time = System.nanoTime();
			env.setSampleTime(dt);
			System.out.println("robot : " + r.generateNext(env));
			i++;
		}
	}

	// Constructor
	public BehaviorAlea() {
		this.setName("alea");
	}

	/**
	 * Function which generate a new random position from the last one Using
	 * move from the class Pos, the function move the robot thank to 2 random
	 * speed (from 0 to max speed possible) for both wheels The function make
	 * sure that the robot is not going to bump something
	 */
	@Override
	public Pos generateNext(Robot rob, Environment env) {
		Pos lastPos = rob.getPos().clone();
		Pos newPos = rob.getPos();

		boolean bumping = false; // Flag for bumping on something
		// double lastSpeed[] = new double[] {rob.getSpeed(0),rob.getSpeed(1)};

		do {
			rob.getPos()
					.set(lastPos.getX(), lastPos.getY(), lastPos.getTheta());
			double v = 0;
			for (int i = 0; i < 2; i++) // Generate a random speed for both
										// wheels
			{
				// rob.setSpeed(i,lastSpeed[i]);
				v = rob.getSpeed(i) + (Math.random() - 0.5)*0.1;
				v = (Math.abs(v) > rob.getMaxSpeed()) ? rob.getMaxSpeed() : v;
				rob.setSpeed(i, v);
			}

			newPos = rob.move(env.getSampleTime());
			for (int i = 0; i < rob.nbObstSensor(); i++) // Check all the
															// obstacles sensors
			{
				bumping = rob.getObstSensor(i).eventDetection(env);

				if (bumping)
					break;
			}
		} while (bumping); // if the generate position raise the flag we
							// continue
		return newPos; // Return the pos which doesn't raise the flag
	}
}

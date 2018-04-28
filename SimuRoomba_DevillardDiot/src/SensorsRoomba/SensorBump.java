package SensorsRoomba;

import java.util.ArrayList;

import ObjectOnMap.Obstacle;
import ObjectOnMap.OnMap;
import ObjectOnMap.Robot;
import SimuRoomba.Environment;

/**
 * A bump sensor (SensorObst) detected an obstacle by touching it : distance
 * returned is 0
 * 
 * @author Alexis Devillard and Tiphaine Diot
 * 
 */
public class SensorBump extends SensorObst {

	/**
	 * 2 constructors
	 */
	public SensorBump(Robot r) {
		super((double) 0, r.getSize(), (double) 0);
		this.myRob = r;
		this.posOnRob.set((double) 0, r.getSize() / 2, (double) 0);
	}

	public SensorBump(Robot r, double anglOnRob) {
		super(r.getSize() * Math.cos(anglOnRob), r.getSize()
				* Math.sin(anglOnRob), anglOnRob);
		this.myRob = r;
		this.posOnRob.set(r.getSize() / 2 * Math.sin(anglOnRob), r.getSize()
				/ 2 * Math.cos(anglOnRob), anglOnRob);

	}

	/**
	 * getInforSensor() return 0 if bumping (others distances sensors would
	 * return the distance between the obstacle and the robot) Return -1 if no
	 * bumping
	 */
	public Object getInfoSensor() {
		if (this.flag == true)
			this.dist = 0;
		else
			this.dist = -1;
		return this.dist;
	}

	/**
	 * Function calling the bumping functions for each shape
	 */
	public boolean eventDetection(Environment env) {
		// Listes pour les différentes formes d'obstacles
		ArrayList<Obstacle> circlesObsts = new ArrayList<Obstacle>();
		ArrayList<Obstacle> squareObsts = new ArrayList<Obstacle>();
		// Ajouter une autre liste si il y a un nouveau type d'obstacles

		// On doit séparer toutes les formes selon leur types
		for (int i = 0; i < env.nbObst(); i++) {

			Obstacle obst = env.getObst(i);

			if (obst.getShape() == OnMap.shapes[0])// circle
				circlesObsts.add(obst);
			else if (obst.getShape() == OnMap.shapes[1])// square
				squareObsts.add(obst);
			// Ajouter d'autres tests pour les autres formes
		}

		// Cas pour le bumping sur un objet circulaire
		boolean bumping = false;
		bumping = isBumpingCircle(this.myRob, env, circlesObsts);
		// If bumping on a circular object we stop else we try for every shape
		// if(!bumping)
		// bumping = isBumpingSquare(this.myRob,env,squareObsts);
		return bumping;
	}

	/**
	 * isBumpingCircle() is a function which permits to know if the robot has
	 * bumped on a circular obstacle
	 */
	private boolean isBumpingCircle(Robot rob, Environment env,
			ArrayList<Obstacle> obstCircles) // A remplacer par l'arrayList
												// d'obstacles
	{
		double xr = rob.getPos().getX();
		double yr = rob.getPos().getY();
		double thetar = rob.getPos().getTheta();

		double dx = this.getPos().getX();
		double dy = this.getPos().getY();

		double ptx = 0;
		double pty = 0;
		double range = Math.toRadians(40);
		double inc = Math.toRadians(0.5);

		for (double dO = -range; dO < range; dO += inc) {
			ptx = xr + dx * Math.cos(thetar + dO) + dy * Math.sin(thetar + dO);
			pty = yr - dx * Math.sin(thetar + dO) + dy * Math.cos(thetar + dO);
			if (ptx < 0 || pty < 0 || ptx > env.getWidth()
					|| pty > env.getHeigth())
				return true;

			for (int i = 0; i < obstCircles.size(); i++) {
				Obstacle obst = obstCircles.get(i);
				if (Math.hypot(ptx - obst.getPos().getX(), pty
						- obst.getPos().getY()) < obst.getSize() / 2)
					return true;
			}
		}
		return false;
	}

}

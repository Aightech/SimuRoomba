package SimuRoomba;

import java.awt.Color;

/**
 * Class representing obstacles visible on the Map, the robot needs to avoid them
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Obstacle extends OnMap{

	/**
	 * Just a way to separate obstacle which can not be overlap and dust which can  
	 */
	
	public Obstacle()
	{
		super(200,200,0,"Circle");
		this.color = Color.green;
	}
	
	public Obstacle(int px, int py)
	{
		super(px,py,0,"Circle");
		this.color = Color.green;
	}

}

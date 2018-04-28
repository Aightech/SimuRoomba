package SimuRoomba;

import java.awt.Color;

/**
 * Durt represents a durty zone which need to be clean by Robot
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Durt extends OnMap{

	/**
	 * Just a way to separate obstacle which can not be overlap and dust which can  
	 */
	
	public Durt()
	{
		super(200,200,0,10,"Circle");
		this.color = Color.gray;
	}
	
	public Durt(int px, int py)
	{
		super(px,py,0,10,"Circle");
		this.color = Color.gray;
	}
}

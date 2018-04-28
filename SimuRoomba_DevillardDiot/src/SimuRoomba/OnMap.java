package SimuRoomba;

import java.awt.Color;


/**
 * Abstract Class OnMap for all objects visible on the map
 * @author Alexis Devillard et Tiphaine Diot
 *
 */
public abstract class OnMap {

	/**
	 * The differents shape a OnMap can have
	 */
	public static String[] shapes = new String[] {"Circle", "Square", "Polygon"};
	
	/**
	 * The differents type a OnMap can be 
	 */
	private static String[] types = new String[] {"Durt", "Obstacle"};
	
	/**
	 * The position of the OnMap on the map
	 */
	protected Pos posOnMap;
	
	/**
	 * The shape of the OnMap
	 */
	protected String shape;
	
	/**
	 * The size of the Onmap (diameter for a circle, length for a square)
	 */
	protected double size; 
	
	/**
	 * The color of the object
	 */
	protected Color color=Color.pink;
	
	/**
	 * Methods : constructors
	 */
	public OnMap()
	{
		//default position
		this.posOnMap = new Pos(0,0,0);
		//default shape
		this.shape = OnMap.shapes[0];
		this.size = 40;
	}

	public OnMap(int px, int py, int ptheta, int psize)
	{
		//specify the position
		this.posOnMap = new Pos(px,py,ptheta);
		//default shape
		this.shape = OnMap.shapes[0];
		this.size = psize;
	}
	
	public OnMap(int px, int py, int ptheta, int psize, String pshape)
	{
		//specify the position
		this.posOnMap = new Pos(px,py,ptheta);
		//default shape
		this.shape = OnMap.shapes[0];
		//look for the shape asked in argument
		for(int i =0; i< OnMap.shapes.length ; i++)
			if(OnMap.shapes[i].equals(pshape))
				this.shape = OnMap.shapes[i];
		this.size = psize;
	}
	
	/**
	 * Methods : getters, setters, main
	 */
	public void setPos(Pos p){	this.posOnMap = p;	}
	
	public Pos getPos(){	return posOnMap;	}
	
	public double getSize(){	return size;	}
	
	public void setSize(double s){	this.size = s;	}
	
	public String getShape(){	return shape;	}
	
	public void setShape(String s){	this.shape = s;	}
	
}

package SimuRoomba;


/**
 * Abstract Class OnMap for all objects visible on the map
 * @author Alexis Devillard et Tiphaine Diot
 *
 */
public abstract class OnMap {

	/**
	 * @attributs: posOnMap, shape, size, nature;
	 */
	public static String[] shapes = new String[] {"Circle", "Square", "Polygon"};
	private static String[] types = new String[] {"Durt", "Obstacle"};
	protected Pos posOnMap;
	protected String shape;
	protected double size; 
	protected String nature;
	
	
	
	public OnMap()
	{
		//default position
		this.posOnMap = new Pos(0,0,0);
		//default shape
		this.shape = OnMap.shapes[0];
		this.size = 40;
	}

	public OnMap(int px, int py, int ptheta)
	{
		//specify the position
		this.posOnMap = new Pos(px,py,ptheta);
		//default shape
		this.shape = OnMap.shapes[0];
		this.size = 40;
	}
	
	public OnMap(int px, int py, int ptheta, String pshape)
	{
		//specify the position
		this.posOnMap = new Pos(px,py,ptheta);
		
		//default shape
		this.shape = OnMap.shapes[0];
		
		//look for the shape asked in argument
		for(int i =0; i< OnMap.shapes.length ; i++)
			if(OnMap.shapes[i].equals(pshape))
				this.shape = OnMap.shapes[i];
		this.size = 40;
	}

	public void setPos(Pos p)
	{
		this.posOnMap = p;
	}
	public Pos getPos()
	{
		return posOnMap;
		
	}
	public double getSize()
	{
		return size;
		
	}
	public void setSize(double s)
	{
		this.size = s;
	}
	public String getShape()
	{
		return shape;
		
	}
	public void setShape(String s){
		
	}
	
	
}

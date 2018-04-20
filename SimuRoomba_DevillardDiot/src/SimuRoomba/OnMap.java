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
	public static String[] shapes = new String[] {"Circle", "Square", "Polyg"};
	private static String[] types = new String[] {"Durt", "Obstacle"};
	protected Pos posOnMap = new Pos();
	protected String shape = OnMap.shapes[0];
	protected double size; 
	protected String nature;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public void setPos(Pos p)
	{
		
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
		
	}
	public String getShape()
	{
		return shape;
		
	}
	public void setShape(String s){
		
	}
}

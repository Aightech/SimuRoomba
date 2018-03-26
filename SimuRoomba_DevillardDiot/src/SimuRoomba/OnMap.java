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
	private static String[] shapes = new String[] {"Circle", "Square", "Polyg"};
	private static String[] types = new String[] {"Durt", "Obstacle"};
	protected Pos posOnMap;
	protected String shape;
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
		
	}
	public double getSize()
	{
		
	}
	public void setSize(double s)
	{
		
	}
	public String getShape()
	{
		
	}
	public void setShape(String s){
		
	}
}

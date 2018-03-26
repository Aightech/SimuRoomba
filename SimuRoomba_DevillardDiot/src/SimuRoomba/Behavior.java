package SimuRoomba;


/**
 * Abstract class representing a behavior
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public abstract class Behavior{

	/**
	 * @attribut : name
	 */
	protected String name;

	public void setName(String nm)
	{
		this.name = nm;
	}
	public String getName()
	{
		return this.name;
	}
	
	public abstract Pos generateNext(Robot rob);


}

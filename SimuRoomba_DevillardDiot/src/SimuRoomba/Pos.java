package SimuRoomba;

/**
 * Class given by teachers: go search it
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Pos {

	private int x;
	private int y;
	
	public Pos()
	{
		this.x=0;
		this.y=0;
	}
	
	public Pos(int px, int py)
	{
		this.x=px;
		this.y=py;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}

package game;

/**
 * Class that manages the position of where the mouse is on click.
 */
public class Position{
	/* The x coordinate of the mouse */
	private int x;
	/* The y coordinate of the mouse */
	private int y;
	
	/**
	 * class constructor.
	 * @param x the x coord.
	 * @param y the y coord.
	 */
	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}

	/**
	 * Getter method for the x attribute.
	 * @return the x coord.
	 */
	public int getX(){
		return x;
	}
	/**
	 * Getter method for the y attribute.
	 * @return the y coord.
	 */
	public int getY(){
		return y;
	}

	/**
	 * method that tells us if the coord is in the board
	 * @return <code>true<\code> if its in the board, <code>false<\code> otherwise
	 */
	public boolean inBoard(){
		return(this.x<6&&this.x>0&&this.y<6&&this.y>0)?true:false;
	}

	/**
	 * method that transforms the class into a string.
	 * @return representation in string of the class. 
	 */
	@Override
	public String toString(){
		return"  ||x:"+this.getX()+" y:"+this.getY()+"||";
	}
}	
package game;
/**
 * Class for the side tiles that have th hints about the board.
 */
public class SideTile{
	/* number of crabs in the line */
	protected int crabs;
	/* number of shells in the line */
	protected int shells;

	/**
	 * Getter method for the crabs attribute.
	 * @return the crabs in the line
	 */
	public int getCrabs(){
		return crabs;
	}

	/**
	 * Getter method for the shells attribute.
	 * @return the shells in the line
	 */
	public int getShells(){
		return shells;
	}
}
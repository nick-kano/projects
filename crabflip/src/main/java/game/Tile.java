package game;

/**
 * Class that models an individual tile of the board.
 */
public class Tile{
	/* The value the tile has. */
	private int value;
	/* Represents if a tile has been fliped before. */
	private boolean flipped;

	/**
	 * Constructor of the class.
	 * @param value the value the tile will have.
	 */
	public Tile(int value){
		this.value=value;
		this.flipped=false;
	}

	/**
	 * Getter method for the value atribute.
	 * @return the value of the tile.
	 */
	public int getValue(){
		return value;
	}

	/**
	 * Getter method for the flipped atribute.
	 * @return <code>true</code> if the tile has been flipped before, <code>false</code> otherwise.
	 */
	public boolean getFlipped(){
		return flipped;
	}

	/**
	 * Method that "flips" the tile.
	 */
	public void flip(){
		flipped=true;
	}
}
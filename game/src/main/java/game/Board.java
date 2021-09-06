package game;

import java.util.Random;

/**
 * Class that models the game board.
 * only one of this class can be created.
 */
public class Board{
	/* The board.*/
	private static Board board;
	/* The number of succesful tiles that needs to be flipped to win. */
	private int target;
	/* The size of the board. */
	private int SIZE=5;
	/* The double array of Tiles of the board. */
	private Tile[][] tiles;

	/**
	 * Constructor of the class.
	 * It is a private method to guarantee that only one board exist. 
	 */
	private Board(){
		Random r=new Random();
		int num;
		this.target=0;
		tiles=new Tile[SIZE][SIZE];
		for(int i=0; i<SIZE; i++)
			for(int j=0; j<SIZE; j++){
				num=r.nextInt(4)-1;
				if(num>0)
					target++;
				tiles[i][j]=new Tile(num);
			}
	}

	/**
	 * Method to get an instance of the board.
	 * The first time this is called it crates the board.
	 * afterwards it returns the created board.
	 * @return an instance of the board.
	 */
	public static Board getInstance(){
		if(board==null)
			board=new Board();
		return board;
	}

	/**
	 * Getter method for the size attribute.
	 * @return the size of the board.
	 */
	public int getSize(){
		return SIZE;
	}

	/**
	 * Method that returns the tile at the specified row and column.
	 * @param row row where the tile is at
	 * @param column column where the tile is at
	 * @return the tile at the row and column specified.
	 */
	public Tile getTile(int row, int column){
		return tiles[row][column];
	}

	/**
	 * Getter method for the target attribute.
	 * @return the target attribute.
	 */
	public int getTarget(){
		return target;
	}
}
package game;
/**
 * class that manages the row tiles.
 */
public class RowTile extends SideTile{
	/**
	 * class constructor.
	 * @param board the board from where we will count the crabs and shells
	 * @param row the row that we will count the crabs and shells
	 */
	public RowTile(int row, Board board){
		int crabs=0;
		int shells=0;
		Tile tile;
		for(int i=0; i<board.getSize(); i++){
			tile=board.getTile(i,row);
			if(tile.getValue()==-1)
				crabs++;
			else
				shells+=tile.getValue();
		}
		this.crabs=crabs;
		this.shells=shells;
	}
}
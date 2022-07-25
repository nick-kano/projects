package game;

public class ColumnTile extends SideTile{
	/**
	 * Class constructor.
	 * @param board the board from where we will count the crabs and shells
	 * @param column the column that we will count the crabs and shells
	 */
	public ColumnTile(int column, Board board){
		int crabs=0;
		int shells=0;
		Tile tile;
		for(int i=0; i<board.getSize(); i++){
			tile=board.getTile(column,i);
			if(tile.getValue()==-1)
				crabs++;
			else
				shells+=tile.getValue();
		}
		this.crabs=crabs;
		this.shells=shells;
	}
}
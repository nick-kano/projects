package game;
/**
 * 
 */
public class RowTile extends SideTile{
	public RowTile(int row, Board b){
		int crabs=0;
		int shells=0;
		Tile t;
		for(int i=0; i<b.getSize(); i++){
			t=b.getTile(i,row);
			if(t.getValue()==-1)
				crabs++;
			else
				shells+=t.getValue();
		}
		this.crabs=crabs;
		this.shells=shells;
	}
}
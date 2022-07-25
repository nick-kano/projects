package gui;
import processing.core.PApplet;
import processing.core.PImage;
import game.*;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Class that manages the visuals of the games
 */
public class GameGUI extends PApplet{
	/* size of the 'blocks' for the game*/
	private int PIXEL_SIZE=50;
	/* the crab sprite */
	private PImage crab;
	/* the zero shells sprite */
	private PImage zero;
	/* the one shell sprite*/
	private PImage one;
	/* the two shells sprite*/
	private PImage two;
	/* the board of the game */
	private Board board=Board.getInstance();
	/* the hint tile of the row tiles*/
	private LinkedList<RowTile> rowTiles;
	/* the hint tile of the column tiles*/
	private LinkedList<ColumnTile> columnTiles;
	/* the number of shell tiles in the board */
	private int target; 
	
	public static void main(String[] args){
		PApplet.main("gui.GameGUI");
	}
	
	@Override
	public void settings(){
		size(400, 400);
	}
	@Override
	public void setup(){
		target=board.getTarget();
		rowTiles=new LinkedList<RowTile>();
		columnTiles=new LinkedList<ColumnTile>();
		board.getInstance();
		crab=loadImage(getClass().getResource("/resource/crab.png").getPath());
		zero=loadImage(getClass().getResource("/resource/nothing.png").getPath());
		one=loadImage(getClass().getResource("/resource/one.png").getPath());
		two=loadImage(getClass().getResource("/resource/two.png").getPath());
		for(int i=0;i<board.getSize();i++){
			rowTiles.add(new RowTile(i,board));
			columnTiles.add(new ColumnTile(i,board));
		}
		drawBoard();
		drawIndicators();
	}

	@Override
	public void draw(){
	}
	private void drawIndicators(){
		Iterator itr=rowTiles.iterator();
		Iterator itc=columnTiles.iterator();
		for(int i=1;i<board.getSize()+1;i++){
			fill(236,204,162);
			rect(i*PIXEL_SIZE,(board.getSize()+1)*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
			rect((board.getSize()+1)*PIXEL_SIZE,i*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
			rect(i*PIXEL_SIZE,(board.getSize()+1)*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE/2);
			rect((board.getSize()+1)*PIXEL_SIZE,i*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE/2);
			fill(0,0,0);
			RowTile rt=(RowTile)itr.next();
			ColumnTile ct=(ColumnTile)itc.next();
			text("Shells "+rt.getShells(),2+(board.getSize()+1)*PIXEL_SIZE,(i*PIXEL_SIZE)+12);
			text("crabs "+rt.getCrabs(),2+(board.getSize()+1)*PIXEL_SIZE,(i*PIXEL_SIZE)+37);
			text("Shells "+ct.getShells(),i*PIXEL_SIZE,12+(board.getSize()+1)*PIXEL_SIZE);
			text("crabs "+ct.getCrabs(),i*PIXEL_SIZE,37+(board.getSize()+1)*PIXEL_SIZE);
		}
	}
	private void drawBoard(){//reemplazar rect con imagenes
		fill(236,204,162);
		rect(0,0,400,400);
		for(int i=1;i<board.getSize()+1;i++){
			for(int j=1;j<board.getSize()+1;j++){
				if(i%2==0){
					if(j%2==0)
						fill(231,196,150);
					else
						fill(225,191,146);
				}else{
					if(j%2==0)
						fill(225,191,146);
					else fill(231,196,150);
				}
				rect(i*PIXEL_SIZE,j*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
			}
		}
	}
	private void lose(){
		revealAll();
		noLoop();
	}
	private void win(){
		noLoop();
	}
	private void drawTile(Tile t,int x,int y){
		if(t.getValue()==-1)
			image(crab,x*PIXEL_SIZE,y*PIXEL_SIZE);
		if(t.getValue()==0)
			image(zero,x*PIXEL_SIZE,y*PIXEL_SIZE);
		if(t.getValue()==1)
			image(one,x*PIXEL_SIZE,y*PIXEL_SIZE);
		if(t.getValue()==2)
			image(two,x*PIXEL_SIZE,y*PIXEL_SIZE);;
	}

	private void drawMessage(Tile t){
		fill(236,204,162);
		noStroke();
		rect(1,1,399,40);
		fill(0,0,0);
		if(t.getValue()==-1)
			text("oh no! you dug a crab!",130,25);
		if(t.getValue()==0)
			text("there is nothing here...",130,25);
		if(t.getValue()==1)
			text("you got a shell!",130,25);
		if(t.getValue()==2)
			text("you got two shells!!",130,25);
	}

	private void revealAll(){
		for (int i=0;i<board.getSize();i++){
			for(int j=0;j<board.getSize();j++){
				Tile t=board.getTile(i,j);
				drawTile(t,i+1,j+1);
			}
		}
	}
	@Override
	public void mouseClicked(){
		int x=mouseX/PIXEL_SIZE;
		int y=mouseY/PIXEL_SIZE;
		Position p=new Position(x,y);
		if(!p.inBoard())
			return;
		Tile t=board.getTile(x-1,y-1);
		drawTile(t,x,y);
		drawMessage(t);
		if(!t.getFlipped()){
			if(t.getValue()==-1){
				lose();
			}
			if(t.getValue()>0){
				target--;
				if(target==0)
					win();
			}
		}
		t.flip();
	}
}
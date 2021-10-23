package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObjects implements Collider{
	protected int x,y; 
	protected Game game;
	protected String symbol;
	
	public GameObjects (Game game, int x, int y) {
		
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	protected String getSymbol() {
		return symbol;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public abstract void onEnter();
	public abstract void update();
	public abstract void onDelete();
	public abstract boolean isAlive();
	
	@Override
	
	public String toString() {
		
		String amatonto = "tonto";
		// your code
		return amatonto;
	}
	
}

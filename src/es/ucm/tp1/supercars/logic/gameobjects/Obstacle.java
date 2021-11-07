package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObjects {

	public final static String INFO = "[Obstacle] hits car";
	private static int counter = 0;
 	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = "░";
		deadSymbol = "";
	}
	
	public boolean receiveCollision(Player player) {
		boolean collision = false;
		if(player.isInPosition(x,y)) {
			player.kill();   
			collision = true;
		}	
		return collision;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public void onEnter() {
		counter += 1;
	}
 
	public void onDelete() {
		counter -= 1;
	}
	
	public static void reset() {
		counter = 0;
	}
	
	public static int getObsCounter() {
		return counter;
	}	
	
	public boolean isAlive() {
		return alive;
	}
	
	public void update() {
 	}
}

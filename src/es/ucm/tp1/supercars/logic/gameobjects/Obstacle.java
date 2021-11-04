package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObjects {

	public final static String INFO = "[Obstacle] hits car";
	private static int counter = 0;
 
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = "░";
	}
	
	public int getX() {
		return x;	
	}
	
	public int getY() {
		return y;		
	}
	
	public int getObsCounter() {
		return counter;
	}	
	
	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		counter += 1;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		counter -= 1;
		
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

}

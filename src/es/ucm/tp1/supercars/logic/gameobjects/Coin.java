package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObjects {

	public final static String INFO = "[Coin] gives 1 coin to the player";
	private static int counter = 0;

	
	public Coin(Game game, int x, int y) {
		super(game, x, y);
		symbol = "¢";
	}
	
	public int getX() {
		return x;	
	}
	
	public int getY() {
		return y;		
	}
	
	public int getCoinCounter() {
		return counter;
	}
	
	public void dead() {
		alive = false;
	}
	
	public boolean getAlive() {
		return this.alive;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public void onEnter() {
		counter += 1;
	}

	@Override
	public void update() {
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

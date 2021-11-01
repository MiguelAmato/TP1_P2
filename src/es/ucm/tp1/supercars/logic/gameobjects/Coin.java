package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObjects {

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
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

}

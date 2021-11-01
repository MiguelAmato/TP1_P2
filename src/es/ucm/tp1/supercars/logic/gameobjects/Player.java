package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObjects {
	
	private int coinCounter;
	private int distance;
	
	public final String skin = ">";
	public final int INITIAL_COINS = 5;

	public Player(Game game, int x, int y, int distance) {
		super(game, x, y);
		symbol = ">";
		this.coinCounter = INITIAL_COINS;
		this.distance = distance;
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}
	
	public void moveForward() { // CUIDADO
		x = x + 1;
	}
	
	public void reduceDistance() {
		distance -= 1;
	}
	
	public void goUp() {
		y = y - 1;
	}
	
	public void goDown() {
		y = y + 1;
	}
	

	public boolean doCollision() {
		return false;
	}

	public boolean receiveCollision(Player player) {
		return false;
	}

	public void onEnter() {
		
	}

	public void update() {
		
	}
	
	public void onDelete() {
		
	}

	public boolean isAlive() {
		return false;
	}
	
}

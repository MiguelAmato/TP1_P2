package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObjects{
	
	private int coinCounter;
	private int distance;
	public final static String INFO = "[Car] the racing car";
 	public final int INITIAL_COINS = 5;
 	 
	public Player(Game game, int x, int y) {
		super(game, x, y);
		symbol = ">";
		deadSymbol = "@";
		coinCounter = INITIAL_COINS;
		distance = game.getRoadLength();
	}
		
	public boolean doCollision() {
		Collider other = game.getColliderInPosition(x, y);
		if (other != null) {
		return other.receiveCollision(this);
		}
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		return false;
	}

	public void moveForward() {  
		x = x + 1;
	}
	
	public void goUp() {
		y = y - 1;
	}
	
	public void goDown() {
		y = y + 1;
	}
	
	public void reduceDistance() {
		distance -= 1;
	}
	
	public void takeCoin() {
		coinCounter += 1;	
	}
	
	public void kill() {
		 alive = false;
	}	
	
	public boolean isAlive() {
		return alive;
	}
	
	public int getCoinCounter() {
		return coinCounter;
	}
	
	public int getDistance() {
		return distance;
	}

	public void onEnter() {}

	public void update() {}
	
	public void onDelete() {}
 
}

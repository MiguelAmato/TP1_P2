package es.ucm.tp1.supercars.logic;

import java.util.*;
import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*; 
  
public class Game {
	
	public final String GOAL = "¦";
	
	private long seed;
	private long initialTime;
	private int cycles;
	private int length;
	private int width;
	private boolean exit = false;
	private boolean test = false;
	
	Level level;
	Player car;
	GameObjectContainer container;
	Random random;
	
	public Game (long seed, Level level) {
		this.seed = seed;
		this.level = level;
	}
	
	public void initializeGame() {
		testMode();
		cycles = 0;
		length = level.getLength();
	    width = level.getWidth();
		car = new Player(this,0, width/2); 
        container = new GameObjectContainer();
        random = new Random(seed);
        objectsPlacement();
        initialTime = System.currentTimeMillis();
	}
	
	public void objectsPlacement() {
		GameObjectGenerator.generateGameObjects(this, level);
	}
	
	public void tryToAddObject(GameObjects gameObject , double frequency) {
		if (random.nextDouble() < frequency) {
			container.addObject(gameObject);
        }
	}
	
	public void reset (String seed, String inputLevel, boolean bigReset) {
		if (bigReset) {
			this.seed = Long.parseLong(seed);
			this.level = Level.valueOfIgnoreCase(inputLevel);
		}
		GameObjectGenerator.reset(level); // Asumimos que el parametro level se usara en la practica 2
		initializeGame();
	}
	
	public void update() {
		cycles += 1;
		car.moveForward();
		car.reduceDistance();
		car.doCollision();
		container.deleteObject();
	}
	
	public boolean moveUp() {
		boolean moveUp = false;
		if (car.getY() > 0) {
			car.goUp();
			moveUp = true;
		}
		return moveUp; 
 	}
	
	public boolean moveDown() {
		boolean moveDown = false;
		if (car.getY() < getRoadWidth() - 1) {
			car.goDown();
			moveDown = true;
		}
		return moveDown; 
 	}
	
	public void testMode() {
		if (level == Level.TEST) {
			toggleTest();
		}
		else {
			test = false;
		}
	}
	
	public void toggleTest() { 
		test = true;
	}
	
	public void exit() {
		exit = true;
	}
	
	public void takeCoin() {
		car.takeCoin();
	}

	public boolean isFinished() {   
		boolean isFinished = false;
		if (exit || !car.isAlive() || car.getX() == length + 1) {
			isFinished = true;
		}
		return isFinished;
	}
	
	public String positionToString(int x, int y) {
	    String ret;
	    if(car.isInPosition(x, y)) {
	    	ret = car.toString();
	    }
	    else {
		    if (x == length){
			   	ret = GOAL;
		     }
	        else {
	            ret = container.getSymbolfrom(x,y);
		    }
	    }
        return ret;
 	}

	public Collider getColliderInPosition(int x, int y) {  
		return container.isThereAnObject(x,y);
	}
	
	public String getInfoPlayer() {
		return  "Distance: " + car.getDistance() + "\n"
				+ "Coins: " + car.getCoinCounter() + "\n";
	}
	
	public int getRandomLane() {    
  		return (int)(random.nextDouble() * level.getWidth());
  	}
	
	public int getVisibility() {
		return level.getVisibility();  
    }
    	
	public int getRoadWidth() {
        return level.getWidth();
    }
  	
  	public int getRoadLength() {
 		return level.getLength();
	}
  	
 	public int getCarPosX() {
		return car.getX();
	}
	
	public boolean hasWon() {
		return car.isAlive();
	}
	
	public int getCycles() {
		return cycles;
	}
			
	public boolean getExit() {
		return exit;
	}

	public boolean getTest() {
		return test;
	}

	public double getInitialTime() {
		return initialTime;
	}
}
	
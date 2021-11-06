package es.ucm.tp1.supercars.logic;
import java.util.*;
 

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*; 
import es.ucm.tp1.supercars.logic.GameObjectGenerator;
 
public class Game {
    
	private long seed;
	private int cycles;
	private boolean exit = false;
	private int length;
	private boolean test = false;
	private int width;
	private long initialTime;
	
	Level level;
	Player car;
	GameObjectContainer container;
	Random random;
	
	public final String GOAL = "¦";
	
	public Game (long seed, Level level) {
		this.seed = seed;
		this.level = level;
	}
	
	public void reset (String seed, String inputLevel, boolean bigReset) {
		if (bigReset) {
			this.seed = Long.parseLong(seed);
			this.level = Level.valueOfIgnoreCase(inputLevel);
		}
		GameObjectGenerator.reset(level); // Asumimos que el parametro level se usara en la practica 2
		initializeGame();
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
  	
  	public int getRandomLane() {    
  		return (int)(random.nextDouble() * level.getWidth());
  	}

	public int getCarPosX() {
		return car.getX();
	}
	
	public int getCarPosY() {
		return car.getY();
	}
	
	public int getCycles() {
		return cycles;
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
	
	public void exit() {
		exit = true;
	}
	
	public GameObjects getObjectInPosition(int x, int y) {  // En el enunciado se muestra esta funcion que devuelve un gameObject 
		return container.isThereAnObject(x,y);
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
	            ret = container.getSymbolfrom(x,y);;
		    }
	    }
        return ret;
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
 
	public void update() {
		cycles += 1;
		car.moveForward();
		car.reduceDistance();
		car.doCollision();
		container.deleteObject();
	}

	public void tryToAddObject(GameObjects gameObject , double frequency) {
		if (random.nextDouble() < frequency) {
			container.addObject(gameObject);
        }
	}

	public void toggleTest() { 
		test = true;
	}

	public void objectsPlacement() {
		GameObjectGenerator.generateGameObjects(this, level);
	}
	
	public void testMode() {
		if (level == Level.TEST) {
			toggleTest();
		}
		else {
			test = false;
		}
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

	public String getInfoPlayer() {
		return  "Distance: " + car.getDistance() + "\n"
				+ "Coins: " + car.getCoinCounter() + "\n";
	}

	public boolean getExit() {
		return exit;
	}

	public boolean hasWon() {
		return car.isAlive();
	}

	public boolean getTest() {
		return test;
	}

	public double getInitialTime() {
		return initialTime;
	}
}
	
package es.ucm.tp1.supercars.logic;



import java.util.*;
 

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*; 
import es.ucm.tp1.supercars.logic.GameObjectGenerator;
 
public class Game {
    
	
	private long seed;
	private int cycles;
	//private double random;
	private boolean exit = false;
	private int length;
	private boolean test = false;
	private int width;
	private double randomNumber;
	Level level;
	Player car;
	GameObjectContainer container;
	Random random;
	
	
 
	
	public Game (long seed, Level level) {
		
		this.seed = seed;
		this.level = level;
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
	
	public GameObjects getObjectInPosition(int x, int y) {  // Este metodo es una estupidez, deberiamos cambiarlo por el isThereAnObject directamnte, si es que se puede
		 
		GameObjects ret = container.isThereAnObject(x,y);
		
		return ret;
	}
	
	public String positionToString(int x, int y) {
		 
	    String ret;
	   
	    
	    if(car.isInPosition(x, y)) {		 
	    		 
	    	ret = car.toString();
	    }
	    
	    else {
	    
		   
		        
		    if (x == length){
			   	ret = "¦";
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
	
	
	public boolean isFinished() { // Esto esta como booleano del while principal en el run 
		boolean isFinished = false;
		if (exit || !car.isAlive()) {
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
		
		 
		// Si la pos del jugador coincide con la de una moneda u objeto muro
			// En caso de que sea una moneda la borras
			// En caso de que sea un muro pos te mueres
		 
		// Habria que llamar al collider para sumar una moneda o acabar el juego
	}

	public void tryToAddObject(GameObjects gameObject , double frequency) {
		
		if (random.nextDouble() < frequency) {
			container.addObject(gameObject);
        }
	}

	public void toggleTest() {  // 
		test = true;
		
	}

	public void objectsPlacement() {
		
		GameObjectGenerator.generateGameObjects(this, level);
		
	}
	

	public void initializeGame() {
		
		cycles = 0;
		length = level.getLength();
	    width = level.getWidth();
		car = new Player(this,0, width/2,length); 
        container = new GameObjectContainer();
        random = new Random(seed);
        
          
		
	}
	
	
	
	
   
}
	
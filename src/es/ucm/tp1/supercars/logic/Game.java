package es.ucm.tp1.supercars.logic;



import java.util.*;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*; 

 


public class Game {
    
	
	private long seed;
	private int cycles;
	private double random;
	private boolean exit = false;
	
	Level level;
	Player car;
	GameObjectContainer container;
 
	public int getVisibility() {
		return level.getVisibility();  
    }
    	
  	public int getRoadWidth() {
        return level.getWidth();
    }
  	
  	public int getRoadLength() {
 		return level.getLength();
	}
  	
  	public int getRandomLane() {  // Este random no se puede poner aqui porque hace falta en otros metodos y no se puede pasar como parametro 
  		Random random = new Random(seed);
  		this.random = random.nextDouble();
  		return (int)(random.nextDouble() * level.getWidth());
  	}

	public int getCarPosX() {
		return car.getPosX();
	}
	
	public int getCarPosY() {
		return car.getPosY();
	}
	
	public int getCycles() {
		return cycles;
	}
	
	public boolean moveUp() {
		boolean moveUp = false;
		
		if (car.getPosY() > 0) {
			car.goUp();
			moveUp = true;
		}
		
		return moveUp; 
 	}
	
	public boolean moveDown() {
		boolean moveDown = false;
		
		if (car.getPosY() < getRoadWidth() - 1) {
			car.goDown();
			moveDown = true;
		}
		
		return moveDown; 
 	}
	
	public void exit() {
		exit = true;
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
		
		// Si la pos del jugador coincide con la de una moneda u objeto muro
			// En caso de que sea una moneda la borras
			// En caso de que sea un muro pos te mueres
		 
		// Habria que llamar al collider para sumar una moneda o acabar el juego
	}

	public void tryToAddObject(GameObjects gameObject , double frequency) {
		if (random < frequency) {
			container.addObject(gameObject);
        }
	}
	
	
	
   
}
	
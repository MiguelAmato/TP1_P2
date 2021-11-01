package es.ucm.tp1.supercars.logic;

import java.util.*;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*;
 
public class Game {
    
	private int cycles;
	private boolean exit = false;
	
	Level level;
	Player car;

	public int getVisibility() {
		return level.getVisibility();  
    }
    
  	public int getRoadWidth() {
        return level.getWidth();
    }

	public int getCarPosX() {
		return car.getPosX();
	}
	
	public int getCarPosY() {
		return car.getPosY();
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
    
}
	
package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;

import java.util.List;

public class GameObjectContainer {
	
	private List<GameObjects> gameObjects;
	private int objectCounter;
	
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
		objectCounter = 0;
	}
	
	public void addObject(GameObjects gameObject) {
		
		if(!isThereAnObject(gameObject.getX(),gameObject.getY())) {	
			gameObjects.add(gameObject);
			gameObject.onEnter();
		}	
	}
	
	public List<GameObjects> deleteObject (GameObjects gameObject) {
		
		List<GameObjects> list = new ArrayList<>() ;
		int j = 0;
		
		for(int i = 0; i < list.size();i++) {  // Hay que cambiar este bucle for para ponerlo con lo de los dos puntos / claro
			
			if(gameObjects.get(i).alive)
				list.add(gameObjects.get(i));
		}
		
		return list;
	}
	
	public boolean isThereAnObject(int x,int y) {
		
		boolean answer = false;
		int i = 0;
		
		while(!answer && i < objectCounter) {
			
			if(gameObjects.get(i).getX() == x && gameObjects.get(i).getY() == y)
				answer = true;
			else 
				i += 1;
		}
		
		return answer;
	}
 }

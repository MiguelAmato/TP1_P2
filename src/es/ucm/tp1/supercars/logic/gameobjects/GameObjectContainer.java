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
		if(isThereAnObject(gameObject.getX(),gameObject.getY()) == null) {	
			gameObjects.add(gameObject);
			gameObject.onEnter();
			objectCounter += 1;
		}	
	}
	
	public List<GameObjects> deleteObject () {
		List<GameObjects> list = new ArrayList<>() ;
		for(int i = 0; i < list.size(); i++) {  
			if(gameObjects.get(i).alive)
				list.add(gameObjects.get(i));
		}
		return list;
	}
	
	public GameObjects isThereAnObject(int x,int y) {
		GameObjects object = null;
		int i = 0;
		while(object == null && i < objectCounter) {
			if(gameObjects.get(i).getX() == x && gameObjects.get(i).getY() == y)
				object = gameObjects.get(i);
			else 
				i += 1;
		}
		return object;
	}
 
	public String getSymbolfrom(int x, int y) {
		String ret = "";
		int i = 0;
		boolean end = false;
		while(i < objectCounter && !end) {
			if(gameObjects.get(i).isInPosition(x, y)) {
				end = true;
				ret = gameObjects.get(i).toString();
			}
			else {
				i += 1;
			} 	
		}
		return ret;
	}
 }

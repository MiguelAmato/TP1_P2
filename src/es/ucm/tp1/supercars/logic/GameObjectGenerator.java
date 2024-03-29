package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.control.*;

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {
		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
		}
	}

	public static void reset(Level level) { 
		Obstacle.reset();
		Coin.reset();
	}
	
	public static StringBuilder getInfo() {
		StringBuilder info = new StringBuilder();
		info.append(Player.INFO + "\n");
		info.append(Coin.INFO + "\n");
		info.append(Obstacle.INFO);
		return info;
	}

	public static void generateRuntimeObjects(Game game) { // Para la pract 2.2
		// TODO add your code
	}
}

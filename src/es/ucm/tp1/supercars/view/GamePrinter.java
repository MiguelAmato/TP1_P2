package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.*;
import es.ucm.tp1.supercars.utils.*;

public class GamePrinter {

	private static final String SPACE = " ";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "─";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;
	
	private static final String EXIT_MSG =  "Player leaves the game";
	
	private String indentedRoadBorder;

	private String indentedLlanesSeparator;

	private String margin;


	private static final String CRASH_MSG = String.format("Player crashed!%n");

	private static final String WIN_MSG = String.format("Player wins!%n");

	
	private static final String GAME_OVER_MSG = "[GAME OVER]"; 
	
	public String newLine; 

	protected Game game;
	protected Coin coin;
	protected Obstacle obstacle;
	protected Player car;
	
	public GamePrinter(Game game) {
		this.game = game;
		

		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) *  game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator =  SPACE + StringUtils.repeat(laneDelimiter +  SPACE,  game.getVisibility() - 1) + laneDelimiter + SPACE;

		indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
		newLine =  System.getProperty("line.separator");
		

		newLine =  System.getProperty("line.separator");
	}
	


	private String getInfo() {
		String s = "Distance: " + car.getDistance() + "\n"
				+ "Coins: " + car.getCoinCounter() + "\n"
				+ "Cycle: " + game.getCycles() + "\n"
				+ "Total obstacles: " + obstacle.getObsCounter() + "\n"
				+ "Total coins: " + coin.getCoinCounter() ;
		
		//if (!game.getTest()) {
			//s = s + ("\nElapsed Time: " + game.getTime() + " s"); 
		//}
		
		return s;
		 
	}


	public String toString() {
		StringBuilder str = new StringBuilder();

		// Game Status
		
		str.append(getInfo());
		
		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;
		
		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = game.getCarPosX(); x < game.getVisibility() + game.getCarPosX(); x++) { 
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE)).append(verticalDelimiter);
			}
			if (y <  game.getRoadWidth() - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}

	public void endMessage(){ 
		
		/*System.out.print(GAME_OVER_MSG + " "); 
		
		if (game.getExit()) 
			System.out.println(EXIT_MSG);
		else if (game.hasWon())
			System.out.println(WIN_MSG);
		else 
			System.out.println(CRASH_MSG);
		
	}*/
	}
	
}

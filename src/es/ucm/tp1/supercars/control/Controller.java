package es.ucm.tp1.supercars.control;

import java.util.Scanner;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;
import es.ucm.tp1.supercars.view.GamePrinter;



public class Controller {
	
	private String option;
	
 	private static final String PROMPT = "Command > "; 

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	private static final String ERROR = "[ERROR]: ";
	
	private static final String DEBUG = "[DEBUG] Executing:";
	
	private static final String INVALID = "Invalid command!";
	
	private boolean exit = false;

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobject info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	 
	
	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;
	
	private Level level;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}

	public void printGame() {
		System.out.println(printer);
	}
	
	public void showExecution() {
		
		System.out.println("\n" + DEBUG + " " +  this.option);
		
	}

	public void run() {
		boolean refreshDisplay = false;
		
		game.initializeGame();
	 
		printGame();
		
		while (!game.isFinished()){
			
			if (refreshDisplay ) {
				printGame();
			}
			refreshDisplay = false;
			
			System.out.print(PROMPT);
			
			String s = scanner.nextLine();
			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.println("[DEBUG] Executing: " + s);
			Command command = Command.getCommand(parameters);
			if (command != null) {
				refreshDisplay = command.execute(game);
			} 
			else {
				System.out.println("[ERROR]: "+ UNKNOWN_COMMAND_MSG);
			}
		}
		printGame();
 		printer.endMessage(); 
 		
	}
 }

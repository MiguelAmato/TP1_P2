package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {
	
	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset";
	private static final String SHORTCUT = "r";
	private static final String HELP = "reset game";
	
	private String level;
	private String seed;
	private boolean bigReset; 
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
 
	public boolean execute(Game game) {
		game.reset(seed, level, bigReset);
		return true;
	}
	
	protected Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {
			commandWords[0] = SHORTCUT;
			if (commandWords.length == 3) { // 3 Parametros (reset, level y seed)
				if (Level.valueOfIgnoreCase(commandWords[1]) == null) { 
					return null;
				}
				level = commandWords[1];
				seed = commandWords[2];
				bigReset = true;
				commandWords = new String[] {SHORTCUT};
 			} 
		}
		return super.parse(commandWords);
	}
}

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

	@Override
	public boolean execute(Game game) {
		game.reset(seed, level, bigReset);
		return true;
	}
	
	protected Command parse(String[] commandWords) {
		if ("r".equalsIgnoreCase(commandWords[0]) || "reset".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
			if (commandWords.length == 3) { // Si se quiere hacer el reset con nuevo nivel y semilla se ha de escribir 3 comandos (comando, nivel y semilla)
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

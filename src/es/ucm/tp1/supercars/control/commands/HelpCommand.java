package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:");

		// TODO Add your code

		System.out.println(buffer.toString());

		return false;
	}

}

// El generator es el unico que sabe los objetos disponibles, en el caso de info lo mejor que podemos hacer es:
// hacer un getInfo en GameObjectsGenerator (De tipo string) 
// tambien se puede poner en el gameprinter, con un metodo estatico, porque el gameprinter tiene la informacion de todoos los objetos, ya que tiene uqe saber cuantas monedas y obstaculos hay etc
// pero mejor en el generator 
// El unico que sabe que objetos hay es el GameObjectGenerator (El profesor dijo que es lo mas importante de la practica, por eso te lo repito tobilongalo)

// Hacer un protected para acceder del command al helpcommand y asi poder acceder a la lista de available commands (O hacer un getter protected)

// En el reset se pasa el Level para poder conservar la semilla y la dificultad del juego, hay que hacer tambien un nuevo random en el reset para que todo este en su lugar
// a la hora de volver a inicializar. 


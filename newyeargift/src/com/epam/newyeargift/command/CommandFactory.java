package com.epam.newyeargift.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
	
private static final Map<Commands, Command> commands = new HashMap<>();
	
	static {
		commands.put(Commands.COUNT_WEIGHT, new CommandCountWeight());
		commands.put(Commands.FIND_BY_SHUGAR_AMOUNT, new CommandFind());
		commands.put(Commands.SORT_BY_WEIGHT, new CommandSortByWeight());
		commands.put(Commands.SHOW_ALL, new CommandShow());
		commands.put(Commands.DOM, new CommandDomParsing());
		commands.put(Commands.SAX, new CommandSaxParsing());
		commands.put(Commands.STAX, new CommandStaxParsing());
	}
	
	public static Command getCommand(Commands commandName) {
		return commands.get(commandName);
	}

}

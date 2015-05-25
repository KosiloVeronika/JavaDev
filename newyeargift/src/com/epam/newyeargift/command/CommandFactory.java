package com.epam.newyeargift.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
	
private static final Map<Commands, Command> commands = new HashMap<>();
	
	static {
		commands.put(Commands.COUNT_WEIGHT, new CommandCountWeight());
		commands.put(Commands.FIND_BY_SHUGAR_AMOUNT, new CommandFind());
		commands.put(Commands.SORT_BY_WEIGHT, new CommandSortByWeight());
		commands.put(Commands.CREATE_GIFT, new CommandCreator());
		commands.put(Commands.SHOW_ALL, new CommandShow());
	}
	
	public static Command getCommand(Commands commandName) {
		return commands.get(commandName);
	}

}

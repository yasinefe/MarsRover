package com.yefe.marsrover.console;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.yefe.marsrover.command.Command;

/**
 * This contains commands and executes them according to given keywords
 * 
 * @author Yasin EFE
 */
public class CommandExecutor {

	private CommandHelpWriter commandHelpWriter;
	private Map<String, Command> commandMap = new HashMap<String, Command>();

	public CommandExecutor(CommandHelpWriter commandHelpWriter) {
		this.commandHelpWriter = commandHelpWriter;
	}

	public void registerCommand(Command command) {
		commandMap.put(command.keyword(), command);
	}

	/**
	 * Checks all commands registered and runs them
	 * 
	 * @param commands
	 *            contains commands such as LFRLFFL
	 */
	public void execute(String commands) {
		Collection<String> keys = parse(commands);
		if (commandMap.keySet().containsAll(keys)) {
			for (String key : keys) {
				Command command = commandMap.get(key);
				command.run();
			}
		} else {
			commandHelpWriter.writeHelp(commandMap.values());
		}
	}

	/**
	 * Parse commands as key list
	 * 
	 * @param command
	 *            contains all commands
	 * @return a collection which contains all keys
	 */
	private Collection<String> parse(String command) {
		char[] charArray = command.toCharArray();
		Collection<String> keys = new ArrayList<String>();
		for (char c : charArray) {
			keys.add(String.valueOf(c));
		}
		return keys;
	}
}

package com.yefe.marsrover.console;

import java.io.PrintStream;

import java.util.Collection;

import com.yefe.marsrover.command.Command;

/**
 * This writes all commands to show which commands can be used
 * 
 * @author Yasin EFE
 */
public class CommandHelpWriter {

	public static final String TITLE = "Available commands are:";
	public static final String ERROR = "Error : Unknown Command !";

	private PrintStream out;

	public CommandHelpWriter(PrintStream out) {
		this.out = out;
	}

	public void writeHelp(Collection<Command> values) {
		out.println(ERROR);
		out.println(TITLE);
		for (Command command : values) {
			out.println(command.keyword() + ": " + command.description());
		}
	}

}

package com.yefe.marsrover;

import java.io.InputStream;
import java.io.PrintStream;

import com.yefe.marsrover.command.ForwardCommand;
import com.yefe.marsrover.command.LeftCommand;
import com.yefe.marsrover.command.RightCommand;
import com.yefe.marsrover.console.CommandExecutor;
import com.yefe.marsrover.console.CommandHelpWriter;
import com.yefe.marsrover.console.CommandReader;
import com.yefe.marsrover.model.Rover;

/**
 * This class is a builder pattern implementation to build Rover context and its dependencies
 * 
 * @author Yasin EFE
 */
public class RoverBuilder {

	private CommandHelpWriter commandHelpWriter;
	private CommandExecutor commandExecutor;
	private CommandReader commandReader;

	/**
	 * I injected in and out object becuase command can be given with different ways, for example
	 * FileInputStream can be used
	 * 
	 * @param in
	 *            contains InputStream
	 * @param out
	 *            contains PrintStream
	 * @param rover
	 *            contains Rover implementation
	 */
	public RoverBuilder(InputStream in, PrintStream out, Rover rover) {
		commandHelpWriter = new CommandHelpWriter(out);
		commandExecutor = new CommandExecutor(commandHelpWriter);

		// Register all command to the executor
		commandExecutor.registerCommand(new LeftCommand(rover, out));
		commandExecutor.registerCommand(new RightCommand(rover, out));
		commandExecutor.registerCommand(new ForwardCommand(rover, out));
		// If you want to add a new command you should register to the command executor

		commandReader = new CommandReader(commandExecutor, in, out);
	}

	public void start() {
		commandReader.start();
	}

	public void stop() {
		commandReader.close();
	}

}

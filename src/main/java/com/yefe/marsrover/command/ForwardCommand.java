package com.yefe.marsrover.command;

import java.io.PrintStream;

import com.yefe.marsrover.console.IllegalMovementException;
import com.yefe.marsrover.model.Rover;

/**
 * This is forward command, this is independent rover implementation
 * 
 * @author Yasin EFE
 */
public class ForwardCommand extends Command {

	public static final String KEY = "F";
	public static final String DESCRIPTION = "move forward one square in the direction";

	public ForwardCommand(Rover rover, PrintStream out) {
		super(rover, out);
	}

	@Override
	public void execute() throws IllegalMovementException {
		rover.forward();
	}

	@Override
	public String keyword() {
		return KEY;
	}

	@Override
	public String description() {
		return DESCRIPTION;
	}

}

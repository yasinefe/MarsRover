package com.yefe.marsrover.command;

import java.io.PrintStream;

import com.yefe.marsrover.model.Rover;

/**
 * This is left command, this is independent rover implementation
 * 
 * @author Yasin EFE
 */
public class LeftCommand extends Command {

	public static final String KEY = "L";
	public static final String DESCRIPTION = "rotate left 90 degrees";

	public LeftCommand(Rover rover, PrintStream out) {
		super(rover, out);
	}

	@Override
	public void execute() {
		rover.turnLeft();
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

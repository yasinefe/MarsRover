package com.yefe.marsrover.command;

import java.io.PrintStream;

import com.yefe.marsrover.model.Rover;

/**
 * This is right command, this is independent rover implementation
 * 
 * @author Yasin EFE
 */
public class RightCommand extends Command {

	public static final String KEY = "R";
	public static final String DESCRIPTION = "rotate right 90 degrees";

	public RightCommand(Rover rover, PrintStream out) {
		super(rover, out);
	}

	@Override
	public void execute() {
		rover.turnRight();
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

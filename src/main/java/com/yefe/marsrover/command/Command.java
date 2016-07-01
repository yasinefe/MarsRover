package com.yefe.marsrover.command;

import java.io.PrintStream;

import com.yefe.marsrover.console.IllegalMovementException;
import com.yefe.marsrover.model.Rover;

/**
 * This is a base class for commands
 * 
 * @author Yasin EFE
 */
public abstract class Command {

	protected Rover rover;
	protected PrintStream out;

	public Command(Rover rover, PrintStream out) {
		this.rover = rover;
		this.out = out;
	}

	/**
	 * Executes sub command class and writes current state
	 */
	public void run() {
		try {
			execute();
		} catch (IllegalMovementException e) {
			out.println("Illegal Movement: " + e.getMessage());
		}
		out.println("Current Location : " + rover.getCurrentX() + "x" + rover.getCurrentY());
		out.println("Current Direction : " + rover.getCurrentDirection().name());
	}

	/**
	 * Execute command
	 * 
	 * @throws IllegalMovementException
	 */
	protected abstract void execute() throws IllegalMovementException;

	/**
	 * @return keyword for this command
	 */
	public abstract String keyword();

	/**
	 * @return description for this command
	 */
	public abstract String description();

}

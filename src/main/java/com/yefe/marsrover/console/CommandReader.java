package com.yefe.marsrover.console;

import java.io.InputStream;
import java.io.PrintStream;

import java.util.Scanner;

/**
 * This is the reader, this reads commands from an input stream via Scanner
 * 
 * @author Yasin EFE
 */
public class CommandReader extends Thread {

	public static final String PROMPT = ">";

	private CommandExecutor commandExecutor;
	private Scanner scanner;
	private PrintStream out;
	private boolean exit = true;

	public CommandReader(CommandExecutor commandExecutor, InputStream in, PrintStream out) {
		this.commandExecutor = commandExecutor;
		this.out = out;
		scanner = new Scanner(in);
	}

	/**
	 * This is the run method of this thread, writes prompt to outline and reads commands and
	 * execute thems
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (exit) {
			out.print(PROMPT);
			String commands = scanner.next();
			commandExecutor.execute(commands);
		}
	}

	/**
	 * Closes the reader
	 */
	public void close() {
		scanner.close();
		exit = false;
	}
}

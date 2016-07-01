package com.yefe.marsrover.command;

import java.io.PrintStream;

import org.junit.Before;
import org.mockito.Mockito;

import com.yefe.marsrover.model.Rover;
import com.yefe.marsrover.util.TestUtil;

public class BaseCommand {

	protected Rover rover;
	protected PrintStream out;

	@Before
	public void baseSetup() {
		rover = Mockito.mock(Rover.class);
		out = TestUtil.createPrintStream();
	}
}

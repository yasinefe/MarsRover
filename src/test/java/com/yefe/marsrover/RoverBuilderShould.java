package com.yefe.marsrover;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.yefe.marsrover.RoverBuilder;
import com.yefe.marsrover.model.Direction;
import com.yefe.marsrover.model.MarsRover;
import com.yefe.marsrover.model.Rover;
import com.yefe.marsrover.util.TestUtil;

public class RoverBuilderShould {

	private InputStream in;
	private PrintStream out;
	private Rover rover;
	private RoverBuilder roverBuilder;

	@Before
	public void setup() {
		// Normally I use mock objects for dependencies but Builder class creates context and I want
		// to see if it creates context properly
		rover = new MarsRover();
		in = TestUtil.createInputStream("FRFLLF");
		out = TestUtil.createPrintStream();
		roverBuilder = new RoverBuilder(in, out, rover);
	}

	/**
	 * This test if RoverBuilder creates context properly.
	 */
	@Test
	public void startRoverBuilderWhenStartIsCalled() throws InterruptedException {
		// When
		roverBuilder.start();

		// Then
		// I know that this does not make sense. But we cannot achieve command reader thread and I
		// dont want to expose outside
		// This checks current direction must be WEST after command execution in 10 seconds, if not
		// anyway this test fails. Of course this is not expected.
		for (int i = 0; i < 100; i++) {
			if (rover.getCurrentDirection() == Direction.WEST) {
				break;
			}
			Thread.sleep(100);
		}
		Assert.assertEquals(Direction.WEST, rover.getCurrentDirection());
	}

	/**
	 * This test if RoverBuilder stop context without any exception.
	 * 
	 * @throws IOException
	 */
	@Test
	public void stopRoverBuilderWhenStopIsCalled() throws InterruptedException, IOException {
		// Given
		// Runs first test and start the context
		startRoverBuilderWhenStartIsCalled();

		// When
		roverBuilder.stop();

		// Then
		Assert.assertEquals(0, in.available());
	}
}

package com.yefe.marsrover.command;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yefe.marsrover.command.Command;
import com.yefe.marsrover.console.IllegalMovementException;
import com.yefe.marsrover.model.Direction;
import com.yefe.marsrover.model.Rover;
import com.yefe.marsrover.util.TestUtil;

public class CommandShould {

	private static final String DESCRIPTION = "DESCRIPTION";
	private static final String KEYWORD = "KEYWORD";

	private int execute;

	private PrintStream out;
	private TestCommand testCommand;
	private Rover rover;
	private int currentX;
	private int currentY;
	private ByteArrayOutputStream byteArrayOutputStream;

	@Before
	public void setup() {
		execute = 0;
		byteArrayOutputStream = new ByteArrayOutputStream();

		out = TestUtil.createPrintStream(byteArrayOutputStream);
		rover = Mockito.mock(Rover.class);
		currentX = TestUtil.getInteger();
		currentY = TestUtil.getInteger();

		Mockito.when(rover.getCurrentX()).thenReturn(currentX);
		Mockito.when(rover.getCurrentY()).thenReturn(currentY);
		Mockito.when(rover.getCurrentDirection()).thenReturn(Direction.EAST);

		testCommand = new TestCommand(rover, out);
	}

	@Test
	public void printInformationAboutIllegalMovementWhenCommandThrowsIllegalMovementException() {
		// Given
		execute = -1;
		// When
		testCommand.run();
		// Then
		Assert.assertTrue(byteArrayOutputStream.toString().contains(
				"Illegal Movement: " + new IllegalMovementException(1, 1).getMessage()));
		Assert.assertTrue(byteArrayOutputStream.toString().contains(
				"Current Location : " + currentY + "x" + currentY));
		Assert.assertTrue(byteArrayOutputStream.toString().contains(
				"Current Direction : " + Direction.EAST.name()));
	}

	@Test
	public void runExecuteAndWriteCurrentSituation() {
		// When
		testCommand.run();
		// Then
		Assert.assertTrue(byteArrayOutputStream.toString().contains(
				"Current Location : " + currentY + "x" + currentY));
		Assert.assertTrue(byteArrayOutputStream.toString().contains(
				"Current Direction : " + Direction.EAST.name()));
		Assert.assertEquals(execute, 1);
	}

	/**
	 * Command is an abstract class so I create stub object for this class. I could create SPY but
	 * using SPY is very complicated. I prefer in this case create a stub. We could use a real
	 * implementation, like forward command
	 */
	class TestCommand extends Command {

		public TestCommand(Rover rover, PrintStream out) {
			super(rover, out);
		}

		@Override
		protected void execute() throws IllegalMovementException {
			if (execute == -1) {
				throw new IllegalMovementException(1, 1);
			}
			execute++;
		}

		@Override
		public String keyword() {
			return KEYWORD;
		}

		@Override
		public String description() {
			return DESCRIPTION;
		}

	}

}

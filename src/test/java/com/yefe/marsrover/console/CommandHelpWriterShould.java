package com.yefe.marsrover.console;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yefe.marsrover.command.Command;
import com.yefe.marsrover.console.CommandHelpWriter;
import com.yefe.marsrover.util.TestUtil;

public class CommandHelpWriterShould {

	private PrintStream out;
	private CommandHelpWriter commandHelpWriter;
	private Command commandX;
	private Command commandY;
	private Command commandZ;
	private ByteArrayOutputStream baos;

	@Before
	public void setup() {
		baos = new ByteArrayOutputStream();
		out = TestUtil.createPrintStream(baos);
		commandHelpWriter = new CommandHelpWriter(out);

		commandX = Mockito.mock(Command.class);
		commandY = Mockito.mock(Command.class);
		commandZ = Mockito.mock(Command.class);

		Mockito.when(commandX.keyword()).thenReturn("X");
		Mockito.when(commandY.keyword()).thenReturn("Y");
		Mockito.when(commandZ.keyword()).thenReturn("Z");
		Mockito.when(commandX.description()).thenReturn("DescX");
		Mockito.when(commandY.description()).thenReturn("DescY");
		Mockito.when(commandZ.description()).thenReturn("DescZ");
	}

	@Test
	public void writeHelpForAllCommands() {
		// Given
		Collection<Command> values = Arrays.asList(commandX, commandY, commandZ);

		// When
		commandHelpWriter.writeHelp(values);

		// Then
		String help = baos.toString();

		Assert.assertTrue(help.contains(CommandHelpWriter.ERROR));
		Assert.assertTrue(help.contains(CommandHelpWriter.TITLE));
		Assert.assertTrue(help.contains("X: DescX"));
		Assert.assertTrue(help.contains("Y: DescY"));
		Assert.assertTrue(help.contains("Z: DescZ"));
	}

	@Test
	public void writeHelpIfListIsEmpty() {
		// Given
		Collection<Command> values = Arrays.asList();

		// When
		commandHelpWriter.writeHelp(values);

		// Then
		String help = baos.toString();

		Assert.assertTrue(help.contains(CommandHelpWriter.ERROR));
		Assert.assertTrue(help.contains(CommandHelpWriter.TITLE));
	}
}

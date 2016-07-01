package com.yefe.marsrover.console;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import com.yefe.marsrover.command.Command;
import com.yefe.marsrover.console.CommandExecutor;
import com.yefe.marsrover.console.CommandHelpWriter;

public class CommandExecutorShould {

	private CommandHelpWriter commandHelpWriter;
	private CommandExecutor commandExecutor;

	private Command commandX;
	private Command commandY;
	private Command commandZ;

	@Before
	public void setup() {
		commandHelpWriter = Mockito.mock(CommandHelpWriter.class);
		commandExecutor = new CommandExecutor(commandHelpWriter);

		commandX = Mockito.mock(Command.class);
		commandY = Mockito.mock(Command.class);
		commandZ = Mockito.mock(Command.class);

		Mockito.when(commandX.keyword()).thenReturn("X");
		Mockito.when(commandY.keyword()).thenReturn("Y");
		Mockito.when(commandZ.keyword()).thenReturn("Z");

		commandExecutor.registerCommand(commandX);
		commandExecutor.registerCommand(commandY);
		commandExecutor.registerCommand(commandZ);
	}

	@Test
	public void executeAllCommandsInString() {
		// When
		commandExecutor.execute("XYZ");
		// Then
		Mockito.verify(commandX).run();
		Mockito.verify(commandY).run();
		Mockito.verify(commandZ).run();
	}

	@Test
	public void doNothingWhenCommandStringIsEmpty() {
		// When
		commandExecutor.execute("");
		// Then
		Mockito.verify(commandX, Mockito.never()).run();
		Mockito.verify(commandY, Mockito.never()).run();
		Mockito.verify(commandZ, Mockito.never()).run();
	}

	@Test
	public void writeHelpWhenCommandStringHasUnknownCommand() {
		// When
		commandExecutor.execute("XAYZ");

		// Then
		// I used matcher to verify collection is properly sent
		ArgumentMatcher<Collection<Command>> matcher = new ArgumentMatcher<Collection<Command>>() {
			@Override
			public boolean matches(Object argument) {
				Collection<Command> commands = (Collection<Command>) argument;
				return commands.contains(commandX) && commands.contains(commandY)
						&& commands.contains(commandZ);
			}
		};

		Mockito.verify(commandHelpWriter).writeHelp(Mockito.argThat(matcher));
		Mockito.verify(commandX, Mockito.never()).run();
		Mockito.verify(commandY, Mockito.never()).run();
		Mockito.verify(commandZ, Mockito.never()).run();
	}
}

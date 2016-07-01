package com.yefe.marsrover.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yefe.marsrover.command.LeftCommand;
import com.yefe.marsrover.console.IllegalMovementException;

public class LeftCommandShould extends BaseCommand {

	private LeftCommand command;

	@Before
	public void setup() {
		command = new LeftCommand(rover, out);
	}

	@Test
	public void executeForwardWhenExecuteIsCalled() throws IllegalMovementException {
		// When
		command.execute();
		// Then
		Mockito.verify(rover).turnLeft();
	}

	@Test
	public void returnKeywordWhenKeyWordIsCalled() {
		Assert.assertEquals(LeftCommand.KEY, command.keyword());
	}

	@Test
	public void returnDescriptionWhenDescriptionIsCalled() {
		Assert.assertEquals(LeftCommand.DESCRIPTION, command.description());
	}

}

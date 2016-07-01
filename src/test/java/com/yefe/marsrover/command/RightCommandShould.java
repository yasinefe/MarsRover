package com.yefe.marsrover.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yefe.marsrover.command.RightCommand;
import com.yefe.marsrover.console.IllegalMovementException;

public class RightCommandShould extends BaseCommand {

	private RightCommand command;

	@Before
	public void setup() {
		command = new RightCommand(rover, out);
	}

	@Test
	public void executeForwardWhenExecuteIsCalled() throws IllegalMovementException {
		// When
		command.execute();
		// Then
		Mockito.verify(rover).turnRight();
	}

	@Test
	public void returnKeywordWhenKeyWordIsCalled() {
		Assert.assertEquals(RightCommand.KEY, command.keyword());
	}

	@Test
	public void returnDescriptionWhenDescriptionIsCalled() {
		Assert.assertEquals(RightCommand.DESCRIPTION, command.description());
	}

}

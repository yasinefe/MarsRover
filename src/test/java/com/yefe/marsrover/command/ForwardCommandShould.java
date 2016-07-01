package com.yefe.marsrover.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yefe.marsrover.command.ForwardCommand;
import com.yefe.marsrover.console.IllegalMovementException;

public class ForwardCommandShould extends BaseCommand {

	private ForwardCommand command;

	@Before
	public void setup() {
		command = new ForwardCommand(rover, out);
	}

	@Test
	public void executeForwardWhenExecuteIsCalled() throws IllegalMovementException {
		// When
		command.execute();
		// Then
		Mockito.verify(rover).forward();
	}

	@Test
	public void returnKeywordWhenKeyWordIsCalled() {
		Assert.assertEquals(ForwardCommand.KEY, command.keyword());
	}

	@Test
	public void returnDescriptionWhenDescriptionIsCalled() {
		Assert.assertEquals(ForwardCommand.DESCRIPTION, command.description());
	}

}

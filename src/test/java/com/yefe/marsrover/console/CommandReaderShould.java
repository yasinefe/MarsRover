package com.yefe.marsrover.console;

import java.io.InputStream;
import java.io.PrintStream;

import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.yefe.marsrover.console.CommandExecutor;
import com.yefe.marsrover.console.CommandReader;
import com.yefe.marsrover.util.TestUtil;

public class CommandReaderShould {

	private CommandExecutor commandExecutor;
	private InputStream in;
	private PrintStream out;
	private CommandReader commandReader;
	private String command1;
	private String command2;

	@Before
	public void setup() {
		commandExecutor = Mockito.mock(CommandExecutor.class);
		command1 = "XYZ";
		command2 = "DEF";
		in = TestUtil.createInputStream(command1 + "\n" + command2);
		out = TestUtil.createPrintStream();
		commandReader = new CommandReader(commandExecutor, in, out);
	}

	@Test
	public void executeCommand() {
		// When
		try {
			commandReader.run();
		} catch (NoSuchElementException e) {
			// Suppressed becuase of scanner waits more data but we use predefined byte array stream
		}
		// Then
		Mockito.verify(commandExecutor).execute(command1);
		Mockito.verify(commandExecutor).execute(command2);
	}

	@Test
	public void closeScannerAndExit() throws InterruptedException {
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(1);
		Mockito.doAnswer(new Answer<Object>() {

			public Object answer(InvocationOnMock invocation) throws Throwable {
				// Complete start
				start.countDown();
				// Wait for close is called
				done.await();
				Thread.sleep(500);
				return null;
			}
		}).when(commandExecutor).execute(command1);

		// When
		try {
			commandReader.start();
		} catch (NoSuchElementException e) {
			// Suppressed becuase of scanner waits more data but we use predefined byte array stream
		}
		// Wait for thread is started
		start.await();
		commandReader.close();
		// Complete done
		done.countDown();

		// Then
		Mockito.verify(commandExecutor).execute(command1);
		Mockito.verify(commandExecutor, Mockito.never()).execute(command2);
	}
}

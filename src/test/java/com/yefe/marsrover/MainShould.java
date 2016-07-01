package com.yefe.marsrover;

import org.junit.Test;

import com.yefe.marsrover.Main;

/**
 * This class very basic and just test main class is correctly run without any exception
 * 
 * @author Yasin EFE
 */
public class MainShould {

	@Test
	public void createRoverBuilderAndStartItWithoutAnyException() {
		Main.main(null);
		Main.marsRoverBuilder.stop();
	}

}

package com.yefe.marsrover;

import com.yefe.marsrover.model.MarsRover;
import com.yefe.marsrover.model.Rover;

/**
 * This class is used to run MarsRover implementation
 * 
 * @author Yasin EFE
 */
public class Main {

	public static RoverBuilder marsRoverBuilder;

	public static void main(String[] args) {
		Rover rover = new MarsRover();
		// You can create with initial coordinate and initial direction.
		// Rover rover = new MarsRover(new Coordinate(2, 2), Direction.SOUTH);

		marsRoverBuilder = new RoverBuilder(System.in, System.out, rover);
		marsRoverBuilder.start();
	}

}

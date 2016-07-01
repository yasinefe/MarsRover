package com.yefe.marsrover.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.yefe.marsrover.console.IllegalMovementException;
import com.yefe.marsrover.model.Direction;
import com.yefe.marsrover.model.MarsRover;

public class MarsRoverShould {

	private MarsRover marsRover;
	private int initialX;
	private int initialY;
	private Direction initialDirection;
	private int xSize;
	private int ySize;

	@Before
	public void setup() {
		initialX = 0;
		initialY = 0;
		initialDirection = Direction.NORTH;
		xSize = 5;
		ySize = 5;
	}

	@Test
	public void forwardOnYAxisWhenForwardIsCalledAndCurrentDirectionIsNorth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, initialDirection, xSize, ySize);
		// When
		marsRover.forward();
		// Then
		assertMarsRover(initialX, initialY + 1, initialDirection);
	}

	@Test
	public void forwardOnXAxisWhenForwardIsCalledAndCurrentDirectionIsEast()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.EAST, xSize, ySize);
		// When
		marsRover.forward();
		// Then
		assertMarsRover(initialX + 1, initialY, Direction.EAST);
	}

	@Test
	public void backwardOnXAxisWhenForwardIsCalledAndCurrentDirectionIsWest()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(1, initialY, Direction.WEST, xSize, ySize);
		// When
		marsRover.forward();
		// Then
		assertMarsRover(0, initialY, Direction.WEST);
	}

	@Test
	public void backwardOnYAxisWhenForwardIsCalledAndCurrentDirectionIsSouth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, 1, Direction.SOUTH, xSize, ySize);
		// When
		marsRover.forward();
		// Then
		assertMarsRover(initialX, 0, Direction.SOUTH);
	}

	@Test(expected = IllegalMovementException.class)
	public void throwIllegalMovementExceptionWhenForwardIsCalledAndCurrentDirectionIsNorth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, 4, initialDirection, xSize, ySize);
		// When
		marsRover.forward();
	}

	@Test(expected = IllegalMovementException.class)
	public void throwIllegalMovementExceptionWhenForwardIsCalledAndCurrentDirectionIsEast()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(4, initialY, Direction.EAST, xSize, ySize);
		// When
		marsRover.forward();
	}

	@Test(expected = IllegalMovementException.class)
	public void throwIllegalMovementExceptionWhenForwardIsCalledAndCurrentDirectionIsSouth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.SOUTH, xSize, ySize);
		// When
		marsRover.forward();
	}

	@Test(expected = IllegalMovementException.class)
	public void throwIllegalMovementExceptionWhenForwardIsCalledAndCurrentDirectionIsWest()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.WEST, xSize, ySize);
		// When
		marsRover.forward();
	}

	@Test
	public void turnDirectionToWestWhenTurnLeftIsCalledAndCurrentDirectionIsNorth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, initialDirection, xSize, ySize);
		// When
		marsRover.turnLeft();
		// Then
		assertMarsRover(initialX, initialY, Direction.WEST);
	}

	@Test
	public void turnDirectionToSouthWhenTurnLeftIsCalledAndCurrentDirectionIsWest()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.WEST, xSize, ySize);
		// When
		marsRover.turnLeft();
		// Then
		assertMarsRover(initialX, initialY, Direction.SOUTH);
	}

	@Test
	public void turnDirectionToEastWhenTurnLeftIsCalledAndCurrentDirectionIsSouth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.SOUTH, xSize, ySize);
		// When
		marsRover.turnLeft();
		// Then
		assertMarsRover(initialX, initialY, Direction.EAST);
	}

	@Test
	public void turnDirectionToNorthWhenTurnLeftIsCalledAndCurrentDirectionIsEast()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.EAST, xSize, ySize);
		// When
		marsRover.turnLeft();
		// Then
		assertMarsRover(initialX, initialY, Direction.NORTH);
	}

	@Test
	public void turnDirectionToEastWhenTurnRightIsCalledAndCurrentDirectionIsNorth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, initialDirection, xSize, ySize);
		// When
		marsRover.turnRight();
		// Then
		assertMarsRover(initialX, initialY, Direction.EAST);
	}

	@Test
	public void turnDirectionToSouthWhenTurnRightIsCalledAndCurrentDirectionIsEast()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.EAST, xSize, ySize);
		// When
		marsRover.turnRight();
		// Then
		assertMarsRover(initialX, initialY, Direction.SOUTH);
	}

	@Test
	public void turnDirectionToWestWhenTurnRightIsCalledAndCurrentDirectionIsSouth()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.SOUTH, xSize, ySize);
		// When
		marsRover.turnRight();
		// Then
		assertMarsRover(initialX, initialY, Direction.WEST);
	}

	@Test
	public void turnDirectionToNorthWhenTurnRightIsCalledAndCurrentDirectionIsWest()
			throws IllegalMovementException {
		// Given
		marsRover = new MarsRover(initialX, initialY, Direction.WEST, xSize, ySize);
		// When
		marsRover.turnRight();
		// Then
		assertMarsRover(initialX, initialY, Direction.NORTH);
	}

	private void assertMarsRover(int currentX, int currentY, Direction currentDirection) {
		Assert.assertEquals(currentX, marsRover.getCurrentX());
		Assert.assertEquals(currentY, marsRover.getCurrentY());
		Assert.assertEquals(currentDirection, marsRover.getCurrentDirection());
	}
}

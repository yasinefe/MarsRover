package com.yefe.marsrover.model;

import com.yefe.marsrover.console.IllegalMovementException;

/**
 * This is the Mars implementation of Rover.
 * 
 * @author Yasin EFE
 */
public class MarsRover implements Rover {

	private int currentX;
	private int currentY;

	private Direction currentDirection;

	private int xSize;
	private int ySize;

	/**
	 * Creates MarsRover object with default parameters. These parameters are required by Test
	 */
	public MarsRover() {
		this(0, 0, Direction.NORTH, 5, 5);
	}

	/**
	 * Creates MarsRover with given parameters.
	 * 
	 * @param initialX
	 * @param initialY
	 * @param intialDirection
	 * @param xSize
	 * @param ySize
	 */
	public MarsRover(int initialX, int initialY, Direction intialDirection, int xSize, int ySize) {
		currentX = initialX;
		currentY = initialY;
		currentDirection = intialDirection;
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public void forward() throws IllegalMovementException {
		move(1);
	}

	/**
	 * Move according to movement size and direction
	 * 
	 * @param movement
	 * @throws IllegalMovementException
	 */
	private void move(int movement) throws IllegalMovementException {
		switch (currentDirection) {
		case NORTH:
			checkMovement(currentY, movement, ySize);
			currentY += movement;
			break;
		case SOUTH:
			checkMovement(currentY, -1 * movement, ySize);
			currentY -= movement;
			break;
		case EAST:
			checkMovement(currentX, movement, xSize);
			currentX += movement;
			break;
		case WEST:
			checkMovement(currentX, -1 * movement, xSize);
			currentX -= movement;
			break;
		}
	}

	/**
	 * Check if this movement will cause to go outside of grid
	 * 
	 * @param current
	 * @param movement
	 * @param size
	 * @throws IllegalMovementException
	 */
	private void checkMovement(int current, int movement, int size) throws IllegalMovementException {
		if (current + movement < 0 || current + movement >= size) {
			throw new IllegalMovementException(xSize, ySize);
		}
	}

	public void turnLeft() {
		switch (currentDirection) {
		case NORTH:
			currentDirection = Direction.WEST;
			break;
		case SOUTH:
			currentDirection = Direction.EAST;
			break;
		case EAST:
			currentDirection = Direction.NORTH;
			break;
		case WEST:
			currentDirection = Direction.SOUTH;
			break;
		}
	}

	public void turnRight() {
		switch (currentDirection) {
		case NORTH:
			currentDirection = Direction.EAST;
			break;
		case SOUTH:
			currentDirection = Direction.WEST;
			break;
		case EAST:
			currentDirection = Direction.SOUTH;
			break;
		case WEST:
			currentDirection = Direction.NORTH;
			break;
		}
	}

	public int getCurrentX() {
		return currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

}

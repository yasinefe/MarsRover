package com.yefe.marsrover.model;

import com.yefe.marsrover.console.IllegalMovementException;

/**
 * This interface is used to make different Rover implementations This contains basic movement
 * methods and current state methods
 * 
 * @author Yasin EFE
 */
public interface Rover {

	/**
	 * Move forward accotding to direction, if this movement will cuase to go outside of grid throw
	 * IllegalMovementException
	 * 
	 * @throws IllegalMovementException
	 */
	void forward() throws IllegalMovementException;

	void turnLeft();

	void turnRight();

	int getCurrentX();

	int getCurrentY();

	Direction getCurrentDirection();

}

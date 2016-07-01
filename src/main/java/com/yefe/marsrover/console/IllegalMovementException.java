package com.yefe.marsrover.console;

public class IllegalMovementException extends Exception {

	private static final long serialVersionUID = -1912450643102528052L;

	public IllegalMovementException(int xSize, int ySize) {
		super("This movement is not acceptable. You have to move in given grid. 0x0, " + (xSize - 1) + "x" + (ySize - 1));
	}
}

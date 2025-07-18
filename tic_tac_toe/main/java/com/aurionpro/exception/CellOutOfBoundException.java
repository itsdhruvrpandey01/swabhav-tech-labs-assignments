package com.aurionpro.exception;

public class CellOutOfBoundException extends Exception{
	public String getMessage() {
		return "rows and columns must be between 0 - 2";
	}
}

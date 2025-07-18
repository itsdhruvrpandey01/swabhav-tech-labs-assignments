package com.aurionpro.exception;

public class CellAlreadyTakeException extends Exception{
	public String getMessage() {
		return "Cell Already Taken";
	}
}

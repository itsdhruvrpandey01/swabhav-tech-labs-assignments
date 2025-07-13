package com.aurionpro.exception.model;

public class OperationFailedException extends Exception{
	public String getMessage() {
		return "❌ Operation Failed";
	}
}

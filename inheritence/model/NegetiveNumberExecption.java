package com.aurionpro.inheritence.model;

public class NegetiveNumberExecption extends RuntimeException{
	
	public NegetiveNumberExecption() {
		
	}
	public String getMessage() {
		return "Number Must be greater than 0";
	}
}

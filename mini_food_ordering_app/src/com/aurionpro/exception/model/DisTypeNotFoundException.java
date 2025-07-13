package com.aurionpro.exception.model;

public class DisTypeNotFoundException extends Exception{
	public String getMessage() {
		return"❌ Dish Type Not Found Please Enter Valid Dish Type";
	}
}

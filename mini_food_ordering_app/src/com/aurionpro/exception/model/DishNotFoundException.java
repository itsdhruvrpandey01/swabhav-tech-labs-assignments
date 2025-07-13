package com.aurionpro.exception.model;

public class DishNotFoundException extends Exception{
	public String getMessage() {
		return"❌ Dish Not Found Please Enter Valid Id";
	}
}

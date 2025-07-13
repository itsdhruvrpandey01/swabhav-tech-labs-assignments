package com.aurionpro.model;

import java.io.Serializable;

public class Dish implements Serializable{
	private double dishPrice;
	private String dishName;
	private IdishType dishType;
	
	public Dish(double dishPrice, String dishName, IdishType dishType) {
		super();
		this.dishPrice = dishPrice;
		this.dishName = dishName;
		this.dishType = dishType;
	}
	public String getDishName() {
		return this.dishName;
	}
	public double getDishPrice() {
		return this.dishPrice;
	}
	public IdishType getDishType() {
		return this.dishType;
	}
	
}

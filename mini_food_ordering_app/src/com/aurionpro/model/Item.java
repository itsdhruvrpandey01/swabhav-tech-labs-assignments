package com.aurionpro.model;

import java.io.Serializable;

public class Item implements Serializable{
	private Dish dish;
	private double quantity;
	private double itemCost;
	
	public Item(Dish dish, double quantity,double itemCost) {
		super();
		this.dish = dish;
		this.quantity = quantity;
		this.itemCost = itemCost;
	}
	public double getItemQuantity() {
		return this.quantity;
	}
	public Dish getDish() {
		return this.dish;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getQuantity() {
		return this.quantity;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	public double getItemCost() {
		return this.itemCost;
	}
}

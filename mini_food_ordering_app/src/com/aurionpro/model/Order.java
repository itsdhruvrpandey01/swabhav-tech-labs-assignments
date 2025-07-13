package com.aurionpro.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	private int orderId;
	private List<Item> foodItems;
	private DeliveryPartner deliveryPartner;
	private Payment payment;
	private double total;
	public Order(int orderId, List<Item> foodItems,DeliveryPartner deliveryPartner,double total,Payment payment) {
		super();
		this.orderId = orderId;
		this.foodItems = foodItems;
		this.deliveryPartner = deliveryPartner;
		this.total = total;
		this.payment = payment;
	}
	public int getOrderId() {
		return orderId;
	}
	public List<Item> getFoodItems() {
		return foodItems;
	}
	public DeliveryPartner getDeliveryPartner() {
		return deliveryPartner;
	}
	public double getTotal() {
		return total;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}
	
}

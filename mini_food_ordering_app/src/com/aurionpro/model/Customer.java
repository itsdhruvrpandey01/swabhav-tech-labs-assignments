package com.aurionpro.model;

import java.io.Serializable;

public class Customer implements Serializable{
	private int customerId;
	private String customerName;
	private Order order;
	
	public Customer(int customerId, String customerName, Order order) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.order = order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Order getOrder() {
		return order;
	}
	
}

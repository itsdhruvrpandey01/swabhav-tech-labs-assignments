package com.aurionpro.model;

import java.io.Serializable;

public class Invoice implements Serializable{
	private int invoiceId;
	private Order order;
	
	public Order getOrder() {
		return order;
	}

	public Invoice(int invoiceId, Order order) {
		super();
		this.invoiceId = invoiceId;
		this.order = order;
	}
	
}

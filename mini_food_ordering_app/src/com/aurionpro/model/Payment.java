package com.aurionpro.model;

import java.io.Serializable;

import com.aurionpro.payment.method.model.IPayment;

public class Payment implements Serializable{
	private double amount;
	private IPayment paymentType;
	
	public double getAmount() {
		return amount;
	}


	public IPayment getPaymentType() {
		return paymentType;
	}

	public Payment(double amount, IPayment paymentType) {
		super();
		this. amount = amount;
		this.paymentType = paymentType;
	}
	
}

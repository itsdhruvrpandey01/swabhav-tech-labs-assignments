package com.aurionpro.exception.model;

public class PaymentMethodNotFoundException extends Exception{
	public String getMessage() {
		return "❌ Invalid payment choice";
	}
}

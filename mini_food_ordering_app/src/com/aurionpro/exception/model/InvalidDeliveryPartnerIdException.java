package com.aurionpro.exception.model;

public class InvalidDeliveryPartnerIdException extends Exception{
	public String getMessage() {
		return "❌ Invalid Partner Id";
	}
}

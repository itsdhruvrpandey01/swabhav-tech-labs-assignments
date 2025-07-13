package com.aurionpro.exception.model;

public class InvoiceNotFoundException extends Exception{
	public String getMessage() {
		return "❌ Invoice not found";
	}
}

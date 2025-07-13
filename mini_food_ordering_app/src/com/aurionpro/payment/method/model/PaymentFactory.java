package com.aurionpro.payment.method.model;

public class PaymentFactory {

	public static IPayment givePayMentType(int paymentChoice) {
		if(paymentChoice == 1) {
			return new UPI();
		}
		if(paymentChoice == 2) {
			return new DebitCard();
		}
		if(paymentChoice == 3) {
			return new CreditCard();
		}
		if(paymentChoice == 4) {
			return new Cash();
		}
		return null;
	}
	
}

package com.aurionpro.controller.model;

import java.util.Scanner;

import com.aurionpro.exception.model.InvalidCredintialsException;
import com.aurionpro.exception.model.PaymentMethodNotFoundException;
import com.aurionpro.model.Payment;
import com.aurionpro.payment.method.model.IPayment;
import com.aurionpro.payment.method.model.PaymentFactory;
import com.aurionpro.payment.method.model.ValidatePayment;

public class PaymentController {

	public static Payment givePayment(double amount,Scanner scanner) {
		try {
			System.out.println("=====================================================");
			System.out.println("            💳 Choose a Payment Method");
			System.out.println("=====================================================");
			System.out.println("  1️  UPI");
			System.out.println("  2️  Debit Card");
			System.out.println("  3️  Credit Card");
			System.out.println("  4️  Cash on Delivery");
			System.out.println("-----------------------------------------------------");
			System.out.print("👉 Please enter your choice (1-4): ");

		int selectedPaymentNumber = scanner.nextInt();
		IPayment payment = PaymentFactory.givePayMentType(selectedPaymentNumber);
		if(payment == null) throw new PaymentMethodNotFoundException();
		doPayment(payment,scanner);
		return new Payment(amount,payment);
		}catch(PaymentMethodNotFoundException paymentMethodNotFoundException) {
			System.out.println(paymentMethodNotFoundException.getMessage());
		}
		return null;
	}
	private static void doPayment(IPayment payment,Scanner scanner) {
		boolean paymentDone = false;
		while(!paymentDone) {
			if(payment.givePaymentTypeName().equals("UPI")) {
				paymentDone = ValidatePayment.UPI(scanner);
			}
			if(payment.givePaymentTypeName().equals("CreditCard")) {
				paymentDone = ValidatePayment.CreditCard(scanner);
			}
			if(payment.givePaymentTypeName().equals("DebitCard")) {
				paymentDone = ValidatePayment.DebitCard(scanner);
			}
			if(payment.givePaymentTypeName().equals("Cash")) {
				paymentDone = true;
			}
			try {
			if(!paymentDone) {
				throw new InvalidCredintialsException();
			}
			}catch (InvalidCredintialsException invalidException) {
				System.out.println(invalidException.getMessage());
			}
		}
	}
	
}

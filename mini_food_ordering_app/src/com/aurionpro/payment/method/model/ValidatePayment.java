package com.aurionpro.payment.method.model;

import java.util.Scanner;

public class ValidatePayment {
	public static boolean UPI(Scanner scanner) {
		UPIValidator upiValidator = new UPIValidator();
		return upiValidator.validate(scanner);
	}
	public static boolean CreditCard(Scanner scanner) {
		CardValidator cardValidator = new CardValidator();
		return cardValidator.validate(scanner);
	}
	public static boolean DebitCard(Scanner scanner) {
		CardValidator cardValidator = new CardValidator();
		return cardValidator.validate(scanner);
	}
}

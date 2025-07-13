package com.aurionpro.payment.method.model;

import java.time.LocalDate;
import java.util.Scanner;

public class CardValidator implements IPaymentValidate {
	private static LocalDate localDate = LocalDate.now();
	private static int currentMonth = localDate.getMonthValue();
	private static int currentYear = localDate.getYear();

	@Override
	public boolean validate(Scanner scanner) {
		System.out.println("=====================================================================");
		System.out.println("                          💳 Card Payment Details");
		System.out.println("=====================================================================");

		System.out.print("👉 Enter Card Number (16 digits): ");
		String debitCardNumber = scanner.next();

		System.out.print("👉 Enter CVV (3 digits): ");
		String cvv = scanner.next();

		System.out.print("👉 Enter Expiry Month (MM): ");
		int expiryMonth = scanner.nextInt();

		System.out.print("👉 Enter Expiry Year (YYYY): ");
		int expiryYear = scanner.nextInt();
		
		return validateCard(debitCardNumber, cvv, expiryMonth, expiryYear);
	}
	public boolean validateCard(String debitCardNumber, String cv, int expiryMonth,int expiryYear) {
		boolean correctDetails = true;
		if(!(checkCardNumberLength(debitCardNumber))){
			System.out.println("Card Number Must be 16 digit long");
			correctDetails = false;
		}
		if(!(checkCvvLength(cv))) {
			System.out.println("Cvv must be of 3 digit length only");
			correctDetails = false;
		}
		if(!(checkDateAndYear(expiryMonth, expiryYear))) {
			System.out.println("Invalid Month and Year");
			correctDetails = false;
		}
		return correctDetails;
	}

	private boolean checkCardNumberLength(String cardNumber) {
		try {
			double carNumberDigits = Double.parseDouble(cardNumber);	
		}catch(NumberFormatException exception) {
			System.out.println("Must be a number");
			return false;
		}
		return cardNumber.length() == 16;
	}
	private boolean checkCvvLength(String cvv) {
		return cvv.length() == 3;
	}
	private boolean checkDateAndYear(int month,int year) {
		if(month<0 || month>12) {
			return false;
		}
		if(month<currentMonth && year<=currentYear) {
			return false;
		}
		return true;
	}

}

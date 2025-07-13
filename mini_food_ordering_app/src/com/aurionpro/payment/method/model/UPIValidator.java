package com.aurionpro.payment.method.model;

import java.util.Scanner;


public class UPIValidator implements IPaymentValidate{

	@Override
	public boolean validate(Scanner scanner){
		System.out.println("👉 Please Enter UPI Id:");
		String upiId = scanner.next();
		if(upiId == null) return false;
		if(!( upiId.endsWith("@sbi")
			||upiId.endsWith("@okicici")
			||upiId.endsWith("@hdfc")
			||upiId.endsWith("@boi")
			||upiId.endsWith("@paytm"))){
			System.out.println("Invalid UPI ID");
			return false;
		}
		return true;
	}

}

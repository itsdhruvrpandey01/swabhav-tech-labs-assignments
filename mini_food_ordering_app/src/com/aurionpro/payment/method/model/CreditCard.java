package com.aurionpro.payment.method.model;

import java.io.Serializable;
import java.util.Scanner;

public class CreditCard implements IPayment,Serializable{
	@Override
	public String givePaymentTypeName() {
		return "CreditCard";
	}


}

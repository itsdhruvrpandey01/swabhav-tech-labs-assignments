package com.aurionpro.payment.method.model;

import java.io.Serializable;

public class UPI implements IPayment,Serializable{

	@Override
	public String givePaymentTypeName() {
		return "UPI";
	}


}

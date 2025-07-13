package com.aurionpro.payment.method.model;

import java.io.Serializable;

public class DebitCard implements IPayment,Serializable {

	@Override
	public String givePaymentTypeName() {
		// TODO Auto-generated method stub
		return "DebitCard";
	}

}

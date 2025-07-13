package com.aurionpro.payment.method.model;

import java.io.Serializable;

public class Cash implements IPayment,Serializable {

	@Override
	public String givePaymentTypeName() {
		return "Cash";
	}

}

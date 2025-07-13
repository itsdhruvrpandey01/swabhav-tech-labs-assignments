package com.aurionpro.delivery.partner.model;

import java.io.Serializable;

public class Zomato implements IDeliveryPartner,Serializable {

	@Override
	public String getDeliveryCompanyName() {
		return "Zomato";
	}

}

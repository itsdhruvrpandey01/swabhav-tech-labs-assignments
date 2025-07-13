package com.aurionpro.delivery.partner.model;

import java.io.Serializable;

public class Swiggy implements IDeliveryPartner,Serializable{

	@Override
	public String getDeliveryCompanyName() {
		return "Swiggy";
	}

}

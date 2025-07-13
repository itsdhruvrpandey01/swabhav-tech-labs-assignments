package com.aurionpro.model;

import java.io.Serializable;

import com.aurionpro.delivery.partner.model.IDeliveryPartner;

public class DeliveryPartner implements Serializable{
	private int deliveryPersonId;
	private String deliveryPersonName;
	private IDeliveryPartner deliveryPartner;
	
	public DeliveryPartner(int deliveryPersonId, String deliveryPersonName, IDeliveryPartner deliveryPartner) {
		this.deliveryPersonId = deliveryPersonId;
		this.deliveryPersonName = deliveryPersonName;
		this.deliveryPartner = deliveryPartner;
	}

	public int getDeliveryPersonId() {
		return deliveryPersonId;
	}

	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public IDeliveryPartner getDeliveryPartner() {
		return deliveryPartner;
	}
	
}

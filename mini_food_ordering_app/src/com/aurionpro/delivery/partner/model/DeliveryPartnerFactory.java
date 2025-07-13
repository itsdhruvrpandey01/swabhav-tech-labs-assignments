package com.aurionpro.delivery.partner.model;

public class DeliveryPartnerFactory {
	public static IDeliveryPartner getDeliveryPartner(int choice) {
		if(choice == 1) {
			return new Zomato();
		}
		if(choice == 2) {
			return new Swiggy();
		}
		return null;
	}
}

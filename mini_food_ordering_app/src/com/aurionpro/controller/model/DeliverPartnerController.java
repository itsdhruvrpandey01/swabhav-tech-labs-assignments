package com.aurionpro.controller.model;
import com.aurionpro.delivery.partner.model.DeliveryPartnerFactory;
import com.aurionpro.delivery.partner.model.IDeliveryPartner;
import com.aurionpro.exception.model.InvalidDeliveryPartnerIdException;
import com.aurionpro.exception.model.PaymentMethodNotFoundException;
import com.aurionpro.model.DeliveryPartner;

public class DeliverPartnerController {
	public static DeliveryPartner getDeliveryPartner() {
		int randomDeliveryId =(int) Math.random()*2+1;
		String DeliveryPersonName = null;
		if(randomDeliveryId == 1) {
			DeliveryPersonName = "Vinay Gajula";
		}
		if(randomDeliveryId == 2) {
			DeliveryPersonName = "LokeshOtti";
		}
		
		return new DeliveryPartner(randomDeliveryId, DeliveryPersonName, DeliveryPartnerFactory.getDeliveryPartner(randomDeliveryId));
	}
	public static DeliveryPartner getDeliveryPartner(int deliveryPartnerId) throws InvalidDeliveryPartnerIdException{
		String DeliveryPersonName = null;
		if(deliveryPartnerId == 1) {
			DeliveryPersonName = "Vinay Gajula";
		}
		if(deliveryPartnerId == 2) {
			DeliveryPersonName = "LokeshOtti";
		}
		IDeliveryPartner idelivery = DeliveryPartnerFactory.getDeliveryPartner(deliveryPartnerId);
		if(idelivery == null) {
			throw new InvalidDeliveryPartnerIdException();
		}
		DeliveryPartner partner = new DeliveryPartner(deliveryPartnerId, DeliveryPersonName,idelivery );
		return partner;
	}
}

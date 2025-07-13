package com.aurionpro.controller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.discount.model.DiscountFactory;
import com.aurionpro.exception.model.OperationFailedException;
import com.aurionpro.model.Item;
import com.aurionpro.model.Order;
import com.aurionpro.model.Payment;

public class OrderController {

	public static Order placeOrder(int orderId,List<Item> listItems,Scanner scanner) throws OperationFailedException{
		double total = 0;
		for(Item item:listItems) {
			total+=item.getDish().getDishPrice()*item.getQuantity();
		}
		double finalTotal = total - total*DiscountFactory.giveDiscountType(total).giveDiscount()/100;
		Payment payment = PaymentController.givePayment(finalTotal,scanner);
		if(payment == null) throw new OperationFailedException();
		return new Order(orderId,new ArrayList<>( listItems), DeliverPartnerController.getDeliveryPartner(),finalTotal,payment);
	}
}

package com.aurionpro.discount.model;

public class DiscountFactory {
	public static Idiscount giveDiscountType(double total) {
		if(total>500) {
			return new FlatDiscount();
		}
		return new NoDiscount();
	}
}

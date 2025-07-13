package com.aurionpro.discount.model;

public class FlatDiscount implements Idiscount {
	private static final double discountPercent = 5;

	@Override
	public double giveDiscount() {
		return this.discountPercent;
	}

}

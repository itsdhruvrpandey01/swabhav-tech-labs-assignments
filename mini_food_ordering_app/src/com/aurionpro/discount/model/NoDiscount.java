package com.aurionpro.discount.model;

public class NoDiscount implements Idiscount {

	@Override
	public double giveDiscount() {
		return 0;
	}

}

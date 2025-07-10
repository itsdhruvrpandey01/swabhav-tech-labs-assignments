package com.aurionpro.inheritence.model;

public class MinimumAmountLimitReachedException extends RuntimeException{
	
	private int withrawAbleAmount;

	public MinimumAmountLimitReachedException(int withrawAbleAmount) {
		super();
		this.withrawAbleAmount = withrawAbleAmount;
	}
	public String getMessage() {
		return "Mininum amount limit reached. You can Withraw upto "+withrawAbleAmount;
	}
}

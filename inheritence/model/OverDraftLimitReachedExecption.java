package com.aurionpro.inheritence.model;

public class OverDraftLimitReachedExecption extends RuntimeException{

	private int withrawAbleAmount;

	public OverDraftLimitReachedExecption(int withrawAbleAmount) {
		super();
		this.withrawAbleAmount = withrawAbleAmount;
	}
	public String getMessage() {
		return "Over Draft Limit Reached. You can Withraw upto "+withrawAbleAmount;
	}
}

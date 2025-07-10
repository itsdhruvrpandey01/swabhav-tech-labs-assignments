package com.aurionpro.inheritence.model;

public class CurrentAccount extends Accounts{
	private int over_draft_limit;

	public CurrentAccount(String accountNumber, int balance, String name,int over_draft_limit) {
		super(accountNumber, balance, name);
		this.over_draft_limit = over_draft_limit;
	}
	@Override
	public void debitAmount(int amount) {
		if(amount<0) {
			throw new NegetiveNumberExecption();
		}
		int withrawAbleAmount = balance + over_draft_limit;
		if( amount > withrawAbleAmount) {
			throw new OverDraftLimitReachedExecption(withrawAbleAmount);
		}
		balance-=amount;
		displayBalance();
	}
	public void displayBalance() {
		int withrawAbleAmount = balance + over_draft_limit;
		if(balance<0) {
			System.out.println("Current Balance : 0");
			System.out.println("Over Draft Avaialble upto "+withrawAbleAmount);
			return;
		}
		System.out.println("Current Balance : "+balance);
		System.out.println("You can withraw upto "+withrawAbleAmount);
		
	}
	@Override
	public void creditAmount(int amount) {
		if(amount<0) {
			throw new NegetiveNumberExecption();
		}
		balance+=amount;
		displayBalance();
	}
}

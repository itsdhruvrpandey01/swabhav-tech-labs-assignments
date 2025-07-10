package com.aurionpro.inheritence.model;

public class SavingAccounts extends Accounts{
	private static int min_balance = 5000;
	public SavingAccounts(String accountNumber, int balance, String name) {
		super(accountNumber, balance, name);
	}
	public void debitAmount(int amount) {
		if(amount<0) {
			throw new NegetiveNumberExecption();
		}
		int withrawAbleAmount = balance-min_balance;
		if((amount)>withrawAbleAmount) {
			throw new MinimumAmountLimitReachedException(withrawAbleAmount);
		}
		balance-=amount;
		displayBalance();
	}
	public static int getMinBalance() {
		return min_balance;
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

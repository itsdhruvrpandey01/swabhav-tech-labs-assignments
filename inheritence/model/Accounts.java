package com.aurionpro.inheritence.model;

public abstract class Accounts {
	private String accountNumber;
	protected int balance;
	private String name;
	public Accounts(String accountNumber, int balance, String name) {
		this.accountNumber = accountNumber;
		if(balance<0) {
			throw new NegetiveNumberExecption();
		}
		this.balance = balance;
		this.name = name;
	}
	@Override
	public String toString() {
		return "accountNumber=" + accountNumber + ", balance=" + balance + ", name=" + name;
	}
	public void displayBalance() {
		System.out.println("Your Current Balance is :"+balance);
	}
	public abstract void creditAmount(int amount); 
	public abstract void debitAmount(int amount);
	
}

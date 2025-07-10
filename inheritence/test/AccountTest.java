package com.aurionpro.inheritence.test;

import java.util.Scanner;

import com.aurionpro.inheritence.model.Accounts;
import com.aurionpro.inheritence.model.CurrentAccount;
import com.aurionpro.inheritence.model.MinimumAmountLimitReachedException;
import com.aurionpro.inheritence.model.NegetiveNumberExecption;
import com.aurionpro.inheritence.model.OverDraftLimitReachedExecption;
import com.aurionpro.inheritence.model.SavingAccounts;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Name :");
		String name = scanner.next();
		System.out.println("Specify the type of account you want");
		System.out.println("Type 1 for Current else Type 2 for Savings");
		int type = scanner.nextInt();
		if(type == 1) {
			doOperateCurrentAccount(name,scanner);
		}
		if(type == 2) {
			doOperateSavingAccount(name,scanner);
		}
	}
	private static void doOperateCurrentAccount(String name,Scanner scanner) {
		int over_draft_limit = -1;
		while(over_draft_limit<0) {
			System.out.println("Enter over draft limit it must be positive number");
			over_draft_limit = scanner.nextInt();
		}
		String accNumber = generateAccountNumber();
		CurrentAccount currentAccount = new CurrentAccount(accNumber, 0,name, over_draft_limit);
		int choice = 0;
		while(choice!=4) {
			displayOptions();
			choice = scanner.nextInt();
			handleCurrentAccount(choice,currentAccount,scanner);
		}
	}
	
	private static void doOperateSavingAccount(String name,Scanner scanner) {
		String accNumber = generateAccountNumber();
		int initialAmount = scanner.nextInt();
		int minAmount = SavingAccounts.getMinBalance();
		while(initialAmount<minAmount) {
			System.out.println("Amount must not be atleast "+minAmount);
			initialAmount = scanner.nextInt();
		}
		SavingAccounts savingAccount = new SavingAccounts(accNumber,initialAmount,name);
		int choice = 0;
		while(choice!=4) {
			displayOptions();
			choice = scanner.nextInt();
			handleSavingAccount(choice,savingAccount,scanner);
		}
	}
	
	private static void displayOptions() {
		System.out.println("1. Check Balance.");
		System.out.println("2. Debit");
		System.out.println("3. Credit");
		System.out.println("4. Exit");
	}
	private static void handleCurrentAccount(int choice,CurrentAccount currentAccount,Scanner scanner) {
		if(choice == 1) {
			currentAccount.displayBalance();
			return;
		}
		try {
			doCreditOrDebit(choice, scanner, currentAccount);
		}catch(NegetiveNumberExecption negetiveNumberExpection) {
			System.out.println(negetiveNumberExpection.getMessage());
		}catch(OverDraftLimitReachedExecption overDraftLimitReachedExecption) {
			System.out.println(overDraftLimitReachedExecption.getMessage());
		}
		if(choice == 4) {
			return;
		}
		
	}
	private static void handleSavingAccount(int choice,SavingAccounts savingAccount,Scanner scanner) {
		if(choice == 1) {
			savingAccount.displayBalance();
			return;
		}
		try {
			doCreditOrDebit(choice, scanner, savingAccount);
		}catch(MinimumAmountLimitReachedException minimumAmountLimitReachedException) {
			System.out.println(minimumAmountLimitReachedException.getMessage());
		}catch(NegetiveNumberExecption negetiveNumberExecption) {
			System.out.println(negetiveNumberExecption.getMessage());
		}
		if(choice == 4) {
			return;
		}
		
	}
	
	private static void doCreditOrDebit(int choice,Scanner scanner,Accounts accounts) {
		if(choice == 2) {
			System.out.println("Enter Amount to be withraw");
			int amount = scanner.nextInt();
			accounts.debitAmount(amount);
			return;
		}
		if(choice == 3) {
			System.out.println("Enter Amount to be deposited");
			int amount = scanner.nextInt();
			accounts.creditAmount(amount);
			return;
		}
	}
	private static String generateAccountNumber() {
		return "IDBI"+(int)Math.random()*99999+100000;
	}

}

package com.aurionpro.controller.model;

import java.util.Scanner;

import com.aurionpro.admin.model.Admin;

public class AdminController {
	
	private Scanner scanner;
	
	public void start() {
		boolean hasLogin = false;
		while(!hasLogin) {
			System.out.println("=====================================================================");
			System.out.println("                          🔐 Admin Login");
			System.out.println("=====================================================================");

			System.out.print("👉 Enter your User ID: ");
			String id = scanner.next();

			System.out.print("🔑 Enter your Password: ");
			String password = scanner.next();
			hasLogin = login(id,password);
		}
		if(hasLogin) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("🔄 Logging you in...");
			redirectToControls();
		}
	}
	
	public void redirectToControls() {
		System.out.println("=====================================================================");
		System.out.println("                          🛠️ Admin Control Panel");
		System.out.println("=====================================================================");
		while(true) {
			System.out.println("👉 What would you like to do?");
			System.out.println();
			System.out.println("  1️  Check or Update Dishes");
			System.out.println("  2️  Check or Update Invoices");
			System.out.println("  3️  Logout");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("➡️  Enter your choice (1-3): ");

			int choice = scanner.nextInt();
			if(choice == 1) {
				DishController dishController = new DishController();
				dishController.start(scanner);
				continue;
			}
			if(choice == 2) {
				InvoiceController invoiceController = new InvoiceController();
				invoiceController.start(scanner);
				continue;
			}
			if(choice == 3) {
				System.out.println("Logged Out Successfully");
				break;
			}
		}
	}
	
	private boolean login(String id, String password) {
		return Admin.adminId.equals(id) && Admin.password.equals(password);
	}

	public AdminController() {
	 this.scanner = new Scanner(System.in);
	}
}

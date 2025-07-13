package com.aurionpro.controller.model;

import java.util.Scanner;

import com.aurionpro.model.InvoiceManager;

public class InvoiceController {
	InvoiceManager invoiceManager;
	public InvoiceController() {
		invoiceManager = new InvoiceManager();
	}
	public void start(Scanner scanner) {
		while(true) {
			System.out.println("=====================================================================");
			System.out.println("                        📄 Invoice Management");
			System.out.println("=====================================================================");
			System.out.println("👉 Choose an option:");
			System.out.println();
			System.out.println("  1️  View All Invoices");
			System.out.println("  2️  Assign or Change Delivery Partner");
			System.out.println("  3️  Exit");
			System.out.println("-----------------------------------------------------");
			System.out.print("➡️ Enter your choice (1-3): ");

			int choice = scanner.nextInt();
			if(choice == 1) {
				invoiceManager.viewAllInvoices();
			}
			if(choice == 2) {
				invoiceManager.assignOrChangeDeliveryPartner();
			}
			if(choice == 3) {
				break;
			}
		}
	}
}

package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.aurionpro.controller.model.DeliverPartnerController;
import com.aurionpro.exception.model.InvalidDeliveryPartnerIdException;
import com.aurionpro.exception.model.InvoiceNotFoundException;
import com.aurionpro.exception.model.NegetiveNumberExecption;

public class InvoiceManager {
	private Scanner scanner;
	private Map<Integer, Invoice> invoices;
	private static final String filePath = "invoice.ser";

	public InvoiceManager() {
		scanner = new Scanner(System.in);
		invoices = new HashMap<Integer, Invoice>();
		loadInvoices();
	}

	private void loadInvoices() {
		try {
			FileInputStream file = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(file);
			this.invoices = (Map<Integer, Invoice>) in.readObject();
			in.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught"+ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
	}


	private void saveInvoice() {
		try {
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this.invoices);
			out.close();
			file.close();
			System.out.println("Object has been serialized");

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

	public void addInvoice(Invoice invoice) {
		this.invoices.put(invoices.size(), invoice);
		saveInvoice();
	}

	public void viewAllInvoices() {
		this.invoices.forEach((invoiceId, invoice) -> {
			System.out.println("Id: " + invoiceId);
			Display.printInvoice(invoice);
		});
	}
	public void assignOrChangeDeliveryPartner() {
		try {
		this.scanner = new Scanner(System.in);
		System.out.println("Enter Invoice Id You want to assign or change the delivery partner");
		int invoiceId = scanner.nextInt();
		if(invoiceId<0) {
			throw new NegetiveNumberExecption();
		} 
		if(invoiceId>=this.invoices.size()) {
			throw new InvoiceNotFoundException();
		}
		System.out.println("Enter 1 for Zomato 2 for Swiggy");
		int partnerId = scanner.nextInt();
		DeliveryPartner deliveryPartner = DeliverPartnerController.getDeliveryPartner(partnerId);
		if(deliveryPartner == null) {
			throw new InvalidDeliveryPartnerIdException();
		}
		invoices.get(invoiceId).getOrder().setDeliveryPartner(deliveryPartner);
		saveInvoice();
		}catch (InvalidDeliveryPartnerIdException idException) {
			System.out.println(idException.getMessage());
		}catch(InvoiceNotFoundException invoiceNotFoundException) {
			System.out.println(invoiceNotFoundException.getMessage());
		}catch(NegetiveNumberExecption negetiveNumberExecption) {
			System.out.println(negetiveNumberExecption.getMessage());
		}catch(Exception exception) {
			System.out.println("something went wrong");
		}
	}
}

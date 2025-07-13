package com.aurionpro.controller.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.aurionpro.exception.model.DisTypeNotFoundException;
import com.aurionpro.exception.model.DishNotFoundException;
import com.aurionpro.exception.model.NegetiveNumberExecption;
import com.aurionpro.exception.model.OperationFailedException;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Dish;
import com.aurionpro.model.Invoice;
import com.aurionpro.model.InvoiceManager;
import com.aurionpro.model.Item;
import com.aurionpro.model.Display;
import com.aurionpro.model.Order;

public class FoodDeliveryAppController {
	private static int orderId = 0;
	private Display menu;
	private Scanner scanner;
	private List<Item> lineItem;
	private Customer customer;
	private String customerName;
	private Set<String> addedItems;
	private Invoice invoice;
	private InvoiceManager invoiceManager;
	
	
	public void start() {
			System.out.println("=====================================================");
	        System.out.println("         🍔 WELCOME TO MINI FOOD DELIVERY! 🍕");
	        System.out.println("=====================================================");
	        System.out.println();
	        System.out.println();
		int choice = -1;
		System.out.println("Enter your name:");
		this.customerName = scanner.nextLine();
		while(choice!=0) {
			handleController();
			System.out.println("Enter 0 to Exit or Any Number to Continue:");
			try {
			choice = scanner.nextInt();
			}catch (Exception e) {
				System.out.println("Something went wrong");
			}
		}
	}

	private void handleController() {
		while(true) {
			menu.displayMessage();
			int userInput = scanner.nextInt();
			if(userInput == 1) {
				menu.displayAllDishes();
				continue;
			}
			if(userInput == 2) {
				addLineItem();
				continue;
			}
			if(userInput == 3) {
				menu.viewLineItems(lineItem);
				continue;
			}
			if(userInput == 4) {
				removeItem();
				continue;
			}
			if(userInput == 5) {
				placeOrder();
				continue;
			}
			if(userInput == 6) {
				break;
			}
		}
	}

	private void addLineItem() {
		try {
		System.out.println("Enter the dish category you want to buy");
		menu.displayMenuCategory();
		int dishTypeChoice = scanner.nextInt();
		menu.displayMenu(dishTypeChoice);
		System.out.println("Enter Id of Dish You Want to buy");
		int dishId = scanner.nextInt();
			Dish dish = this.menu.getDish(dishTypeChoice, dishId);
			if(dish==null) throw new DishNotFoundException();
		
		System.out.println("Enter the quantity you want to buy");
		int quantity = scanner.nextInt();
		if(quantity<0) {
			throw new NegetiveNumberExecption();
		}
		if(!addedItems.contains(dish.getDishName())) {
			addedItems.add(dish.getDishName());
			this.lineItem.add(new Item(dish,quantity,(quantity*dish.getDishPrice())));
			return;
		}
		int index = 0;
		for(Item item:lineItem) {
			if(item.getDish().getDishName().equals(dish.getDishName())){
				double updatedQuantity = quantity+item.getQuantity();
				lineItem.get(index).setQuantity(updatedQuantity);
				lineItem.get(index).setItemCost(updatedQuantity*item.getDish().getDishPrice());
				break;
			}
		}
		}catch(DishNotFoundException exception) {
			System.out.println(exception.getMessage());
		}catch(DisTypeNotFoundException disTypeNotFoundException) {
			System.out.println(disTypeNotFoundException.getMessage());
		}catch(NegetiveNumberExecption negetiveNumberExecption) {
			System.out.println(negetiveNumberExecption.getMessage());
		}
	}
	public void removeItem() {
		try {
		System.out.println("Enter Id Of Dish You want to delete ");
		this.menu.viewLineItems(lineItem);
		int itemId = scanner.nextInt();
		if(itemId<0) throw new NegetiveNumberExecption();
		if(itemId>=lineItem.size()) throw new DishNotFoundException();
		this.addedItems.remove(lineItem.get(itemId).getDish().getDishName());
		this.lineItem.remove(itemId);
		}catch(NegetiveNumberExecption negetiveNumberExecption) {
			System.out.println(negetiveNumberExecption.getMessage());
		}catch(DishNotFoundException dishNotFoundException) {
			System.out.println(dishNotFoundException.getMessage());
		}
		catch(Exception ex) {
			System.out.println("Something went wrong");
		}
	}
	public FoodDeliveryAppController() {
		this.menu = new Display();
		this.scanner = new Scanner(System.in);
		this.lineItem = new ArrayList<Item>();
		this.addedItems = new HashSet<String>();
		this.invoiceManager = new InvoiceManager();
	}
	public void placeOrder() {
		try {
		Order order = OrderController.placeOrder(orderId, lineItem,scanner);
		this.customer = new Customer(0, this.customerName, order);
		lineItem.clear();
		addedItems.clear();
		orderId++;
		generateInvoice(order);
		menu.printInvoice(invoice);
		}catch(OperationFailedException operationFailedException) {
			System.out.println(operationFailedException.getMessage());
		}
	}
	
	private void generateInvoice(Order order) {
		this.invoice = new Invoice(orderId, order);
		invoiceManager.addInvoice(invoice);
	}

}


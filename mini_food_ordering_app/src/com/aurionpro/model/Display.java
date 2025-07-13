package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.aurionpro.dishtype.model.DishTypeFactory;
import com.aurionpro.exception.model.DisTypeNotFoundException;
import com.aurionpro.exception.model.DishNotFoundException;


public class Display {
	private Map<String,List<Dish>> dishes;
	private static final String filePath = "menu.ser";
	public Display() {
		this.dishes = new HashMap<>();
		loadDishes();
	}
	@SuppressWarnings("unchecked")
	private void loadDishes() {
		try {
		    FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);
            this.dishes = (Map<String,List<Dish>>) in.readObject();
            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
	}
	
	public void displayMenu(int dishTypeChoice) throws DisTypeNotFoundException{
		IdishType dishType = DishTypeFactory.giveDishType(dishTypeChoice);
		if(dishType == null )throw new DisTypeNotFoundException();
		List<Dish> dishesOfChosenType = dishes.get(dishType.dishType());
		displayDish(dishesOfChosenType);
	}
	
	private void displayDish(List<Dish> dishesOfType) {
	    int dishId = 0;

	    System.out.printf("%-5s %-25s %-10s\n", "ID", "Dish Name", "Price");
	    System.out.println("---------------------------------------------------------------------");

	    for (Dish dish : dishesOfType) {
	        System.out.printf("%-5d %-25s ₹%-9.2f\n", dishId, dish.getDishName(), dish.getDishPrice());
	        dishId++;
	    }

	    System.out.println("---------------------------------------------------------------------");
	}

	
	public void displayMenuCategory() {
	    System.out.println("=====================================================================");
	    System.out.println("🍽️  Choose a Cuisine Category");
	    System.out.println("=====================================================================");
	    System.out.println("  1️  Indian");
	    System.out.println("  2️  Italian");
	    System.out.println("  3️ Mexican");
	    System.out.println("---------------------------------------------------------------------");
	    System.out.print("👉 Please enter your choice (1-3): ");
	}

	
	public Dish getDish(int dishCategoryNumber,int dishId) throws DisTypeNotFoundException,DishNotFoundException {
		
		IdishType dishType = DishTypeFactory.giveDishType(dishCategoryNumber);
		if(dishType == null) {
			throw new DisTypeNotFoundException();
		}
		if(dishes.get(dishType.dishType()).size()<=dishId) {
			throw new DishNotFoundException();
		}
		Dish dish = dishes.get(dishType.dishType()).get(dishId);
		if(dish == null) throw new DishNotFoundException();
		return dish;
	}
	
	public void displayAllDishes() {
	    System.out.println("=====================================================================");
	    System.out.println("                          🍲 All Available Dishes");
	    System.out.println("=====================================================================");

	    this.dishes.forEach((dishType, dishesOfType) -> {
	        System.out.println("\n🍽️ Category: " + dishType);
	        System.out.println("---------------------------------------------------------------------");
	        displayDish(dishesOfType);
	    });
	}

	
	public static void printInvoice(Invoice invoice) {
	    Order order = invoice.getOrder();
	    List<Item> listItems = order.getFoodItems();

	    System.out.println("=====================================================================");
	    System.out.println("                          🧾 INVOICE");
	    System.out.println("=====================================================================");

	    System.out.printf("%-8s %-20s %-12s %-10s %-12s\n", "Sr. No.", "Dish Name", "Dish Price", "Qty", "Total Price");
	    System.out.println("---------------------------------------------------------------------");

	    int srNo = 1;
	    double totalPrice = 0;

	    for (Item item : listItems) {
	        Dish dish = item.getDish();
	        double quantity = item.getItemQuantity();
	        double price = dish.getDishPrice();
	        double itemTotal = item.getItemCost();

	        System.out.printf("%-8d %-20s ₹%-11.2f %-10.1f ₹%-11.2f\n", srNo, dish.getDishName(), price, quantity, itemTotal);
	        totalPrice += itemTotal;
	        srNo++;
	    }

	    System.out.println("---------------------------------------------------------------------");
	    System.out.printf("%-50s ₹%.2f\n", "Total Price:", totalPrice);
	    System.out.printf("%-50s ₹%.2f\n", "After Discount:", order.getTotal());
	    System.out.printf("%-50s %s\n", "Payment Mode:", order.getPayment().getPaymentType().givePaymentTypeName());
	    System.out.printf("%-50s %s\n", "Delivery Person Name:", order.getDeliveryPartner().getDeliveryPersonName());
	    System.out.printf("%-50s %s\n", "Delivery Company:", order.getDeliveryPartner().getDeliveryPartner().getDeliveryCompanyName());
	    System.out.println("=====================================================================");
	}

	
	public void viewLineItems(List<Item> lineItem) {
	    System.out.println("=====================================================================");
	    System.out.println("                          🛒 Your Selected Dishes");
	    System.out.println("=====================================================================");

	    System.out.printf("%-8s %-20s %-12s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Qty");
	    System.out.println("--------------------------------------------------------------------");

	    int id = 0;
	    for (Item item : lineItem) {
	        Dish dish = item.getDish();
	        System.out.printf(
	            "%-8d %-20s %-12s ₹%-9.2f %-10.1f\n",
	            id,
	            dish.getDishName(),
	            dish.getDishType().dishType(),
	            dish.getDishPrice(),
	            item.getItemQuantity()
	        );
	        id++;
	    }

	    System.out.println("=====================================================================");
	}

	public void displayMessage() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("                          🍽️ MAIN MENU 🍽️");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("  1️  View Menu");
		System.out.println("  2️  Select Food Dishes");
		System.out.println("  3️  View Your Selected Dishes");
		System.out.println("  4️  Remove a Dish");
		System.out.println("  5️  Place Order");
		System.out.println("  6️  Exit");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("👉 Please enter your choice (1-6): ");

	}
}

package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.aurionpro.dishtype.model.DishTypeFactory;
import com.aurionpro.exception.model.DisTypeNotFoundException;
import com.aurionpro.exception.model.DishNotFoundException;
import com.aurionpro.exception.model.NegetiveNumberExecption;

public class DishManager {
	private Scanner scanner;
	private Map<String, List<Dish>> dishes;
	private static final String filePath = "menu.ser";

	public DishManager() {
		scanner = new Scanner(System.in);
		dishes = new HashMap<String, List<Dish>>();
		loadDishes();
	}

	private void loadDishes() {
		try {
			FileInputStream file = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(file);
			this.dishes = (Map<String, List<Dish>>) in.readObject();
			in.close();
			file.close();
			if (dishes.size() == 0) {
				System.out.println("yess");
			}
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
	}

	public void addDish() {
		try {
			System.out.println("=====================================================================");
			System.out.println("    Select the Category from which you want to add a dish");
			System.out.println("=====================================================================");
			System.out.println("  1. Indian");
			System.out.println("  2. Italian");
			System.out.println("  3. Mexican");
			System.out.print("➡️ Enter your choice (1-3): ");

			int dishTypeChoice = this.scanner.nextInt();

			IdishType dishType = DishTypeFactory.giveDishType(dishTypeChoice);

			if (dishType == null)
				throw new DisTypeNotFoundException();

			System.out.print("👉 Enter Dish Name: ");
			String dishName = scanner.next();

			System.out.print("👉 Enter Price (e.g., 199.99): ");
			double dishPrice = scanner.nextDouble();

			if (dishPrice < 0)
				throw new NegetiveNumberExecption();
			Dish dish = new Dish(dishPrice, dishName, dishType);

			this.dishes.computeIfAbsent(dishType.dishType(), k -> new ArrayList<>()).add(dish);
			
			saveDish();
		} catch (DisTypeNotFoundException disTypeNotFoundException) {
			System.out.println(disTypeNotFoundException.getMessage());
		} catch (NegetiveNumberExecption negetiveNumberExecption) {
			System.out.println(negetiveNumberExecption.getMessage());
		}
	}

	private void saveDish() {
		try {
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this.dishes);
			out.close();
			file.close();
			System.out.println("✅ Dish added successfully!");

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

	public void removeDish() {
		try {
			System.out.println("=====================================================================");
			System.out.println("    Select the Category from which you want to remove a dish");
			System.out.println("=====================================================================");
			System.out.println("  1. Indian");
			System.out.println("  2. Italian");
			System.out.println("  3. Mexican");
			System.out.print("➡️ Enter your choice (1-3): ");
		int dishTypeChoice = this.scanner.nextInt();
		
		IdishType dishType = DishTypeFactory.giveDishType(dishTypeChoice);
		if(dishType == null) throw new DisTypeNotFoundException();
		List<Dish> dishesOfChosenType = dishes.get(dishType.dishType());
		
		displayDish(dishesOfChosenType);
		
		System.out.println("Please Enter the Id of dish to be deleted");
		
		int dishToBeDeleted = scanner.nextInt();
		if(dishToBeDeleted<0) {
			throw new NegetiveNumberExecption();
		}
		if (dishToBeDeleted >= dishesOfChosenType.size()) {
			throw new DishNotFoundException();
		}
		dishesOfChosenType.remove(dishToBeDeleted);
		saveDish();
		}catch(DishNotFoundException exception) {
			System.out.println(exception.getMessage());
		}catch(DisTypeNotFoundException disTypeNotFoundException) {
			System.out.println(disTypeNotFoundException.getMessage());
		}catch(NegetiveNumberExecption negetiveNumberExecption) {
			System.out.println(negetiveNumberExecption.getMessage());
		}
	}

	private void displayDish(List<Dish> dishesOfType) {
	    int dishId = 0;
	    System.out.printf("%-5s %-25s %-10s\n", "ID", "Dish Name", "Price (₹)");
	    System.out.println("---------------------------------------------------------------------");
	    for (Dish dish : dishesOfType) {
	        System.out.printf("%-5d %-25s %-10.2f\n", dishId, dish.getDishName(), dish.getDishPrice());
	        dishId++;
	    }
	    System.out.println();
	}

	public void viewAllDishes() {
	    this.dishes.forEach((dishType, dishesOfType) -> {
	    	System.out.println("=====================================================================");
	        System.out.println("🍽️  Cuisine Category: " + dishType);
	        System.out.println("=====================================================================");
	        displayDish(dishesOfType);
	    });
	}

}

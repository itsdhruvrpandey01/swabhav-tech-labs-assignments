package com.aurionpro.controller.model;

import java.util.Scanner;

import com.aurionpro.model.DishManager;

public class DishController {

	DishManager dishMananger;
	public void start(Scanner scanner) {
		while(true) {
			System.out.println("=====================================================================");
			System.out.println("                          🍽️ Manage Dishes");
			System.out.println("=====================================================================");
			System.out.println("👉 Choose an option:");
			System.out.println();
			System.out.println("  1️  Add Dish");
			System.out.println("  2️  Delete Dish");
			System.out.println("  3️  View All Dishes");
			System.out.println("  4️  Exit");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("➡️  Enter your choice (1-4): ");

			int option = scanner.nextInt();
			if(option == 1) {
				this.dishMananger.addDish();
				continue;
			}
			if(option == 2) {
				this.dishMananger.removeDish();
				continue;
			}
			if(option == 3) {
				this.dishMananger.viewAllDishes();
				continue;
			}
			if(option == 4) {
				break;
			}
		}
	}
	public DishController() {
		this.dishMananger = new DishManager();
	}
}

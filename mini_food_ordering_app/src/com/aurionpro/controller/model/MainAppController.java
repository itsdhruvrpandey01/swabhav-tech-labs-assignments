package com.aurionpro.controller.model;

import java.util.Scanner;

public class MainAppController {
	private AdminController adminController; 
	private FoodDeliveryAppController foodDeliveryAppController;
	public void start() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			int choice = scanner.nextInt();
			if(choice == 1) {
				adminController.start();
				continue;
			}
			if(choice == 2) {
				foodDeliveryAppController.start();
				continue;
			}
			if(choice == 3) {
				break;
			}
		}
		
	}
	public MainAppController() {
		adminController = new AdminController();
		foodDeliveryAppController = new FoodDeliveryAppController();
	}
}

package com.aurionpro.dishtype.model;

import com.aurionpro.model.IdishType;

public class DishTypeFactory {
	public static IdishType giveDishType(int choice) {
		if(choice == 1) {
			return new Indian();
		}
		if(choice == 2) {
			return new Italian();
		}
		if(choice == 3) {
			return new Mexican();
		}
		return null;
	}
}

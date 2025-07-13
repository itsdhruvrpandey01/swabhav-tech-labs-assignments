package com.aurionpro.dishtype.model;

import java.io.Serializable;

import com.aurionpro.model.IdishType;

public class Italian implements IdishType,Serializable {

	@Override
	public String dishType() {
		return "Italian";
	}

}

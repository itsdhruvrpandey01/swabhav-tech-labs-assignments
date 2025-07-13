package com.aurionpro.dishtype.model;

import java.io.Serializable;

import com.aurionpro.model.IdishType;

public class Indian implements IdishType,Serializable {

	@Override
	public String dishType() {
		return "Indian";
	}

}

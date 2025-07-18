package com.aurionpro.model;

public class Cell {
	private Symbol symbol;
	public Cell() {
		this.symbol = Symbol.N;
	}
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	public Symbol getSymbol() {
		return symbol;
	}
}

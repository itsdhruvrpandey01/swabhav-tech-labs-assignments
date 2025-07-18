package com.aurionpro.model;

import com.aurionpro.exception.CellAlreadyTakeException;
import com.aurionpro.exception.CellOutOfBoundException;

public class Board {
	Cell cells[][];
	public Board() {
		this.cells = new Cell[3][3];
		fillCells();
	}
	private void fillCells() {
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				this.cells[i][j] = new Cell();
			}
		}
	}
	public void printBoard() {
		System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j].getSymbol()==Symbol.N?" ":cells[i][j].getSymbol());
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }
	public boolean setCellIndex(int row,int col,Symbol symbol) {
		try {
			if(!((row>=0 && row<3) && (col>=0 && col<3))) {
				throw new CellOutOfBoundException();
			}
			if(this.cells[row][col].getSymbol()!=Symbol.N) {
				throw new CellAlreadyTakeException();
			}
			cells[row][col].setSymbol(symbol);
			return true;
		}catch (CellAlreadyTakeException alreadyTakeException) {
			System.out.println(alreadyTakeException.getMessage());
		}catch (CellOutOfBoundException cellOutOfBoundException) {
			System.out.println(cellOutOfBoundException.getMessage());
		}catch(Exception exception) {
			System.out.println("something went wrong");
		}
		return false;
	}
	public boolean checkwin(Symbol symbol) {
		return diagonalWin(symbol) || rowWin(symbol) || columnWin(symbol);
	}
	private boolean columnWin(Symbol symbol) {
		for(int column= 0;column<3;column++) {
			if(cells[0][column].getSymbol()==symbol && cells[1][column].getSymbol()==symbol && cells[2][column].getSymbol()==symbol) {
				return true;
			}
		}
		return false;
	}
	private boolean rowWin(Symbol symbol) {
		for(int row= 0;row<3;row++) {
			if(cells[row][0].getSymbol()==symbol && cells[row][1].getSymbol()==symbol && cells[row][2].getSymbol()==symbol) {
				return true;
			}
		}
		return false;
	}
	private boolean diagonalWin(Symbol symbol) {
		if((cells[0][0].getSymbol() == symbol) && (cells[1][1].getSymbol() == symbol) && (cells[2][2].getSymbol() == symbol)) {
			return true;
		}
		if((cells[0][2].getSymbol() == symbol) && (cells[1][1].getSymbol() == symbol) && (cells[2][0].getSymbol() == symbol)) {
			return true;
		}
		return false;
	}
	public void emptyCells() {
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				this.cells[i][j].setSymbol(Symbol.N);;
			}
		}
	}
	public boolean checkDraw() {
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(this.cells[i][j].getSymbol()==Symbol.N) {
					return false;
				}
			}
		}
		return true;
	}
}

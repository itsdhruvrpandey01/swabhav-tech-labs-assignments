package com.aurionpro.controller;

import java.util.Scanner;

import com.aurionpro.model.Board;
import com.aurionpro.model.Symbol;

public class BoardController {
	private Symbol currentPlayerSymbol;
	private Board board;
	private Scanner scanner;
	public BoardController() {
		this.currentPlayerSymbol = Symbol.X;
		this.board = new Board();
		this.scanner = new Scanner(System.in);
	}
	
	public void start() {
		boolean willPlayAgain = true;
		while(willPlayAgain) {
			playTicTacToe();
			System.out.println("Play Again ?");
			System.out.println("Type 1 for Play again or Type 0 to quit");
			int choice = scanner.nextInt();
			willPlayAgain = choice == 1 ? true:false;
			
		}
		
	}
	private void playTicTacToe() {
		boolean isGameOver = false;
		while(!isGameOver) {
			board.printBoard();
			System.out.println("Current Turn "+currentPlayerSymbol);
			System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();
            
            boolean isEnteredSuccessfully = board.setCellIndex(row, col, currentPlayerSymbol);
            if(!isEnteredSuccessfully) {
            	continue;
            }
            if(board.checkwin(currentPlayerSymbol)) {
            	board.printBoard();
            	System.out.println("Winner :"+currentPlayerSymbol);
            	board.emptyCells();
            	isGameOver = true;
            }
            if(board.checkDraw()) {
            	board.printBoard();
            	System.out.println("Draw");
            	board.emptyCells();
            	isGameOver = true;
            }
            
            changePlayerSymbol();
		}
	}

	private void changePlayerSymbol() {
		this.currentPlayerSymbol = this.currentPlayerSymbol == Symbol.X ? Symbol.O:Symbol.X;
	}
}

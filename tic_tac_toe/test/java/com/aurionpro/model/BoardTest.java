package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
	private Board board;
	
	@BeforeEach
	public void init() {
		this.board = new Board();
	}
	@Test
	void testSetCellIndex() {
		assertEquals(true,board.setCellIndex(1, 1, Symbol.X));
		assertFalse(board.setCellIndex(1, 1, Symbol.X));
	}

	@Test
	void testCheckwin() {
		board.setCellIndex(0, 0, Symbol.X);
		board.setCellIndex(1, 1, Symbol.X);
		board.setCellIndex(2, 2, Symbol.X);
		assertTrue(board.checkwin(Symbol.X));
	}

	@Test
	void testCheckDraw() {
		board.setCellIndex(0, 0, Symbol.X);
        board.setCellIndex(0, 1, Symbol.O);
        board.setCellIndex(0, 2, Symbol.X);
        board.setCellIndex(1, 0, Symbol.X);
        board.setCellIndex(1, 1, Symbol.O);
        board.setCellIndex(1, 2, Symbol.O);
        board.setCellIndex(2, 0, Symbol.O);
        board.setCellIndex(2, 1, Symbol.X);
        board.setCellIndex(2, 2, Symbol.X);
		assertTrue(board.checkDraw());
		
	}

}

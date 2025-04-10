package com.game.tic.tac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TicTacBoardTest {

	TicTacBoard board = new TicTacBoard();

	@Test
	void checkIfValidMove() {

		List<String> innerBoxes = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

		assertTrue(board.validMove(1, innerBoxes));
	}

	@Test
	void shouldReturnTheInnerBoxList() {
		List<String> innerBoxes = Arrays.asList("1", "2");

		board.setInnerBoxes(innerBoxes);

		assertEquals(innerBoxes, board.getInnerBoxes());
	}
}

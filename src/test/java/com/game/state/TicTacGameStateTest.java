package com.game.state;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.game.tic.tac.Board;
import com.game.tic.tac.TicTacBoard;

class TicTacGameStateTest {

	TicTacGameState gameState;

	TicTacBoard board = new TicTacBoard();

	@Test
	void closeTheGameWhenPlayerOneStrikesConsicutiveRows() {

		gameState = new TicTacGameState();

		Board anonymousBoard = createAnnonymousBoard(Arrays.asList("X", "X", "X", "O", "O", "6", "7", "8", "9"));

		assertTrue(gameState.evaluateBoard(anonymousBoard));

	}

	@Test
	void closeTheGameWhenPlayerTwoStrikesConsicutiveColumns() {

		gameState = new TicTacGameState();

		Board anonymousBoard = createAnnonymousBoard(Arrays.asList("X", "O", "X", "4", "O", "O", "X", "O", "9"));

		assertTrue(gameState.evaluateBoard(anonymousBoard));

	}
	
	@Test
	void closeTheGameWhenPlayerStrikesDiagonallyFromLeft() {

		gameState = new TicTacGameState();

		Board anonymousBoard = createAnnonymousBoard(Arrays.asList("X", "O", "3", "4", "X", "O", "X", "8", "X"));

		assertTrue(gameState.evaluateBoard(anonymousBoard));

	}
	@Test
	void closeTheGameWhenPlayerStrikesDiagonallyFromRight() {

		gameState = new TicTacGameState();

		Board anonymousBoard = createAnnonymousBoard(Arrays.asList("X", "2", "O", "4", "O", "6", "O", "8", "X"));

		assertTrue(gameState.evaluateBoard(anonymousBoard));

	}

	private Board createAnnonymousBoard(List<String> listOfBoxes) {
		return new Board(listOfBoxes) {

			@Override
			public boolean validMove(int selectedBox, List<String> innerBoxes) {
				return false;
			}
		};
	}

	@Test
	void continueTheGameWhenIfNotStrike() {

		gameState = new TicTacGameState();

		Board anonymousBoard = createAnnonymousBoard(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

		assertFalse(gameState.evaluateBoard(anonymousBoard));

	}

}

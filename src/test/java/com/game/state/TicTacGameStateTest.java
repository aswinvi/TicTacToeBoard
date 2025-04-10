package com.game.state;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.game.tic.tac.Board;
import com.game.tic.tac.TicTacBoard;

class TicTacGameStateTest {

	TicTacGameState gameState;

	TicTacBoard board = new TicTacBoard();

	@Test
	void closeTheGameWhenPlayerOneStrikesConsicutiveRows() {

		gameState = new TicTacGameState();

		Scanner scanner = new Scanner("5\n3\n7\n9\n6\n8\n4\n2\n1\n");

		Board anonymousBoard = new Board(Arrays.asList("X", "X", "X", "O", "O", "6", "7", "8", "9")) {

			@Override
			public boolean validMove(int selectedBox, List<String> innerBoxes) {
				return false;
			}
		};

		scanner.close();

		assertTrue(gameState.evaluateBoard(anonymousBoard));

	}

}

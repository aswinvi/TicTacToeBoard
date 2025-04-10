package com.game.tic.tac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.game.constant.TicTacConstants;

class TicTacPlayerInputTest {

	TicTacBoard board = new TicTacBoard();

	List<String> innerBoxes;

	TicTacPlayerInput playerInput;

	@Test
	void shouldReturnXasLastPlayerAftreInitialMove() {

		Scanner scanner = new Scanner("5\n3");

		playerInput = new TicTacPlayerInput(board);

		assertEquals(TicTacConstants.PLAYER_X, playerInput.getNextMove(board.getInnerBoxes(), "", scanner));

	}

	@Test
	void shouldReturnEmptyStringLastPlayerIfLastPlayedIsX() {

		Scanner scanner = new Scanner("5\n3");

		playerInput = new TicTacPlayerInput(board);

		assertEquals(TicTacConstants.PLAYER_X,
				playerInput.getNextMove(board.getInnerBoxes(), TicTacConstants.PLAYER_X, scanner));

	}

	@Test
	void shouldReturnLastPlayerIfLastPlayedIsX() {

		Board anonymousBoard = new Board(Arrays.asList("1", "X", "3", "X", "X", "6", "7", "8", "9")) {

			@Override
			public boolean validMove(int selectedBox, List<String> innerBoxes) {
				return false;
			}
		};

		Scanner scanner = new Scanner("5\n3");

		playerInput = new TicTacPlayerInput(anonymousBoard);

		assertEquals(TicTacConstants.PLAYER_X,
				playerInput.getNextMove(anonymousBoard.getInnerBoxes(), TicTacConstants.PLAYER_X, scanner));

	}

}

package com.game.tic.tac;

import java.util.List;
import java.util.Scanner;

import com.game.constant.TicTacConstants;

public class TicTacPlayerInput implements PlayerInput {

	private final Board ticTacBoard;

	public TicTacPlayerInput(Board ticTacBoard) {
		this.ticTacBoard = ticTacBoard;

	}

	@Override
	public String getNextMove(List<String> innerBoxes, String lastPlayed, Scanner scanner) {

		if (isTurnForPlayerX(lastPlayed)) {
			return getInputFromFirstPlayer(innerBoxes, scanner, lastPlayed);
		}

		return lastPlayed;
	}

	private boolean isTurnForPlayerX(String lastPlayed) {
		return lastPlayed.isEmpty() || !TicTacConstants.PLAYER_X.equals(lastPlayed);
	}

	private String getInputFromFirstPlayer(List<String> innerBoxes, Scanner scanner, String lastPlayed) {
		System.out.println(TicTacConstants.KEY_IN_THE_POSITION_TO_PLAY);
		return setPositionIfValidInput(innerBoxes, scanner.nextInt(), lastPlayed);
	}

	private String setPositionIfValidInput(List<String> innerBoxes, int nextPosition, String lastPlayed) {

		if (!ticTacBoard.validMove(nextPosition, innerBoxes)) {
			System.out.println(TicTacConstants.INVALID_MOVE_PLEASE_TRY_ANOTHER_POSITION);
			return lastPlayed;
		} else {
			innerBoxes.set(nextPosition - 1, TicTacConstants.PLAYER_X);
			return TicTacConstants.PLAYER_X;
		}
	}
}

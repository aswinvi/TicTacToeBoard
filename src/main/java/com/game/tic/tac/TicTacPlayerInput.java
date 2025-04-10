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
		} else {
			return getInputFromSecondPlayer(innerBoxes, scanner, lastPlayed);
		}

	}

	private boolean isTurnForPlayerX(String lastPlayed) {
		return lastPlayed.isEmpty() || !TicTacConstants.PLAYER_X.equals(lastPlayed);
	}

	private String getInputFromSecondPlayer(List<String> boardPositions, Scanner scanner, String lastPlayed) {
		System.out.println(TicTacConstants.KEY_IN_THE_POSITION_TO_PLAY);
		return setPositionIfValidInput(boardPositions, scanner.nextInt(), TicTacConstants.PLAYER_O, lastPlayed);
	}

	private String getInputFromFirstPlayer(List<String> innerBoxes, Scanner scanner, String lastPlayed) {
		System.out.println(TicTacConstants.KEY_IN_THE_POSITION_TO_PLAY);
		return setPositionIfValidInput(innerBoxes, scanner.nextInt(), TicTacConstants.PLAYER_X, lastPlayed);
	}

	private String setPositionIfValidInput(List<String> innerBoxes, int nextPosition, String player,
			String lastPlayed) {

		if (!ticTacBoard.validMove(nextPosition, innerBoxes)) {
			System.out.println(TicTacConstants.INVALID_MOVE_PLEASE_TRY_ANOTHER_POSITION);
			return lastPlayed;
		} else {
			innerBoxes.set(selectedBox(nextPosition), player);
			return player;
		}
	}

	private int selectedBox(int nextPosition) {
		return nextPosition - 1;
	}
}

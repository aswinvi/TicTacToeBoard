package com.game.state;

import java.util.List;

import com.game.constant.TicTacConstants;
import com.game.tic.tac.Board;

public class TicTacGameState implements GameState {

	@Override
	public boolean evaluateBoard(Board board) {
		return checkGameState(board);
	}

	private boolean checkGameState(Board board) {

		return checkRowsForStrike(board.getInnerBoxes()) || checkColumnForStrike(board.getInnerBoxes());

	}

	private boolean checkColumnForStrike(List<String> innerBoxes) {
		for (int boxPosition = 0; boxPosition < TicTacConstants.MAX_NO_OF_COLUMN; boxPosition++) {
			if (isVerticallyMatched(innerBoxes, boxPosition)) {
				String winner = populatesMessageToPrint(innerBoxes, boxPosition);
				System.out.println(String.format("%s %s", TicTacConstants.GAME_OVER, winner));
				return true;
			}
		}
		return false;
	}

	private boolean isVerticallyMatched(List<String> boardPositions, int boxPosition) {
		return boardPositions.get(boxPosition).equals(boardPositions.get(boxPosition + TicTacConstants.MAX_NO_OF_COLUMN))
				&& boardPositions.get(boxPosition + TicTacConstants.MAX_NO_OF_COLUMN).equals(boardPositions.get(boxPosition + 6));
	}

	private boolean checkRowsForStrike(List<String> innerBoxes) {
		for (int boxPosition = 0; boxPosition < TicTacConstants.MAX_NUMBER_OF_BOXES; boxPosition += TicTacConstants.MAX_NO_OF_COLUMN) {
			if (isHorizontallyMatched(innerBoxes, boxPosition)) {
				String winner = populatesMessageToPrint(innerBoxes, boxPosition);
				System.out.println(String.format("%s %s", TicTacConstants.GAME_OVER, winner));
				return true;
			}
		}
		return false;
	}

	private boolean isHorizontallyMatched(List<String> boardPositions, int boxPosition) {
		return boardPositions.get(boxPosition)
				.equals(boardPositions.get(boxPosition + TicTacConstants.BOX_INDEX_OFFSET))
				&& boardPositions.get(boxPosition + TicTacConstants.BOX_INDEX_OFFSET)
						.equals(boardPositions.get(boxPosition + TicTacConstants.BOX_MIDDLE_TWO));
	}

	private String populatesMessageToPrint(List<String> boardPositions, int positionToCheck) {
		return TicTacConstants.PLAYER_X.equals(boardPositions.get(positionToCheck))
				? TicTacConstants.PLAYER_ONE_IS_THE_WINNER
				: TicTacConstants.PLAYER_TWO_IS_THE_WINNER;
	}

}

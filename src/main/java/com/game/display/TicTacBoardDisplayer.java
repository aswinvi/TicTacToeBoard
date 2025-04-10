package com.game.display;

import com.game.constant.TicTacConstants;
import com.game.exception.TicTacExceptionHandler;
import com.game.tic.tac.Board;

public class TicTacBoardDisplayer implements BoardDisplay {

	private static final String EXCEPTION_MESSAGE = "Failed to load the Game Board!!";

	@Override
	public void displayBoard(Board board) {
		if (isValidBoard(board)) {
			for (int box = TicTacConstants.COLUMN_INDEX_DECIDER; box < board.getInnerBoxes().size(); box++) {
				System.out.print(board.getInnerBoxes().get(box) + TicTacConstants.SPACE_BETWEEN_BOXES);
				displayInNextLineIfLastColumn(box);
			}
		} else {
			throw new TicTacExceptionHandler(EXCEPTION_MESSAGE);
		}
	}

	private boolean isValidBoard(Board board) {
		return null != board && null != board.getInnerBoxes() && !board.getInnerBoxes().isEmpty();
	}

	private void displayInNextLineIfLastColumn(int box) {
		if (isLastColumn(box))
			System.out.println();
	}

	private boolean isLastColumn(int box) {
		return isColumnBoundary(selectedBox(box));
	}

	private boolean isColumnBoundary(int selectedBox) {
		return selectedBox % TicTacConstants.MAX_NO_OF_COLUMN == TicTacConstants.COLUMN_INDEX_DECIDER;
	}

	private int selectedBox(int box) {
		return box + TicTacConstants.BOX_INDEX_OFFSET;
	}
}

package com.game.tic.tac;

import com.game.display.BoardDisplay;
import com.game.display.TicTacBoardDisplayer;

public class Main {

	public static void main(String[] args) {

		Board ticTacBoard = new TicTacBoard();

		BoardDisplay display = new TicTacBoardDisplayer();
		display.displayBoard(ticTacBoard);

	}
}

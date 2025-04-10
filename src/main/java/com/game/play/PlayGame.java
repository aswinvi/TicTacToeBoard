package com.game.play;

import java.util.Scanner;

import com.game.constant.TicTacConstants;
import com.game.display.BoardDisplay;
import com.game.exception.TicTacExceptionHandler;
import com.game.rules.GameRules;
import com.game.tic.tac.Board;
import com.game.tic.tac.PlayerInput;

public class PlayGame {

	private final PlayerInput playerInput;

	private final BoardDisplay boardDisplayer;

	private final GameRules rule;

	public PlayGame(PlayerInput playerInput, BoardDisplay display, GameRules rule) {
		this.playerInput = playerInput;
		this.boardDisplayer = display;
		this.rule = rule;
	}

	public void playTicTacGame(Board board, String lastPlayed, int pendingMovesForPlayers, Scanner scanner) {

		if (rule.shouldStopGame(pendingMovesForPlayers)) {
			scanner.close();
			System.out.println(TicTacConstants.GAME_OVER);
			throw new TicTacExceptionHandler(TicTacConstants.NO_MOVES_LEFT_TO_PLAY);
		}

		lastPlayed = playerInput.getNextMove(board.getInnerBoxes(), lastPlayed, scanner);
		boardDisplayer.displayBoard(board);
		System.out.println(TicTacConstants.LAST_PLAYED + lastPlayed);

		playTicTacGame(board, lastPlayed, decrementPendingMoves(pendingMovesForPlayers), scanner);
	}

	private int decrementPendingMoves(int pendingMovesForPlayers) {
		return pendingMovesForPlayers - 1;
	}
}

package com.game.play;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.game.constant.TicTacConstants;
import com.game.display.BoardDisplay;
import com.game.display.TicTacBoardDisplayer;
import com.game.exception.TicTacExceptionHandler;
import com.game.rules.GameRules;
import com.game.rules.TicTacGameRules;
import com.game.tic.tac.Board;
import com.game.tic.tac.PlayerInput;
import com.game.tic.tac.TicTacBoard;
import com.game.tic.tac.TicTacPlayerInput;

class PlayGameTest {

	PlayGame playGame;

	Board ticTacBoard = new TicTacBoard();

	PlayerInput playerInput = new TicTacPlayerInput(ticTacBoard);

	BoardDisplay display = new TicTacBoardDisplayer();

	@Mock
	TicTacBoardDisplayer mockBoardDisplayer;

	GameRules rule = new TicTacGameRules();

	@Test
	void shouldThrowExceptionWhenThereIsNoMoveLeft() {
		Scanner scanner = new Scanner("5\n3");

		playGame = new PlayGame(playerInput, display, rule);

		TicTacExceptionHandler exception = assertThrows(TicTacExceptionHandler.class,
				() -> playGame.playTicTacGame(ticTacBoard, "", 0, scanner));
		assertEquals(TicTacConstants.NO_MOVES_LEFT_TO_PLAY, exception.getMessage());
	}

	@Test
	void shouldDisplay9TimesWhenAllThe9MovesExhausted() {

		MockitoAnnotations.openMocks(this);
		Scanner scanner = new Scanner("5\n3\n1\n9\n6\n4\n7\n8\n2\n");

		playGame = new PlayGame(playerInput, mockBoardDisplayer, rule);

		assertThrows(TicTacExceptionHandler.class, () -> playGame.playTicTacGame(ticTacBoard, "", 9, scanner));
		Mockito.verify(mockBoardDisplayer, Mockito.times(9)).displayBoard(ticTacBoard);

	}

}

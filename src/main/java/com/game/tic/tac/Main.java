package com.game.tic.tac;

import java.util.Scanner;

import com.game.display.BoardDisplay;
import com.game.display.TicTacBoardDisplayer;
import com.game.play.PlayGame;
import com.game.rules.GameRules;
import com.game.rules.TicTacGameRules;
import com.game.state.GameState;
import com.game.state.TicTacGameState;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Board ticTacBoard = new TicTacBoard();

		BoardDisplay display = new TicTacBoardDisplayer();

		PlayerInput playerInput = new TicTacPlayerInput(ticTacBoard);

		GameRules rule = new TicTacGameRules();

		GameState gameState = new TicTacGameState();

		PlayGame playGame = new PlayGame(playerInput, display, rule, gameState);
		
		display.displayBoard(ticTacBoard);

		playGame.playTicTacGame(ticTacBoard, "", 9, scanner, false);

		

	}
}

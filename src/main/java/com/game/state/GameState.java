package com.game.state;

import com.game.tic.tac.Board;

public interface GameState {
	 boolean evaluateBoard(Board board);
}

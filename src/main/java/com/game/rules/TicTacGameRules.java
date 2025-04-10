package com.game.rules;

public class TicTacGameRules implements GameRules {
	
	 @Override
	    public boolean shouldStopGame(int pendingMovesForPlayers) {
			return pendingMovesForPlayers <= 0;
	    }
}

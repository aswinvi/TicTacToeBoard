package com.game.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.game.constant.TicTacConstants;

class TicTacGameRulesTest {

	TicTacGameRules rules;

	@Test
	void shouldReturnTrueIfThereAreNoPendingMovesLeft() {

		rules = new TicTacGameRules();

		assertTrue(rules.shouldStopGame(TicTacConstants.COLUMN_INDEX_DECIDER));
	}

	@Test
	void shouldReturnFalseIfThereAreNoPendingMovesLeft() {

		rules = new TicTacGameRules();

		assertFalse(rules.shouldStopGame(TicTacConstants.BOX_INDEX_OFFSET));
	}

}

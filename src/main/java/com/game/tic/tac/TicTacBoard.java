package com.game.tic.tac;

import java.util.Arrays;
import java.util.List;

import com.game.constant.TicTacConstants;

public class TicTacBoard extends Board {

	public TicTacBoard() {
		super(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
	}

	@Override
	public boolean validMove(int selectedBox, List<String> innerBoxes) {
		return isTheSelectedBoxEmpty(selectedBox, innerBoxes);

	}

	private boolean isTheSelectedBoxEmpty(int selectedBox, List<String> innerBoxes) {
		return innerBoxes.get(selectedBox-1).matches(TicTacConstants.CHECK_FOR_NUMBER);
	}

}

package com.game.tic.tac;

import java.util.List;

public abstract class Board {

	private List<String> innerBoxes;

	protected Board(List<String> initialBoxes) {
		this.innerBoxes = initialBoxes;
	}

	public List<String> getInnerBoxes() {
		return innerBoxes;
	}

	public void setInnerBoxes(List<String> innerBoxes) {
		this.innerBoxes = innerBoxes;
	}

	public abstract boolean validMove(int selectedBox, List<String> innerBoxes);

}

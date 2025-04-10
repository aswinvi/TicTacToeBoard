package com.game.tic.tac;

import java.util.List;
import java.util.Scanner;

public interface PlayerInput {

	public String getNextMove(List<String> innerBoxes, String lastPlayed, Scanner scanner);

}

package com.game.display;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.game.exception.TicTacExceptionHandler;
import com.game.tic.tac.TicTacBoard;

class TicTacBoardDisplayerTest {

	@InjectMocks
	TicTacBoardDisplayer ticTacBoardDisplayer = new TicTacBoardDisplayer();
	
	@Mock
	TicTacBoard mockBoard;
	
	@Mock
	List<String> mockInnerBoxList;

	@Test
	void shouldThrowExceptionIfBoardIsNull() {

		TicTacExceptionHandler exception = Assertions.assertThrows(TicTacExceptionHandler.class,
				() -> ticTacBoardDisplayer.displayBoard(null));
		Assertions.assertEquals("Failed to load the Game Board!!", exception.getMessage());

	}

	@Test
	void shouldDisplayWhenPassingTicTacToeBoard() {
		
		MockitoAnnotations.openMocks(this);
		
		Mockito.when(mockBoard.getInnerBoxes()).thenReturn(mockInnerBoxList);
		Mockito.when(mockInnerBoxList.size()).thenReturn(9);
		mockInnerBoxList();
		
		ticTacBoardDisplayer.displayBoard(mockBoard);
		
		Mockito.verify(mockBoard, Mockito.atLeastOnce()).getInnerBoxes();
		IntStream.range(0, 9).forEach(i -> Mockito.verify(mockInnerBoxList, Mockito.atLeastOnce()).get(i));
		
		
	}

	private void mockInnerBoxList() {
		for(int box=0; box < 9; box++) {
		Mockito.when(mockBoard.getInnerBoxes().get(box)).thenReturn(String.valueOf(box+1));
		}
	}
}

package org.game.sudoku;

/*
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Unit test Sudoku application.
 */
public class AppTest {

	private String currentBoard;
	
/*	@Spy
	SudokuOperations ops;
	
	@Mock
	Sudoku sudoku;
	
	@Mock
	SudokuBoard sudokuBoard;
	
	@InjectMocks
	SudokuController sudokuController;
	
	@BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void checkHowTo(){
		
    }
	
	@Test
    public void checkStart(){
		
    }
	
	@Test
    public void checkPlay(){
		
    }
	
	@Test
    public void checkQuit(){
		
    }
*/	
	public String testRandomBoard() {
    	
    	return 
             "7,0,0,0,4,0,5,3,0,"+
             "0,0,5,0,0,8,0,1,0,"+
             "0,0,8,5,0,9,0,4,0,"+
             "5,3,9,0,6,0,0,0,1,"+
             "0,0,0,0,1,0,0,0,5,"+
             "8,0,0,7,2,0,9,0,0,"+
             "9,0,7,4,0,0,0,0,0,"+
             "0,0,0,0,5,7,0,0,0,"+
             "6,0,0,0,0,0,0,5,0";
    }

}

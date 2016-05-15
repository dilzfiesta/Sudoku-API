package org.game.sudoku;

import org.game.sudoku.Sudoku;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SudokuBoard extends ResourceSupport {

	private Sudoku sudoku;
    private String board;
    private String message;
    
    @JsonCreator
    public SudokuBoard() {
        
    }

	public String getBoard() {
		return board;
	}
	
	public void setBoard(String board) {
		this.board = board;
	}
	
	public void setSudoku(Sudoku sudoku) {
		this.sudoku = sudoku;
	}
	
	public Sudoku getSudoku() {
		return sudoku;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
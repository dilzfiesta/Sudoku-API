package org.game.sudoku;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class SudokuOperations {

	/**	Generate a random board, but here we are supplying a custom board.
	 */
    public String getRandomBoard() {
    	
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
    
    /**	Validate the number and position.
     * 	Number should be between [1-9] & Position should be between [1-81]
     */
    public String validateInput(String currentBoard, Sudoku sudoku) {
    	
    	Integer number = sudoku.getNumber();
    	Integer position = sudoku.getPosition();
    	String output = "success";
    	
    	if(number < 1 || number > 10 || position < 1 || position > 81) {
    		output = "Number should be between [1-9] & Position should be between [1-81]";
    	} else {
    		
    		String[] boardArray = currentBoard.split(",");
    		if(Integer.parseInt(boardArray[position - 1]) > 0) 
    			output = "Position is already occupied with "+ boardArray[position - 1];
    	}
    	
    	return output;
    }
    
    /**	Validate the move of the user.
     * 	Check whether the number is present in the row, column or grid
     */
    public String validateMove(String currentBoard, Sudoku sudoku) {
    
    	String message = "success";
    	short[][] board = convertStringToArray(currentBoard);
    	short[] data = new short[9];
    	
    	/*	Check row	*/
    	short row = (short) Math.ceil((sudoku.getPosition() - 1) / 9);
    	data = board[row];
    	
    	if(valuePresent(data, sudoku.getNumber().shortValue())) {
    		message = "Sorry, "+ sudoku.getNumber() + " is already present in row "+ Arrays.toString(data);
    	}
    	
    	/*	Check column	*/
    	short column = (short) ((sudoku.getPosition() - 1) % 9);
    	for(int i=0; i<9; i++) {
	    	data[i] = board[i][column];
    	}
    	
    	if(valuePresent(data, sudoku.getNumber().shortValue())) {
    		message = "Sorry, "+ sudoku.getNumber() + " is already present in column "+ Arrays.toString(data);
    	}
    	
    	/*	Check grid	*/ 
    	
    	
    	return message;
    	
    }
    
    /**	Check if there are any moves left to play or not.
     */
    public boolean movesLeftToPlay(String currentBoard) {
    	
    	return true;
    	
    }
    
    /**	Convert the board from String to Array for easy manipulation.
     */
    public short[][] convertStringToArray(String currentBoard) {
    	
    	String[] strings = currentBoard.split(",");
	    short[][] data = new short[9][9];
	    int j = 0;
	    
	    for(int i=0; i<strings.length; i++) {
	    	if(i % 9 == 0 && i != 0) {
	    		j++;
	    	}
	    	
	    	data[j][i%9] = Short.parseShort(strings[i]);
	    }
	    
    	return data;
    }
    
    /**	Update the current board with the number.
     */
    public String updateCurrentBoard(String currentBoard, Sudoku sudoku) {
    	
    	String[] boardArray = currentBoard.split(",");
    	boardArray[sudoku.getPosition() - 1] = sudoku.getNumber().toString();
    	
    	return String.join(",", boardArray);
    	
    }
    
    /**	Check of the number is present in the array or not.
     */
    public boolean valuePresent(short[] data, short number) {
    	
    	boolean found = false;
    	for(short s: data) {
    		if(number == s) {
    			found = true;
    			break;
    		}
    	}
    	
    	return found;
    	
    }
}

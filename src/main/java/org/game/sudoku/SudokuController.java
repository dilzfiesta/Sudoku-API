package org.game.sudoku;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
public class SudokuController {

	/*	This variable holds the value of the current board	*/
	private String currentBoard = null;
	
	@Autowired
	private SudokuOperations ops;
	
	/**	This is a guide which shows list of APIs available for use.
	 * 
	 * 	URL - http://localhost:8080/
	 */
	@RequestMapping("/")
    public ResponseEntity<SudokuBoard> howTo() {
		
		Sudoku sudoku = new Sudoku(1, 1);
		sudoku.add(linkTo(methodOn(SudokuController.class).start()).withRel("Start a new game"));
        sudoku.add(linkTo(methodOn(SudokuController.class).play(1, 1)).withRel("Play your move (number[1-9], position[1-81])"));
        sudoku.add(linkTo(methodOn(SudokuController.class).quit()).withRel("Quit ongoing game"));
        
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setSudoku(sudoku);
        sudokuBoard.setBoard("Board is yet to be created");
        sudokuBoard.setMessage("Sudoku API Implementation");
        
        return new ResponseEntity<SudokuBoard>(sudokuBoard, HttpStatus.OK);
	}
	
	/**	By invoking this URL, you will start the game.
	 * 
	 * 	URL - http://localhost:8080/start
	 */
	@RequestMapping("/start")
    public ResponseEntity<SudokuBoard> start() {

        Sudoku sudoku = new Sudoku(1, 1);
        sudoku.add(linkTo(methodOn(SudokuController.class).play(1, 1)).withRel("Play your move (number[1-9], position[1-81])"));
        sudoku.add(linkTo(methodOn(SudokuController.class).quit()).withRel("Quit ongoing game"));
        
        currentBoard = ops.getRandomBoard();
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setBoard(currentBoard);
        sudokuBoard.setSudoku(sudoku);
        sudokuBoard.setMessage("Sudoku API Implementation");
        
        return new ResponseEntity<SudokuBoard>(sudokuBoard, HttpStatus.OK);
    }
	
	/** You play the game by passing number (between 1-9) and position between (1-81).
	 * 	Please note - Position is numbered horizontally, 
	 * 	which means first row contains positions between 1-9, second row contains positions between 10-18 and so on.
	 * 
	 * 	URL - http://localhost:8080/play?number=1&position=29
	 */
    @RequestMapping("/play")
    public HttpEntity<SudokuBoard> play(
            @RequestParam(value = "number") Integer number,
            @RequestParam(value = "position") Integer position) {
    	
    	String message;
        Sudoku sudoku = new Sudoku(number, position);
        
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setBoard(currentBoard);
        
        /* Check if the number and position are valid */
        message = ops.validateInput(currentBoard, sudoku);
        if(message != "success") {
        	sudokuBoard.setMessage(message);
        } else {
        	
        	/* Check if the move is valid or not */
        	message = ops.validateMove(currentBoard, sudoku);
        	if(message != "success") {
        		sudokuBoard.setMessage(message);
        	} else {
        		
        		/*	If everything is correct, update the board with the number	*/
        		currentBoard = ops.updateCurrentBoard(currentBoard, sudoku);
        		sudokuBoard.setMessage(message);
        	}
        	
        }
        /*	Check if there are any moves left to play	*/
        
        
        /*	Add supporting URLs o the response	*/
        sudoku.add(linkTo(methodOn(SudokuController.class).play(number, position)).withSelfRel());
        sudoku.add(linkTo(methodOn(SudokuController.class).quit()).withRel("Quit ongoing game"));
        
        sudokuBoard.setBoard(currentBoard);
        sudokuBoard.setSudoku(sudoku);
        
        return new ResponseEntity<SudokuBoard>(sudokuBoard, HttpStatus.OK);
    }
    
    /** Quit the ongoing game without finishing it.
	 * 
	 * 	URL - http://localhost:8080/quit
	 */
    @RequestMapping("/quit")
    public HttpEntity<SudokuBoard> quit() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.add(linkTo(methodOn(SudokuController.class).start()).withRel("Start a new game"));
        Sudoku sudoku = new Sudoku(1, 1);
        sudokuBoard.setSudoku(sudoku);
        sudokuBoard.setBoard("Board was destroyed");
        sudokuBoard.setMessage("Game quit successfully");
        currentBoard = null;
        
        return new ResponseEntity<SudokuBoard>(sudokuBoard, HttpStatus.OK);
    }
    
    
}

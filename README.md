Sudoku API (Spring Boot + HATEOS)
=================================

This application opens up APIs for the popular Sudoku game. Below is the list -

1. This URL will list all the APIs with descriptions available in this application. Invoke below URL to find out more.

		URL - http://localhost:8080/
		Output - 
		{
		    "sudoku": {
		        "number": 1,
		        "position": 1,
		        "_links": {
		            "Start a new game": {
		                "href": "http://localhost:8080/start"
		            },
		            "Play your move (number[1-9], position[1-81])": {
		                "href": "http://localhost:8080/play?number=1&position=1"
		            },
		            "Quit ongoing game": {
		                "href": "http://localhost:8080/quit"
		            }
		        }
		    },
		    "board": "Board is yet to be created",
		    "message": "Sudoku API Implementation"
		}


2. Invoke the below URL to start a new game. In return you will get the board and few supporting URL as a next step of action to take.

		URL - http://localhost:8080/start
		Output - 
		{
		    "sudoku": {
		        "number": 1,
		        "position": 1,
		        "_links": {
		            "Play your move (number[1-9], position[1-81])": {
		                "href": "http://localhost:8080/play?number=1&position=1"
		            },
		            "Quit ongoing game": {
		                "href": "http://localhost:8080/quit"
		            }
		        }
		    },
		    "board": "7,0,0,0,4,0,5,3,0,0,0,5,0,0,8,0,1,0,0,0,8,5,0,9,0,4,0,5,3,9,0,6,0,0,0,1,0,0,0,0,1,0,0,0,5,8,0,0,7,2,0,9,0,0,9,0,7,4,0,0,0,0,0,0,0,0,0,5,7,0,0,0,6,0,0,0,0,0,0,5,0",
		    "message": "Sudoku API Implementation"
		}

3. Invoke the below URL to play the game. You have to pass 2 parameters namely "number" (between 1-9) and "position" between (1-81). Please note that "position" is numbered horizontally, which means first row contains positions between 1-9, second row contains positions between 10-18 and so on.

		URL - http://localhost:8080/play?number7&position=11
		Output -
		{
		    "sudoku": {
		        "number": 7,
		        "position": 11,
		        "_links": {
		            "self": {
		                "href": "http://localhost:8080/play?number=7&position=11"
		            },
		            "Quit ongoing game": {
		                "href": "http://localhost:8080/quit"
		            }
		        }
		    },
		    "board": "7,0,0,0,4,0,5,3,0,0,7,5,0,0,8,0,1,0,0,0,8,5,0,9,0,4,0,5,3,9,0,6,0,0,0,1,0,0,0,0,1,0,0,0,5,8,0,0,7,2,0,9,0,0,9,0,7,4,0,0,0,0,0,0,0,0,0,5,7,0,0,0,6,0,0,0,0,0,0,5,0",
		    "message": "success"
		}

In case you are inserting a value which is already present in either the row, column or grid, the application will give you an error as shown below.

		URL - http://localhost:8080/play?number=7&position=2
		Output -
		{
		    "sudoku": {
		        "number": 7,
		        "position": 2,
		        "_links": {
		            "self": {
		                "href": "http://localhost:8080/play?number=7&position=2"
		            },
		            "Quit ongoing game": {
		                "href": "http://localhost:8080/quit"
		            }
		        }
		    },
		    "board": "7,0,0,0,4,0,5,3,0,0,7,5,0,0,8,0,1,0,0,0,8,5,0,9,0,4,0,5,3,9,0,6,0,0,0,1,0,0,0,0,1,0,0,0,5,8,0,0,7,2,0,9,0,0,9,0,7,4,0,0,0,0,0,0,0,0,0,5,7,0,0,0,6,0,0,0,0,0,0,5,0",
		    "message": "Sorry, 7 is already present in column [0, 7, 0, 3, 0, 0, 0, 0, 0]"
		}

4. Invoke the below URL to quit the game.

		URL - http://localhost:8080/quit
		Output -
		{
		    "sudoku": {
		        "number": 1,
		        "position": 1
		    },
		    "board": "Board was destroyed",
		    "message": "Game quit successfully",
		    "_links": {
		        "Start a new game": {
		            "href": "http://localhost:8080/start"
		        }
		    }
		}

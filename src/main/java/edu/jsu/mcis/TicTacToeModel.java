package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
	
	public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		
		grid = new Mark[width][width];

        /* INSERT YOUR CODE HERE */

        /* Initialize grid by filling every square with empty marks */
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = Mark.EMPTY;
			}
		}

        /* INSERT YOUR CODE HERE */
			
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
		if (xTurn && isValidSquare(row, col) && !isSquareMarked(row,col) ) {
			grid[row][col] = Mark.X;
			xTurn = false;
			return true;
		}
		
		else if (!xTurn && isValidSquare(row, col) && !isSquareMarked(row,col) ) {
			grid[row][col] = Mark.O;
			xTurn = true;
			return true;
		}

        else return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		if (row >= width || row < 0 || col >= width || col < 0) {
			return false;
		}

        else return true; /* remove this line! */
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
		if (getMark(row, col) == Mark.EMPTY) {
			return false;
		}

        else return true; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
		

        return grid[row][col]; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		
		if (isMarkWin(Mark.X)) {
			return Result.X;
		}
		else if (isMarkWin(Mark.O)) {
			return Result.O;
		}
		else if (isTie()) {
			return Result.TIE;
		}
		

        else return Result.NONE; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		int firstDiagCounter = 0;
		int secondDiagCounter = 0;
		int rowCounter = 0;
		int colCounter = 0;
		for (int i = 0; i < width; i++) {
			int forCounter = 0;
			for (int j = 0; j < width; j++) {
				if (getMark(i,j) == mark) {
					forCounter++;
				}
				if (forCounter == width) {
					rowCounter = forCounter;
				}
			}
		}
		for (int i = 0; i < width; i++) {
			int forCounter = 0;
			for (int j = 0; j < width; j++) {
				if (getMark(j,i) == mark) {
					forCounter++;
				}
				if (forCounter == width) {
					colCounter = forCounter;
				}
			}
		}
		for (int i = 0; i < width; i++) {
			if (getMark(i,i) == mark) {
				firstDiagCounter++;
			}
		}
		for (int i = 0; i < width; i++) {
			if (getMark(i,width - 1 - i) == mark) {
				secondDiagCounter++;
			}
		}
		if (firstDiagCounter == width || secondDiagCounter == width || rowCounter == width || colCounter == width ) {
			return true;
		}

        else return false; /* remove this line! */

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (getMark(i,j) == Mark.EMPTY) {
					return false;
				}
			}
		}

        return true; /* remove this line! */
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}
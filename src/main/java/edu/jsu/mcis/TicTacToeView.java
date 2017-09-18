package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		
		System.out.print("\n  ");
		for (int i = 0; i < model.getWidth(); i++) {
			System.out.print(i);
		}
		System.out.print("\n\n");
		for (int i = 0; i < model.getWidth(); i++) {
			System.out.print(i + " ");
			for (int j = 0; j < model.getWidth(); j++) {
				if(model.getMark(i,j) == TicTacToeModel.Mark.EMPTY) {
					System.out.print("-");
				}
				else {
					System.out.print(model.getMark(i,j));
			
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n\n\n");
		
		//System.out.print("\n  012\n\n0 ---\n1 ---\n2 ---\n\n\n\n");
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
		if (model.isXTurn()) {
			System.out.println("Player 1 (X) Move:");
		}
		else {
			System.out.println("Player 2 (O) Move:");
		}

        /* INSERT YOUR CODE HERE */
		System.out.print("Enter the row and column numbers, separated by a space: ");

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */
		
		
        /* INSERT YOUR CODE HERE */
		System.out.println("Invalid Input!");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}
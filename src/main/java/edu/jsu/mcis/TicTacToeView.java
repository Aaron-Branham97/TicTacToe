package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeView extends JPanel implements ActionListener {

    private TicTacToeModel model;
	private JButton[][] board;
	private JLabel label;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		board = new JButton[model.getWidth()][model.getWidth()];
		for (int i = 0; i < model.getWidth(); i++) {
			for (int j = 0; j < model.getWidth(); j++) {
				board[i][j] = new JButton("");
				board[i][j].setName("Square" + Integer.toString(i) + Integer.toString(j));
				board[i][j].addActionListener(this);
				board[i][j].setPreferredSize(new Dimension(64, 64));
				add(board[i][j]);
			}
		}
		label = new JLabel("X Turn");
		label.setName("ResultLabel");
		add(label);
		
		setLayout(new GridLayout(model.getWidth() + 1, model.getWidth()));
    }
	
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < model.getWidth(); i++) {
			for (int j = 0; j < model.getWidth(); j++) {
				if (e.getSource() == board[i][j]) {
					if(!model.makeMark(i,j)) {
						label.setText(showInputError());
					}
					else {
						board[i][j].setText(model.getMark(i,j).toString());
						label.setText("");
					}
					if (model.getResult() == TicTacToeModel.Result.NONE) {
						if (model.isXTurn()) {
							label.setText("X Turn");
					
						}
						else {
							label.setText("O Turn");
						}
					}
					else {
						label.setText(model.getResult().toString().toUpperCase());
					}
				}
			}
		}
		if (model.getResult() != TicTacToeModel.Result.NONE) {
			for (int i = 0; i < model.getWidth(); i++) {
				for (int j = 0; j < model.getWidth(); j++) {
					board[i][j].setEnabled(false);
				}
			}
		}
		
		
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

    public String showInputError() {

        /* Display an error if input is invalid (see examples) */
		
		
        /* INSERT YOUR CODE HERE */
		return("Invalid Input!");

    }
	
	

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}
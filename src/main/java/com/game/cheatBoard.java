package com.game;

import com.exceptions.OutOfBoardCharacterException;

public class cheatBoard {

    private int boardLength = 64;
    private cheatSquare[] board = new cheatSquare[boardLength];

    /****CONSTRUCTOR****/
    /**
     * Creates the board and fills it
     */
    public cheatBoard() {
        int counter = 0;
        while (counter < boardLength) {
            cheatSquare square = new cheatSquare();
            board[counter] = square;
            counter++;
        }
    }

    /****METHODS****/
    /**
     * Prints the board
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println("Case n°" + i + " : " + board[i]);
        }
    }

    /**
     * Gets the surprise of the square
     *
     * @param squareNb the number of the square
     * @return the surprise corresponding to the square
     * @throws OutOfBoardCharacterException when the number in parameter is higher to the number of the board length
     */
    public ISurprise goToSquare(int squareNb) throws OutOfBoardCharacterException {
        if (squareNb >= board.length || squareNb < 1) {
            throw new OutOfBoardCharacterException();
        } else {
            return board[squareNb].getSurprise();
        }
    }

    /****GETTERS****/
    public cheatSquare[] getBoard() {
        return board;
    }

}



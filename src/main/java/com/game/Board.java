package com.game;

import com.exceptions.OutOfBoardCharacterException;

import java.util.ArrayList;


public class Board {
    /****ATTRIBUTES****/
    private int boardLength = 64;
    private ArrayList<Square> board;

    /**CONSTRUCTOR****/
    /**
     * Creates the board and fills it
     */
    public Board() {
        board = new ArrayList<Square>();
        int counter = 0;
        while (counter < boardLength) {
            Square square = new Square();
            board.add(square);
            counter++;
        }
    }

    /****METHODS****/
    /**
     * Prints the board
     */
    public void printBoard() {
        for (int i = 0; i < board.size(); i++) {
            System.out.println("Case n°" + i + " : " + board.get(i));
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
        if (squareNb >= board.size() || squareNb < 1) {
            throw new OutOfBoardCharacterException();
        } else {
            return board.get(squareNb).getSurprise();
        }
    }

    /****GETTERS****/
    public ArrayList<Square> getBoard() {
        return board;
    }


}

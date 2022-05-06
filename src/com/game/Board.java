package com.game;

import com.exceptions.OutOfBoardCharacterException;

import java.util.Random;

public class Board {
    /****ATTRIBUTES****/
    private String[] squareContentTypes = {"empty", "monster", "surprise"};
    private Square[] board = new Square[64];


    /****GETTERS****/
    public Square[] getBoard() {
        return board;
    }

    /****CONSTRUCTOR****/
    /**
     * Creates the board and fills it
     */
    public Board() {
        int counter = 0;
        Random random = new Random();
        while (counter < 64) {
            Square square = new Square();
            int randomNumber = random.nextInt(3 - 0) + 0;
            square.setContent(squareContentTypes[randomNumber]);
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
     * Displays the content of the square according to the number in parameter
     * @param squareNb the number of the square
     * @throws OutOfBoardCharacterException when the number in parameter is higher to the number of the board length
     */
    public void getSquareContent(int squareNb) throws OutOfBoardCharacterException {
        if (squareNb > board.length) {
            throw new OutOfBoardCharacterException();
        } else {
            System.out.println("Contenu de la case n°" + squareNb + ": " + board[squareNb]);
        }
    }
}

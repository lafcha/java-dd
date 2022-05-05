package com.game;

import java.util.Random;

public class Board {

    /****ATTRIBUTES****/
   private String [] squareContentTypes = {"empty", "monster", "surprise"};
   private Square [] board = new Square[64];

    /****GETTERS****/
    public Square[] getBoard() {
        return board;
    }

    /****METHODS****/

    /**
     * Prints the board and the square contents
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++){
            System.out.println("Case n°"+ i + " : "+ board[i]);
        }
    }

    /**
     * Prints the square content of one square, corresponding to its number
     * @param squareNb the number of the square
     */

    public void printSquare( int squareNb){
        System.out.println("Contenu de la case n°" + squareNb + ": " + board[squareNb]);
    }

}

package com.game;

import java.util.Random;

public class Board {

   private String [] squareContentTypes = {"empty", "monster", "surprise"};
   private Square [] board = new Square[64];


    public Board(){
        int counter = 0;
        Random random = new Random();
        while(counter < 64){
            Square square = new Square();
            int randomNumber = random.nextInt(3-0)+0;
            square.setContent(squareContentTypes[randomNumber]);
            board[counter]= square;
            counter ++;
        }
    }

    /****GETTERS****/
    public Square[] getBoard() {
        return board;
    }

    public void printBoard() {

        for (int i = 0; i < board.length; i++){
            System.out.println("Case n°"+ i + " : "+ board[i]);
        }

    }

    public void printSquare( int squareNb){
        System.out.println("Contenu de la case n°" + squareNb + ": " + board[squareNb]);
    }

}

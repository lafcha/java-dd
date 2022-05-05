package com.game;

import java.util.Random;

public class Dice {

    /****ATTRIBUTES****/
    private int value;

    /****GETTER****/
    public int getValue() {
        return value;
    }

    /****METHODS***/
    /**
     * Gives a random number correspondig to the dice when rolled and stores it into value
     */
    public void rollTheDice(){
        Random random = new Random();
        this.value = random.nextInt(6-1)+1;
    }

    public static void main(String[] args) {
        Dice d = new Dice();
        for (int i=0; i< 1000; i++) {
            d.rollTheDice();
            if (d.getValue() < 1 || d.getValue() > 6) {
                System.out.println("ERROR "+ d.getValue());
            }
        }
    }
}

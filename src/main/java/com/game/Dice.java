package com.game;

import java.util.Random;

public class Dice {

    /****ATTRIBUTES****/
    private int value;


    /****METHODS***/
    /**
     * Gives a random number correspondig to the dice when rolled and stores it into value
     */
    public void rollTheDice(){
        Random random = new Random();
        this.value = random.nextInt(6-1)+1;
    }

    /****GETTER****/
    public int getValue() {
        return value;
    }
}

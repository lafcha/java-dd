package com.game;

import java.util.Random;

public class Dice {

    private int value;

    public void rollTheDice(){
        Random random = new Random();
        this.value = random.nextInt(6-1)+1;
    }

    public int getValue() {
        return value;
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

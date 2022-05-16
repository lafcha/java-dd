package com.equipment;

import com.Menu;
import com.characters.heroes.Hero;
import com.exceptions.FleeingException;
import com.game.ISurprise;

public abstract class Equipment implements ISurprise {



    /***ATTRIBUTES****/
    private int power;
    private String name;

    /****GETTER****/
    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    /****SETTERS****/
    public void setPower(int power) {
        this.power = power;
    }

    /****CONSTRUCTOR****/
    /**
     *
     * @param power the number of points (force or life) that are given by the equipment
     */
    public Equipment( int power, String  name){
        this.power = power;
        this.name = name;
    }

    /****METHODS****/
    /**
     * The method of the Isurprise interface.
     * @param hero the hero playing
     * @return a string
     */
    public abstract String openSurprise(Hero hero, Menu menu) throws FleeingException;

    @Override
    public String toString() {
        return this.getName();
    }
}

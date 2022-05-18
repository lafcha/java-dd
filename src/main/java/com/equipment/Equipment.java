package com.equipment;

import com.Menu;
import com.characters.heroes.Hero;
import com.exceptions.fleeingException;
import com.game.ISurprise;

public abstract class Equipment implements ISurprise {



    /***ATTRIBUTES****/
    private int power;
    private String name;

    /****CONSTRUCTOR****/
    /**
     * @param power the number of points (force or life) that are given by the equipment
     */
    public Equipment( int power, String  name){
        this.power = power;
        this.name = name;
    }


    /****GETTERS****/
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
  }

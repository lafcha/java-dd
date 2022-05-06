package com.equipment;

public abstract class Equipment {

    /***ATTRIBUTES****/
    private int power;

    /****CONSTRUCTOR****/
    /**
     *
     * @param power the number of points (force or life) that are given by the equipment
     */
    public Equipment( int power){
        this.power = power;
    }

}

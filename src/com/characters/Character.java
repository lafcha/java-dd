package com.characters;

public class Character {

    /****ATTRIBUTES****/
    private String name;
    private int lifePoints;
    private int force;
    private int position;

    /****CONSTRUCTOR****/

    public Character(String name, int lifePoints, int force){
        this.lifePoints = lifePoints;
        this.name = name;
        this.force= force;
    }


    /****GETTERS****/

    public int getLifePoints(){
        return lifePoints;
    }

    public int getForce(){
        return force;
    }

    public String getName() {
        return name;
    }

    public int getPosition(){
        return position;
    }

    /****SETTERS****/
    public void setName(String name){
        this.name = name;
    }

    public void setPosition (int position){
        this.position = position;
    }

    public void  setLifePoints(int lifePoints){
        this.lifePoints = lifePoints;
    }

    /****METHODS****/

    /***
     * Calculates the new lifePoints after a blow from a monster has been taken
     * @param blowForce
     */
    public void takeBlow(int blowForce){

        //TODO: add in case lifepoints < 0 to stop the game

        setLifePoints(getLifePoints()-blowForce);

    }

    public static void main(String[] args) {

    }
}

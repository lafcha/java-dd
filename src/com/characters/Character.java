package com.characters;

public abstract class Character {

    /****ATTRIBUTES****/
    private String name;
    private int lifePoints;
    private int force;


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



    /****SETTERS****/
    public void setName(String name){
        this.name = name;
    }

    public void  setLifePoints(int lifePoints){
        this.lifePoints = lifePoints;
    }

    /****METHODS****/

    /***
     * Calculates the new lifePoints after a blow from a monster has been taken
     * @param blowForce The force of the blow
     */
    public void takeBlow(int blowForce){

        //TODO: add in case lifepoints < 0 to stop the game

        setLifePoints(getLifePoints()-blowForce);

    }


}

package com.characters;

public abstract class Character {

    /****ATTRIBUTES****/
    private String name;
    private int lifePoints;
    private int force;


    /****CONSTRUCTOR****/
    /**
     *
     * @param name
     * @param lifePoints
     * @param force
     */
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
    /**
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @param lifePoints
     */
    public void  setLifePoints(int lifePoints){

        if(lifePoints < 0){
            this.lifePoints = 0;
        } else {
            this.lifePoints = lifePoints;
        }
    }

    /**
     *
     * @param force
     */
    public void setForce(int force) {
        this.force = force;
    }



}

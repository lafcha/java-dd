package com.equipment;

import com.characters.heroes.Hero;
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

    public abstract String openSurprise(Hero hero);

   //rendre la méthode abstraite => vide

        // faire le code dans chaque sous classe
        //Pour spells & weapons (faire dans les sous sous classes)
        // attackforce = attackforce + arme force
        // si attackforce > maxAttack force, alors attackforce = maxAttackforce

        //pour small & largepotion
        // lifepoints = lifepoints + potion force
        // si lifepoints > maxlifepoints, alors lifepoints = maxlifepoints


}

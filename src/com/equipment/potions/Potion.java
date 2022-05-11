package com.equipment.potions;

import com.characters.heroes.Hero;
import com.equipment.Equipment;

public abstract class Potion extends Equipment {

    /****CONSTRUCTOR****/
    /**
     *
     * @param power number of lifepoints the hero can gain with the potion
     * @param name name of the potion
     */
    public Potion(int power, String name){
        super(power, name );
    }

    /**
     * Determines the lifepoints the hero has after getting a potion.
     * @param hero the hero playing
     * @return a string indicatation how many lifepoints the hero has after getting a potion.
     */
    public String openSurprise(Hero hero) {

        if((hero.getLifePoints() + this.getPower()) > hero.getMaxLifePoints()){
            hero.setLifePoints(hero.getMaxLifePoints());
            return "Vous avez ramassé une potion de type " + this.getName() + ". Elle donne " + this.getPower() +" points de vie en plus, mais vous ne pouvez avoir que  " + hero.getMaxLifePoints() + " points de vie. Vous avez donc " + hero.getLifePoints() + " points de vie";
        } else {
            hero.setLifePoints(hero.getLifePoints() + this.getPower());
            System.out.println("Hero après potion: " + hero.getLifePoints());
            return "Vous avez ramassé une potion de type " + this.getName() + ". Elle vous donne " + this.getPower() +" points de vie en plus. Vous avez donc " + hero.getLifePoints() + "points de vie.";
        }

    };
}

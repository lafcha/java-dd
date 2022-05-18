package com.equipment.potions;

import com.Menu;
import com.characters.heroes.Hero;
import com.equipment.Equipment;
import com.exceptions.fleeingException;

public abstract class Potion extends Equipment {

    /****CONSTRUCTOR****/
    /**
     * @param power number of lifepoints the hero can gain with the potion
     * @param name  name of the potion
     */
    public Potion(int power, String name) {
        super(power, name);
    }


    /****METHODS****/

    /**
     * Determines the lifepoints the hero has after getting a potion.
     *
     * @param hero the hero playing
     * @return a string indicatation how many lifepoints the hero has after getting a potion.
     */
    public String openSurprise(Hero hero, Menu menu) throws fleeingException {
        if ((hero.getLifePoints() + this.getPower()) > hero.getMaxLifePoints()) {
            hero.setLifePoints(hero.getMaxLifePoints());
            return "Vous avez ramassé une potion de type " + this.getName() + ". Elle donne " + this.getPower() + " points de vie en plus, mais vous ne pouvez avoir que " + hero.getMaxLifePoints() + " points de vie.";
        } else {
            hero.setLifePoints(hero.getLifePoints() + this.getPower());
            return "Vous avez ramassé une potion de type " + this.getName() + ". Elle vous donne " + this.getPower() + " points de vie en plus. Vous avez donc " + hero.getLifePoints() +  " points de vie.";
        }

    }

    ;
}

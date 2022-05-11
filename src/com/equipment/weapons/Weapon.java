package com.equipment.weapons;

import com.characters.heroes.Hero;
import com.characters.heroes.Warrior;
import com.characters.heroes.Wizard;
import com.equipment.Equipment;

public abstract class Weapon extends Equipment {

    /***CONSTRUCTOR***/
    /**
     * @param power the number of attack points the hero can get
     * @param name  the name of the weapon
     */
    public Weapon(int power, String name) {
        super(power, name);
    }

    /**
     * Adds force to the hero according to the hero's type
     *
     * @param hero the hero playing
     * @return a string indicating if the player can have the weapon, and if so, how many attackpoints he gains.
     */
    public String openSurprise(Hero hero) {
        if (hero instanceof Warrior) {
            if (hero.getForce() + this.getPower() > hero.getMaxAttackForce()) {
                hero.setForce(hero.getMaxAttackForce());
                return "Vous avez ramassé une arme de type " + this.getName() + ". Elle vous apporte " + this.getPower() + " points d'attaque, mais vous ne pouvez avoir que " + hero.getMaxAttackForce() + " points d'attaque. Vous avez donc " + hero.getForce() + " points d'attaque";
            } else {
                hero.setForce(hero.getForce() + this.getPower());
                return "Vous avez ramassé une arme de type " + this.getName() + ". Elle vous apporte " + this.getPower() + " points d'attaque.";
            }

        } else {
            return "Vous avez ramassé une arme de type " + this.getName() + " mais vous êtes un " + hero.getClass().getSimpleName() + " et vous ne pouvez pas l'utiliser. Vous ne bénéficiez pas de points d'attaque supplémentaires.";
        }
    }

}

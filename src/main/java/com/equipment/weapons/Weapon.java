package com.equipment.weapons;

import com.Menu;
import com.characters.heroes.Hero;
import com.characters.heroes.Warrior;
import com.characters.heroes.Wizard;
import com.equipment.Equipment;
import com.exceptions.fleeingException;

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
    public String openSurprise(Hero hero, Menu menu) throws fleeingException {
        if (hero instanceof Warrior) {
            if (hero.getWeapon() == null) {
                if (hero.getForce() + this.getPower() > hero.getMaxAttackForce()) {
                    hero.setForce(hero.getMaxAttackForce());
                    hero.setWeapon(this);
                    return "Vous avez ramassé une arme de type " + this.getName() + ". Elle vous apporte " + (hero.getMaxAttackForce() - this.getPower()) + " points d'attaque.";
                } else {
                    hero.setForce(hero.getForce() + this.getPower());
                    hero.setWeapon(this);
                    return "Vous avez ramassé une arme de type " + this.getName() + ". Elle vous apporte " + this.getPower() + " points d'attaque.";
                }
            } else if (hero.getWeapon().getPower() > this.getPower()) {
                System.out.println("Vous récupérez une arme plus puissante que la votre et vous échangez donc l'arme que vous aviez par celle que vous avez ramassez.");
                if (((hero.getForce() - hero.getWeapon().getPower()) + this.getPower()) > hero.getMaxAttackForce()) {
                    hero.setForce(hero.getMaxAttackForce());
                    hero.setWeapon(this);
                    return "Vous avez ramassé une arme de type " + this.getName() + ". Elle vous apporte " + (hero.getMaxAttackForce() - this.getPower()) + " points d'attaque.";
                } else {
                    hero.setForce((hero.getForce() - hero.getWeapon().getPower())+ this.getPower());
                    hero.setWeapon(this);
                    return "Vous avez ramassé une arme de type " + this.getName() + ". Elle vous apporte " + this.getPower() + " points d'attaque.";
                }

            } else {
                return "La case contient une arme de moins bonne qualité que celle que vous avez actuellement. Vous ne la ramassez donc pas.";
            }
        } else {
            return "Vous avez ramassé un équipement de type " + this.getName() + " mais vous êtes un " + hero.getClass().getSimpleName() + " et vous ne pouvez pas l'utiliser. Vous ne bénéficiez pas de points d'attaque supplémentaires.";
        }
    }
}

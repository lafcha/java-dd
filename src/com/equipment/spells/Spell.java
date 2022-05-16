package com.equipment.spells;

import com.Menu;
import com.characters.heroes.Hero;
import com.characters.heroes.Wizard;
import com.equipment.Equipment;
import com.exceptions.FleeingException;

public abstract class Spell extends Equipment {

    /**
     * @param power the number of attackpoints the hero can get
     * @param name  the name of the spell
     */
    public Spell(int power, String name) {
        super(power, name);
    }

    /**
     * Interface OpenSuprise : Determines if the hero can have a spell & and how many attack points he gains.
     * @param hero the hero playing
     * @param menu the game's menu
     * @return a string indicating if the hero can have a spell & and how many attack points he gains.
     * @throws FleeingException if the player chooses to flee the fights
     */
    public String openSurprise(Hero hero, Menu menu) throws FleeingException {

        if (hero instanceof Wizard) {
            if (hero.getWeapon() == null) {
                if (hero.getForce() + this.getPower() > hero.getMaxAttackForce()) {
                    hero.setForce(hero.getMaxAttackForce());
                    hero.setWeapon(this);
                    return "Vous avez ramassé un sort de type " + this.getName() + ". Il vous apporte " + (hero.getMaxAttackForce() - this.getPower()) + " points d'attaque.";
                } else {
                    hero.setForce(hero.getForce() + this.getPower());
                    hero.setWeapon(this);
                    return "Vous avez ramassé un sort de type " + this.getName() + ". Il apporte " + this.getPower() + " points d'attaque.";
                }
            } else if (hero.getWeapon().getPower() > this.getPower()) {
                System.out.println("Vous récupérez un sort plus puissant que la votre et vous échangez donc le sort que vous aviez par celui que vous avez ramassé.");
                if (((hero.getForce() - hero.getWeapon().getPower()) + this.getPower()) > hero.getMaxAttackForce()) {
                    hero.setForce(hero.getMaxAttackForce());
                    hero.setWeapon(this);
                    return "Vous avez ramassé un sort de type " + this.getName() + ". Il vous apporte " + (hero.getMaxAttackForce() - this.getPower()) + " points d'attaque.";
                } else {
                    hero.setForce((hero.getForce() - hero.getWeapon().getPower())+ this.getPower());
                    hero.setWeapon(this);
                    return "Vous avez ramassé un sort de type " + this.getName() + ". Il vous apporte " + this.getPower() + " points d'attaque.";
                }

            } else {
                return "La case contient un sort de moins bonne qualité que celui que vous avez actuellement. Vous ne le ramassez donc pas.";
            }
        } else {
            return "Vous avez ramassé équipement de type " + this.getName() + " mais vous êtes un " + hero.getClass().getSimpleName() + " et vous ne pouvez pas l'utiliser. Vous ne bénéficiez pas de points d'attaque supplémentaires.";
        }
    }
}
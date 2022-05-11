package com.equipment.spells;

import com.characters.heroes.Hero;
import com.characters.heroes.Warrior;
import com.characters.heroes.Wizard;
import com.equipment.Equipment;

public abstract class Spell extends Equipment {

    /**
     * @param power the number of attackpoints the hero can get
     * @param name  the name of the spell
     */
    public Spell(int power, String name) {
        super(power, name);
    }

    /**
     * Determines if the hero can have a spell & and how many attack points he gains.
     *
     * @param hero the hero playing
     * @return a string indicating if the hero can have a spell & and how many attack points he gains.
     */
    public String openSurprise(Hero hero) {
        if (hero instanceof Wizard) {
            if (hero.getForce() + this.getPower() > hero.getMaxAttackForce()) {
                hero.setForce(hero.getMaxAttackForce());
            } else {
                hero.setForce(hero.getForce() + this.getPower());
            }
            return "Vous avez ramassé un sort de type " + this.getName() + ". Elle vous apporte " + this.getPower() + " points d'attaque.";
        } else {
            return "Vous avez ramassé un sort de type " + this.getName() + " mais vous êtes un " + hero.getClass().getSimpleName() + " et vous ne pouvez pas l'utiliser. Vous ne bénéficiez pas de points d'attaque supplémentaires.";
        }
    }
}
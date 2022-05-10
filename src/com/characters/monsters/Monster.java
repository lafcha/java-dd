package com.characters.monsters;

import com.characters.Character;
import com.characters.heroes.Hero;
import com.game.ISurprise;


public abstract class Monster extends Character implements ISurprise {

    /****CONSTRUCTOR****/
    public Monster(String name, int lifePoints, int force) {
        super(name, lifePoints, force);
    }

    /**
     * Interface OpenSuprise : the hero fights against a monster
     *
     * @param hero
     * @return a string wether the hero
     */
    public String openSurprise(Hero hero) {

        System.out.println("Vous avez " + hero.getLifePoints() +" points de vie et " + hero.getForce() + " points d'attaque.");
        System.out.println("Vous allez combattre un " + this.getName() + ". Il a " + this.getLifePoints() + " point de vie et " + this.getForce() + " points d'attaque. Bon combat ! ");
        boolean fighting = true;
        while (fighting) {
            int monsterLostPoints;
            if (hero.getForce() > this.getLifePoints()) {
                monsterLostPoints = this.getLifePoints();
            } else {
                monsterLostPoints = hero.getForce();
            }
            this.setLifePoints(this.getLifePoints()-monsterLostPoints);
            System.out.println("Vous avez attaqué le " + this.getName() + " et vous lui avez fait perdre " + monsterLostPoints + " points de vie. Il lui reste " + this.getLifePoints()+ " points de vie.");
            if (this.getLifePoints() == 0) {
                fighting = false;
            } else {
                int heroLostPoints;
                if (this.getForce() > hero.getLifePoints()) {
                    heroLostPoints = hero.getLifePoints();
                } else {
                    heroLostPoints = this.getForce();
                }
                hero.setLifePoints(hero.getLifePoints()-heroLostPoints);
                System.out.println("Le " + this.getName() + " vous a attaqué et il vous a fait perdre " + heroLostPoints + " points de vie. Il vous reste " + hero.getLifePoints() + " points de vie.");
                if (hero.getLifePoints() == 0) {
                    fighting = false;
                }
            }
        }
        if (this.getLifePoints() == 0) {
            return "Le " + this.getName() + " n'a plus de point de vie ! Vous avez gagné le combat !";
        } else {
            return "Vous n'avez plus de points de vie ! Vous avez perdu !";
        }
    }
}




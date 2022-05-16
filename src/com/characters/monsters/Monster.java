package com.characters.monsters;

import com.Menu;
import com.characters.Character;
import com.characters.heroes.Hero;
import com.exceptions.fleeingException;
import com.game.ISurprise;

import java.util.Random;


public abstract class Monster extends Character implements ISurprise {

    /****CONSTRUCTOR****/
    public Monster(String name, int lifePoints, int force) {
        super(name, lifePoints, force);
    }

    /**
     * Interface OpenSuprise : the hero fights against a monster. He attacks first and loose lifepoints when he takes a blow.
     *
     * @param hero
     * @return a string giving the result of the fight : won or lost.
     */
    public String openSurprise(Hero hero, Menu menu) throws fleeingException {

        System.out.println("Vous allez combattre un " + this.getName());
        boolean fighting = true;
        while (fighting) {
            char playerChoice = menu.displayFleeOrFightMenu();
            if (playerChoice == 'C') {
                System.out.println("Vous avez " + hero.getLifePoints() + " points de vie et " + hero.getForce() + " points d'attaque.");
                System.out.println("Vous combattez un " + this.getName() + ". Il a " + this.getLifePoints() + " point de vie et " + this.getForce() + " points d'attaque.");
                int monsterLostPoints;
                if (hero.getForce() > this.getLifePoints()) {
                    monsterLostPoints = this.getLifePoints();
                } else {
                    monsterLostPoints = hero.getForce();
                }
                this.setLifePoints(this.getLifePoints() - monsterLostPoints);
                System.out.println("Vous avez attaqué le " + this.getName() + " et vous lui avez fait perdre " + monsterLostPoints + " points de vie. Il lui reste " + this.getLifePoints() + " points de vie.");

                if (this.getLifePoints() <= 0) {
                    fighting = false;
                   return ("Bravo ! Vous avez combatu un " + this.getName() + " et vous avez gagné le combat !");
                } else {
                    int heroLostPoints;
                    if (this.getForce() > hero.getLifePoints()) {
                        heroLostPoints = hero.getLifePoints();
                    } else {
                        heroLostPoints = this.getForce();
                    }
                    hero.setLifePoints(hero.getLifePoints() - heroLostPoints);
                    return ("Le " + this.getName() + " vous a attaqué et il vous a fait perdre " + heroLostPoints + " points de vie. Il vous reste " + hero.getLifePoints() + " points de vie.");
                }
            } else {
                Random random = new Random();
                int randomBackwardSquares = random.nextInt(6 - 1) + 1;
                System.out.println("Vous avez décidé de fuir, vous reculez de " + randomBackwardSquares + " cases.");
                hero.setPosition((hero.getPosition() - randomBackwardSquares));
                throw new fleeingException();

            }
        }
        return null;
    }


}




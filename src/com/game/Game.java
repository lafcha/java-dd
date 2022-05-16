package com.game;

import com.Menu;
import com.characters.heroes.Hero;
import com.characters.heroes.Warrior;
import com.characters.heroes.Wizard;
import com.equipment.Inventory;
import com.exceptions.OutOfBoardCharacterException;
import com.exceptions.FleeingException;

public class Game {

    /****ATTRIBUTES***/
    private Hero hero;
    private cheatBoard board;
    private Menu menu;
    private boolean stillPlaying = true;
    private boolean displayMenu = true;


    /***CONSTRUCTOR***/

    public Game() {
        this.menu = new Menu();
    }

    /****SETTERS****/
    public void setBoard(cheatBoard board) {
        this.board = board;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }


    /****GETTERS****/
    public cheatBoard getBoard() {
        return board;
    }

    public Hero getHero() {
        return hero;
    }


    /****METHODS***/

    public void start() {
        while (stillPlaying) {
            System.out.println("Bienvenue sur le jeu !");
            char heroType = menu.chooseHeroTypeMenu();
            String heroName = menu.chooseHeroNameMenu();
            hero = createNewCharacter(heroType, heroName);
            System.out.println("Bravo ! vous avez crée votre personnage. Que voulez-vous faire maintenant ?");
            board = new cheatBoard();
            while (displayMenu) {
                char playerChoice = menu.displayBeforeGameMenu();
                if (playerChoice == 'I') {
                    playerChoice = menu.displayOrModifyHeroInfos();
                    switch (playerChoice) {
                        case 'A':
                            System.out.println(this.hero);
                            break;
                        case 'M':
                            String newName = menu.chooseNewHeroNameMenu();
                            this.hero.setName(newName);
                            break;
                    }
                } else if (playerChoice == 'Q') {
                    exitGame();
                } else {
                    playTheGame();
                }
            }
            char playerChoice = menu.displayEndOfGameMenu();
            if (playerChoice == 'R') {
                stillPlaying = true;
                displayMenu = true;
            }
            if (playerChoice == 'Q') {
                exitGame();
            }
        }
    }

    /**
     * @param letter the letter corresponding to the character type typed by the player
     * @param name   the name of the character typed by the player
     * @return an instance of the hero according to the type
     */
    public Hero createNewCharacter(char letter, String name) {
        Hero newCharacter = null;
        switch (letter) {
            case 'M':
                newCharacter = new Wizard(name);
                break;
            case 'G':
                newCharacter = new Warrior(name);
                break;
        }
        this.hero = newCharacter;
        return newCharacter;
    }


    /**
     * Plays a game
     */
    public void playTheGame() {
        System.out.println(hero);
        System.out.println("La partie commence. Bonne chance !");
        boolean endOfGame = false;
        while (!endOfGame) {
            char letterChar = menu.turnMenu();
            if (letterChar == ' ') {
                int newPosition = setHeroPosition();
                try {
                    ISurprise surprise = board.goToSquare(newPosition);
                    try {
                        System.out.println(surprise.openSurprise(hero, menu));
                        System.out.println("Vous avez " + hero.getLifePoints() + " points de vie et " + hero.getForce() + " points d'attaque.");
                    } catch (FleeingException e) {
                        if (hero.getPosition() <= 0) {
                            hero.setPosition(1);
                            System.out.println("Vous revenez à la case 1.");
                        } else {
                            System.out.println("Vous etes à la case " + hero.getPosition() + ".");
                        }
                    }
                    if (hero.getLifePoints() <= 0) {
                        endOfGame = true;
                        this.displayMenu = false;
                        System.out.println("GAME OVER ! Vous avez perdu la partie!");
                    }
                } catch (OutOfBoardCharacterException e) {
                    endOfGame = true;
                    this.displayMenu = false;
                    System.out.println(" Vous avez GAGNÉ ! BRAVO !");
                }

            }else if (letterChar == 'I'){
                menu.displayInventory(hero);
            } else if (letterChar == 'Q') {
                exitGame();
            }
        }
    }

    public int setHeroPosition() {
        Dice dice = new Dice();
        dice.rollTheDice();
        int diceValue = dice.getValue();
        System.out.println("Le dé fait " + diceValue + ".");
        int newPosition = hero.getPosition() + diceValue;
        hero.setPosition(newPosition);
        System.out.println("Vous avancez à la case " + newPosition + ".");
        return newPosition;
    }

    public void exitGame() {
        System.out.println("Au revoir et à bientôt !");
        System.exit(0);
    }

}




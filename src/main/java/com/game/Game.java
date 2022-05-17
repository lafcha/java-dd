package com.game;

import com.Menu;
import com.bdd.Bdd;
import com.characters.heroes.Hero;
import com.characters.heroes.Warrior;
import com.characters.heroes.Wizard;
import com.exceptions.OutOfBoardCharacterException;
import com.exceptions.fleeingException;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Game {

    /****ATTRIBUTES***/
    private Hero hero;
    private cheatBoard board;
    private Menu menu;
    private boolean stillPlaying;
    private boolean displayMenu;
    private Connection dbConnection;
    private Request request;


    /***CONSTRUCTOR***/

    public Game() {
        this.menu = new Menu();
        this.stillPlaying = true;
        this.displayMenu = true;
        Bdd bdd = new Bdd();
        this.dbConnection = bdd.dbConnection();
        request = new Request();
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

    public void start() throws SQLException {
        while (stillPlaying) {
            System.out.println("Bienvenue sur le jeu !");
            char playersChoice = menu.createOrUseHeroMenu();
            if(playersChoice == 'O'){
                System.out.println("Voici les héros qui ont été sauvegardés");
                int selectedHeroIndex = menu.selectSavedHero(request, dbConnection);
                ResultSet selectedHero = request.getOneHero(selectedHeroIndex, dbConnection);
                if ( selectedHero.getString("Type") == "Warrior" ){
                    hero = createNewCharacter( 'G',  selectedHero.getString("Name"));
                } else {
                    hero = createNewCharacter( 'M',  selectedHero.getString("Name"));
                }
            } else {
                char heroType = menu.chooseHeroTypeMenu();
                String heroName = menu.chooseHeroNameMenu();
                hero = createNewCharacter(heroType, heroName);
                System.out.println("Bravo ! vous avez crée votre personnage. Que voulez-vous faire maintenant ?");
            }
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
                    try{
                        System.out.println(surprise.openSurprise(hero, menu));
                        System.out.println("Vous avez " + hero.getLifePoints() + " points de vie et " + hero.getForce() + " points d'attaque.");
                    } catch (fleeingException e){
                        if (hero.getPosition() <=0){
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




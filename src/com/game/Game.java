package com.game;

import com.characters.heroes.Hero;
import com.characters.heroes.Warrior;
import com.characters.heroes.Wizard;
import com.exceptions.OutOfBoardCharacterException;

import java.util.Scanner;


public class Game {

    /****ATTRIBUTES***/
    private Hero hero;
    private Board board;
    private boolean stillPlaying = true;
    private boolean displayMenu = true;

    private Scanner scanner = new Scanner(System.in);

    /****SETTERS****/
    public void setBoard(Board board) {
        this.board = board;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setStillPlaying(boolean stillPlaying) {
        this.stillPlaying = stillPlaying;
    }

    public void setDisplayMenu(boolean displayMenu) {
        this.displayMenu = displayMenu;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /****GETTERS****/
    public Board getBoard() {
        return board;
    }

    public Hero getHero() {
        return hero;
    }

    public boolean getStillPlaying() {
        return this.stillPlaying;
    }

    public boolean getDisplayMenu() {
        return this.displayMenu;
    }

    public Scanner getScanner() {
        return scanner;
    }

    /****METHODS***/

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
     * The menu to choose between display or modify the hero's infos
     *
     * @return the letter corresponding to the player's choice
     */
    public void displayOrModifyHeroInfos() {
        char letterChar = '!';
        while (letterChar != 'M' && letterChar != 'A') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez 'A' pour afficher les infos de votre personnage");
            System.out.println("Tapez 'M' pour modifier les infos de votre personnage");
            String letter = scanner.nextLine();
            letterChar = letter.charAt(0);

        }
        switch (letterChar) {
            case 'A':
                System.out.println(this.hero);
                break;
            case 'M':
                System.out.println("Entrez un nouveau nom pour votre personnage");
                String newName = scanner.nextLine();
                this.hero.setName(newName);
                break;
        }

    }
    /**
     * Ask hero's settings & creates it
     *
     * @return an instance of the hero created
     */
    public Hero setAndCreateNewHero() {
        char letterChar = '!';
        while (letterChar != 'M' && letterChar != 'G') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Choisissez un type de personnage. 'M' pour Magicien ou 'G' Guerrier");
            String letter = scanner.nextLine();
            letterChar = letter.charAt(0);
        }
        char characterType = letterChar;
        System.out.println("Entrez le nom de votre personnage : ");
        String characterName = scanner.nextLine();
        return createNewCharacter(characterType, characterName);
    }

    /**
     * Plays a game
     */
    public void playTheGame() {

        System.out.println(hero);
        System.out.println("La partie commence. Bonne chance !");
        boolean endOfGame = false;
        Dice dice = new Dice();
        while (!endOfGame) {
            System.out.println("Tapez sur la barre d'espace, puis Entrée pour lancer le dé.");
            System.out.println("Tapez sur Q pour quitter.");
            char letterChar = '!';
            while (letterChar != ' ') {
                if (letterChar != '!') {
                    System.out.println("La lettre que vous avez tapé n'est pas correcte");
                }
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
                if (letterChar == ' '){
                    dice.rollTheDice();
                    int diceValue = dice.getValue();
                    System.out.println("Le dé fait " + diceValue +".");
                    int newPosition = hero.getPosition() + diceValue;
                    hero.setPosition(newPosition);
                    try {
                        ISurprise surprise = board.goToSquare(newPosition);
                        System.out.println("Vous avancez à la case " + newPosition +".");
                        System.out.println(surprise.openSurprise(hero));
                        System.out.println("Vous avez " + hero.getLifePoints() +" points de vie et " + hero.getForce() + " points d'attaque.");
                        if (hero.getLifePoints() <= 0){
                            endOfGame = true;
                            this.displayMenu = false;
                            System.out.println("GAME OVER ! Vous avez perdu la partie!");
                        }
                    } catch (OutOfBoardCharacterException e) {
                        endOfGame = true;
                        this.displayMenu = false;
                        System.out.println(" Vous avez GAGNÉ ! BRAVO !");
                    }

                }
                if(letterChar == 'Q'){
                    System.out.println("Au revoir et à bientôt !");
                    System.exit(0);
                }
            }


        }
    }

    /**
     * Displays the Menu and launches again the game or exit according to the player's choice
     */
    public void displayEndOfGameMenu() {
        char letterChar = '!';
        while (letterChar != 'R' && letterChar != 'Q') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez 'R' pour Rejouer ");
            System.out.println("Tapez 'Q' pour Quitter ");
            String letter = scanner.nextLine();
            letterChar = letter.charAt(0);
        }
        if (letterChar == 'R') {
            stillPlaying = true;
            displayMenu = true;
        }
        if (letterChar == 'Q') {
            System.out.println("Au revoir et à bientôt !");
            System.exit(0);
        }
    }

    /**
     * Displays the menu and directs the player according to his/her choice
     */
    public void displayMenu() {
        char letterChar = '!';
        while (letterChar != 'I' && letterChar != 'Q' && letterChar != 'J') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez 'J' pour Jouer ");
            System.out.println("Tapez 'I' pour Modifier ou afficher les Informations de votre personnage ");
            System.out.println("Tapez 'Q' pour Quitter ");
            String letter = scanner.nextLine();
            letterChar = letter.charAt(0);
        }
        if (letterChar == 'I') {
            displayOrModifyHeroInfos();
        } else if (letterChar == 'Q') {
            System.out.println("Au revoir et à bientôt !");
            System.exit(0);
        } else {
            playTheGame();
        }
    }

}




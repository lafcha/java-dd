package com.game;

import com.characters.Hero;
import com.characters.Warrior;
import com.characters.Wizard;

import java.util.Scanner;


public class Game {

    /****ATTRIBUTES***/
    private Hero hero;

    /****METHODS***/
    /**
     * Ask the type of the character to the player
     * @return The letter chosen by the player
     */
    public char askCharacterType() {
        Scanner scanner = new Scanner(System.in);
        char letterChar = '!';
        while (letterChar != 'M' && letterChar != 'G') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Choisissez un type de personnage. 'M' pour Magicien ou 'G' Guerrier");
            String letter = scanner.nextLine();
            letterChar = letter.charAt(0);
        }
        return letterChar;
    }

    /**
     * Asks the name of the character to the player
     * @return the name of the character typed by the player
     */
    public String askCharacterName() {
        System.out.println("Entrez le nom de votre personnage : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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
     * The menu to choose between display or modify the hero's infos
     * @return the letter corresponding to the player's choice
     */
    public void askDisplayOrModifyHeroInfos() {
        Scanner scanner = new Scanner(System.in);
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
        displayDisplayOrModifyInfos(letterChar);
    }

    /**
     * Displays or modify of the player's hero
     * @param answer the letter chosen by the player
     */
    public void displayDisplayOrModifyInfos(char answer) {
        switch (answer) {
            case 'A':
                System.out.println(this.hero);
                break;
            case 'M':
                modifyCharacter();
                break;
        }
    }

    /**
     * Modifies the name of the player's hero
     */
    public void modifyCharacter() {

        System.out.println("Entrez un nouveau nom pour votre personnage");
        Scanner scanner = new Scanner(System.in);
        String newName = scanner.nextLine();
        this.hero.setName(newName);
    }


    /**
     * Ask hero's settings & creates it
     * @return an instance of the hero created
     */
    public Hero setNewHero() {

        char characterType = askCharacterType();
        String characterName = askCharacterName();
        return createNewCharacter(characterType, characterName);

    }

    /**
     * Displays the menu and directs the player according to his/her choice
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
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
        if(letterChar =='I'){
            askDisplayOrModifyHeroInfos();
        } else if(letterChar =='Q'){
            System.out.println("Au revoir et à bientôt !");
            System.exit(0);
        } else {
            //play
        }
    }

    /****MAIN METHOD***/

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Bienvenue sur le jeu !");
        Game game = new Game();
        Hero hero = game.setNewHero();
        System.out.println("Bravo ! vous avez crée votre personnage. Que voulez-vous faire maintenant ?");
        Board board = new Board();
        while(true){
            game.displayMenu();
        }

    }
}




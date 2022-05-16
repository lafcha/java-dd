package com;

import com.characters.heroes.Hero;
import com.game.Game;

import java.util.Scanner;

public class Menu {

    /***ATTRIBUTES***/
    private Scanner scanner = new Scanner(System.in);

    /***GETTERS***/
    public Scanner getScanner() {
        return scanner;
    }

    /***METHODS***/

    /**
     * Ask hero's settings & creates it
     *
     * @return an instance of the hero created
     */
    public char chooseHeroTypeMenu() {
        char letterChar = '!';
        while (letterChar != 'M' && letterChar != 'G') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Choisissez un type de personnage. 'M' pour Magicien ou 'G' Guerrier");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }

        }
        return letterChar;
    }

    /**
     * Asks the name of the hero
     * @return String hero's name
     */
    public String chooseHeroNameMenu() {
        System.out.println("Entrez le nom de votre personnage : ");
        String letter ="";
        try {
            letter = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("La lettre que vous avez tapé n'est pas correcte");
        }
        return letter;
    }

    /**
     * Asks a new name for the hero
     * @return String new hero's name
     */
    public String chooseNewHeroNameMenu() {
        System.out.println("Entrez le nouveau nom de votre personnage : ");
        String letter ="";
        try {
            letter = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("La lettre que vous avez tapé n'est pas correcte");
        }
        return letter;
    }

    /**
     * Displays the menu and directs the player according to his/her choice
     * @return Char J, I, Q according to the player's choice
     */
    public char displayBeforeGameMenu() {
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
        return letterChar;
    }


    /**
     * The menu when the player is playing, asks wether s/he wants to launch the dice or quit
     * @return char, according to the player's choice
     */
    public char turnMenu() {
        char letterChar = '!';
        while (letterChar != ' ' && letterChar != 'Q' && letterChar != 'I') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez sur la barre d'espace, puis Entrée pour lancer le dé.");
            System.out.println("Tapez sur I pour afficher votre inventaire.");
            System.out.println("Tapez sur Q pour quitter.");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;
    }

    /**
     * Asks what the player wants to do when he enconters a new equipment
     * @return char, according to the player's choice
     */
    public char getNewEquipmentMenu(){
        char letterChar = '!';
        while (letterChar != 'U' && letterChar != 'S') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez sur U pour utiliser ce nouvel équipement.");
            System.out.println("Tapez sur S pour stocker cet équipement dans votre inventaire.");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;
    }

    public char displayInventory(Hero hero){
        char letterChar = '!';
        while (letterChar != 'Q' ) {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            hero.getInventory().displayAllEquipments();
            System.out.println("Tapez sur Q pour quitter et revenir au jeu.");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;


    }

    /**
     * Asks the player if s/he want to fight or flee a fight when fighting a monster.
     * @return char, according to the player's choice
     */
    public char fightMenu(){
        char letterChar = '!';
        while (letterChar != 'F' && letterChar != 'C' && letterChar != 'U') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez sur F pour Fuir le combat. Vous reculerez d'un nombre aléatoire entre 1 et 6 cases.");
            System.out.println("Tapez sur C pour Combattre le monstre.");
            System.out.println("Tapez sur U pour utiliser un équipement.");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;
    }

    /**
     * The menu to choose between display or modify the hero's infos
     * @return the letter corresponding to the player's choice
     */
    public char displayOrModifyHeroInfos() {
        char letterChar = '!';
        while (letterChar != 'M' && letterChar != 'A') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez 'A' pour afficher les infos de votre personnage");
            System.out.println("Tapez 'M' pour modifier les infos de votre personnage");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }

        }
        return letterChar;
    }


    /**
     * Displays the Menu after a game, asks if the players wants to launch again or to exit
     * @return char, according to the player's choice
     */
    public char displayEndOfGameMenu() {
        char letterChar = '!';
        while (letterChar != 'R' && letterChar != 'Q') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez 'R' pour Rejouer ");
            System.out.println("Tapez 'Q' pour Quitter ");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;
    }
}
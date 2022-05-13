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

    /***SETTERS***/

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


    public char turnMenu() {
        char letterChar = '!';
        while (letterChar != ' ' && letterChar != 'Q') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez sur la barre d'espace, puis Entrée pour lancer le dé.");
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

    public char displayFleeOrFightMenu(){
        char letterChar = '!';
        while (letterChar != 'F' && letterChar != 'C') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Tapez sur F pour Fuir le combat. Vous reculerez d'un nombre aléatoire entre 1 et 6 cases.");
            System.out.println("Tapez sur C pour Combattre le monstre.");
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
     *
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
     * Displays the Menu and launches again the game or exit according to the player's choice
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
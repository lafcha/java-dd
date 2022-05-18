package com;

import com.bdd.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    /***ATTRIBUTES***/


    private Scanner scanner;

    /***CONSTRUCTORS***/

    public Menu() {
        scanner = new Scanner(System.in);

    }

    /***METHODS***/


    public char createOrUseHeroMenu() {
        char letterChar = '!';
        while (letterChar != 'O' && letterChar != 'N') {
            if (letterChar != '!') {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            System.out.println("Voulez-vous utiliser un héros déjà enregistrer ou en créer un nouveau ?");
            System.out.println("Tapez 'O' Oui pour utiliser un héros enregistré");
            System.out.println("Tapez 'N' Non pour créer un nouveau héros");
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }

        }
        return letterChar;

    }

    public int selectSavedHero(Request request, Connection dbConnection) throws SQLException {
        try {
            ResultSet result = request.getAllHeroes(dbConnection);
            System.out.println("Tapez le numéro du Héros que vous souhaitez utiliser");
            int selectedNb = -1;
            if (selectedNb != -1) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            while (result.next()) {
                System.out.println(result.getInt("Id") + "." + result.getString("Name") + " : " + result.getString("Type"));
            }
            try {
                selectedNb = scanner.nextInt();
                scanner.nextLine();
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
            return selectedNb;

        } catch (SQLException e) {
            System.out.println("Erreur de base de données");
        }
        return ' ';
    }


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
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }

        }
        return letterChar;
    }

    public String chooseHeroNameMenu() {
        System.out.println("Entrez le nom de votre personnage : ");
        String letter = "";
        try {
            letter = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("La lettre que vous avez tapé n'est pas correcte");
        }
        return letter;
    }

    public String chooseNewHeroNameMenu() {
        System.out.println("Entrez le nouveau nom de votre personnage : ");
        String letter = "";
        try {
            letter = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e) {
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
            try {
                String letter = scanner.nextLine();
                letterChar = letter.charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
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
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;
    }

    /**
     * Allows the player to flee a fight.
     * @return char, the player's choice.
     */
    public char displayFleeOrFightMenu() {
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
            } catch (StringIndexOutOfBoundsException e) {
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
            } catch (StringIndexOutOfBoundsException e) {
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
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("La lettre que vous avez tapé n'est pas correcte");
            }
        }
        return letterChar;
    }


    /***GETTERS***/

    public Scanner getScanner() {
        return scanner;
    }

    /***SETTERS***/

}
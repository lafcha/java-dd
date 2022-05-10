package com;

import com.game.Board;
import com.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while (game.getStillPlaying()) {
            System.out.println("Bienvenue sur le jeu !");
            game.setHero(game.setAndCreateNewHero());
            System.out.println("Bravo ! vous avez crée votre personnage. Que voulez-vous faire maintenant ?");
            game.setBoard(new Board()) ;
            while (game.getDisplayMenu()) {
                game.displayMenu();
            }
            game.displayEndOfGameMenu();
        }
    }
}

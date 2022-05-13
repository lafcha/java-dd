package com.game;

import com.characters.heroes.Hero;
import com.game.ISurprise;

public class EmptySquare implements ISurprise {
    /**
     *
     * @param hero the hero playing
     * @return a string indicating the case is empty.
     */
    public String openSurprise(Hero hero){
        return "La case est vide ! ";
    }
}
package com.game;

import com.Menu;
import com.characters.heroes.Hero;
import com.game.ISurprise;

public class EmptySquare implements ISurprise {

    /***CONSTRUCTOR***/
    /**
     *
     * @param hero the hero playing
     * @return a string indicating the case is empty.
     */
    public String openSurprise(Hero hero, Menu menu){
        return "La case est vide ! ";
    }
}

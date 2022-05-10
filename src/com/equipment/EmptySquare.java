package com.equipment;

import com.characters.heroes.Hero;
import com.game.ISurprise;

public class EmptySquare implements ISurprise {
    public String openSurprise(Hero hero){
        return "La case est vide ! ";
    }
}

package com.game;

import com.characters.monsters.Gobelin;
import com.equipment.weapons.Sword;

public class cheatSquare {

    /****ATTRIBUTES***/
    ISurprise surprise;

    public cheatSquare(){
        surprise = new Sword();
    }
    public ISurprise getSurprise(){
        return surprise;
    }

}

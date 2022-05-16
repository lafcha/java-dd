package com.game;

import com.characters.monsters.Gobelin;

public class cheatSquare {

    /****ATTRIBUTES***/
    ISurprise surprise;

    public cheatSquare(){
        surprise = new Gobelin();
    }
    public ISurprise getSurprise(){
        return surprise;
    }

}

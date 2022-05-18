package com.game;

import com.characters.monsters.Gobelin;

public class cheatSquare {

    /****ATTRIBUTES***/
    ISurprise surprise;

    /****CONSTRUCTOR****/

    public cheatSquare(){
        surprise = new Gobelin();
    }

    /****METHODS****/
    public ISurprise getSurprise(){
        return surprise;
    }

}

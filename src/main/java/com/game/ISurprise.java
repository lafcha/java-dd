package com.game;

import com.Menu;
import com.characters.heroes.Hero;
import com.exceptions.fleeingException;

public interface ISurprise {

    /***CONSTRUCTOR***/
    public String openSurprise(Hero hero, Menu menu) throws fleeingException;
}

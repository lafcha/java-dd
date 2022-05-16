package com.game;

import com.Menu;
import com.characters.heroes.Hero;
import com.exceptions.FleeingException;

public interface ISurprise {

    public String openSurprise(Hero hero, Menu menu) throws FleeingException;
}

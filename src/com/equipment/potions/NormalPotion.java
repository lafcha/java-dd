package com.equipment.potions;

import com.Menu;
import com.characters.heroes.Hero;
import com.exceptions.FleeingException;

public class NormalPotion extends Potion {

    public NormalPotion(){
        super(2, "Potion Standard");

    }

    @Override
    public String openSurprise(Hero hero, Menu menu) throws FleeingException {
        return null;
    }
}

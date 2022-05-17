package com.equipment.potions;

import com.Menu;
import com.characters.heroes.Hero;
import com.exceptions.fleeingException;

public class NormalPotion extends Potion {

    public NormalPotion(){
        super(2, "standard");

    }

    @Override
    public String openSurprise(Hero hero, Menu menu) throws fleeingException {
        return null;
    }
}

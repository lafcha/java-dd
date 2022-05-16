package com.equipment;

import com.equipment.potions.LargePotion;
import com.equipment.spells.Fireball;
import com.equipment.weapons.Hammer;
import com.equipment.weapons.Sword;

import java.util.*;

public class Inventory {

    /***ATTRIBUTES***/
     Map<Equipment, Integer> inventory;
    /***CONSTRUCTORS***/
    public Inventory() {
       inventory = new HashMap<>();
        inventory.put(new Hammer(), 5);
        inventory.put(new Sword(), 2);
        inventory.put(new Fireball(), 1);
        inventory.put(new LargePotion(), 3);
     }
    /***GETTERS***/

    /***SETTERS***/

    /***METHODS***/
    public void addNewEquipment(Equipment equipment) {

        if(inventory.containsKey(equipment)){
            inventory.put(equipment, inventory.get(equipment)+1);
        } else {
            inventory.put(equipment, 1);
        }
    }

    public void removeEquipment(Equipment equipment) {
        if(inventory.get(equipment) !=1 ){
            inventory.put(equipment, inventory.get(equipment)-1);
        } else {
            inventory.remove(equipment);
        }
    }


    public void displayAllEquipments() {
    for(Map.Entry<Equipment, Integer> set : inventory.entrySet()){
        System.out.println(set.getKey().getName() + " : " + set.getValue());
    }


    }


}

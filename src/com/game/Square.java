package com.game;

import com.characters.monsters.Dragon;
import com.characters.monsters.Gobelin;
import com.characters.monsters.Sorcer;
import com.equipment.EmptySquare;
import com.equipment.potions.LargePotion;
import com.equipment.potions.NormalPotion;
import com.equipment.spells.Fireball;
import com.equipment.spells.Lightning;
import com.equipment.weapons.Hammer;
import com.equipment.weapons.Sword;

import java.util.Random;

public class Square {

    /****ATTRIBUTES***/
   ISurprise surprise;

   /****CONSTRUCTOR****/

    public Square(){

        Random random = new Random();
        int randomSquareType = random.nextInt(100 - 1) + 1;

        if (randomSquareType > 70){
            int randomMonsterType = random.nextInt(100 - 1) + 1;
            if(randomMonsterType > 66){
                surprise = new Gobelin();
            } else if (randomMonsterType > 33){
                surprise = new Dragon();
            } else {
                surprise = new Sorcer();
            }
        } else if(randomSquareType > 30){
            int randomEquipmentType = random.nextInt(100 - 1) + 1;
            if(randomEquipmentType > 66){
                int randomPotionType = random.nextInt(100 - 1) + 1;
                if(randomPotionType > 50){
                    surprise = new LargePotion();
                } else {
                    surprise = new NormalPotion();
                }
            } else if (randomEquipmentType > 33){
                int randomSpellType = random.nextInt(100 - 1) + 1;
                if(randomSpellType > 50){
                    surprise = new Lightning();
                } else {
                    surprise = new Fireball();
                }
            } else {
                int randomWeaponType = random.nextInt(100 - 1) + 1;
                if(randomWeaponType > 50){
                    surprise = new Hammer();
                } else {
                    surprise = new Sword();
                }
            }
        } else {
            surprise = new EmptySquare();
        }
    }

    /****METHODS****/

    public ISurprise getSurprise(){
        return surprise;
    }

}

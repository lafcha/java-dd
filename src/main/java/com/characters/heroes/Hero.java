package com.characters.heroes;


import com.characters.Character;
import com.equipment.Equipment;
import com.equipment.spells.Spell;
import com.equipment.weapons.Weapon;

public abstract class Hero extends Character {

    /****ATTRIBUTES***/
    private String image;
    private int maxLifePoints;
    private int maxAttackForce;

    private int position;

    private Equipment weapon;

    /****GETTERS****/
    public String getImage() {
        return image;
    }

    public int getMaxAttackForce() {
        return maxAttackForce;
    }

    public int getMaxLifePoints() {
        return maxLifePoints;
    }
    public int getPosition() {
        return position;
    }
    public Equipment getWeapon() {
        return weapon;
    }

    /****SETTERS****/
    public void setImage(String imagePath) {
        this.image = imagePath;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }

    public void setMaxAttackForce(int maxAttackForce) {
        this.maxAttackForce = maxAttackForce;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void setWeapon(Equipment hasWeapon) {
        this.weapon = hasWeapon;
    }

    /****CONSTRUCTOR***/
    /**
     * @param name name of the hero.
     * @param lifePoints lifepoints of the hero. Depends on the hero type & the fights.
     * @param force attack points of the hero.
     * @param maxLifePoints maximum of lifepoints a hero can have.
     * @param maxAttackForce maximum of attack points a hero can have.
     */
    public Hero(String name, int lifePoints, int force, int maxLifePoints, int maxAttackForce) {
        super(name, lifePoints, force);
        this.maxAttackForce = maxAttackForce;
        this.maxLifePoints = maxLifePoints;
        this.weapon = null;
    }

    /****METHODS****/
    /**
     * @return a String with the hero's characteristics
     */
    @Override
    public String toString() {
        return "Vous vous appelez " + getName() + ". Vous êtes un " + this.getClass().getSimpleName() + ". Vous avez " + getLifePoints() + " points de vie et " + getForce() +" points d'attaque.";

    }


}

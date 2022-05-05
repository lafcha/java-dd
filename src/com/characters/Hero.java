package com.characters;


import com.equipment.Equipment;

public class Hero extends Character {

    /****ATTRIBUTES***/
    private String image;
    private int maxLifePoints;
    private int maxAttackForce;
    private Equipment equipment;

    /****CONSTRUCTOR***/

    public Hero(String name, int lifePoints, int force, int maxLifePoints, int maxAttackForce){
        super(name, lifePoints, force);
        this.maxAttackForce = maxAttackForce;
        this.maxLifePoints = maxLifePoints;

    }

    /****GETTERS****/
    public String getImage() {
        return image;
    }
    public Equipment getEquipment(){return equipment;}

    /****SETTERS****/
    public void setImage(String imagePath) {
        this.image = imagePath;
    }
    public void setEquipment(Equipment equipment){this.equipment = equipment;}

    /****METHODS****/

    /**
     * Sets the position of the player after the dice has been launched
     * @param diceResult
     */
    public void goForward(int diceResult) {

        int newPosition = getPosition() + diceResult;
        //todo : add in case newPosition > 64 => launch a function to verify if the player has won
        this.setPosition(newPosition);
    }

    @Override
    public String toString() {
        return "Nom : " + getName() +" | Type de héros : "+  this.getClass().getSimpleName() + " | Points de vie : " + getLifePoints() + " | Points d'attaque : " +getForce();
    }

    public static void main(String[] args) {

    }
}

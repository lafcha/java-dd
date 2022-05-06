package com.characters;


import com.equipment.Equipment;

public abstract class Hero extends Character {

    /****ATTRIBUTES***/
    private String image;
    private int maxLifePoints;
    private int maxAttackForce;
    private Equipment equipment;
    private int position;

    /****GETTERS****/
    public String getImage() {
        return image;
    }
    public Equipment getEquipment(){return equipment;}
    public int getPosition(){
        return position;
    }

    /****SETTERS****/
    public void setImage(String imagePath) {
        this.image = imagePath;
    }
    public void setEquipment(Equipment equipment){this.equipment = equipment;}
    public void setPosition (int position){
        this.position = position;
    }

    /****CONSTRUCTOR***/

    public Hero(String name, int lifePoints, int force, int maxLifePoints, int maxAttackForce){
        super(name, lifePoints, force);
        this.maxAttackForce = maxAttackForce;
        this.maxLifePoints = maxLifePoints;

    }

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


}

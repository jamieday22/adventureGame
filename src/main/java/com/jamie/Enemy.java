package com.jamie;

public class Enemy {

    static String enemyName = "Rat";

    public int maxHealth;
    public int currHealth;
    public int damageHigh;
    public int damageLow;
    public String enemyType;



    public void takeDamage(Player player){
        int damage = player.getDamage();
        this.currHealth -= damage;
        System.out.println("You deal " + damage + " damage.");
        if (enemyIsDead()){
            System.out.println("The enemy " + this.enemyType + " has been defeated.");
            boolean dead = false;
            return;
        }
        System.out.println("The enemy has " + this.currHealth + " health left.");

    }


    public boolean enemyIsDead(){
        if (this.currHealth > 0){
            return false;
        }
        else {
            return true;
        }
    }

    public Enemy(){

    }



    public void printEnemyStats() {
        System.out.println("Type: " + enemyType + "\nHealth: " + currHealth + "\n");
    }
}

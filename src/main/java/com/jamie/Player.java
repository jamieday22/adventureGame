package com.jamie;

import java.util.Random;


public class Player {

    int damageMin = 20;
    int damageMax = 40;
    int maxHealth = 100;
    int currentHealth = maxHealth;

    Decision fightOption;
    Location location;

    public int getDamage(){
        Random rand = new Random();
        int damage = rand.nextInt(damageMin, damageMax);
        return damage;
    }


    public void attack(Enemy enemy) {
        enemy.takeDamage(this);
    }

    public Player() {
        Decision fightOption = new Decision();
        fightOption.add("attack");
        fightOption.add("run");
        this.fightOption = fightOption;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setFightOption(Decision decision)
    {
        this.fightOption = decision;

    }

    public Decision getFightOption()
    {
        return this.fightOption;
    }




    }







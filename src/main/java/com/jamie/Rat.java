package com.jamie;

public class Rat extends Enemy {


    public Rat(){
        enemyType = "rat";
        maxHealth = 100;
        currHealth = maxHealth;
        damageHigh = 20;
        damageLow = damageHigh / 2;
    }




}

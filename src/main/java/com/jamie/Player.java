package com.jamie;

import java.awt.*;

public class Player {

    int health = 22;
    Decision fightOption;
    Location location;


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







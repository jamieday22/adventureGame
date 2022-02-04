package com.jamie;

public class Location  {

    Decision decision;
    int[] coordinates = new int[0];
    String text;
    Enemy enemy;

    public void setText(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }

    public void setCoordinates(int[] coordinates)
    {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates()
    {
        return this.coordinates;
    }

    public void setDecision(Decision decision)
    {
        this.decision = decision;
    }

    public Decision getDecision()
    {
        return this.decision;
    }

    public void setEnemy(Enemy enemy)
    {
        this.enemy = enemy;
    }

    public Enemy getEnemy()
    {
        return this.enemy;
    }

}

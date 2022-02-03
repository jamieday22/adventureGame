package com.jamie;

public class Location  {

    Decision decision;
    int[] coordinates = new int[2];

    public Location () {

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
}

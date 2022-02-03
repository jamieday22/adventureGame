package com.jamie;

import java.util.ArrayList;

public class Decision {

    ArrayList<String> choices = new ArrayList<String>();
    String selection;

    public Decision() {

    }

    public void add(String newDecision){
        choices.add(newDecision);
    }

    public void select(String selection){
        this.selection = selection;
    }

    public String getSelection(){
        return this.selection;
    }

    @Override
    public String toString(){
        return choices.toString();
    }

}

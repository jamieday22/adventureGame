package com.jamie;





public class Main {

    public static void main (String[] args){


        {
            Sewer sewer = new Sewer();
            Player player = new Player();
            sewer.setPlayer(player);


            sewer.loop();
        }


    }






}

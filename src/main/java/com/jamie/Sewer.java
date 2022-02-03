package com.jamie;

public class Sewer {

    public Sewer () {



        Location location00 = new Location();
        int[] coordinates00 = {0,0};
        Decision decision00 = new Decision();
        decision00.add(String.valueOf(Direction.South));
        decision00.add(String.valueOf(Direction.East));
        location00.setCoordinates(coordinates00);
        location00.setDecision(decision00);
        System.out.println("welcome");
        this.addLocation(location00);



        this.startingLocation = location00;
    }

    Location[][] mySewer = new Location[3][3];
    Player player;
    Location startingLocation;

    public void setPlayer(Player player) {
        player.setLocation(this.startingLocation);
        this.player = player;
    }

    public void addLocation(Location location) {
        int[] coordinates = location.getCoordinates();
        mySewer[coordinates[0]][coordinates[1]] = location;
    }

    public void loop() {
        boolean playing = true;

        while (playing) {

            Location location = player.getLocation();

            Decision decision = location.getDecision();


            System.out.println(location);

            String str = ("Your current choices are: " + decision + "\nWhat will you do? ");



            if (decision.getSelection().equals(Direction.North)) {
                int[] coordinates = location.getCoordinates();
                player.setLocation(mySewer[coordinates[0]][coordinates[1] + 1]);

            } else if (decision.getSelection().equals(Direction.South)) {
                int[] coordinates = location.getCoordinates();
                player.setLocation(mySewer[coordinates[0]][coordinates[1] - 1]);

            } else if (decision.getSelection().equals(Direction.East)) {
                int[] coordinates = location.getCoordinates();
                player.setLocation(mySewer[coordinates[0] + 1][coordinates[1]]);

            } else if (decision.getSelection().equals(Direction.West)) {
                int[] coordinates = location.getCoordinates();
                player.setLocation(mySewer[coordinates[0] - 1][coordinates[1]]);

            } else {
                System.out.println("\ninvalid\n");
            }
        }
    }
}
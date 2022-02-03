package com.jamie;

public class Sewer {

    Location[][] mySewer = new Location[3][3];
    Player player;
    Location startingLocation;


    public Sewer () {



        Location location00 = new Location();
        int[] coordinates00 = {0,0};
        Decision decision00 = new Decision();
        decision00.add(String.valueOf(Direction.South));
        decision00.add(String.valueOf(Direction.East));
        location00.setCoordinates(coordinates00);
        location00.setDecision(decision00);
        location00.setText("This is your first room ");
        this.addLocation(location00);



        this.startingLocation = location00;
    }



    public void setPlayer(Player player) {
        player.setLocation(this.startingLocation);
        this.player = player;
    }

    public void addLocation(Location location) {
        int[] coordinates = location.getCoordinates();
        mySewer[coordinates[0]][coordinates[1]] = location;
    }

    
    @SuppressWarnings("InfiniteLoopStatement")
    public void loop() {
        boolean playing = true;


        while (true) {

            Location location = player.getLocation();

            Decision decision = location.getDecision();


            System.out.println(location.getText());


            switch (decision.getSelection()) {
                case "North" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0]][coordinates[1] + 1]);

                }
                case "South" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0]][coordinates[1] - 1]);

                }
                case "East" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0] + 1][coordinates[1]]);

                }
                case "West" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0] - 1][coordinates[1]]);

                }
                default -> System.out.println("\ninvalid\n");
            }
        }
    }
}
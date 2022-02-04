package com.jamie;
import java.util.Scanner;

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

        Location location01 = new Location();
        int[] coordinates01 = {0,0};
        Decision decision01 = new Decision();
        decision01.add(String.valueOf(Direction.South));
        decision01.add(String.valueOf(Direction.East));
        location01.setCoordinates(coordinates01);
        location01.setDecision(decision01);
        location01.setText("This is your second room ");
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



        while (true) {

            Location location = player.getLocation();

            Decision decision = location.getDecision();


            System.out.println(location.getText());

            Scanner inputRead = new Scanner(System.in);
            switch ((inputRead.next())+ decision.getSelection()) {
                case "North" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0]][coordinates[1] + 1]);
                    break;
                }

                case "South" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0]][coordinates[1] - 1]);
                    break;
                }
                case "East" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0] + 1][coordinates[1]]);
                    break;
                }
                case "West" -> {
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0] - 1][coordinates[1]]);
                    break;
                }
                default -> System.out.println("\ninvalid\n");
            }
        }
    }
}
package com.jamie;
import java.util.Scanner;

public class Sewer {

    Location[][] mySewer = new Location[2][2]; // size
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

    Scanner input = new Scanner(System.in);

    public String readLine(String prompt){
        System.out.print(prompt);
        return input.nextLine();
    }

    public Sewer() {


        Location location00 = new Location();
        int[] coordinates00 = {0, 0};
        Decision decision00 = new Decision();
        decision00.add(String.valueOf(Direction.North));
        decision00.add(String.valueOf(Direction.East));
        decision00.add(String.valueOf(Direction.South));
        decision00.add(String.valueOf(Direction.West));
        location00.setCoordinates(coordinates00);
        location00.setDecision(decision00);
        location00.setText("This is your first room ");
        System.out.println(player);
        this.addLocation(location00);

        /////////////////////////////////////////////////////////////////////////////////

        Location location10 = new Location();
        int[] coordinates10 = {1, 0};
        Decision decision10 = new Decision();
        Rat rat = new Rat();
        decision10.add(String.valueOf(Direction.North));
        decision10.add(String.valueOf(Direction.South));
        decision10.add(String.valueOf(Direction.West));
        decision10.add("fight");
        location10.setCoordinates(coordinates10);
        location10.setDecision(decision10);
        location10.setText("This is your second room ");
        location10.setEnemy(rat);
        this.addLocation(location10);


        /////////////////////////////////////////////////////////////////////////////////

        Location location01 = new Location();
        int[] coordinates01 = {0, 1};
        Decision decision01 = new Decision();
        decision01.add(String.valueOf(Direction.North));
        decision01.add(String.valueOf(Direction.East));
        decision01.add(String.valueOf(Direction.South));
        decision01.add(String.valueOf(Direction.West));
        location01.setCoordinates(coordinates01);
        location01.setDecision(decision01);
        location01.setText("East ");
        System.out.println(player);
        this.addLocation(location01);

        /////////////////////////////////////////////////////////////////////////////////

        Location location11 = new Location();
        int[] coordinates11 = {1, 1};
        Decision decision11 = new Decision();
        decision11.add(String.valueOf(Direction.North));
        decision11.add(String.valueOf(Direction.East));
        decision11.add(String.valueOf(Direction.South));
        decision11.add(String.valueOf(Direction.West));
        location11.setCoordinates(coordinates11);
        location11.setDecision(decision11);
        location11.setText("11 ");
        this.addLocation(location11);

        /////////////////////////////////////////////////////////////////////////////////

        this.startingLocation = location00;
    }


    public void loop() {

        while (true) {


            Location location = player.getLocation();

            Decision decision = location.getDecision();

            System.out.println(location.getText());


         String next = readLine("You only have " + decision + " to move make a choice"+"\n");
            decision.select(next);

            switch (decision.getSelection()) {
                case "North" -> {
                    System.out.println("moving on");
                    int[] coordinates = location.getCoordinates();
                    player.setLocation(mySewer[coordinates[0]][coordinates[1] + 1]);
                }

                case "South" -> {
                    System.out.println("South");
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
                    ;
                }
                case "fight" ->{
                    Enemy enemy = location.getEnemy();
                    fightLoop(enemy);
                }

                default -> System.out.println("invalid request");
            }


        }
    }

    public void fightLoop(Enemy enemy)
    {
        boolean fighting = true;

        System.out.println( "a nasty "+Enemy.enemyName+" has appeared");
        while(fighting) {

            Decision decision = player.getFightOption();
            String str = readLine("Your current choices are: " + decision.toString() + "\nWhat will you do? ");
            decision.select(str);
            if (decision.getSelection().equals("attack")) {
                enemy.printEnemyStats();
                System.out.println("you attacked!");
                enemy.takeDamage(player);
                if(enemy.enemyIsDead()){
                    (fighting) = false;
                }


            } else if (decision.getSelection().equals("run")) {
                System.out.println("\n"+"you little bitch"+"\n");
                fighting = false;
            } else {
                System.out.println("\ninvalid option\n");
            }

        }
    }
}


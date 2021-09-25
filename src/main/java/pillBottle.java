//Java
//Authors: Brendan Loyd bmlnh9@umsystems.edu
//HomeWork 2 4500
//09-17-2021
//External files: None

package main.java;
import java.util.*;

//This program simulates taking half a pill from a pill bottle a day and examines the differences of half to whole pills
//in the bottle at the beginning of each day, before the pill is taken.

//This class holds the wholePills and half Pills from each simulation to be stored in a hashmap
class PillCount {
    private int wholePills;
    private int halfPills;

    //constructor
    public PillCount(int wholePills, int halfPills) {
        this.wholePills = wholePills;
        this.halfPills = halfPills;
    }

    //get half pill ratio
    public double getHalfPillRatio() {
        return this.halfPills / (double) (this.wholePills + this.halfPills);
    }

    public int getWholePills() {
        return wholePills;
    }

    public void setWholePills(int wholePills) {
        this.wholePills = wholePills;
    }

    public int getHalfPills() {
        return halfPills;
    }

    public void setHalfPills(int halfPills) {
        this.halfPills = halfPills;
    }
}

//The main class of the program.
public class pillBottle {
    //validates inputs made by the user.
    public static int validateInputs(int min, int max, Scanner scanner) {
        boolean tryFlag = true;
        int input = -1;
        while(tryFlag) {
            try {
                input = scanner.nextInt();
                while (input < min || input > max) {
                    System.out.print("That is an invalid input. Please enter a number between " + min + " and " + max +": ");
                    input = scanner.nextInt();
                }
                tryFlag = false;
            } catch (Exception e) {
                System.err.print("Wrong input! Please enter an Integer: ");
                scanner.nextLine();
            }
        }
        return input;
    }

    //Fills the bottle with pills.
    public static void fillBottle(int pills, List<Character> bottle){
        for(int j = 0; j < pills; j++){
            bottle.add('W');
        }
    }

    //Randomly selects a pill from the bottle.
    public static int getRandomElement(List<Character> list) {
        Random rand = new Random();
        return rand.nextInt(list.size());
    }

    //Simulates a half pill being taken.
    public static void takePill(List<Character> bottle) {
    int selectedPillIndex = getRandomElement(bottle);
    if(bottle.get(selectedPillIndex) == 'W') {
        bottle.set(selectedPillIndex, 'H');
        }
    else {
        bottle.remove(selectedPillIndex);
        }
    }

    //prints the header for the table.
    public static void printHeader() {
        System.out.format("%-12s %-12s %-12s %-12s\n","Day","WholePills","HalfPills","Ratio");
    }


    //Examines how many half and whole pills are in the bottle and prints results.
    public static void examineBottleDaily(List<Character> bottle, int day, HashMap<Integer, ArrayList<PillCount>> allData) {
        int wholePills = 0, halfPills = 0;
        double totalPills = 0;
        for (Character character : bottle) {
            if (character == 'W') {
                wholePills++;
            } else {
                halfPills++;
            }
        }
        totalPills = halfPills + wholePills;

        allData.putIfAbsent(day, new ArrayList<>());
        allData.get(day).add(new PillCount(wholePills, halfPills));

        System.out.format("%-12d %-12d %-12d %-12f\n", day, wholePills, halfPills, (halfPills/totalPills));
    }

    public static void examineBottleAverageChange(HashMap<Integer, ArrayList<PillCount>> allData) {
        System.out.println("\nThe daily average of simulations table.");
        printHeader();
        allData.forEach((day, simulations) -> {
            OptionalDouble wholePillsAverage = simulations.stream().mapToDouble(pillCount -> pillCount.getWholePills()).average(); //https://stackoverflow.com/questions/10791568/calculating-average-of-an-array-list
            OptionalDouble halfPillsAverage = simulations.stream().mapToDouble(pillCount -> pillCount.getHalfPills()).average();
            OptionalDouble ratioAverage = simulations.stream().mapToDouble(pillCount -> pillCount.getHalfPillRatio()).average();
            System.out.format("%-12d %-12f %-12f %-12f\n", day, wholePillsAverage.getAsDouble(), halfPillsAverage.getAsDouble(), ratioAverage.getAsDouble());
        });
    }

    //Prompts enter key after displaying results.
    //https://stackoverflow.com/questions/26184409/java-console-prompt-for-enter-input-before-moving-on/26184535
    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    //the core of the process of the program. Handles simulations, calls necessary methods, and continues til the bottle
    //is empty and simulations are finished.
    public static void pillSimulation(int pills, int simulations) {
        HashMap<Integer, ArrayList<PillCount>> allData = new HashMap<>();

        for(int i = 0; i < simulations; i++){
        List<Character> bottle = new ArrayList<>();
            int day = 0;
            fillBottle(pills, bottle);
            boolean notEmpty = true;
            System.out.println("\nSimulation table: "+ (i+1) + ".");
            printHeader();
            while(notEmpty) {
            day++;
            examineBottleDaily(bottle, day, allData);
            takePill(bottle);
            if(bottle.isEmpty()) {
                notEmpty = false;
                }
            //System.out.println(bottle);
            }
        }

        examineBottleAverageChange(allData);
    }

    //Gathers information from user and calls the pillSimulation method.
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the pill bottle simulation. This program takes in information regarding a \nprescription and examines the results of taking half a pill a day until the pills are gone.\n");

        System.out.print("Please enter the amount of pills(an integer) in the bottle(between 1 and 1000): ");
        int pills = validateInputs(1, 1000, scanner);

        System.out.print("How many simulations would you like to run?(between 1 and 1000): ");
        int simulations = validateInputs(1, 1000, scanner);

        System.out.println("You have decided to run a simulation of a pill bottle having: " + pills + " pills: " + simulations + " times.");
        pillSimulation(pills, simulations);
    }

    //Main function to start and end the program.
    public static void main (String[] args) {
        menu(); //To start
        promptEnterKey(); //To finish
    }
}
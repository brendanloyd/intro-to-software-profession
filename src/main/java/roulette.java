package main.java;

import java.util.Scanner;

public class roulette {

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

    public static void choiceHandler(int slots, int rouletteZero, int timesVisted, int dollars, int choice) {
        switch(choice) {
            case 1:
                martingaleStrategy(slots, rouletteZero, timesVisted, dollars);
                break;
            case 2:
                randomStrategy(slots, rouletteZero, timesVisted, dollars);
                break;
            case 3:
                fixedBetStrategy(slots, rouletteZero, timesVisted, dollars);
                break;
        }
    }

    public static void martingaleStrategy(int slots, int rouletteZero, int timesVisted, int dollars) {
    }

    public static void randomStrategy(int slots, int rouletteZero, int timesVisted, int dollars) {
    }

    public static void fixedBetStrategy(int slots, int rouletteZero, int timesVisted, int dollars) {
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello welcome to the casino, we will be playing a roulette wheel game.");

        System.out.print("How many slots will be in your roulette wheel? Enter a number between 2 and 200: ");
        int slots = validateInputs(2, 200, scanner);
        System.out.println("Awesome you entered: " + slots);

        System.out.println("How many slots will be labeled with 0/00? Enter an number between 0 and 2:");
        int rouletteZero = validateInputs(0, 2, scanner);
        System.out.println("Awesome you entered: " + rouletteZero);

        System.out.println("How many times would you like to visit the casino? Enter a number between 1 and 100,000:");
        int timesVisted = validateInputs(1, 100000, scanner);
        System.out.println("Awesome your going to visit: " + timesVisted + " times.");

        System.out.println("How many dollars would you like to start with each time? Enter a number between 1 and 1,000,000:");
        int dollars = validateInputs(1, 1000000, scanner);
        System.out.println("Awesome your going to start with: " + dollars);

        System.out.println("Choose a betting strategy:\n1)The Martingale Strategy.\n2)The Random Strategy.\n3)The Fixed Bet Strategy.");
        System.out.println("Enter a choice(1, 2, or 3):");
        int strategyChoice = validateInputs(1, 3, scanner);
        System.out.println("Awesome your choice was: " + strategyChoice);
        choiceHandler(slots, rouletteZero, timesVisted, dollars, strategyChoice);
    }


    public static void main(String[] args) {
        menu();

    }
}

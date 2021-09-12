package main.java;

import java.util.Scanner;

public class roulette {

    public static int validateInputs(int min, int max){
        Scanner scanner = new Scanner(System.in);
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

    public static void menu(int slots, int rouletteZero, int timesVisted, int dollars) {
        Scanner scanner = new Scanner(System.in);
        boolean tryFlag = true;
        System.out.println("Hello welcome to the casino, we will be playing a roulette wheel game.");

        System.out.print("How many slots will be in your roulette wheel? Enter a number between 2 and 200: ");
        while(tryFlag) {
            try {
                slots = scanner.nextInt();
                while (slots < 2 || slots > 200) {
                    System.out.print("That is an invalid input. Please enter a number between 2 and 200: ");
                    slots = scanner.nextInt();
                }
                tryFlag = false;
            } catch (Exception e) {
                System.err.print("Wrong input! Please enter an Integer: ");
                scanner.nextLine();
            }
        }
        System.out.println("Awesome you entered: " + slots);


        System.out.println("How many slots will be labeled with 0/00? Enter an number between 0 and 2:");
        rouletteZero = scanner.nextInt();
        while (rouletteZero < 0 || rouletteZero > 2) {
            System.out.print("That is an invalid input. Please enter a number between 0 and 2: ");
            rouletteZero = scanner.nextInt();
        }
        System.out.println("Awesome you entered: " + rouletteZero);


        System.out.println("How many times would you like to vist the casino? Enter a number between 1 and 100,000:");
        timesVisted = scanner.nextInt();
        while (timesVisted < 1 || timesVisted > 100000) {
            System.out.print("That is an invalid input. Please enter a number between 1 and 100,000: ");
            timesVisted = scanner.nextInt();
        }
        System.out.println("Awesome your going to visit: " + timesVisted + " times.");


        System.out.println("How many dollars would you like to start with each time? Enter a number between 1 and 1,000,000:");
        dollars = scanner.nextInt();
        while (dollars < 1 || dollars > 1000000) {
            System.out.print("That is an invalid input. Please enter a number between 1 and 1,000,000: ");
            dollars = scanner.nextInt();
        }
        System.out.println("Awesome your going to start with: " + dollars);
        System.out.println("");
    }

    public static void martinagleStrategy() {
    }

    public static void randomStrategy() {
    }

    public static void fixedBetStrategy() {
    }

    public static void main(String[] args) {
        int slots = 0, rouletteZero = 0, timesVisted = 0, dollars = 0;
        menu(slots, rouletteZero, timesVisted, dollars);

    }
}

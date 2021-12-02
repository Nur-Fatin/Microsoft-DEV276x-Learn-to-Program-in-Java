/*
What the program does: asks the user for some info about their international trip
from the info do some conversions. Then, tell the user some info,
so they can better plan their trip

Part 1 – Greeting
Part 2 – Travel time and Budget
Part 3 – Time Difference
Part 4 – Country Area
Part 5 – Round
 */

import java.util.Scanner;

public class TripPlanner {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        greeting();
        System.out.println("**********");
        System.out.println();
        System.out.println();
        budget();
        System.out.println("**********");
        System.out.println();
        System.out.println();
        timeDifference();
        System.out.println("**********");
        System.out.println();
        System.out.println();
        countryArea();
        System.out.println("**********");
        System.out.println();
        System.out.println();
    }

    public static void greeting() {
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String city = input.nextLine();
        System.out.println("Great! " + city + " sounds like a great trip");
    }

    public static void budget() {
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double money = input.nextDouble();
        System.out.print("What is the three letter Currency symbol for your travel destination? ");
        String currencySymbol = input.next();
        System.out.print("How many " + currencySymbol + " are there in 1 USD? " );
        double conversionRate = input.nextDouble();
          System.out.println();
          System.out.println();

        System.out.println("If you are travelling for " + days + " days that is the same as " + (days * 24) +
                " hours or " + (days * 24 * 60) + " minutes");
        System.out.println("If you are going to spend $" + money + " USD that means per day you can spend up to $" +
                (((double)((int)(money / days * 100))) / 100) + " USD");
        System.out.println("Your total budget in " + currencySymbol + " is " + (((double)((int)(money * conversionRate * 100))) / 100)
                + " " + currencySymbol + ", which per day is " + (((double)((int)(money * conversionRate / days * 100))) / 100) + " " + currencySymbol);
    }

    public static void timeDifference() {
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int timeDifference = input.nextInt();
        System.out.println("That means that when it is midnight at home it will be " + (timeDifference % 24) + ":00" +
                " in your travel destination\nand when it is noon at home it will be " + (12 + timeDifference % 24) + ":00");
    }

    public static void countryArea() {
        System.out.print("What is the square area of your destination country in km2? ");
        int area = input.nextInt();
        System.out.println("In miles2 that is " + (((double)((int)(area / 2.59 * 100))) / 100) );
    }

}














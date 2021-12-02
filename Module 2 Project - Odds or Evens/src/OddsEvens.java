/*
Build "Odds and Evens" Game
What it does:  Sum up 2 numbers and see if the number is even or odd
How it works?
2 player game: the user vs computer
The user choose side, either odds or even, if the user choose odds, the computer has even. vice versa
Then, each player choose a number of fingers to play- 0 to 5.
The winner is selected by summing up all fingers and see if the number is odds or evens.

Part 1 - Pick odds or evens

 */

import java.util.*;

public class OddsEvens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Let’s play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.nextLine();

        // Part 1 - Pick odds or evens
        System.out.print("Hi " + name + ", Which do you choose? (O)dds or (E)vens ");
        String userSide = input.next();

        // 1. Display each player side
        if (userSide.startsWith("O")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        System.out.println("________________________________________");

        // Part 2 - Play the Game
        // 1. Get the numbers
        System.out.print("How many \"fingers\" do you put out? ");
        int userFingers = input.nextInt();

        Random rand = new Random();
        int computerFingers = rand.nextInt(6);
        System.out.println("The computer plays " +  computerFingers + " \"fingers\".");
        System.out.println("________________________________________");

        // 2. Sum up the numbers
        int total = userFingers + computerFingers;
        System.out.println(userFingers + " + " + computerFingers + " = " + total);

        // Part 3 - Who won? Odds or Evens?
        if (total % 2 == 0 ) {
            System.out.println(total + " is ...even!");
            if (userSide.startsWith("E")) {
                System.out.println("That means " + name + "wins! :) ");
            }else {
                System.out.println("That means computer wins! :) ");
            }

        } else {
            System.out.println(total + " is ...odd!");
            if (userSide.startsWith("O")) {
                System.out.println("That means " + name + " wins! :) ");
            }else {
                System.out.println("That means computer wins! :) ");
            }
            System.out.println("________________________________________");
        }

    }
}

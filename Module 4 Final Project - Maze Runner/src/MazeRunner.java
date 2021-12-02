import java.util.Scanner;

public class MazeRunner {
    public static final Scanner input = new Scanner(System.in);
    public static final Maze myMap = new Maze();

    public static void main(String[] args) {
        intro();

        // ******************************************** //
        System.out.println("The \"x\" represents your current position and the \".\" Represents an unknown space. " +
                "\nAs you move through the map the \".\" Will turn into either walls (\"-\") or free spaces (\"*\"). ");
        System.out.println();
        System.out.println("You only have 100 steps to move before the exit to the maze closes!");
        System.out.println();
        // ******************************************** //

        int numberOfMoves = 0;
        boolean gamePlay = true;
        while (true) {
            userMove();
            numberOfMoves++;

            if (myMap.didIWin()) {
                System.out.println("Congratulations, you made it out alive! And you did it in " + numberOfMoves + " moves");
                break;
            }
            if (numberOfMoves == 50 || numberOfMoves == 75 || numberOfMoves == 90 || numberOfMoves == 100) {
                movesMessage(numberOfMoves);
            }
            if (numberOfMoves == 100) {
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                break;
            }
        }
    }


    // Part 1 - Let the user solve the maze
    public static void intro() {
        System.out.println("Welcome to Maze Runner! \nHere is your current position: ");
        myMap.printMap();
    }

    public static String userMove() {
        boolean wrongDirection = true;
        String direction = "";

        // Make sure the direction that the user selected is either (R, L, U or D)
        while (wrongDirection) {
            System.out.print("Where would you like to move? Right (R), Left (L), Up (U) or Down (D). : ");
            direction = input.next().toUpperCase();
            if (direction.equals("R") || direction.equals("L") ||
                    direction.equals("U") || direction.equals("D")) {
                wrongDirection = false;

                // Watch out for pits
                navigatePit(direction);

                // Check if they can move in that direction
                if (direction.equalsIgnoreCase("R") && myMap.canIMoveRight()) {
                    myMap.moveRight();
                    myMap.printMap();
                } else if (direction.equalsIgnoreCase("L") && myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    myMap.printMap();
                } else if (direction.equalsIgnoreCase("U") && myMap.canIMoveUp()) {
                    myMap.moveUp();
                    myMap.printMap();
                } else if (direction.equalsIgnoreCase("D") && myMap.canIMoveDown()) {
                    myMap.moveDown();
                    myMap.printMap();
                } else {
                    System.out.println("Sorry, you’ve hit a wall. Pick a new direction to move.");
                    wrongDirection = true;
                }

            } else {
                System.out.println("Direction is not recognised. Select only one of these (R, L, U or D)");
                System.out.println();
            }

        }
        return direction;
    }

    // Part 2 – Move Limit
    // Display message after certain number of moves
    public static void movesMessage(int moves) {
        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }

    // Part 3 – Watch out for pits
    public static void navigatePit(String direction) {
        if (myMap.isThereAPit(direction)) {
            System.out.print("Watch out! There's a pit ahead, jump it? (yes or no): ");
            String jump = input.next();
            if (jump.startsWith("y")) {
                myMap.jumpOverPit(direction);
            } else {
                userMove();
            }
        }
    }
}

/*
NAMES OF PROGRAMMERS:
CANLAPAN, Daniel Martin G.
CONTRERAS, Princess Alexis G.
DELA CRUZ, Andrei Nicole J.
GARCIA, John Michael C.
HABAN, Zyryll Kurt S.
KERCHATEN, Ma. Louella Felicidad B.

Course and Class Code: CS 122/ CS122L 9308 A/B

Class Schedule: 2:30-3:30 MTH
*/
package edu.slu.prog2;

import java.util.Scanner;

public class FractionTester {
    static Scanner kbd = new Scanner(System.in);

    /**
     * Main method to initialize and run the program.
     */
    public static void main(String[] args) {
        FractionTester groupTester;
        try {
            groupTester = new FractionTester();
            groupTester.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Method to run the Fraction Tester program.
     * This method handles the main logic of the program - input, processing, and output of fractions.
     */
    public void run() throws Exception {
        Fraction result = new Fraction();
        int type = 0;
        int choice = 0;
        System.out.println("Mixed Fraction and Fraction Computer");
        System.out.println();
        System.out.println("Choose an operation:");
        System.out.println("1 - Add Fractions ");
        System.out.println("2 - Subtract Fractions");
        System.out.println("3 - Multiply Fractions ");
        System.out.println("4 - Divide Fractions ");
        System.out.println("5 - Program Termination");

        // Main loop to keep the program running until the user chooses to exit
        while (choice != 5) {
            displayMenu();
            choice = readNumber("Please input number of choice: ", 1, 5);

            // Perform operations based on user's choice
            if (choice != 5) {
                displayFractionType((byte) choice);
                type = readNumber("Please enter number of choice: ", 1, 3);
            }
            switch (choice) {
                case 1 -> result = readFraction1(type).add(readFraction2(type));
                case 2 -> result = readFraction1(type).subtract(readFraction2(type));
                case 3 -> result = readFraction1(type).multiplyBy(readFraction2(type));
                case 4 -> result = readFraction1(type).divide(readFraction2(type));
                case 5 -> {
                    System.out.println("Exiting the program, thank you for using the Fraction Tester.");
                    return;
                }
            }

            // Display the result of the operation and provide options to continue
            System.out.printf("Result: %s or %.2f%n", result.simplifyFraction(), result.toDouble());
            System.out.print("Press enter to continue.");
            kbd.nextLine();
        }
    }

    /**
     * Method to display the menu (not implemented in the provided code snippet).
     * This method would typically show the options available for the user to choose from.
     */
    private void displayMenu() {
        // Implementation of displaying menu options can be added here
    }

    /**
     * Method to read an integer input within a specified range.
     * Prompt the user to input a number within the specified range and handle input validation.
     */
    public int readNumber(String prompt, int min, int max) {
        int number = 0;
        boolean validInput = false;

        // Keep prompting the user until a valid input within the specified range is provided
        while (!validInput) {
            System.out.printf("%s", prompt);
            try {
                number = Integer.parseInt(kbd.nextLine());
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.printf("Please enter a number with a minimum of %d and a maximum of %d.%n", min, max);
                }
            } catch (NumberFormatException exception) {
                System.out.println("ERROR: Invalid number.");
                System.out.println("Please try again.");
            }
        }
        return number;
    }


    /**
     * Displays the type of fractions based on the choice.
     */
    private void displayFractionType(byte choice) {
        if (choice != 5) {
            System.out.println("""
                    [---------------------------------]
                        Please choose fractions:    
                        1.) Two Improper           
                        2.) Mixed and Improper     
                        3.) Two Mixed               
                    [---------------------------------]""");
        } else {
            System.out.println("""
                    [---------------------------------]
                        Please choose fraction:     
                        1.) Improper               
                        2.) Mixed                   
                    [---------------------------------]""");
        }
    }

    public int readNumberNotZero(String message, int min, int max) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf("%s", message);
            try {
                number = Integer.parseInt(kbd.nextLine());
                if (number >= min && number <= max && number != 0) {
                    validInput = true;
                } else {
                    System.out.printf("Please enter a NON-ZERO number with a minimum of %d and a maximum of %d.%n", min, max);
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number input, please try again.");
            }
        }
        return number;
    }


    /**
     * Reads fraction 1 based on the type provided.
     */
    public Fraction readFraction1(int type) {
        Fraction result;
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;

        System.out.println("Please enter a fraction (1)");

        switch (type) {
            case 1:
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumberNotZero("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator);
                break;
            case 2:
            case 3:
                wholeNumber = readNumber("Please enter a whole number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumberNotZero("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNumber, numerator, denominator);
                break;
            default:
                result = new Fraction(); // Handle default case if needed
                break;
        }

        return result;
    }

    /**
     * Reads fraction 2 based on the type provided.
     */
    public Fraction readFraction2(int type) {
        Fraction result = new Fraction(); // Initialize a new Fraction object
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;

        System.out.println("Please enter a fraction (2)");

        // Switch statement based on the type of fraction to be read
        switch (type) {
            case 1:
            case 2:
                // For cases 1 and 2, read numerator and denominator
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumberNotZero("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator); // Create a new Fraction object
                break;
            case 3:
                // For case 3, read whole number, numerator, and denominator
                wholeNumber = readNumber("Please enter a whole number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumberNotZero("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNumber, numerator, denominator); // Create a new MixedFraction object
                break;
        }

        return result; // Return the fraction object read
    }
}

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
    static Scanner keyboard = new Scanner(System.in);

    /**
     * Main method to initialize and run the program.
     */
    public static void main(String[] args) {
        FractionTester groupProgram;
        try {
            groupProgram = new FractionTester();
            groupProgram.run();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    /**
     * Method to run the Fraction Tester program.
     * This method handles the main logic of the program - input, processing, and output of fractions.
     */
    public void run() throws Exception {
        Fraction result;
        int choice = 0;
        int type = 0;
        System.out.println("Mixed Fraction and Fraction Computer");
        System.out.println();
        // Main loop to keep the program running until the user chooses to exit
        do {
            displayMenu();
            choice = readOperationAndNumerator("Please input number of choice: ", 1, 5);
            if (choice != 5) {
                type = displayFractionType(choice);
                result = performOperation(choice, type);
                // Display the result of the operation and provide options to continue
                System.out.printf("Result in Simplified Form: %s or %.2f%n", result.toString(), result.toDouble());
                System.out.print("Press enter to continue.");
                keyboard.nextLine();
            } else {
                System.out.println("Exiting the program, thank you for using the Fraction Tester.");
            }
        } while (choice != 5);
    }

    private Fraction performOperation(int choice, int type){
        Fraction result = new Fraction();
        Fraction fraction1 = readFraction1(type);
        Fraction fraction2 = readFraction2(type);
            switch (choice) {
                case 1 -> result = fraction1.add(fraction2).simplifyFraction();
                case 2 -> result = fraction1.subtract(fraction2).simplifyFraction();
                case 3 -> result = fraction1.multiplyBy(fraction2).simplifyFraction();
                case 4 -> result = fraction1.divide(fraction2).simplifyFraction();
                }
                return result;
            }






    /**
     * Method to display the menu (not implemented in the provided code snippet).
     * This method would typically show the options available for the user to choose from.
     */
    private void displayMenu() {
        System.out.println("Choose an operation:");
        System.out.println("1 - Add Fractions ");
        System.out.println("2 - Subtract Fractions");
        System.out.println("3 - Multiply Fractions ");
        System.out.println("4 - Divide Fractions ");
        System.out.println("5 - Program Termination");
    }

    /**
     * Method to read an integer input within a specified range.
     * Prompt the user to input a number within the specified range and handle input validation.
     */
    public int readOperationAndNumerator(String prompt, int min, int max) {
        int number = 0;
        // Keep prompting the user until a valid input within the specified range is provided
        do{
            System.out.printf("%s", prompt);
            try {
                number = Integer.parseInt(keyboard.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.printf("Please enter a number with a minimum of %d and a maximum of %d.%n", min, max);
                }
            } catch (NumberFormatException x) {
                System.out.println("Input must be a number, please try again.");
            }
        } while (true);

    }

    public int readDenominator(String message, int min, int max) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf("%s", message);
            try {
                number = Integer.parseInt(keyboard.nextLine());
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

    private int displayFractionType(int choice){
        int fractionType;
        if (choice != 5) {
            System.out.println("""
                [---------------------------------]
                    Please choose fractions:  
                    1.) Two Proper and or Proper/Improper           
                    2.) Mixed and Proper/Improper     
                    3.) Two Mixed               
                [---------------------------------]""");
            fractionType = readOperationAndNumerator("Please input number of choice: ", 1, 3);
        } else {
            System.out.println("""
                [---------------------------------]
                    Please choose fraction:   
                    1.) Proper and or Proper/Improper               
                    2.) Mixed                   
                [---------------------------------]""");
            fractionType = readOperationAndNumerator("Please input number of choice: ", 1, 2);
        }
        return fractionType;
    }


    /**
     * Reads fraction 1 based on the type provided.
     */
    public Fraction readFraction1(int type) {
        Fraction result;
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;

        System.out.println("-----Input for 1st Fraction-----");

        switch (type) {
            case 1 -> {
                numerator = readOperationAndNumerator("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readDenominator("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator);
            }
            case 2, 3 -> {
                wholeNumber = readOperationAndNumerator("Please enter a whole number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                numerator = readOperationAndNumerator("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readDenominator("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNumber, numerator, denominator);
            }
            default -> result = new Fraction(); // Handle default case if needed
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
        int wholeNum = 0;

        System.out.println("-----Input for 2nd Fraction-----");

        // Switch statement based on the type of fraction to be read
        switch (type) {
            case 1 -> {
                // For cases 1 and 2, read numerator and denominator
                numerator = readOperationAndNumerator("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readDenominator("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator); // Create a new Fraction object
            }
            case 2, 3 -> {
                // For case 3, read whole number, numerator, and denominator
                wholeNum = readOperationAndNumerator("Please enter a whole number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                numerator = readOperationAndNumerator("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readDenominator("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNum, numerator, denominator); // Create a new MixedFraction object
            }
        }

        return result; // Return the fraction object read
    }
}

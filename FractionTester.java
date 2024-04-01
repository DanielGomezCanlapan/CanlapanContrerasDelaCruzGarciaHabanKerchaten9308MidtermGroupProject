/*
NAMES OF PROGRAMMERS:
CANLAPAN, Daniel Martin G.
CONTRERAS, Princess Alexis G.
DELA CRUZ, Andrei Nicole J.
GARCIA, John Michael C.
HABAN, Zyryll Kurt S.
KERCHATEN, Ma. Louella Felicidad B.
NAME OF INSTRUCTOR:
Sir Dalos D. Miguel
Course and Class Code: CS 122/ CS122L 9308 A/B
Class Schedule: 2:30-3:30 MTH 1:30-3:00 TF(LAB)
*/
package edu.slu.prog2;

import java.util.Scanner;

public class FractionTester {
    static Scanner kbd = new Scanner(System.in);
    /**
----
     */
    public static void main(String[] args) {
        FractionTester groupProgram;
        try {
            groupProgram = new FractionTester();
            groupProgram.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
----
     */
    public void run() throws Exception {
        Fraction result = new Fraction();
        byte type = (byte) 0;
        byte choice = (byte) 0;
        System.out.println("Welcome to Fraction Tester!");
        while (choice != 6) {
            displayMenu();
            choice = (byte) readNumber("Please enter number of choice: ", 1, 6);
            if (choice != 6) {
                displayFractionType(choice);
                type = (byte) readNumber("Please enter number of choice: ", 1, 3);
            }
            switch (choice) {
                case 1 -> result = readFraction1(type).add(readFraction2(type));
                case 2 -> result = readFraction1(type).subtract(readFraction2(type));
                case 3 -> result = readFraction1(type).multiplyBy(readFraction2(type));
                case 4 -> result = readFraction1(type).divideBy(readFraction2(type));
                case 5 -> result = readFraction1(type).simplify();
                case 6 -> {
                    System.out.println("""
                            Thank you for using Fraction Tester!
                            Tester exiting...""");
                    return;
                }
            }
            System.out.printf("Result: %s or %.2f%n", result.simplify(), result.toDouble());
            System.out.print("Please press enter to continue...");
            kbd.nextLine();
        }
    }

    /**
    -----
     */
    private void displayMenu() {
        System.out.println("");
    }

    /**
-----
     */
    public int readNumber(String prompt, int min, int max) {
        int number = 0;
        boolean validInput = false;
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

    public int readNumberNotZero(String prompt, int min, int max) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf("%s", prompt);
            try {
                number = Integer.parseInt(kbd.nextLine());
                if (number >= min && number <= max && number != 0) {
                    validInput = true;
                } else {
                    System.out.printf("Please enter a NON-ZERO number with a minimum of %d and a maximum of %d.%n", min, max);
                }
            } catch (NumberFormatException exception) {
                System.out.println("ERROR: Invalid number.");
                System.out.println("Please try again.");
            }
        }
        return number;
    }

    /**
     ----
     */
    private void displayFractionType(byte choice) {
        if (choice != 5) {
            System.out.println("""
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
                    |    Please choose fractions:    |
                    |    1.) Two Im/Proper           |
                    |    2.) Mixed and Im/Proper     |
                    |    3.) Two Mixed               |
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *""");
        } else {
            System.out.println("""
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
                    |    Please choose fraction:     |
                    |    1.) Im/Proper               |
                    |    2.) Mixed                   |
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *""");
        }
    }

    public Fraction readFraction1(byte type) {
        Fraction result = new Fraction();
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
        }
        return result;
    }

    public Fraction readFraction2(byte type) {
        Fraction result = new Fraction();
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;
        System.out.println("Please enter a fraction (2)");
        switch (type) {
            case 1:
            case 2:
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumberNotZero("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new Fraction(numerator, denominator);
                break;
            case 3:
                wholeNumber = readNumber("Please enter a whole number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                numerator = readNumber("Please enter numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                denominator = readNumberNotZero("Please enter denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                result = new MixedFraction(wholeNumber, numerator, denominator);
                break;
        }
        return result;
    }
}


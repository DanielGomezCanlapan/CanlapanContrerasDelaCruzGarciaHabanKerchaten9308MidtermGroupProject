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
        System.out.println("Mixed Fraction and Fraction Computer");
        System.out.println();
        System.out.println("Choose an operation:" +
                "1 - Add Fractions" +
                "2 - Subtract Fractions" +
                "3 - Multiply Fractions" +
                "4 - Divide Fractions" +
                "5 - Exit Program");

                type = (byte) readNumber("Please enter number of choice: ", 1, 5);
            switch (type) {
                case 1 -> result = readFraction1(type).add(readFraction2(type));
                case 2 -> result = readFraction1(type).subtract(readFraction2(type));
                case 3 -> result = readFraction1(type).multiplyBy(readFraction2(type));
                case 4 -> result = readFraction1(type).divideBy(readFraction2(type));
                case 5 -> {
                    System.out.println("Program Termination");
                    System.exit(0);
                    return;
                }
            }
            System.out.printf("Result: %s or %.2f%n", result.simplify(), result.toDouble());
            System.out.print("Press [ENTER] to continue");
            kbd.nextLine();
        }
    }


    /**
-----
     */
    public int readNumber(String message, int min, int max) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf("%s", message);
            try {
                number = Integer.parseInt(kbd.nextLine());
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.printf("Please enter a number with a minimum of %d and a maximum of %d.%n", min, max);
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number input, please try again.");
            }
        }
        return number;
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
     ----
     */

    public Fraction readFraction1(byte type) {
        Fraction result = new Fraction();
        int numerator = 0;
        int denominator = 1;
        int wholeNumber = 0;
        System.out.println("Input first Fraction");
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
        System.out.println("Input second Fraction");
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


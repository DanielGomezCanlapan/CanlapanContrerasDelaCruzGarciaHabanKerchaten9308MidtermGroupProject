package edu.slu.prog2;
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int wholeNumVal) {
        this(wholeNumVal, 1);
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Denominator cannot be zero!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //--------- Setters and Getters
    public void setNumerator(int num) {
        numerator = num;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int den) {
        if (den == 0) {
            System.out.println("Denominator cannot be zero");
        }
        denominator = den;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    //--------- Addition
    public Fraction add(Fraction frac) {
        //calculate numerator
        int newNumerator = this.numerator * frac.denominator + frac.numerator * this.denominator;
        //calculate denominator
        int newDenominator = this.denominator * frac.denominator;
        //return new fraction
        return new Fraction(newNumerator, newDenominator);
    }

    //--------- Multiply
    public Fraction multiplyBy(Fraction frac) {
        //calculate numerator
        int newNumerator = this.numerator * frac.numerator;
        //calculate denominator
        int newDenominator = this.denominator + frac.denominator;
        //return new fraction
        return new Fraction(newNumerator, newDenominator);
    }

    //--------- Subtract
    public Fraction subtract(Fraction frac) {
        int num, denom;
        //calculate numerator
        num = this.numerator * frac.getDenominator() - this.getDenominator() * frac.getNumerator();
        //calculate denominator
        denom = this.denominator * frac.getDenominator();
        //return new fraction
        return new Fraction(num, denom);
    }


    //--------- Division
    public Fraction divide(Fraction frac) {
        int num, denom;
        //calculate numerator
        num = this.numerator * frac.getDenominator();
        //calculate denominator
        denom = this.denominator * frac.getNumerator();
        //return new fraction
        return new Fraction(num, denom);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Fraction simplifyFraction() {
        Fraction result = new Fraction();
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        return result;
    }

}

package com.pluralsight;

/**
 * Workbook-1c
 * Exercises – Operators
 * EXERCISE 2 - pg 69
 **/

public class VariableApp {
    public static void main(String[] args) {
        String favoriteColor = "Red";
        int classStartYear = 2026;
        char middleInitial = 'N';
        boolean hasPets = false;
        String niceMessage = "You are doing great!";

        System.out.printf("""
                My favorite color is %s.
                I started this class in %d.
                My middle initial is %c.
                I have pets: %b.
                Nice message: %s.
                """,
                favoriteColor, classStartYear, middleInitial, hasPets, niceMessage);

        System.out.println();

        int daysInWeek = 7;
        double coffeePrice = 4.99;
        char favoriteLetter = 'H';
        boolean isRaining = false;

        System.out.printf("""
                There are %d days in a week.
                A cup of coffee costs $%.2f.
                My favorite letter is %c.
                It is raining: %b.
                """,
                daysInWeek, coffeePrice, favoriteLetter, isRaining);
    }
}

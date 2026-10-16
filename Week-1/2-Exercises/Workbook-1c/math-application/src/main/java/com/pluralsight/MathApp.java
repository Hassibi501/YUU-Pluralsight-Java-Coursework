package com.pluralsight;

/**
 *  Workbook-1c: Exercises – Operators
 *  EXERCISE 3 - pg 71
 **/
public class MathApp {
    public static void main(String[] args) {
        double bobSalary = 3000;
        double garySalary = 8000;
        double highestSalary = Math.max(bobSalary, garySalary);

        System.out.println("The highest salary is: " + highestSalary);

        System.out.println();

        double carPrice = 30000;
        double truckPrice = 40000;

        System.out.println("Price of car: " + carPrice);
        System.out.println("Price of truck: " + truckPrice);

        System.out.println();

        double circleRadius = 7.25;
        double circleArea = Math.PI * Math.pow(circleRadius, 2);

        System.out.println("The radius of the circle is: " + circleRadius + " and area of the circle is: " + circleArea);

        double squareRoot = 5;
        System.out.println("The square root of 5 is: " + Math.sqrt(squareRoot));

        System.out.println("The distance between the points (5,10) and (85, 50) is: " + Math.hypot(85 - 5, 50 - 10));

        double absValue = -3.8;
        System.out.printf("The absolute value of %.1f is: %.1f\n", absValue, Math.abs(absValue));

        double randomValue = Math.random();
        System.out.println("Random value between 0.0 and 1.0: " + randomValue);

        int days = 24;
        int hours = 24;
        int minutes = 60;
        int seconds = 60;
        int milliseconds = 1000;

        System.out.printf("Number of minutes in %d days is %d\n", days, days * hours * minutes);
        System.out.printf("Number of milliseconds in %d days is %d\n", days, days * hours * minutes * seconds * milliseconds);

    }
}

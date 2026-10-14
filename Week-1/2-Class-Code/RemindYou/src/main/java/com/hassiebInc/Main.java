package com.hassiebInc;


public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Remind You app\n");

        System.out.println("Don't forget to track your distance in the fitness app");

        System.out.println("Don't forget to complete the survey.");


//        Create a Java program that stores the following information about yourself:
//        Your name
//        Your age
//        Your weight
//        Your dream salary per month
//        The first letter of your last name
//        Do you love gaming? (true or false)
//        🎯 Challenge: Choose the correct data type for each variable: String, int, double, char, or boolean.
//        ⭐ Bonus: Use System.out.println() to display all your information in the console.


        // Your name
        String name = "Hassieb";

        // Your age
        int age = 24;

        // Your weight
        double yourWeight = 9000.67;

        // Dream Salary per month
        double dreamSalaryPerMonth = 670670670.67;

        // firstLetterOfYourLastname
        char firstLetterOfLastName = 'H';

        // LovesGaming (boolean)
        boolean isGamer = true;

        System.out.println();
        System.out.printf("""
        My name is %s.
        I am %d years old.
        My weight is %f.
        My dream salary per month is %f.
        The first letter of my last name is %c.
        I love to game? %b!
        """, name, age, yourWeight, dreamSalaryPerMonth, firstLetterOfLastName, isGamer);
    }
}
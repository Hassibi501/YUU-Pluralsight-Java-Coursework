package com.netflix;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    // Access modifier in all files outside the class
    // Static means without instantiating an object
    // Void means there is no results the method excepts back

    public static void main(String[] args) {

        System.out.println("What is your name!");
        String name = scanner.nextLine();

        message(name);

        System.out.println("What is your age?");
        int age = scanner.nextInt();
        calculateHowManyYearsLeftToWork(name,age);

    }

    public static void message(String name) {
        System.out.println("Hello, how are you doing " + name + "?");
    }

    public static void calculateHowManyYearsLeftToWork(String name, int age) {
        int retirementAge = 67;
        int years = retirementAge - age;
        System.out.println(name + " you still need to work " + years + " amount of years.");

    }

}

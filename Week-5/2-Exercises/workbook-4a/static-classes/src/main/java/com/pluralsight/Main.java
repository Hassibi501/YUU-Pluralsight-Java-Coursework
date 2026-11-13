package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook 4a: Exercise - Static Classes
 * EXERCISE 1 - pg 72
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String firstName = NameFormatter.getValidUserInput(
//                scanner,
//                "Enter First Name:",
//                "^[a-zA-Z]+$",
//                "Error: Name can only have letters. No symbols, special characters or spaces are allowed."
//        );
//
//        String lastName = NameFormatter.getValidUserInput(
//                scanner,
//                "Enter Last Name:",
//                "^[a-zA-Z]+$",
//                "Error: Name can only have letters. No symbols, special characters or spaces are allowed."
//        );

        String fullName = NameFormatter.format("mel", "johnson");

        System.out.println(fullName);


        System.out.println(fullName);

    }
}
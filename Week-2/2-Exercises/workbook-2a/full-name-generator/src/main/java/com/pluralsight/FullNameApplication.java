package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook 2a: Exercises – Full Names
 * EXERCISE 1 - pg 13
 */
public class FullNameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String firstName = inputValidation(
                scanner,
                "Enter your first name:",
                true,
                "^[A-Za-z]+$",
                "First name must contain only letters."
        );

        System.out.println();

        String middleNameInitial = inputValidation(
                scanner,
                "Enter your middle name initial (optional):",
                false,
                "^[A-Z]\\.?$", //Accepts only a single uppercase letter followed by an optional period.
                "Middle initial must be a single letter or left blank."
        );

        System.out.println();

        String lastName = inputValidation(
                scanner,
                "Enter your last name:",
                true,
                "^[A-Za-z]+$",
                "Last name must contain only letters."
        );

        System.out.println();

        String suffix = inputValidation(
                scanner,
                "Enter your suffix (optional):",
                false,
                "^[A-Za-z]+\\.?$$", //Accepts common suffixes or left blank.
                "Suffix must contain only letters or be left blank."
        );

        System.out.println();


        fullNameFormatter(firstName, middleNameInitial, lastName, suffix);

        scanner.close();
    }

    public static String inputValidation(Scanner scanner, String promptMessage, boolean isRequired, String regex, String errorMessage) {
        while (true) {
            System.out.println(promptMessage);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                if (isRequired) {
                    System.out.println("Input cannot be empty. Please try again.");
                    continue;
                }
                else {
                    return input;
                }

            }

            if (!input.matches(regex)) {
                System.out.println(errorMessage);
                continue;
            }

            return input;
        }
    }

    public static void fullNameFormatter(String firstName, String middleNameInitial, String lastName, String suffix) {

        if (!middleNameInitial.isEmpty() && !middleNameInitial.endsWith(".")) middleNameInitial += "."; //Adds period if the user didn't include it.

        StringBuilder fullName = new StringBuilder();

        fullName.append(firstName).append(" ");

        if (!middleNameInitial.isEmpty()) fullName.append(middleNameInitial).append(" ");

        fullName.append(lastName);

        if (!suffix.isEmpty()) fullName.append(", ").append(suffix);


        System.out.println("Full Name: " + fullName);
    }
}

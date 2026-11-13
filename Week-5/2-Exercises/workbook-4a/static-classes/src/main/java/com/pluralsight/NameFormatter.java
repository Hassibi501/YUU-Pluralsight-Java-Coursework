package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;


public class NameFormatter {

    private NameFormatter() {}

    public static String getValidUserInput(Scanner scanner, String promptMessage, String regex, String errorMessage) {
        while (true) {
            System.out.println(promptMessage);

            String userInput = scanner.nextLine();

            if (userInput.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
                continue;
            }

            if (!userInput.matches(regex)) {
                System.out.println(errorMessage);
                continue;
            }

            return userInput;
        }
    }


    public static String format(String firstName, String lastName) {
        firstName = capitalizeFirstLetter(firstName);
        lastName = capitalizeFirstLetter(lastName);
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        firstName = capitalizeFirstLetter(firstName);
        lastName = capitalizeFirstLetter(lastName);
        middleName = capitalizeFirstLetter(middleName);
        prefix = capitalizeFirstLetter(prefix);
        suffix = capitalizeFirstLetter(suffix);

        return  prefix + firstName + lastName + middleName + suffix;
    }



    private static String capitalizeFirstLetter(String input) {
       return input.trim().substring(0,1).toUpperCase(Locale.ROOT) + input.substring(1);

    }




}

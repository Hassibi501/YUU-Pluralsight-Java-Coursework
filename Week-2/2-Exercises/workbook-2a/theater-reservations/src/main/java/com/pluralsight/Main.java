package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-2a: Exercises – High Score Wins
 * EXERCISE 4 - pg 21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fullName = inputValidator(scanner, "Enter your first name and last name:", "^[a-zA-Z]+\\s[a-zA-Z]+$", "Error: First and last name required (e.g: John Doe). Name must contain only letters. Please try again.");

        String date = inputValidator(scanner, "What date will you be coming (MM/DD/YYYY):", "^\\d{2}\\/\\d{2}\\/\\d{4}$", "Error: Date must be in the format MM/DD/YYYY. Please try again.");

        int tickets = Integer.parseInt(inputValidator(scanner, "How many tickets would you like to purchase:", "^[1-9]\\d*$", "Error: Please enter a valid number of tickets (minium 1 ticket)."));

        System.out.println();

        System.out.println(outputFormatedMessage(fullName, date, tickets));

        scanner.close();
    }

    public static String inputValidator(Scanner scanner, String promptMessage,String regex,  String errorMessage) {
        while (true) {
            System.out.println(promptMessage);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
                continue;
            }

            if (!input.matches(regex)) {
                System.out.println(errorMessage);
                continue;
            }

            return input;
        }
    }

    public static String outputFormatedMessage(String fullName, String date, int tickets) {

        String[] nameParts = fullName.split("\\s+");

        String firstName = nameParts[0];
        String lastName = nameParts[1];

        String[] dateParts = date.split("/");

        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];



        if  (tickets > 1) {
            return String.format("%d tickets reserved for %s-%s-%s under %s, %s.", tickets, year, month, day, lastName, firstName);
        }

        return String.format("%d ticket reserved for %s-%s-%s under %s, %s.", tickets, year, month, day, lastName, firstName);


    }
}
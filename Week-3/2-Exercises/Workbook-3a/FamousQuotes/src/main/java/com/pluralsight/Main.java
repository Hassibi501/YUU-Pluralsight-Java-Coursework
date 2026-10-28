package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-3a: Exercises — Famous Quotes
 * EXERCISE 1: pg 8
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] funnyQuotes = {
                "I need a break. I think I need a vacation break.",
                "I used to think I was indecisive, but now I'm not so sure.",
                "Parallel lines have so much in common. It’s a shame they’ll never meet.",
                "I’m on a seafood diet. I see food and I eat it.",
                "I told my wife she was drawing her eyebrows too high. She looked surprised.",
                "I threw a boomerang a few years ago. I now live in constant fear.",
                "The rotation of earth actually makes the day.",
                "I have a joke about construction, but I’m still working on it.",
                "I don’t trust stairs. They’re always up to something.",
                "What’s the object-oriented way to become wealthy? Inheritance."
        };


        while(true) {
            displayMenu();

            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    try {
                        displayQuote(funnyQuotes);

                        System.out.println("Select a quote (1-10): ");
                        int index = Integer.parseInt(scanner.nextLine());

                        index--; // Adjust for 0-based indexing

                        System.out.println(funnyQuotes[index]);
                        System.out.println();
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 10.\n");
                        break;
                    }

                case 2:
                    int randomIndex = (int) (Math.random() * funnyQuotes.length);
                    System.out.println(funnyQuotes[randomIndex]);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.\n");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("""
                ====Quotes Menu====
                1. Select a quote by index
                2. Show a random quote
                3. Exit""");
    }

    public static void displayQuote(String[] quotes) {
        int counter = 1;
        System.out.println("---- List of Quotes ----");
        for (String quote : quotes) {
            System.out.println(counter + ". " + quote);
            counter++;
        }
        System.out.println("------------------------");
    }
}
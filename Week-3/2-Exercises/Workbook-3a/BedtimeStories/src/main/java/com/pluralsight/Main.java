package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Workbook-3a: Exercises — Bedtime Stories
 * EXERCISE 2 - pg 17
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("""
            ===== Bedtime Stories =====
            1. Goldilocks and the Three Bears
            2. Hansel and Gretel
            3. Mary Had a Little Lamb
            4. Exit""");

            String choiceString = scanner.nextLine();

            if (!choiceString.matches("[1-4]")) {
                System.out.println("Invalid choice. Please select a number between 1 and 4.\n");
                continue;
            }


            int choice = Integer.parseInt(choiceString);

            if (choice == 4) {
                System.out.println("Exiting the application. Goodbye!");
                scanner.close();
                return;
            }


            System.out.println();

           String fileName = switch (choice) {
                case 1 -> "goldilocks.txt";
                case 2 -> "hansel_and_gretel.txt";
                case 3 -> "mary_had_a_little_lamb.txt";
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            };//switch


            readStoryFromFile(fileName);
            System.out.println();

        }//while

        }

    public static void readStoryFromFile(String fileName) {
        int counter = 1;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(counter + ". " + line);
                counter++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
    }
}
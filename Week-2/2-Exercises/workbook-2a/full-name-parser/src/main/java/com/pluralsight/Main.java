package com.pluralsight;


import java.util.Scanner;

/**
 * Workbook-2a: Exercises – Full Names
 * EXERCISE 2 - pg 15
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        String[] nameParts = name.split("\\s+");

        String firstName, middleName = "(none)", lastName;

        if (nameParts.length == 2) {
            firstName = nameParts[0];
            lastName = nameParts[1];
        }
        else if (nameParts.length == 3) {
            firstName = nameParts[0];
            middleName = nameParts[1];
            lastName = nameParts[2];
        }
        else {
            System.out.println("Error: Please provide a name in 'first last' or 'first middle last' format.");
            return;
        }

        System.out.printf("""
                
                Fist Name: %s
                Middle Name: %s
                Last Name: %s
                """, firstName, middleName, lastName);


    }
}
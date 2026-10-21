package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-2a: Exercise – Address Builder
 * EXERCISE 5 - pg 30
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder addressBuilder = new StringBuilder();

        System.out.println("Please provide the following information:");

        System.out.println("Full Name: ");
        addressBuilder.append(scanner.nextLine()).append("\n\n");

        System.out.println();

        // BILLING ADDRESS
        addressBuilder.append("Billing Address:\n");

        System.out.println("Billing Address: ");
        addressBuilder.append(scanner.nextLine()).append("\n");

        System.out.println("Billing City: ");
        addressBuilder.append(scanner.nextLine()).append(", ");

        System.out.println("Billing State: ");
        addressBuilder.append(scanner.nextLine()).append(" ");

        System.out.println("Billing Zip Code: ");
        addressBuilder.append(scanner.nextLine()).append("\n\n");

        System.out.println();

        // SHIPPING ADDRESS
        addressBuilder.append("Shipping Address:\n");

        System.out.println("Shipping Street: ");
        addressBuilder.append(scanner.nextLine()).append("\n");

        System.out.println("Shipping City: ");
        addressBuilder.append(scanner.nextLine()).append(", ");

        System.out.println("Shipping State: ");
        addressBuilder.append(scanner.nextLine()).append(" ");

        System.out.println("Shipping Zip Code: ");
        addressBuilder.append(scanner.nextLine());

        System.out.println();

        System.out.println(addressBuilder);



    }
}

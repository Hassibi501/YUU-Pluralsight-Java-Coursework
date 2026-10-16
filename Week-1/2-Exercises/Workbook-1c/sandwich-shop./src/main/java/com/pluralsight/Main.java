package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-1c: Exercises – Sandwich Shop
 * EXERCISE 1 - pg 104
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float cost;

        System.out.println("Enter the size of the Sandwich: ");
        System.out.println("1: Regular: $5.45\n2: Large: $8.95");
        int size = scanner.nextInt();

        if (size == 1) {
            cost = 5.45f;
        }
        else {
            cost = 8.95f;
        }

        System.out.println();

        System.out.println("Do you want the sandwich loaded (yes/no)? It will cost extra:");
        String loaded = scanner.next();

        System.out.println();

        if  (loaded.equals("yes")) {
            System.out.println("1: Regular loaded: $1.00\n2: Large loaded: $1.75");
            int loadedType = scanner.nextInt();

            if (loadedType == 1) {
                cost += 1.00f;
            }
            else {
                cost += 1.75f;
            }

            System.out.println();
        }


        System.out.println("Enter your age: ");
        System.out.println("Students(17 years old or younger): 10% discount\nSeniors(65 years old or older): 20% discount");
        int age = scanner.nextInt();


        if (age <= 17) {
            cost = cost - (cost * 0.10f);
        }
        else if (age >= 65) {
            cost = cost - (cost * 0.20f);
        }

        System.out.println();

        System.out.printf("The total cost of the sandwich is: $%.2f", cost);
        scanner.close();




    }
}
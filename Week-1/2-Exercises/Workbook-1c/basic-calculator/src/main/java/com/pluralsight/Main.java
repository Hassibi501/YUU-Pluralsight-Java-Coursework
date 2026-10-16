package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-1c: Exercises – Basic Calculator
 * EXERCISE 4 - pg 87
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();

        System.out.println("""
                Possible Calculations:
                (A)dd
                (S)ubtract
                (M)ultiply
                (D)ivide
                Please select an option:""");

        char option = scanner.next().charAt(0);

        if  (option == 'A') {
            System.out.printf("%.3g + %.3g = %.3g", num1, num2, (num1 + num2));
        }
        else if (option == 'S') {
            System.out.printf("%.3g - %.3g = %.3g", num1, num2, (num1 - num2));
        }
        else if (option == 'M') {
            System.out.printf("%.3g * %.3g = %.3g", num1, num2, (num1 * num2));
        }
        else if (option == 'D') {
            System.out.printf("%.3g / %.3g = %.3g", num1, num2, (num1 / num2));
        }
        else {
            System.out.println("Invalid option selected.");
        }


    }
}

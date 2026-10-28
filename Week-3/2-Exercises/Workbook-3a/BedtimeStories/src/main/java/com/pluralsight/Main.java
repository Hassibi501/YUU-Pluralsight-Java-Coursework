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
        String fileName;


        while (true) {
            try {
                System.out.println("""
                ===== Bedtime Stories =====
                1. Goldilocks and the Three Bears
                2. Hansel and Gretel
                3. Mary Had a Little Lamb
                4. Exit""");

                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        fileName = "goldilocks.txt";
                        FileReader fileReader1 = new FileReader(fileName);
                        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

                        String input1;
                        while ((input1 = bufferedReader1.readLine()) != null) {
                            System.out.println(input1);
                        }
                        bufferedReader1.close();
                        System.out.println();
                        break;
                    case 2:
                        fileName = "hansel_and_gretel.txt";
                        FileReader fileReader2 = new FileReader(fileName);
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

                        String input2;
                        while ((input2 = bufferedReader2.readLine()) != null) {
                            System.out.println(input2);
                        }
                        bufferedReader2.close();
                        System.out.println();
                        break;
                    case 3:
                        fileName = "mary_had_a_little_lamb.txt";
                        FileReader fileReader3 = new FileReader(fileName);
                        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);

                        String input3;
                        while ((input3 = bufferedReader3.readLine()) != null) {
                            System.out.println(input3);
                        }
                        bufferedReader3.close();
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 3.");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
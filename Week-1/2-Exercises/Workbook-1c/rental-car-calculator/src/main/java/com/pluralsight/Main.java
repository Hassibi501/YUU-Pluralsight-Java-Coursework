package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-1c: Exercises – Rental Car Company
 * EXERCISE 1 - pg 125
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                =================== Car Rental ===================
                  Basic Rental Rate: $29.99 per day.
                  30% surcharge for drivers under 25 years old.
                  All taxes are included in the rental rate.
                ==================================================""");

        System.out.println("Enter the pick up date (DD/MM/YYYY):");
        String pickUpDate = scanner.nextLine();
        //String pickUpDate = "09/06/2024";

        System.out.println("Enter number of days for the rental:");
        int rentalDays = Integer.parseInt(scanner.nextLine());
        //int rentalDays = 5;

        float subTotal = (float) (rentalDays * 29.99);
        float total = subTotal;

        System.out.println("Do you want electronic toll tag at $3.95 per day? (yes/no):");
        String tollTagResponse = scanner.nextLine();
        //String tollTagResponse = "yes";

        System.out.println("Do you want a GPS at $2.95 per day? (yes/no):");
        String gpsResponse = scanner.nextLine();
        //String gpsResponse = "yes";

        System.out.println("Do you want a roadside assistance at $3.95 per day? (yes/no):");
        String roadsideAssistanceResponse = scanner.nextLine();
        //String roadsideAssistanceResponse = "yes";

        System.out.println("Enter your age:");
        int age = Integer.parseInt(scanner.nextLine());
        //int age = 23;

        boolean over25 = false;

        // Supercharge gets added first so it only applies to the base rental rate and not the other add-ons
        if (age < 25) {
            total += (float) (subTotal * 0.30);
            over25 = true;
        }

        if (tollTagResponse.equals("yes")) {
            total += (float) (rentalDays * 3.95);
        }


        if (gpsResponse.equals("yes")) {
            total += (float) (rentalDays * 2.95);
        }

        if (roadsideAssistanceResponse.equals("yes")) {
            total += (float) (rentalDays * 3.95);
        }


        System.out.printf("""
                =================== Charge Summary ===================
                  Basic Rental Rate: $29.99/day
                  Pick Up Date: %s
                  Subtotal for %d days: $%.2f
                  Additional Charges:
                    Electronic Toll Tag ($%.2f): %s
                    GPS ($%.2f): %s
                    Roadside Assistance ($%.2f): %s
                    Age Surcharge (30%%): %b
                  Total Charges: $%.2f
                ======================================================
                """,pickUpDate, rentalDays, subTotal, (rentalDays * 3.95), tollTagResponse, (rentalDays * 2.95)
                   ,gpsResponse, (rentalDays * 3.95), roadsideAssistanceResponse, over25, total);


    }

}

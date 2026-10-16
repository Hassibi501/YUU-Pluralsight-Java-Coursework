package com.pluralsight;

import java.util.Scanner;

/**
 * Workkbook-1c: Exercises – Basic Calculator
 * EXERCISE 5 - pg 88
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter hours worked: ");
        float hoursWorked = scanner.nextFloat();

        System.out.println("Enter pay rate: ");
        float payRate = scanner.nextFloat();

        float grossPay = hoursWorked * payRate;

        boolean isOvertime = false;

        if (hoursWorked >= 40){
            float overtimeHours = hoursWorked - 40;
            float overtimePay = overtimeHours * payRate * 1.5f;
            grossPay = (40 * payRate) + overtimePay;
            isOvertime = true;
        }

        System.out.println();

        System.out.printf("""
                Employee Paycheck:
                First Name: %s
                Hours Worked: %.2f
                Pay Rate: %.2f
                OverTime Payrate: %b
                Gross Pay: %.2f""", firstName, hoursWorked, payRate, isOvertime, grossPay);

    }
}
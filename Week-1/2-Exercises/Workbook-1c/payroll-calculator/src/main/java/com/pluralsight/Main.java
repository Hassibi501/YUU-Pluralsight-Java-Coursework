package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-1c: Exercises – Basic Calculator
 * EXERCISE 5 - pg 88
 * Refactored code for Exercises – Calculator with Methods  - EXERCISE 2 - pg 120
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

        float grossPay = calculateGrossPay(hoursWorked, payRate);
        boolean isOvertime = hoursWorked >= 40;

        System.out.println();

        displayPaychecKSummary(firstName, hoursWorked, payRate, isOvertime, grossPay);

        scanner.close();


    }

    public static float calculateGrossPay(float hoursWorked, float payRate) {
        float grossPay = hoursWorked * payRate;

        if (hoursWorked >= 40){
            float overtimeHours = hoursWorked - 40;
            float overtimePay = overtimeHours * payRate * 1.5f;
            grossPay = (40 * payRate) + overtimePay;
        }

        return grossPay;
    }

    public static void displayPaychecKSummary(String firstName, float hoursWorked, float payRate,boolean isOvertime, float grossPay) {
        System.out.printf("""
                Employee Paycheck:
                First Name: %s
                Hours Worked: %.2f
                Pay Rate: %.2f
                OverTime Pay Rate: %b
                Gross Pay: %.2f""", firstName, hoursWorked, payRate, isOvertime, grossPay);
    }

}
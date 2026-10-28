package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Workbook-3a: Exercises — Payroll Calculator
 * EXERCISE 3 - pg 15
 */

public class Main {
    public static void main(String[] args) {
        String filename = "employees.csv";

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;

            bufferedReader.readLine();// Skip the header line

            System.out.println("===== Employee Payroll Report =====\n------------------------");
            while ((input = bufferedReader.readLine()) != null) {
                String[] employeeData = input.split("\\|");

                int employeeId = Integer.parseInt(employeeData[0]);
                String name = employeeData[1];
                double hoursWorked = Double.parseDouble(employeeData[2]);
                double payRate = Double.parseDouble(employeeData[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.printf("""
                        Employee ID: %d
                        Name: %s
                        Gross Pay: $%.2f
                        ------------------------
                        """,
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

            }
            bufferedReader.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
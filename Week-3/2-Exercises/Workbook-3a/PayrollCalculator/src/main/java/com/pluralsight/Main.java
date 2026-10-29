package com.pluralsight;

import java.io.*;


/**
 * Workbook-3a: Exercises — Payroll Calculator
 * EXERCISE 3 - pg 15
 * Exercises — Payroll Calculator Pt. 2
 * EXERCISE 1 - pg 23
 */

public class Main {
    public static void main(String[] args) {
        String inputFilename = "employees.csv";
        String outputFilename = "payroll.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilename))) {

            bufferedReader.readLine();

            bufferedWriter.write("id|name|gross pay\n");

            String line;
            System.out.println("==== Employee Data ====");
            while ((line = bufferedReader.readLine()) != null) {
                String outPutFileDate = getOutPutFileData(line);
                bufferedWriter.write(outPutFileDate);

                System.out.println(line);


            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getOutPutFileData(String line) {
        String[] fields = line.split("\\|");

        int employeeId = Integer.parseInt(fields[0]);
        String name = fields[1];
        double hoursWorked = Double.parseDouble(fields[2]);
        double payRate = Double.parseDouble(fields[3]);

        Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

        return String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
    }
}
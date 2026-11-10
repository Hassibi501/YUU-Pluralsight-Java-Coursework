package com.Pluralsight;

import java.time.LocalTime;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;
    private boolean isClockedIn;

    public Employee(String employeeID, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }


    public void punchTimeCard(double time) {
        if (!this.isClockedIn) {
            this.startTime = time;
            this.isClockedIn = true;
        }
        else {
            double newHoursWorked = time - this.startTime;
            this.hoursWorked += newHoursWorked;
            this.startTime = 0;
            this.isClockedIn = false;
        }
    }

    public void punchTimeCard() {
        int currentHour = LocalTime.now().getHour();
        double currentMinuteDecimal = (double) (LocalTime.now().getMinute()) /60;
        double time = currentHour + currentMinuteDecimal;
        punchTimeCard(time);
    }


}

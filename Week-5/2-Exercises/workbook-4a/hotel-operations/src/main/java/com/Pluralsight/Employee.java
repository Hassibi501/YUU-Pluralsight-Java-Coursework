package com.Pluralsight;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private int startTime;
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


    public void punchTimeCard(int time) {
        if (!this.isClockedIn) {
            this.startTime = time;
            this.isClockedIn = true;
        }
        else {
            int newHoursWorked = time - this.startTime;
            this.hoursWorked += newHoursWorked;
            this.startTime = 0;
            this.isClockedIn = false;
        }
    }


}

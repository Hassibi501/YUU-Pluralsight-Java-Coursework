package com.pluralsight;

public class Format {
    public static void main(String[] args) {

       String fullName = formatName("John", "Doe");

        System.out.println(fullName);

    }

    public static String formatName(String firstName, String lastName) {

        return lastName + ", " + firstName;
    }
}

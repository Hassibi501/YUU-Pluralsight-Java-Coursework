package com.pluralsight;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String courseTitle = inputValidator(scanner, "Please enter course title (e.g: Microsoft Azure Administrator (AZ-104)");
        String courseCode = courseCodeExtractor(courseTitle);


        System.out.printf("""
                
                Course Code Extractor:
                Course Title: %s
                Course Code: %s
                """, courseTitle, courseCode);

    }


    public static String inputValidator(Scanner scanner, String promptMessage) {
        while (true) {
            System.out.println(promptMessage);
            String userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                System.out.println("Error: Course title was empty please enter valid course title (e.g: Microsoft Azure Administrator (AZ-104)");
                continue;
            }

            if (!userInput.contains("(") || !userInput.contains(")")) {
                System.out.println("Error: Course title does not contain course code or in valid formating (e.g: (AZ-104), (AZ-107))");
                continue;
            }

            return userInput;
        }
    }

    public static String courseCodeExtractor(String courseTitle) {
        int opening = courseTitle.indexOf("(");
        int closing = courseTitle.indexOf(")");

        return courseTitle.substring(opening + 1, closing);
    }
}
package com.pluralsight;

public class Menu {
    public static void main(String[] args) {
        displayMenu();
        System.out.println();
        displayMenu();

    }

    public static void displayMenu() {
        System.out.println("""
                === Menu ===
                1. Coffee - $3.99
                2. Tea - $2.99
                3. Cookie - $1.99""");
    }
}

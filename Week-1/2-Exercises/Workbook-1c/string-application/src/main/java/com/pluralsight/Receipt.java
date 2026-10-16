package com.pluralsight;

public class Receipt {
    public static void main(String[] args) {
        String itemName = "Coffee";
        double itemPrice = 4.99;
        int quantity = 2;

        System.out.printf("You bought %d %s(s) for %.2f", quantity, itemName, itemPrice * quantity);
    }
}

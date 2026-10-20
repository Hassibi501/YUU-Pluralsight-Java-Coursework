package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        String message = "Java Fundamentals            ";
//
//        message = message.toUpperCase();
//        System.out.println(message.length());
//        message = message.trim();ROutingf
//        System.out.println(message.length());
//
//    String amountOfNumbersForPinCode = "4";
//
//    if(amountOfNumbersForPinCode.length() < 4){
//        System.out.println("Not enough characters/numbers for pin code.");
//    }

        String name = "Will";

        int indexNumber = name.indexOf("W");
        System.out.println(indexNumber);


        String bankAccountNumber = "1234567890";
        String lastFourDigits = bankAccountNumber.substring(bankAccountNumber.length() - 4);
        System.out.println(lastFourDigits);

    }
}
package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-2a: Exercise – Cell Phone Service
 * EXERCISE 1: pg 40
 * EXERCISE 2: pg 48
 */

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone cellPhone = new CellPhone();

//        System.out.println("What is the serial number of the cell phone?");
//        int serialNumber = Integer.parseInt(scanner.nextLine());
//        cellPhone.setSerialNumber(serialNumber);
//
//        System.out.println("What is the model of the cell phone?");
//        String model = scanner.nextLine();
//        cellPhone.setModel(model);
//
//        System.out.println("What is the carrier of the cell phone?");
//        String carrier = scanner.nextLine();
//        cellPhone.setCarrier(carrier);

        //System.out.println("What is the phone number of the cell phone?");
        //String phoneNumber = scanner.nextLine();
        cellPhone.setPhoneNumber("888-555-1234");

        //System.out.println("What is the owner's name of the cell phone?");
        //String ownersName = scanner.nextLine();
        cellPhone.setOwnersName("Sandra");

        System.out.println();

        CellPhone cellphone2 = new CellPhone();
        cellphone2.setPhoneNumber("676-767-6767");
        cellphone2.setOwnersName("Mr.Beast");

        cellPhone.dial(cellphone2.getPhoneNumber());
        cellphone2.dial(cellPhone.getPhoneNumber());

        System.out.println();

        display(cellPhone);
        display(cellphone2);

//        System.out.println("Cell Phone Information:");
//        System.out.println("Serial Number: " + cellPhone.getSerialNumber());
//        System.out.println("Model: " + cellPhone.getModel());
//        System.out.println("Carrier: " + cellPhone.getCarrier());
//        System.out.println("Phone Number: " + cellPhone.getPhoneNumber());
//        System.out.println("Owner's Name: " + cellPhone.getOwnersName());


    }

    public static void display(CellPhone phone) {
        phone.dial(phone.getPhoneNumber());
    }
}

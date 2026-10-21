package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-2a: Exercise – Cell Phone Service
 * EXERCISE 1: pg 40
 */

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone cellPhone = new CellPhone();

        System.out.println("What is the serial number of the cell phone?");
        int serialNumber = Integer.parseInt(scanner.nextLine());
        cellPhone.setSerialNumber(serialNumber);

        System.out.println("What is the model of the cell phone?");
        String model = scanner.nextLine();
        cellPhone.setModel(model);

        System.out.println("What is the carrier of the cell phone?");
        String carrier = scanner.nextLine();
        cellPhone.setCarrier(carrier);

        System.out.println("What is the phone number of the cell phone?");
        String phoneNumber = scanner.nextLine();
        cellPhone.setPhoneNumber(phoneNumber);

        System.out.println("What is the owner's name of the cell phone?");
        String ownersName = scanner.nextLine();
        cellPhone.setOwnersName(ownersName);

        System.out.println();

        System.out.println("Cell Phone Information:");
        System.out.println("Serial Number: " + cellPhone.getSerialNumber());
        System.out.println("Model: " + cellPhone.getModel());
        System.out.println("Carrier: " + cellPhone.getCarrier());
        System.out.println("Phone Number: " + cellPhone.getPhoneNumber());
        System.out.println("Owner's Name: " + cellPhone.getOwnersName());


    }
}

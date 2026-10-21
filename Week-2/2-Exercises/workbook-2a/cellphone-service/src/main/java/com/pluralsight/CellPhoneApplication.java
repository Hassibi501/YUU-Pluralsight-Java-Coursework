package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-2a: Exercise – Cell Phone Service
 * EXERCISE 1: pg 40
 * EXERCISE 2: pg 48
 * EXERCISE 3: pg 56
 */

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone cellPhone = new CellPhone();

        System.out.println("What is the serial number of the cell phone?");
        //int serialNumber = Integer.parseInt(scanner.nextLine());
        cellPhone.setSerialNumber(2597153);

        System.out.println("What is the model of the cell phone?");
        //String model = scanner.nextLine();
        cellPhone.setModel("iPhone 15 Pro Max");

        System.out.println("What is the carrier of the cell phone?");
        //String carrier = scanner.nextLine();
        cellPhone.setCarrier("Verizon");

        System.out.println("What is the phone number of the cell phone?");
        //String phoneNumber = scanner.nextLine();
        cellPhone.setPhoneNumber("888-555-1234");

        System.out.println("What is the owner's name of the cell phone?");
        //String ownersName = scanner.nextLine();
        cellPhone.setOwnersName("Sandra");

        System.out.println();

        CellPhone cellphone2 = new CellPhone(67676767, "Samsung Galaxy S23 Ultra", "Xfinity Mobile", "676-767-6776", "Mr.Beast");

        display(cellPhone);

        System.out.println();

        display(cellphone2);

        System.out.println();

        cellPhone.dial(cellphone2.getPhoneNumber());

        System.out.println();

        cellphone2.dial(cellPhone.getPhoneNumber());






    }

    public static void display(CellPhone phone) {
        System.out.println("Cell Phone Information:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner's Name: " + phone.getOwnersName());
    }
}

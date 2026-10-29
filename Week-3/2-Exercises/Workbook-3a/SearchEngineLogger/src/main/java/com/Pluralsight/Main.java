package com.Pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Workbook-3a: Exercises — Dates
 * EXERCISE 2 - pg 33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "logs.txt";
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dateTime.format(formatter);
        String write;

        System.out.println("Enter a search term (X to exit):");

        try (FileWriter fileWrite = new FileWriter(fileName, true)) {
            fileWrite.write(date + " launch\n");
            while(true){
                // I had to add the date and time again so that it updates the time stamps after the user enters text
                dateTime = LocalDateTime.now();
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                date = dateTime.format(formatter);

                write = scanner.nextLine();
                if (write.equals("X")){
                    fileWrite.write(date + " exit\n");
                    break;
                }
                fileWrite.write(date + " search : " + write + "\n");

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
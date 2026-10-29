package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Workbook-3a: Exercises — Dates
 * EXERCISE 2 - pg 33
 */
public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = currentDate.format(fmt);

        System.out.println(formattedDate);
        System.out.println(currentDate);

        fmt = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        formattedDate = currentDate.format(fmt);

        System.out.println(formattedDate);

        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("GMT"));
        fmt = DateTimeFormatter.ofPattern("EEEE, MMM, dd, yyyy  HH:mm"); //GMT time zone military time
        formattedDate = dateTime.format(fmt);
        System.out.println(formattedDate);

        dateTime = LocalDateTime.now();
        fmt = DateTimeFormatter.ofPattern("HH:mm 'on  ' dd-MMM-yyyy");
        formattedDate = dateTime.format(fmt);
        System.out.println(formattedDate);
    }
}
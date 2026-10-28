package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEEE-dd-'of'-MMMM-yyyy", Locale.ENGLISH);
        String filename = "myreasons-on-" + currentDate.format(fmt).toLowerCase() + ".txt";

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM");
        String folderName = currentDate.format(fmt2);
        File folder = new File(folderName);


        folder.mkdirs();

        File image = new File(folder, "zoom_screenshot.png");

        System.out.println(image.getPath());

        // CREATE AND WRITE TO THE FILE FIRST
        // try-with-resources automatically closes the writer when the block exits
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("I want to become a software developer for three main reasons:\n");
            writer.write("1. I love tech\n");
            writer.write("2. I want to create solutions for the software problems I face that aren't solved yet.\n");
            writer.write("3. I like the money developers make.\n");



        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }



        // READ THE FILE
        // try-with-resources automatically closes bufReader when finished
        try (BufferedReader bufReader = new BufferedReader(new FileReader(filename))) {
            String input;
            while ((input = bufReader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
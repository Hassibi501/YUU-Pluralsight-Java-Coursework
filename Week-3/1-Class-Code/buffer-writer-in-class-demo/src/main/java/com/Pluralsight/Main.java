package com.Pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Car[] cars = {
                new Car("Mustang GT"),
                new Car("Mustang EcoBoost")
        };

        BufferedWriter writer = new BufferedWriter(new FileWriter("cars.txt"));

        for (Car car : cars) {
            writer.write(car.name);
            writer.newLine();
        }

        writer.close();
    }
}
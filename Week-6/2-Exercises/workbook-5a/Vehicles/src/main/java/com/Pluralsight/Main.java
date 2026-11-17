package com.Pluralsight;

/**
 * WorkBook 5a: Exercise - Vehicles
 * EXERCISE 1 - pg 20
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Moped moped = new Moped();
        Hovercraft hovercraft = new Hovercraft();
        SemiTruck semiTruck = new SemiTruck();

        car.setColor("red");
        car.setFuelCapacity(10);

        moped.setColor("blue");
        moped.setFuelCapacity(4);

        hovercraft.setColor("green");
        hovercraft.setFuelCapacity(10);

        semiTruck.setColor("orange");
        semiTruck.setFuelCapacity(20);


        System.out.printf("""
                Car Color: %s
                Car Fuel Capacity: %d
                
                Moped Color: %s
                Moped Fuel Capacity: %d
                
                Hovercraft Color: %s
                Hovercraft Fuel Capacity: %d
                
                SemiTruck Color: %s
                SemiTruck Fuel Capacity: %d
                """
                ,car.getColor(), car.getFuelCapacity()
                ,moped.getColor(), moped.getFuelCapacity()
                ,hovercraft.getColor(), hovercraft.getFuelCapacity()
                ,semiTruck.getColor(), semiTruck.getFuelCapacity());

    }
}
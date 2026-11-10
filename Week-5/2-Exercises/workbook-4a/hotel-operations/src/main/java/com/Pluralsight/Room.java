package com.Pluralsight;

public class Room {
    private final int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }


    public void checkIn() {
        this.isOccupied = true;
        this.isDirty = true;
    }
    public void checkOut() {
        this.isOccupied = false;
        this.isDirty  = true;
    }

    public void cleanRoom() {
        this.isDirty = false;
    }

    public boolean isAvailable() {
        return !this.isDirty && !this.isOccupied;
    }

}

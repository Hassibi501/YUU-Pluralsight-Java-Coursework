package com.Pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkIn() {
        this.isOccupied = true;
        this.isDirty = true;
        this.isAvailable = false;

    }
    public void checkOut() {
        this.isOccupied = false;
        this.isAvailable = false;
    }
    public boolean cleanRoom() {
        this.isOccupied = false;
        this.isAvailable = true;
        return this.isDirty = false;

    }
}

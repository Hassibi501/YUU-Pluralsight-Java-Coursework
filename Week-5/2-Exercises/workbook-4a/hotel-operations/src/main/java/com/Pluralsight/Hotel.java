package com.Pluralsight;

public class Hotel {
    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }
    public Hotel (String name, int numberOfSuites, int numberOfRooms) {
       this(name, numberOfSuites, numberOfRooms, 0, 0);
    }

    public boolean bookRoom(int roomCount, boolean suite) {
        if (suite && roomCount <= getAvailableSuites()) {
            bookedSuites += roomCount;
            return true;
        }

        if (!suite && roomCount <= getAvailableRooms()) {
            bookedRooms += roomCount;
            return true;
        }

        return  false;
    }

    public String getName() {
        return name;
    }
    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedRooms;
    }

    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }
}

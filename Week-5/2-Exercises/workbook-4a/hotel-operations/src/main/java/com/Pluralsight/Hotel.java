package com.Pluralsight;

public class Hotel {
    private EnumRoomTypes roomType;
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel () {
        this.bookedSuites = 0;
        this.bookedRooms = 0;
    }

    public Hotel(EnumRoomTypes roomType, String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.roomType = roomType;
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    public boolean bookRoom(int roomCount, boolean suite) {
        if (this.bookedRooms < roomCount) {
            if (suite) {
                this.bookedSuites++;
                this.bookedRooms++;
                return true;
            }
            this.bookedRooms++;
            return true;
        }

        return false;
    }
}

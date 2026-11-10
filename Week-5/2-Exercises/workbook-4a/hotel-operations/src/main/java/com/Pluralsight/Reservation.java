package com.Pluralsight;

public class Reservation {
    private EnumRoomTypes roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(EnumRoomTypes roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.isWeekend = isWeekend;
    }

    public EnumRoomTypes getRoomType() {
        return roomType;
    }

    public void setRoomType(EnumRoomTypes roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public  void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        this.isWeekend = weekend;
    }

    public double getPrice() {
        double price = roomType.getPrice();
        if (this.isWeekend) {
            price *= 1.1;
        }
        return price;
    }

    public double getReservationTotal() {
        return this.numberOfNights * getPrice();
    }

}

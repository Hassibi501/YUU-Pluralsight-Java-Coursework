package com.Pluralsight;

public class Reservation {
    private EnumRoomTypes roomType;
    private int numberOfNights;
    private boolean isWeekend;
    private double reservationTotal;

    public Reservation(EnumRoomTypes roomType, int numberOfNights, boolean isWeekend, double reservationTotal) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        this.reservationTotal = reservationTotal;
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
        return reservationTotal;
    }

}

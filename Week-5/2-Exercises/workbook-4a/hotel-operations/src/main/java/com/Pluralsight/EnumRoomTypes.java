package com.Pluralsight;

public enum EnumRoomTypes {
    KING(139),
    DOUBLE(124);

    private double price;

    private EnumRoomTypes(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}

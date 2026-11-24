package com.pluralsight.finance;

public class House extends FixedAsset {
    private final int builtYear;
    private int squareFeet;
    private int bedRooms;

    public House(String name, double marketValue, int builtYear, int squareFeet, int bedRooms) {
        super("House", 0);
        this.builtYear = builtYear;
        this.squareFeet = squareFeet;
        this.bedRooms = bedRooms;
    }

    @Override
    public double getValue() {
        return 0;
    }

}

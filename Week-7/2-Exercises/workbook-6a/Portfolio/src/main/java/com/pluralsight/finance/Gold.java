package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private final double weight;

    public Gold(String name, double weight) {
        super("Gold", 0);
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return 0;
    }
}

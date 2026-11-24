package com.pluralsight.finance;

import java.util.ArrayList;

public class Portfolio implements Valuable {
    private final String name;
    private String owner;
    private ArrayList<FixedAsset> fixedAssetsList;

    public Portfolio(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public void add(FixedAsset asset) {
        this.fixedAssetsList.add(asset);
    }

    public double getValue() {
        double value = 0;

        for (FixedAsset asset : this.fixedAssetsList) {
           value +=  asset.getValue();
        }
        return value;
    }


}

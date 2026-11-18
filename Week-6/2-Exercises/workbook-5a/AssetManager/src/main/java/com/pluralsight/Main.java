package com.pluralsight;

import java.util.ArrayList;

/**
 * Workshop 5a: Exercises - Assets
 * EXERCISE 1  - pg 47
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Asset mainHouse = new House(
                "Nice house.",
                "02/29/2024",
                4_995_000,
                "537 Grove St, San Francisco, CA 94102",
                4, 3317, 1846
        );


        Asset vacationHouse = new House(
                "Fancy Swiss House.",
                "10/9/2025",
                3_050_000,
                "Endweg 71, 3818 Grindelwald, Switzerland",
                4, 2099, 6523
        );

        Asset sfCar = new Vehicle(
                "Coolest EV you can get in America.",
                "2024-03-01",
                118500.00,
                "Porsche Taycan 4S",
                2024,
                12
        );

        Asset swissCar = new Vehicle(
                "Best hybrid car for cold weather",
                "2025-01-15",
                138000.00,
                "Audi RS6 Avant Performance",
                2025,
                15
        );

        assets.add(mainHouse);
        assets.add(vacationHouse);
        assets.add(sfCar);
        assets.add(swissCar);

        System.out.println("--------------------");
        for (Asset asset : assets) {
            System.out.printf("""
                    Asset Type: %s
                    Asset Description: %s
                    Date Acquired: %s
                    Original Cost: $%.2f
                    --------------------
                    """,
                    asset.getClass().getSimpleName(), asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost());
        }

        System.out.println("\n");

        System.out.println("--------------------");
        for (Asset asset : assets) {
            System.out.printf("""
                    Asset Type: %s
                    Asset Description: %s
                    Date Acquired: %s
                    Original Cost: $%.2f
                    """,
                    asset.getClass().getSimpleName(), asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost());

            if (asset instanceof House) {
                System.out.printf("""
                    Address: %s
                    Condition: %d
                    Square Foot: %d
                    Lot Size: %d
                    --------------------
                    """,
                        ((House) asset).getAddress(), ((House) asset).getCondition(), ((House) asset).getSquareFoot(), ((House) asset).getLotSize());
            }

            if (asset instanceof Vehicle) {
                System.out.printf("""
                        Make Model: %s
                        Year: %d
                        Mileage: %s
                        --------------------
                        """,
                        ((Vehicle) asset).getMakeModel(), ((Vehicle) asset).getYear(), ((Vehicle) asset).getOdometer());
            }
        }



    }
}

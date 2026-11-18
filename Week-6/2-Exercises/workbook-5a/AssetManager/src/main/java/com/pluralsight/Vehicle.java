package com.pluralsight;

import java.time.LocalDate;
import java.util.Locale;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost,String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        int vehiclesAge = 0;
        if (currentYear >= this.year) {
            vehiclesAge = currentYear - this.year;
        }
        else {
            System.err.println("Error: Vehicle is from the future? Please input valid vehicle year.");
            System.exit(1);
        }

        double percentLostInDecimalPerYear = 0;
        double totalValue;

        if (vehiclesAge <= 3) {
            if (vehiclesAge == 0) {
                percentLostInDecimalPerYear = 0.03;
            }
            else {
                percentLostInDecimalPerYear = ((double) 3 /100) * vehiclesAge;
            }
        }
        else if (vehiclesAge <= 6) {
            percentLostInDecimalPerYear = ((double) 6 /100) * vehiclesAge;
        }
        else if (vehiclesAge <= 10) {
            percentLostInDecimalPerYear = ((double) 8 /100) * vehiclesAge;
        }

        if (vehiclesAge < 10) {
            totalValue = 1000;
        }
        else {
            double reducedValueOfCostPerYear = super.getOriginalCost() * percentLostInDecimalPerYear;
            totalValue = super.getOriginalCost() -  reducedValueOfCostPerYear;
        }

        double mileageReduction = (double) 25 /100;
        boolean isHondaOrToyota = this.makeModel.toLowerCase(Locale.ROOT).matches("honda") || this.makeModel.toLowerCase(Locale.ROOT).matches("toyota");

        if (this.odometer > 100_000 && !isHondaOrToyota){
            totalValue -= mileageReduction;
        }

        return totalValue;
    }


}

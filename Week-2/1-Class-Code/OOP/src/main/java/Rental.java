import java.time.LocalDate;

public class Rental {
    // RENT INFORMATION
    int rentalID;
    String customerName;
    int howManyDays;
    double pricePerDay;
    LocalDate rentalStartDate;
    LocalDate rentalEndDate;
    String vin;

    private static double totalPrice(double pricePerDay, int howManyDays) {
        return pricePerDay * howManyDays;
    }
    // DISPLAY RENTAL INFORMATION
    void displayInfo() {
        System.out.println("Rental ID: " + rentalID);
        System.out.println("Customer: " + customerName);
        System.out.println("Days: " + howManyDays);
        System.out.println("Price per day: $" + pricePerDay);
        System.out.println("Start: " + rentalStartDate);
        System.out.println("End: " + rentalEndDate);
        System.out.println("Car VIN: " + vin);
        System.out.println("Total: $" + totalPrice(pricePerDay, howManyDays));
        System.out.println("-----------------------");
    }


}
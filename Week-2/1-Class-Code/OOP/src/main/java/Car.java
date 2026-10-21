public class Car {
    //CAR INFORMATION
    String brand;
    String model;
    String color;
    int buildYear;
    String vin;

    // METHOD TO DISPLAY CAR INFORMATION
    void displayInfo() {
        System.out.println("Color: " + color);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Build Year: " + buildYear);
        System.out.println("VIN: " + vin);
        System.out.println("--------------------");
    }

    public static void dealerShipInfo() {
        System.out.println("Welcome to the future of RentalCars");
    }
}

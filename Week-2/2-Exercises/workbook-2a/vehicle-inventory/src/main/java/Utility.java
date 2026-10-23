import java.util.Locale;

public class Utility {

    private static void displayVehicle(Vehicle vehicle) {
        System.out.printf("""
                Vehicle ID: %d
                Make/Model: %s
                Color: %s
                Odometer Reading: %d
                Price: $%.2f
                ---------------
                """, vehicle.getVehicleId(), vehicle.getMakeModel(), vehicle.getColor(), vehicle.getOdometerReading(), vehicle.getPrice());
    }

    public static void listAllVehicles(Vehicle[] vehicles) {
        System.out.println("---------------");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                displayVehicle(vehicle);
            }
        }
    }

    public static void searchByMakeModel(Vehicle[] vehicles, String makeModel) {
        System.out.println("---------------");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getMakeModel().toLowerCase(Locale.ROOT).contains(makeModel.toLowerCase(Locale.ROOT))) {
                displayVehicle(vehicle);
            }
        }
    }

    public static void searchByPriceRange(Vehicle[] vehicles, double maxPrice, double minPrice ) {
        System.out.println("---------------");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                displayVehicle(vehicle);
            }
        }
    }

    public static void searchByColor(Vehicle[] vehicles, String color) {
        System.out.println("---------------");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase(color)) {
                displayVehicle(vehicle);
            }
        }
    }

    public static void addVehicle(Vehicle[] vehicles, Vehicle newVehicle, int currentSizeOfArray) {
        if (currentSizeOfArray < vehicles.length) {
            vehicles[currentSizeOfArray] = newVehicle;
            System.out.println("Vehicle added successfully.");
        }
    }
}

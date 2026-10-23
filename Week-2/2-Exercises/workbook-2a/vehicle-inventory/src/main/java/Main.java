import java.util.Scanner;
/**
 * Workbook-2a: Exercises – Test Statistics
 * EXERCISE 3 - pg 79
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[20];
        int currentSize = 6;


        vehicles[0] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        vehicles[1] = new Vehicle(101122,"Toyota Camry","Red",60000,11000);
        vehicles[2] = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        vehicles[3] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        vehicles[4] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        vehicles[5] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);

        while (true) {
            System.out.println("""
                    Car Dealership Inventory Management System:
                    -------------------------------------------                    
                    1 - List all vehicles
                    2 - Search by make/model
                    3 - Search by price range
                    4 - Search by color
                    5 - Add a vehicle
                    6 - Quit
                    """);


            int command = Integer.parseInt(getValidUserInput(scanner, "Enter menu option(1-6):", "^[1-6]$", "Error: Command must be a number between 1 and 6. Please try again."));

            switch (command) {
                case 1:
                    Utility.listAllVehicles(vehicles);
                    System.out.println();
                    break;
                case 2:
                    String makeModel = getValidUserInput(scanner, "Enter make/model to search:", "^[a-zA-Z0-9\\s]+$", "Error: Make/Model must contain only letters, numbers, and spaces. Please try again.");

                    System.out.println();
                    Utility.searchByMakeModel(vehicles, makeModel);
                    System.out.println();
                    break;
                case 3:
                    double maxPrice = Double.parseDouble(getValidUserInput(scanner, "Enter max price:", "^\\d+(\\.\\d{1,2})?$", "Error: Price must be a valid number (e.g., 10000.00). Please try again."));
                    double minPrice = Double.parseDouble(getValidUserInput(scanner, "Enter min price:", "^\\d+(\\.\\d{1,2})?$", "Error: Price must be a valid number (e.g., 10000.00). Please try again."));
            System.out.println("Current number of vehicles in inventory: " + currentSize);

                    System.out.println();
                    Utility.searchByPriceRange(vehicles, maxPrice, minPrice);
                    System.out.println();
                    break;
                case 4:
                    String color = getValidUserInput(scanner, "Enter color to search:", "^[a-zA-Z]+$", "Error: Color must contain only letters. Please try again.");

                    System.out.println();
                    Utility.searchByColor(vehicles, color);
                    System.out.println();
                    break;
                case 5:
                    if (currentSize >= vehicles.length) {
                        System.out.println("Error: Vehicle array is full. Cannot add more vehicles.");
                        break;
                    }

                    long newVehicleId = Long.parseLong(getValidUserInput(scanner, "Enter vehicle ID:", "^\\d+$", "Error: Vehicle ID must be a valid number. Please try again."));
                    String newMakeModel = getValidUserInput(scanner, "Enter make/model:", "^[a-zA-Z0-9\\s]+$", "Error: Make/Model must contain only letters, numbers, and spaces. Please try again.");
                    String newColor = getValidUserInput(scanner, "Enter color:", "^[a-z)A-Z]+$", "Error: Color must contain only letters. Please try again.");
                    int newOdometerReading = Integer.parseInt(getValidUserInput(scanner, "Enter odometer reading:", "^\\d+$", "Error: Odometer reading must be a valid number. Please try again."));
                    double newPrice = Double.parseDouble(getValidUserInput(scanner, "Enter price:", "^\\d+(\\.\\d{1,2})?$", "Error: Price must be a valid number (e.g., 10000.00). Please try again."));

                    Vehicle newVehicle = new Vehicle(newVehicleId, newMakeModel, newColor, newOdometerReading, newPrice);
                    Utility.addVehicle(vehicles, newVehicle, currentSize);
                    currentSize++;
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");

            }
            scanner.close();

        }//while

    }

    public static String getValidUserInput(Scanner scanner, String promptMessage, String regex, String errorMessage) {
        while (true) {
            System.out.println(promptMessage);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
                continue;
            }

            if (!input.matches(regex)) {
                System.out.println(errorMessage);
                continue;
            }

            return  input;
        }

    }


}

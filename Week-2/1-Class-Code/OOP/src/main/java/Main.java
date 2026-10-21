import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Learning about OOP");
        System.out.println("Car Renting Company");
        Car.dealerShipInfo();
        System.out.println("--------------------");

        // Creating or instantiating an object of the Car class
//        Car c1 =  new Car();
//        c1.brand = "BMW";
//        c1.vin = "124123";
//
//        Car alexisCar = new Car();
//        alexisCar.vin = "32452423";
//
//
//        Car jackCar = new Car();
//
//        jackCar.color = "Gray";
//
//        Car c3 = new Car();
//        c3.brand = "Cadilac";
//
//
//        alexisCar.color = "White";
//        jackCar.brand = "Tesla";
//        alexisCar.brand = "Benz";
//
//        Car hassiebsMomCar = new Car();
//        hassiebsMomCar.brand = "Kia";
//        hassiebsMomCar.color = "White";
//        hassiebsMomCar.vin = "32452423";
//        hassiebsMomCar.buildYear = 2013;
//        hassiebsMomCar.model = "Optima";
//
//        Car hassiebsDreamCar = new Car();
//        hassiebsDreamCar.brand = "Porsche";
//        hassiebsDreamCar.model = "Taycan 4S";
//        hassiebsDreamCar.color = "Gray";
//        hassiebsDreamCar.vin = "32452423";
//        hassiebsDreamCar.buildYear = 2027;


        //hassiebsDreamCar.displayInfo();
        //hassiebsMomCar.displayInfo();


        Car car1 = new Car();
        car1.brand = "BMW";
        car1.model = "M3";
        car1.buildYear = 2024;
        car1.color = "Blue";
        car1.vin = "BMW001";

        Car car2 = new Car();
        car2.brand = "Tesla";
        car2.model = "Model 3";
        car2.buildYear = 2025;
        car2.color = "White";
        car2.vin = "TES002";

        Car car3 = new Car();
        car3.brand = "Toyota";
        car3.model = "Camry";
        car3.buildYear = 2023;
        car3.color = "Red";
        car3.vin = "TOY003";

        Car car4 = new Car();
        car4.brand = "Mercedes";
        car4.model = "C-Class";
        car4.buildYear = 2023;
        car4.color = "Black";
        car4.vin = "MER004";

        Car car5 = new Car();
        car5.brand = "Ferrari";
        car5.model = "488 GTB";
        car5.buildYear = 2019;
        car5.color = "Yellow";
        car5.vin = "FER005";

        Car car6 = new Car();
        car6.brand = "Renault 5 Turbo";
        car6.model = "Bulma's Car";
        car6.buildYear = 1984;
        car6.color = "Blue";
        car6.vin = "LAMB006";


        Rental rental1 = new Rental();
        rental1.rentalID = 1001;
        rental1.customerName = "Thuan Luu";
        rental1.howManyDays = 3;
        rental1.pricePerDay = 120.00;
        rental1.rentalStartDate = LocalDate.of(2026, 10, 21);
        rental1.rentalEndDate = LocalDate.of(2026, 10, 24);
        rental1.vin = "BMW001";

        Rental rental2 = new Rental();
        rental2.rentalID = 1002;
        rental2.customerName = "Alexis Williams";
        rental2.howManyDays = 5;
        rental2.pricePerDay = 85.00;
        rental2.rentalStartDate = LocalDate.of(2026, 10, 22);
        rental2.rentalEndDate = LocalDate.of(2026, 10, 27);
        rental2.vin = "TES002";

        Rental rental3 = new Rental();
        rental3.rentalID = 1003;
        rental3.customerName = "Jack Naillon";
        rental3.howManyDays = 7;
        rental3.pricePerDay = 55.00;
        rental3.rentalStartDate = LocalDate.of(2026, 10, 23);
        rental3.rentalEndDate = LocalDate.of(2026, 10, 30);
        rental3.vin = "TOY003";

        Rental rental4 = new Rental();
        rental4.rentalID = 1004;
        rental4.customerName = "Hassieb Hassieb";
        rental4.howManyDays = 2;
        rental4.pricePerDay = 110.00;
        rental4.rentalStartDate = LocalDate.of(2026, 10, 24);
        rental4.rentalEndDate = LocalDate.of(2026, 10, 26);
        rental4.vin = "MER004";

        Rental rental5 = new Rental();
        rental5.rentalID = 1005;
        rental5.customerName = "Maurice Rodriguez";
        rental5.howManyDays = 2;
        rental5.pricePerDay = 450.00;
        rental5.rentalStartDate = LocalDate.of(2026, 10, 25);
        rental5.rentalEndDate = LocalDate.of(2026, 10, 27);
        rental5.vin = "FER005";

        Rental rental6 = new Rental();
        rental6.rentalID = 1006;
        rental6.customerName = "Ramesy Mailjard";
        rental6.howManyDays = 3;
        rental6.pricePerDay = 600.00;
        rental6.rentalStartDate = LocalDate.of(2026, 10, 26);
        rental6.rentalEndDate = LocalDate.of(2026,11, 29);
        rental6.vin = "LAMB006";

        car1.displayInfo();
        rental1.displayInfo();

        car2.displayInfo();
        rental2.displayInfo();

        car3.displayInfo();
        rental3.displayInfo();

        car4.displayInfo();
        rental4.displayInfo();

        car5.displayInfo();
        rental5.displayInfo();

        car6.displayInfo();
        rental6.displayInfo();


    }
}

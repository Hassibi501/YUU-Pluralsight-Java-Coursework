import java.util.ArrayList;
import java.util.Scanner;

/**
 * Workbook-3a: Exercises — Search Inventory
 * EXERCISE 1 - pg 49
 */
class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        displayInventory(inventory);
    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        Product item1 = new Product(4, "Banna", 1);
        Product item2 = new Product(5, "Milk", 3.5F);
        Product item3 = new Product(6, "Chocolate", 2.5F);
        Product item4 = new Product(7, "Pokemon Cards", 20.8F);
        Product item5 = new Product(8, "Potato", 1.5F);

        inventory.add(item1);
        inventory.add(item2);
        inventory.add(item3);
        inventory.add(item4);
        inventory.add(item5);

        return inventory;
    }

    public static void displayInventory(ArrayList<Product> inventory) {
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }
}
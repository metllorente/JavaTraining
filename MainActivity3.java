package M3_Activity3;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

public class MainActivity3 {

    private static final Map<String, Integer> productsList = new LinkedHashMap<>(); 
    
    public static void main(String[] args) {
    	carProducts();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                System.out.print("> ");
                String inputChoice = scanner.nextLine().trim();

                if (!isNumeric(inputChoice)) {
                    System.out.println("Please enter a number within 1 to 5.\n");
                    continue;
                }

                int choice = Integer.parseInt(inputChoice);
                switch (choice) {
                    case 1:
                        searchProduct(scanner);
                        break;
                    case 2:
                        addProduct(scanner);
                        break;
                    case 3:
                        printAllProducts();
                        break;
                    case 4:
                        findCheapestProduct();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please select 1-5.\n");
                }
            }
        }
    }

    private static void carProducts() {
    	productsList.put("Intercooler", 8000);
    	productsList.put("Charge Pipes", 3500);
    	productsList.put("Breather Hose", 800);
    	productsList.put("Clamps", 500);
    	productsList.put("Filter", 1000);
    }

    private static void displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and prices");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine().trim();
        String key = findKeyCaseInsensitive(name);

        if (key != null) {
            System.out.println("Product found! Price of Product: " + productsList.get(key));
        } else {
            System.out.println("Product not found!");
        }
        System.out.println();
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name to add: ");
        String name = scanner.nextLine().trim();

        String existingKey = findKeyCaseInsensitive(name);
        String finalKey = existingKey != null ? existingKey : toTitleCase(name);

        Integer priceOfProduct = null;
        while (priceOfProduct == null) {
            System.out.print("Enter price of Product: ");
            String priceOfProductStr = scanner.nextLine().trim();
            if (isNumeric(priceOfProductStr)) {
                priceOfProduct = Integer.parseInt(priceOfProductStr);
                if (priceOfProduct < 0) {
                    System.out.println("Price of Product cannot be negative.");
                    priceOfProduct = null;
                }
            } else {
                System.out.println("Please enter a valid numeric price of Product.");
            }
        }

        productsList.put(finalKey, priceOfProduct);
        System.out.println("Product added: " + finalKey);
        System.out.println();
    }

    private static void printAllProducts() {
        System.out.println("All products and Prices:");
        int count = 0;
        for (Map.Entry<String, Integer> e : productsList.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
            count++;
        }
        System.out.println("Total products: " + count);
        System.out.println();
    }

    private static void findCheapestProduct() {
        if (productsList.isEmpty()) {
            System.out.println("No products available.");
            System.out.println();
            return;
        }
        String cheapestName = null;
        int cheapestPriceOfProduct = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> e : productsList.entrySet()) {
            if (e.getValue() < cheapestPriceOfProduct) {
                cheapestPriceOfProduct = e.getValue();
                cheapestName = e.getKey();
            }
        }
        System.out.println("Cheapest product: " + cheapestName + " - " + cheapestPriceOfProduct);
        System.out.println();
    }

    private static String findKeyCaseInsensitive(String name) {
        for (String key : productsList.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                return key;
            }
        }
        return null;
    }

    private static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static String toTitleCase(String s) {
        if (s == null || s.isBlank()) return s;
        s = s.trim().toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        
	}
}

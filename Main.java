package M3_Activity2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// HashSet of Products 
        Set<String> productsList = new HashSet<>();

		productsList.add("Laptop");
		productsList.add("Mouse");
		productsList.add("Keyboard");
		productsList.add("Monitor");
		productsList.add("Printer");

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Do-While Loop to Display the menu after every choice until Exit
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
            
            	// Search a product
                case 1:
                    System.out.print("\nEnter product name to search: ");
                    String searchProduct = scanner.nextLine();
                    boolean found = false;
                    for (String product : productsList) {
                        if (product.equalsIgnoreCase(searchProduct)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Product found: " + searchProduct);
                    } else {
                        System.out.println("Product not found");
                    }
                    break;

                // Add a product    
                case 2:
                    System.out.print("\nEnter product name to add: ");
                    String newProduct = scanner.nextLine();
                    if (productsList.add(newProduct)) {
                        System.out.println("Product added: " + newProduct);
                    } else {
                        System.out.println("Product already exists.");
                    }
                    break;

                // Print all products and count
                case 3:
                    System.out.println("\nAll products:");
                    for (String product : productsList) {
                                               System.out.println(product);
                    }
                    System.out.println("Total unique products: " + productsList.size());
                    break;

                // Exit    
                case 4:
                    System.out.println("\nExiting...");
                    break;

                // Not in Choice    
                default:
                    System.out.println("Not in choices! Please try again!");
            }
        } 
        while (choice != 4);

        scanner.close();
        
    }
}

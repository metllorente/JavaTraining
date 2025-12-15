package M3_Activity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ArrayList of Products
		List<String> productsList = new ArrayList<>();
		
		productsList.add("Laptop");
		productsList.add("Mouse");
		productsList.add("Keyboard");
		productsList.add("Monitor");
		productsList.add("Printer");
		
		// Print ArrayList
		System.out.println("All products:");
		printProducts(productsList);
		
		// Add and Remove a product in the ArrayList
		productsList.remove("Mouse");
		productsList.add("Webcam");
		
		System.out.println("\nAfter adding and removing products:");
		printProducts(productsList);
		
		// Find a product in the ArrayList
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter product name to search: ");
		String searchProduct = scanner.nextLine();
		
		// Traditional for-loop
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
		
		// Using contains() method
		System.out.println("\nUsing contains() method:");
		if (productsList.contains(searchProduct)) {
		    System.out.println("Product found: " + searchProduct);
		} else {
		    System.out.println("Product not found");
		           }
		
		    scanner.close();
		}
		
		private static void printProducts(List<String> products) {
		    int index = 1;
		    for (String product : products) {
		        System.out.println(index++ + ". " + product);
		    }
		
	}

}

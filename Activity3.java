package ph.com.bpi.javatraining.main;

import java.util.Scanner;

public class Activity3 {
	
    public static int computesum(int num1, int num2) {return num1 + num2;}

    public static int computedifference(int num1, int num2) {return num1 - num2;}

    public static int computeproduct(int num1, int num2) {return num1 * num2;}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 1st integer: ");
		int num1 = input.nextInt();
		
		System.out.print("Enter 2nd integer: ");
		int num2 = input.nextInt();
		
		int sum = computesum(num1, num2);
		int difference = computedifference(num1, num2);
		int product = computeproduct(num1, num2);
		
		System.out.println("Sum: " +sum);
		System.out.println("Difference: " +difference);
		System.out.println("Product: " +product);

		input.close();
		
	}

}

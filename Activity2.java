package ph.com.bpi.helloworld.main;

import java.util.Scanner;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ilagda ang iyong edad: ");
		String aInput = input.nextLine();

		int num1 = Integer.parseInt(aInput);
		double result = num1;
		
		System.out.println("Edad bilang int: " +num1);
		System.out.println("Edad bilang double: " +result);
		

	}

}

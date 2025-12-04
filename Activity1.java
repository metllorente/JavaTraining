package ph.com.bpi.helloworld.main;

import java.util.Scanner;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ano ang iyong pangalan? ");
		String aInput = input.next();
		//String bInput = input.nextLine();
		//String cInput = input.nextLine();
		
		System.out.println("Mabuhay, " +aInput +"!");
		//System.out.println("Input 2: " +bInput);
		//System.out.println("Input 3: " +cInput);
		

	}

}

package M2_Exercise1;

public class Main {

	public static void main(String[] args) {

		Car car1 = new Car();
		
		car1.setBrand("Mitsubishi");
		car1.setModel("Montero");
		car1.setYear("2012");
		car1.setColor("Blue");
		
		Car car2 = new Car("Toyota", "Fortuner", "2020", "Silver");
		
		car1.displayDetails();
		
		car2.displayDetails();	

	}

}

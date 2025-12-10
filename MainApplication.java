package M2_Activity6;

public class MainApplication {

	public static void main(String[] args) {

		Car car = new Car(4, "Montero", "stututu");
		Truck truck = new Truck(12, "Isuzu", "vrrmmm");
		
		//Print line 1
		System.out.println("Start your engines!!!");
		System.out.println("~~~~~~~");
				
		//Car method part1
		car.startEngine();
		
		//Truck method part1
		truck.startEngine();

		//Print line 2
		System.out.println("~~~~~~~");
		System.out.println("Start Race!");
		System.out.println("~~~~~~~");
				
		//Car method part2
		car.refuel();
		
		//Truck method part2
		truck.refuel();
		
		//Print line 3
		System.out.println("~~~~~~~");
		
		//Car method part3
		car.racingSound();
		
		//Truck method part3
		truck.racingSound();
		
		//Print line 4
		System.out.println("~~~~~~~");
		
		//Call method destroy
		destroyVehicle(car);
		destroyVehicle(truck);
		
		//Print line 5
		System.out.println("~~~~~~~");
		System.out.println("Race END!!!");
		
	}
	
	public static void destroyVehicle(Vehicle vehicle) {
		vehicle.destroy();
	}

}

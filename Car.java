package M2_Activity6;

public class Car extends Vehicle implements Refuelable {
	
	public Car() {
		
	}
	
	public Car(int numberOfWheels, String brand, String sound) {
		super(numberOfWheels, brand, sound);
	}
	
	@Override
	public void startEngine() {
		System.out.println(this.getNumberOfWheels() + "-wheeled " + this.getBrand() + ". Engine has started!");
	}
	
	@Override
	public void refuel() {
		System.out.println("Refueling " + this.getBrand() + " at the pits!");
	}
	
	@Override
	public void racingSound() {
		System.out.println(this.getBrand() + " goes " + this.getSound() + "!!!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Oh no! " + this.getBrand() + " is destroyed...");
	}
}

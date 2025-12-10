package M2_Activity6;

public abstract class Vehicle implements Refuelable {
	
	private int numberOfWheels;
	private String brand;
	private String sound;
	
	public Vehicle() {
			
	}
	public Vehicle(int numberOfWheels, String brand, String sound) {
		this.numberOfWheels = numberOfWheels;
		this.brand = brand;
		this.sound = sound;
	}
	
	public abstract void startEngine();
	
	public abstract void racingSound();
	
	public void destroy() {
		System.out.println("This brand of vehicle "+this.getBrand()+" and "+this.getNumberOfWheels()+" wheeler is destroyed");
		
	}
	
	// Setters and Getters
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
}

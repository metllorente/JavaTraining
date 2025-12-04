package M2_Exercise1;

public class Car {
	
	// Attribute
	private String brand;
	private String model;
	private String year;
	private String color;

	// Constructor (NoArgs)
	public Car() {
		this.brand = "";
		this.model = "";
		this.year = "";
		this.color = "";
	}
	
	// Constructor (Params)
	public Car(String brand, String model, String year, String color) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.color = color;
	}
	// Get and Set
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	//Method
	public void displayDetails() {
		System.out.println("I own a " + getYear() + " " + getBrand() + " " + getModel() + " that is color " + getColor());
	}
	
}

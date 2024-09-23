package edu.westga.cs1302.javafx_Project1.model;

public class Food {
	private final String name;
	private final String type;
	private int quantity;

	public Food(String name, String type) {
		this.name = name;
		this.type = type;
		this.quantity = 0;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public int getQuantity() {
		return this.quantity;
	}

}

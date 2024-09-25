package edu.westga.cs1302.javafx_Project1.model;

/**
 * Represents a food item with a name, type, and quantity. The quantity of the
 * food item can be modified, but the name and type are immutable.
 * 
 * @author Joshua Oluranti
 * @version Fall 2024
 */
public class Food {
	private final String name;
	private final String type;
	private int quantity;

	/**
	 * Creates a new Food object with the specified name and type. The quantity is
	 * initialized to 0.
	 * 
	 * @param name the name of the food item
	 * @param type the type of the food item
	 */
	public Food(String name, String type) {
		this.name = name;
		this.type = type;
		this.quantity = 0;
	}

	/**
	 * Gets the name of the food item.
	 * 
	 * @return the name of the food item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the type of the food item.
	 * 
	 * @return the type of the food item
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Gets the current quantity of the food item.
	 * 
	 * @return the quantity of the food item
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Sets the quantity of the food item.
	 * 
	 * @param quantity the new quantity of the food item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Increments the quantity of the food item by 1.
	 */
	public void incrementQuantity() {
		this.quantity++;
	}

	/**
	 * Decrements the quantity of the food item by 1, if the quantity is greater
	 * than 0.
	 */
	public void decrementQuantity() {
		if (this.quantity > 0) {
			this.quantity--;
		}
	}

	@Override
	public String toString() {
		return this.name + " – " + this.quantity;
	}
}

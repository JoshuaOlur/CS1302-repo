package edu.westga.cs1302.javafx_Project1.Test;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.javafx_Project1.model.Food;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFoodConstructor {

	@Test
	void testConstructor() {
		Food apple = new Food("Apple", "Fruit");
		assertEquals("Apple", apple.getName());
	}

	@Test
	void testConstructorType() {
		Food apple = new Food("Apple", "Fruit");
		assertEquals("Fruit", apple.getType());
	}

	@Test
	void testInitializeQuantityToZero() {
		Food apple = new Food("Apple", "Fruit");
		assertEquals(0, apple.getQuantity());
	}
}

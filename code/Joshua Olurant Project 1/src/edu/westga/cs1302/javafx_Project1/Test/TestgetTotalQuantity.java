package edu.westga.cs1302.javafx_Project1.Test;

import edu.westga.cs1302.javafx_Project1.model.Food;
import edu.westga.cs1302.javafx_Project1.utils.PantryUtility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestgetTotalQuantity {

	@Test
	void testGetTotalQuantityWithEmptyList() {
		List<Food> pantryItems = new ArrayList<>();
		int result = PantryUtility.getTotalQuantity(pantryItems);
		assertEquals(0, result);
	}

	@Test
	void testGetTotalQuantityWithOneFoodItem() {
		List<Food> pantryItems = new ArrayList<>();
		Food apple = new Food("Apple", "Fruit");
		apple.setQuantity(5);
		pantryItems.add(apple);

		int result = PantryUtility.getTotalQuantity(pantryItems);
		assertEquals(5, result);
	}

	@Test
	void testGetTotalQuantityWithMultipleFoodItems() {
		List<Food> pantryItems = new ArrayList<>();

		Food apple = new Food("Apple", "Fruit");
		apple.setQuantity(5);
		Food bread = new Food("Bread", "Grain");
		bread.setQuantity(3);

		pantryItems.add(apple);
		pantryItems.add(bread);

		int result = PantryUtility.getTotalQuantity(pantryItems);
		assertEquals(8, result);
	}

	@Test
	void testGetTotalQuantityWithZeroQuantities() {
		List<Food> pantryItems = new ArrayList<>();

		Food apple = new Food("Apple", "Fruit");
		apple.setQuantity(0);
		Food bread = new Food("Bread", "Grain");
		bread.setQuantity(0);

		pantryItems.add(apple);
		pantryItems.add(bread);

		int result = PantryUtility.getTotalQuantity(pantryItems);
		assertEquals(0, result);
	}
}

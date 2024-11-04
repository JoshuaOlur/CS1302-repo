package edu.westga.cs1302.project2.test.model.TypeComparator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.TypeComparator;

public class TestCompare {

    private final TypeComparator comparator = new TypeComparator();

    @Test
    void testEqualTypes() {
        Ingredient ingredient1 = new Ingredient("Tomato", "Vegetable");
        Ingredient ingredient2 = new Ingredient("Lettuce", "Vegetable");
        assertEquals(0, comparator.compare(ingredient1, ingredient2));
    }

    @Test
    void testTypeLessThan() {
        Ingredient ingredient1 = new Ingredient("Chicken", "Meat");
        Ingredient ingredient2 = new Ingredient("Carrot", "Vegetable");
        assertTrue(comparator.compare(ingredient1, ingredient2) > 0);
    }

    @Test
    void testTypeGreaterThan() {
        Ingredient ingredient1 = new Ingredient("Banana", "Fruit");
        Ingredient ingredient2 = new Ingredient("Apple", "Fruit");
        assertTrue(comparator.compare(ingredient1, ingredient2) < 0);
    }
}

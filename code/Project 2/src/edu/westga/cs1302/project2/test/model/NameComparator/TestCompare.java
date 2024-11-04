package edu.westga.cs1302.project2.test.model.NameComparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.TypeComparator;

public class TestCompare {

    private TypeComparator comparator;

    @BeforeEach
    public void setUp() {
        this.comparator = new TypeComparator();
    }

    @Test
    void testCompareFirstBeforeSecond() {
        Ingredient ingredient1 = new Ingredient("Carrot", "Vegetable");
        Ingredient ingredient2 = new Ingredient("Chicken", "Meat");
        
        assertTrue(this.comparator.compare(ingredient1, ingredient2) > 0);
    }

    @Test
    void testCompareFirstAfterSecond() {
        Ingredient ingredient1 = new Ingredient("Chicken", "Meat");
        Ingredient ingredient2 = new Ingredient("Carrot", "Vegetable");
        
        assertTrue(this.comparator.compare(ingredient1, ingredient2) < 0);
    }

    @Test
    void testCompareWhenEqual() {
        Ingredient ingredient1 = new Ingredient("Tomato", "Vegetable");
        Ingredient ingredient2 = new Ingredient("Lettuce", "Vegetable");
        
        assertTrue(this.comparator.compare(ingredient1, ingredient2) == 0);
    }
}

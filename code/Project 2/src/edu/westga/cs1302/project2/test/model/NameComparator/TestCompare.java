package edu.westga.cs1302.project2.test.model.NameComparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.NameComparator;


public class TestCompare {

    private NameComparator comparator;

    @BeforeEach
    public void setUp() {
        this.comparator = new NameComparator();
    }

    @Test
     void testCompareFirstBeforeSecond() {
        Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
        Ingredient ingredient2 = new Ingredient("Banana", "Fruit");
        
        assertTrue(this.comparator.compare(ingredient1, ingredient2) < 0);
    }

    @Test
     void testCompareFirstAfterSecond() {
        Ingredient ingredient1 = new Ingredient("Banana", "Fruit");
        Ingredient ingredient2 = new Ingredient("Apple", "Fruit");
        
        assertTrue(this.comparator.compare(ingredient1, ingredient2) > 0);
    }

    @Test
     void testCompareWhenEqual() {
        Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
        Ingredient ingredient2 = new Ingredient("Apple", "Fruit");
        
        assertTrue(this.comparator.compare(ingredient1, ingredient2) == 0);
    }
}

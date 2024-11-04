package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import java.util.Arrays;

public class TestToString {

    @Test
    void testToStringWithIngredients() {
        Ingredient ingredient1 = new Ingredient("Flour", "Dry");
        Ingredient ingredient2 = new Ingredient("Sugar", "Dry");
        Recipe recipe = new Recipe("Cake", Arrays.asList(ingredient1, ingredient2));
        assertEquals("Cake: [Flour-Dry, Sugar-Dry]", recipe.toString());
    }


    @Test
    void testToStringSingleIngredient() {
        Ingredient ingredient = new Ingredient("Salt", "Spice");
        Recipe recipe = new Recipe("Salted Caramel", Arrays.asList(ingredient));
        assertEquals("Salted Caramel: [Salt-Spice]", recipe.toString());
    }

    @Test
    void testToStringMultipleTypes() {
        Ingredient ingredient1 = new Ingredient("Chicken", "Meat");
        Ingredient ingredient2 = new Ingredient("Rice", "Grain");
        Recipe recipe = new Recipe("Chicken Fried Rice", Arrays.asList(ingredient1, ingredient2));
        assertEquals("Chicken Fried Rice: [Chicken-Meat, Rice-Grain]", recipe.toString());
    }
}


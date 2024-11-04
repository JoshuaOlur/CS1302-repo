package edu.westga.cs1302.project2.test.model.RecipeConverter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeConverter;

import java.util.Arrays;

public class TestConvertRecipeListToString {

    @Test
    void testConvertRecipeListToString() {
        Ingredient ingredient1 = new Ingredient("Chicken", "Meat");
        Ingredient ingredient2 = new Ingredient("Rice", "Grain");
        Recipe recipe1 = new Recipe("Chicken Fried Rice", Arrays.asList(ingredient1, ingredient2));
        
        Ingredient ingredient3 = new Ingredient("Pasta", "Grain");
        Recipe recipe2 = new Recipe("Pasta Salad", Arrays.asList(ingredient3));
        
        String expected = "Chicken Fried Rice\nChicken\nRice\n\nPasta Salad\nPasta\n\n";
        assertEquals(expected, RecipeConverter.convertRecipeListToString(Arrays.asList(recipe1, recipe2)));
    }

    @Test
    void testConvertRecipeListToStringEmpty() {
        String expected = "";
        assertEquals(expected, RecipeConverter.convertRecipeListToString(Arrays.asList()));
    }
}

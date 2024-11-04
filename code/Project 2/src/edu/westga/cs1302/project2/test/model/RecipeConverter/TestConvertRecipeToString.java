package edu.westga.cs1302.project2.test.model.RecipeConverter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeConverter;

import java.util.Arrays;

public class TestConvertRecipeToString {

    @Test
    void testConvertRecipeToString() {
        Ingredient ingredient1 = new Ingredient("Flour", "Dry");
        Ingredient ingredient2 = new Ingredient("Sugar", "Dry");
        Recipe recipe = new Recipe("Cake", Arrays.asList(ingredient1, ingredient2));
        String expected = "Cake\nFlour, Sugar";
        assertEquals(expected, RecipeConverter.convertRecipeToString(recipe));
    }

    @Test
    void testConvertRecipeToStringSingleIngredient() {
        Ingredient ingredient = new Ingredient("Salt", "Spice");
        Recipe recipe = new Recipe("Salted Caramel", Arrays.asList(ingredient));
        String expected = "Salted Caramel\nSalt";
        assertEquals(expected, RecipeConverter.convertRecipeToString(recipe));
    }
}

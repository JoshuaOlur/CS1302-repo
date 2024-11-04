package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

public class TestConstructor {

    @Test
     void TestNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Recipe(null, new ArrayList<>());
        });
        assertEquals("Recipe name cannot be null or empty.", exception.getMessage());
    }

    @Test
     void TestNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Recipe("", new ArrayList<>());
        });
        assertEquals("Recipe name cannot be null or empty.", exception.getMessage());
    }

    @Test
     void TestIngredientsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Recipe("Test Recipe", null);
        });
        assertEquals("Ingredients cannot be null or empty.", exception.getMessage());
    }

    @Test
     void TestIngredientsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Recipe("Test Recipe", new ArrayList<>());
        });
        assertEquals("Ingredients cannot be null or empty.", exception.getMessage());
    }

    @Test
     void TestValidConstructor() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Flour", "Dairy"));
        Recipe recipe = new Recipe("Pancakes", ingredients);
        assertEquals("Pancakes", recipe.getName());
        assertEquals(1, recipe.getIngredients().size());
        assertEquals("Flour", recipe.getIngredients().get(0).getName());
    }
}

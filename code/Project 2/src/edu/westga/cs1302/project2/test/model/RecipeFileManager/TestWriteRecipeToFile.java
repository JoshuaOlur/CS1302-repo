package edu.westga.cs1302.project2.test.model.RecipeFileManager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeFileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class TestWriteRecipeToFile {

    private static final String TEST_FILE_PATH = "test_recipes.txt";

    @Test
    void testWriteNewRecipe() throws IOException {
        Ingredient ingredient = new Ingredient("Eggs", "Dairy");
        Recipe recipe = new Recipe("Omelette", Arrays.asList(ingredient));

        RecipeFileManager.writeRecipeToFile(recipe, TEST_FILE_PATH);

        String content = new String(Files.readAllBytes(new File(TEST_FILE_PATH).toPath()));
        String expectedContent = "Omelette\nEggs\n";
        assertTrue(content.contains(expectedContent));

        Files.delete(new File(TEST_FILE_PATH).toPath());
    }

    @Test
    void testWriteDuplicateRecipe() throws IOException {
        Ingredient ingredient = new Ingredient("Flour", "Dry");
        Recipe recipe = new Recipe("Pancakes", Arrays.asList(ingredient));
        RecipeFileManager.writeRecipeToFile(recipe, TEST_FILE_PATH);

        Recipe duplicateRecipe = new Recipe("Pancakes", Arrays.asList(new Ingredient("Milk", "Dairy")));

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            RecipeFileManager.writeRecipeToFile(duplicateRecipe, TEST_FILE_PATH);
        });

        String expectedMessage = "Recipe with the same name already exists.";
        assertEquals(expectedMessage, exception.getMessage());

        Files.delete(new File(TEST_FILE_PATH).toPath());
    }

    @Test
    void testWriteRecipeThrowsIOException() {
        Recipe recipe = new Recipe("Dummy", Arrays.asList(new Ingredient("None", "None")));

        assertThrows(IOException.class, () -> {
            RecipeFileManager.writeRecipeToFile(recipe, "invalid/path/to/file.txt");
        });
    }
}

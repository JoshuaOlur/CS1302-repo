package edu.westga.cs1302.project2.test.model.RecipeLoader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

public class TestLoadRecipes {

	private static final String TEST_FILE_PATH = "test_recipes.txt";

	@Test
	void testLoadRecipesFromFile() throws IOException {
		String content = "Pancakes\nFlour, Eggs, Milk\n\nOmelette\nEggs, Cheese\n\n";
		Files.write(Paths.get(TEST_FILE_PATH), content.getBytes());

		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipes = loader.loadRecipes(TEST_FILE_PATH);

		assertEquals(2, recipes.size());
		assertEquals("Pancakes", recipes.get(0).getName());
		assertEquals(3, recipes.get(0).getIngredients().size());
		assertEquals("Omelette", recipes.get(1).getName());
		assertEquals(2, recipes.get(1).getIngredients().size());

		Files.delete(Paths.get(TEST_FILE_PATH));
	}

	@Test
	void testLoadEmptyFile() throws IOException {
		Files.createFile(Paths.get(TEST_FILE_PATH));

		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipes = loader.loadRecipes(TEST_FILE_PATH);

		assertTrue(recipes.isEmpty());

		Files.delete(Paths.get(TEST_FILE_PATH));
	}

	@Test
	void testLoadNonExistentFile() {
		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipes = loader.loadRecipes("non_existent_file.txt");

		assertTrue(recipes.isEmpty());
	}
}

package edu.westga.cs1302.project2.test.model.RecipeLoader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestFindRecipesWithIngredient {

	private static final String TEST_FILE_PATH = "test_recipes.txt";

	@Test
	void testFindRecipesWithIngredient() throws IOException {
		String content = "Pancakes\nFlour, Eggs, Milk\n\nOmelette\nEggs, Cheese\n\nSalad\nLettuce, Tomatoes, Cheese\n\n";
		Files.write(Paths.get(TEST_FILE_PATH), content.getBytes());

		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipesWithEggs = loader.findRecipesWithIngredient("Eggs", TEST_FILE_PATH);

		assertEquals(2, recipesWithEggs.size());
		assertEquals("Pancakes", recipesWithEggs.get(0).getName());
		assertEquals("Omelette", recipesWithEggs.get(1).getName());

		Files.delete(Paths.get(TEST_FILE_PATH));
	}

	@Test
	void testFindRecipesWithNonExistentIngredient() throws IOException {
		String content = "Pancakes\nFlour, Eggs, Milk\n\nOmelette\nEggs, Cheese\n\n";
		Files.write(Paths.get(TEST_FILE_PATH), content.getBytes());

		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipesWithSugar = loader.findRecipesWithIngredient("Sugar", TEST_FILE_PATH);

		assertTrue(recipesWithSugar.isEmpty());

		Files.delete(Paths.get(TEST_FILE_PATH));
	}

	@Test
	void testFindRecipesWithIngredientCaseInsensitivity() throws IOException {
		String content = "Pancakes\nFlour, Eggs, Milk\n\nOmelette\neggs, Cheese\n\n";
		Files.write(Paths.get(TEST_FILE_PATH), content.getBytes());

		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipesWithEggs = loader.findRecipesWithIngredient("EGGS", TEST_FILE_PATH);

		assertEquals(2, recipesWithEggs.size());
		assertEquals("Pancakes", recipesWithEggs.get(0).getName());
		assertEquals("Omelette", recipesWithEggs.get(1).getName());

		Files.delete(Paths.get(TEST_FILE_PATH));
	}

	@Test
	void testFindRecipesWithIngredientEmptyFile() throws IOException {
		Files.createFile(Paths.get(TEST_FILE_PATH));

		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipesWithEggs = loader.findRecipesWithIngredient("Eggs", TEST_FILE_PATH);

		assertTrue(recipesWithEggs.isEmpty());

		Files.delete(Paths.get(TEST_FILE_PATH));
	}

	@Test
	void testFindRecipesWithIngredientNonExistentFile() {
		RecipeLoader loader = new RecipeLoader();
		List<Recipe> recipesWithEggs = loader.findRecipesWithIngredient("Eggs", "non_existent_file.txt");

		assertTrue(recipesWithEggs.isEmpty());
	}
}

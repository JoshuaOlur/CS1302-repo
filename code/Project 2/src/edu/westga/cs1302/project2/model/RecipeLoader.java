package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeLoader {

	public List<Recipe> loadRecipes(String filePath) {
		List<Recipe> recipes = new ArrayList<>();
		File file = new File(filePath);

		if (!file.exists()) {
			return recipes;
		}

		try (Scanner scanner = new Scanner(file)) {
			String recipeName = "";
			List<Ingredient> ingredients = new ArrayList<>();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				if (line.isEmpty()) {
					if (!recipeName.isEmpty() && !ingredients.isEmpty()) {
						recipes.add(new Recipe(recipeName, new ArrayList<>(ingredients)));
					}

					recipeName = "";
					ingredients.clear();
				} else if (recipeName.isEmpty()) {

					recipeName = line;
				} else {

					String[] parts = line.split(",\\s*");
					for (String part : parts) {
						ingredients.add(new Ingredient(part.trim(), "unknown"));
					}
				}
			}

			if (!recipeName.isEmpty() && !ingredients.isEmpty()) {
				recipes.add(new Recipe(recipeName, ingredients));
			}
		} catch (FileNotFoundException eE) {
			eE.printStackTrace();
		}

		return recipes;
	}

	public List<Recipe> findRecipesWithIngredient(String ingredientName, String filePath) {
		List<Recipe> allRecipes = this.loadRecipes(filePath);
		List<Recipe> matchingRecipes = new ArrayList<>();

		for (Recipe recipe : allRecipes) {
			for (Ingredient ingredient : recipe.getIngredients()) {
				if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
					matchingRecipes.add(recipe);
					break;
				}
			}
		}

		return matchingRecipes;
	}
}

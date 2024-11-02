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

		if (!file.exists() || file.length() == 0) {
			return recipes;
		}

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String recipeName = scanner.nextLine().trim();
				String ingredientsLine = scanner.nextLine().trim();
				Recipe recipe = new Recipe(recipeName);
				String[] ingredients = ingredientsLine.split(", ");
				for (String ingredient : ingredients) {
					String[] parts = ingredient.split("-");
					if (parts.length == 2) {
						recipe.addIngredient(new Ingredient(parts[0], parts[1]));
					}
				}
				recipes.add(recipe);
			}
		} catch (FileNotFoundException eE) {

		}

		return recipes;
	}

	public List<Recipe> loadRecipesByIngredient(String filePath, String ingredientName) {
		List<Recipe> recipes = this.loadRecipes(filePath);
		List<Recipe> filteredRecipes = new ArrayList<>();

		for (Recipe recipe : recipes) {
			for (Ingredient ingredient : recipe.getIngredients()) {
				if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
					filteredRecipes.add(recipe);
					break;
				}
			}
		}

		return filteredRecipes;
	}
}

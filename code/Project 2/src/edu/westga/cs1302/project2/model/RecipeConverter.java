package edu.westga.cs1302.project2.model;

import java.util.List;

public class RecipeConverter {

	public static String convertRecipeToString(Recipe recipe) {
		StringBuilder ingredientsList = new StringBuilder();
		for (Ingredient ingredient : recipe.getIngredients()) {
			ingredientsList.append(ingredient.getName()).append(", ");
		}
		return recipe.getName() + "\n" + ingredientsList.toString().replaceAll(", $", "");
	}

	public static String convertRecipeListToString(List<Recipe> recipes) {
		StringBuilder allRecipesString = new StringBuilder();
		for (Recipe recipe : recipes) {
			allRecipesString.append(convertRecipeToString(recipe)).append("\n\n");
		}
		return allRecipesString.toString().trim();
	}
}

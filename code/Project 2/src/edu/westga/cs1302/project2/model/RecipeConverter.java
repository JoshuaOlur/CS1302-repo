package edu.westga.cs1302.project2.model;

public class RecipeConverter {
	
	public static String convertRecipeToString(Recipe recipe) {
		StringBuilder ingredientsList = new StringBuilder();
		for (Ingredient ingredient : recipe.getIngredients()) {
			ingredientsList.append(ingredient.getName()).append(", ");
		}
		return recipe.getName() + "\n" + ingredientsList.toString().replaceAll(", $", "");
	}
}

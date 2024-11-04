package edu.westga.cs1302.project2.model;

import java.util.List;

/**
 * Converts recipes and lists of recipes to string representations.
 * 
 * @author Joshua Oluranti
 * @version 2024
 * 
 */
public class RecipeConverter {

    /**
     * Converts a single recipe to a string with its name and ingredients.
     * 
     * @param recipe the recipe to convert
     * @return a string representation of the recipe
     */
    public static String convertRecipeToString(Recipe recipe) {
        StringBuilder ingredientsList = new StringBuilder();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredientsList.append(ingredient.getName()).append(", ");
        }
        return recipe.getName() + "\n" + ingredientsList.toString().replaceAll(", $", "");
    }

    /**
     * Converts a list of recipes to a string with each recipe's name and ingredients.
     * 
     * @param recipes the list of recipes to convert
     * @return a string representation of the list of recipes
     */
    public static String convertRecipeListToString(List<Recipe> recipes) {
        StringBuilder result = new StringBuilder();
        for (Recipe recipe : recipes) {
            result.append(recipe.getName()).append("\n");
            for (Ingredient ingredient : recipe.getIngredients()) {
                result.append(ingredient.getName()).append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }
}

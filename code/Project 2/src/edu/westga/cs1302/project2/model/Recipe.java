package edu.westga.cs1302.project2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a recipe with a name and a list of ingredients.
 * 
 * @author Joshua Oluranti
 * @version 2024
 * 
 */
public class Recipe {
    private String name;
    private List<Ingredient> ingredients;

    /**
     * Creates a new recipe with the given name and ingredients.
     * 
     * @param name        the name of the recipe
     * @param ingredients the list of ingredients
     * @throws IllegalArgumentException if the name is null or empty, or if the
     *                                  ingredients list is null or empty
     */
    public Recipe(String name, List<Ingredient> ingredients) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Recipe name cannot be null or empty.");
        }
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("Ingredients cannot be null or empty.");
        }
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }

    /**
     * Gets the name of the recipe.
     * 
     * @return the recipe name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets a copy of the ingredients list.
     * 
     * @return a list of ingredients
     */
    public List<Ingredient> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }

    /**
     * Returns a string representation of the recipe, including its name and
     * ingredients.
     * 
     * @return the recipe as a string
     */
    @Override
    public String toString() {
        return this.name + ": " + this.ingredients.toString();
    }
}

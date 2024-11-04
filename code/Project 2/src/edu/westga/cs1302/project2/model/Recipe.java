package edu.westga.cs1302.project2.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;

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

    public String getName() {
        return this.name;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }

    @Override
    public String toString() {
        return this.name + ": " + this.ingredients.toString();
    }
}

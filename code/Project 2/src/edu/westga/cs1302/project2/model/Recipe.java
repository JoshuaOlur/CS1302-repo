package edu.westga.cs1302.project2.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;

    public Recipe(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Recipe name cannot be null or empty.");
        }
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}

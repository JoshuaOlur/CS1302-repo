package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**
 * Compares ingredients by their type.
 * 
 * @author Joshua Oluranti
 * @version 2024
 * 
 */
public class TypeComparator implements Comparator<Ingredient> {

    /**
     * Compares two ingredients by type.
     * 
     * @param ingredient1 the first ingredient
     * @param ingredient2 the second ingredient
     * @return a negative integer, zero, or a positive
     */
    @Override
    public int compare(Ingredient ingredient1, Ingredient ingredient2) {
        return ingredient1.getType().compareTo(ingredient2.getType());
    }

    /**
     * Returns "Type" as the string representation of this comparator.
     * 
     * @return the string "Type"
     */
    @Override
    public String toString() {
        return "Type";
    }
}

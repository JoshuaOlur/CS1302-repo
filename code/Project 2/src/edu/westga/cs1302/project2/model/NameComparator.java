package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**
 * Comparator for comparing ingredients by their names in alphabetical order.
 * 
 * @author Joshua Oluranti
 * @version 2024
 * 
 */
public class NameComparator implements Comparator<Ingredient> {

    /**
     * Compares two  Ingredient objects by their names.
     * 
     * @param ingredient1 the first ingredient to compare
     * @param ingredient2 the second ingredient to compare
     * @return a negative integer, zero, or a positive integer 
     */
    @Override
    public int compare(Ingredient ingredient1, Ingredient ingredient2) {
        return ingredient1.getName().compareTo(ingredient2.getName());
    }

    /**
     * Returns a string representation of the comparator.
     * 
     * @return the string "Name"
     */
    @Override
    public String toString() {
        return "Name";
    }
}

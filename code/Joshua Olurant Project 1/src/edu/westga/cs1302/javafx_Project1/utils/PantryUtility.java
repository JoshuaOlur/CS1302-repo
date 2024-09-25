package edu.westga.cs1302.javafx_Project1.utils;

import java.util.List;
import edu.westga.cs1302.javafx_Project1.model.Food;

/**
 * Utility class for pantry related operations.
 * Provides  the method for calculating total quantity of food items in the pantry.
 * 
 * @author Joshua Oluranti
 * @version Fall 2024
 */
public class PantryUtility {

    /**
     * Calculates the total quantity of all food items in the pantry.
     * 
     * @param pantryItems the list of food items in the pantry
     * @return the total quantity of all food items
     */
    public static int getTotalQuantity(List<Food> pantryItems) {
        int totalQuantity = 0;
        for (Food food : pantryItems) {
            totalQuantity += food.getQuantity();
        }
        return totalQuantity;
    }
}

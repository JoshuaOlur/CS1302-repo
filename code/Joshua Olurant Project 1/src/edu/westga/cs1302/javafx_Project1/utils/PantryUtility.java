package edu.westga.cs1302.javafx_Project1.utils;

import java.util.List;

import edu.westga.cs1302.javafx_Project1.model.Food;

public class PantryUtility {

	public static int getTotalQuantity(List<Food> pantryItems) {
        int totalQuantity = 0;
        for (Food food : pantryItems) {
            totalQuantity += food.getQuantity();
        }
        return totalQuantity;
    }
}

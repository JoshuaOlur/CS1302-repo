package edu.westga.cs1302.project2.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Manages saving recipes to a file.
 * 
 * @author Joshua Oluranti
 * @version 2024
 * 
 */
public class RecipeFileManager {

    /**
     * Writes a recipe to a file. If a recipe with the same name already exists
     * in the file, an exception is thrown.
     * 
     * @param recipe   the recipe to save
     * @param filePath the path of the file to save the recipe in
     * @throws IOException              if an I/O error occurs
     * @throws IllegalStateException    if a recipe with the same name exists in
     *                                  the file
     */
    public static void writeRecipeToFile(Recipe recipe, String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    if (scanner.nextLine().equals(recipe.getName())) {
                        throw new IllegalStateException("Recipe with the same name already exists.");
                    }
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(RecipeConverter.convertRecipeToString(recipe) + "\n");
        }
    }
}

package edu.westga.cs1302.project2.model;

import java.io.*;
import java.util.Scanner;

public class RecipeFileManager {
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

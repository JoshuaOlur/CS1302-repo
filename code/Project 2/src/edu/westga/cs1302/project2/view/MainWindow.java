package edu.westga.cs1302.project2.view;

import java.io.IOException;
import java.util.Comparator;

import edu.westga.cs1302.project2.model.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import edu.westga.cs1302.project2.model.NameComparator;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeFileManager;
import edu.westga.cs1302.project2.model.TypeComparator;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private ComboBox<String> ingredientType;
	@FXML
	private ListView<Ingredient> ingredientsList;
	@FXML
	private TextField ingredientName;
	@FXML
	private ComboBox<Comparator<Ingredient>> sortCriteria;
	@FXML
	private ListView<Ingredient> recipeIngredientsList;
	@FXML
	private TextField recipeName;

	@FXML
	void addIngredient(ActionEvent event) {
		try {
			this.ingredientsList.getItems()
					.add(new Ingredient(this.ingredientName.getText(), this.ingredientType.getValue()));
			this.ingredientName.clear();
			this.ingredientType.getSelectionModel().clearSelection();
			this.sortIngredients();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add ingredient");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void removeIngredient(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.ingredientsList.getItems().remove(selectedIngredient);
			this.sortIngredients();
		}
	}

	@FXML
	void initialize() {
		this.ingredientType.getItems().addAll("Vegetable", "Meat", "Bread", "Fruit", "Spice");
		this.sortCriteria.getItems().add(new TypeComparator());
		this.sortCriteria.getItems().add(new NameComparator());
		this.sortCriteria.getSelectionModel().selectFirst();
		this.sortCriteria.setOnAction(event -> this.sortIngredients());
	}

	private void sortIngredients() {
		Comparator<Ingredient> selectedComparator = this.sortCriteria.getValue();
		if (selectedComparator != null) {
			this.ingredientsList.getItems().sort(selectedComparator);
		}
	}

	@FXML
	void addIngredientToRecipe(ActionEvent event) {
	    Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
	    if (selectedIngredient != null) {
	        this.recipeIngredientsList.getItems().add(selectedIngredient);
	    }
	}
	
	@FXML
	void addRecipe(ActionEvent event) {
	    String name = this.recipeName.getText();
	    if (name == null || name.isEmpty()) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText("Invalid Recipe Name");
	        alert.setContentText("Recipe name cannot be empty.");
	        alert.showAndWait();
	        return;
	    }

	    Recipe newRecipe = new Recipe(name);
	    newRecipe.getIngredients().addAll(this.recipeIngredientsList.getItems());

	    try {
	        RecipeFileManager.writeRecipeToFile(newRecipe, "recipes.txt");
	        this.recipeIngredientsList.getItems().clear();
	        this.recipeName.clear();
	    } catch (IOException | IllegalStateException eE) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText("Unable to save recipe");
	        alert.setContentText(eE.getMessage());
	        alert.showAndWait();
	    }
	}
}

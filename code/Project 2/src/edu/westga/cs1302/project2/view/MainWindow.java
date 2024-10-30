package edu.westga.cs1302.project2.view;

import java.util.Comparator;

import edu.westga.cs1302.project2.model.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import edu.westga.cs1302.project2.model.NameComparator;
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

}

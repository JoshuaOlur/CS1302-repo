package edu.westga.cs1302.javafx_Project1.view;

import edu.westga.cs1302.javafx_Project1.model.Food;
import edu.westga.cs1302.javafx_Project1.utils.PantryUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author Joshua Oluranti
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private TextField foodNameTextField;

	@FXML
	private ComboBox<String> foodTypeComboBox;
	@FXML
	private ListView<Food> pantryListView;

	private ObservableList<String> pantryItems;

	@FXML
	private TextField quantityTextField;

	@FXML
	private void initialize() {
		this.foodTypeComboBox.setItems(
				FXCollections.observableArrayList("Vegetable", "Meat", "Bread", "Fruit", "Dessert", "Ingredient"));
		this.pantryItems = FXCollections.observableArrayList();
	}

	@FXML
	private void handleAddFood() {
		String foodName = this.foodNameTextField.getText();
		String foodType = this.foodTypeComboBox.getValue();

		if (foodName != null && !foodName.isEmpty() && foodType != null) {
			Food newFood = new Food(foodName, foodType);
			this.pantryItems.add(newFood.toString());
			this.pantryListView.getItems().add(newFood);
			this.foodNameTextField.clear();
			this.foodTypeComboBox.getSelectionModel().clearSelection();
		}
	}

	@FXML
	private void handleSetQuantity() {
		Food selectedFood = this.pantryListView.getSelectionModel().getSelectedItem();
		String quantityText = this.quantityTextField.getText();

		if (selectedFood != null && quantityText != null && !quantityText.isEmpty()) {
			try {
				int newQuantity = Integer.parseInt(quantityText);
				selectedFood.setQuantity(newQuantity);
				this.pantryListView.refresh();
			} catch (NumberFormatException eE) {

			}
		}
	}

	@FXML
	private void handleIncrementQuantity() {
		Food selectedFood = this.pantryListView.getSelectionModel().getSelectedItem();
		selectedFood.setQuantity(selectedFood.getQuantity() + 1);
		this.pantryListView.refresh();
	}

	@FXML
	private void handleDecrementQuantity() {
		Food selectedFood = this.pantryListView.getSelectionModel().getSelectedItem();
		selectedFood.setQuantity(selectedFood.getQuantity() - 1);
		this.pantryListView.refresh();
	}

	@FXML
	private void handleRemoveFood() {
		Food selectedFood = this.pantryListView.getSelectionModel().getSelectedItem();
		this.pantryListView.getItems().remove(selectedFood);
	}

	@FXML
	private void handleViewCount() {
		int totalQuantity = PantryUtility.getTotalQuantity(this.pantryListView.getItems());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Total Quantity");
		alert.setHeaderText(null);
		alert.setContentText("Total quantity of food items in the pantry: " + totalQuantity);
		alert.showAndWait();
	}
}

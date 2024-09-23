package edu.westga.cs1302.javafx_Project1.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
	private ListView<String> pantryListView;

	private ObservableList<String> pantryItems;

	@FXML
	private void initialize() {
		this.foodTypeComboBox.setItems(FXCollections.observableArrayList("Test", "1", "2", "5", "6"));
		this.pantryItems = FXCollections.observableArrayList();
		this.pantryListView.setItems(this.pantryItems);
	}

	@FXML
	private void handleAddFood() {
		String foodName = this.foodNameTextField.getText();
		String foodType = this.foodTypeComboBox.getValue();

		if (foodName != null && !foodName.isEmpty() && foodType != null) {
			String foodItem = foodName + " (" + foodType + ")";
			this.pantryItems.add(foodItem);
			this.foodNameTextField.clear();
			this.foodTypeComboBox.getSelectionModel().clearSelection();
		}
	}

}

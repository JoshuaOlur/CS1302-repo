package edu.westga.cs1302.javafx_Project1.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
	private void handleAddFood() {
	    String foodName = this.foodNameTextField.getText();
	    String foodType = this.foodTypeComboBox.getValue();

	    if (foodName != null && !foodName.isEmpty() && foodType != null) {
	        String foodItem = foodName + " (" + foodType + ")";
	    }
	}
}

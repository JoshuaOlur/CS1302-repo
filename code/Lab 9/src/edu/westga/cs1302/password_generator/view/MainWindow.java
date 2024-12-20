package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private TextArea output;
	@FXML
	private Label errorTextLabel;
	@FXML
	private Button generatePasswordButton;
	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private MenuBar menuBar;
	@FXML
	private MenuItem closeMenuItem;
	private ViewModel vm;

	@FXML
	void initialize() {
		this.enablePassowrd();
		this.vm = new ViewModel();
		this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
		this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
		this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
		this.minimumLength.setText(this.vm.getMinimumLength().getValue());
		this.vm.getMinimumLength().bind(this.minimumLength.textProperty());

		this.output.textProperty().bind(this.vm.getPassword());
		this.errorTextLabel.textProperty().bind(this.vm.getErrorText());

		this.generatePasswordButton.setOnAction((event) -> {
			this.vm.generatePassword();
		});
	}

	@FXML
	void closeWindow() {
		Platform.exit();
	}

	@FXML
	void displayAboutSection() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ABOUT");
		alert.setContentText("Author: Joshua Oluranti");
		alert.setHeaderText("A Project with the purpose of of creating random really bad passwords");
		alert.showAndWait();
	}

	@FXML
	void enablePassowrd() {
		this.minimumLength.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				int length = Integer.parseInt(newValue);
				if (length < 1) {
					this.generatePasswordButton.setDisable(true);
				} else {
					this.generatePasswordButton.setDisable(false);
				}
			} catch (Exception ex) {
				this.generatePasswordButton.setDisable(true);
			}
		}

		);
	}
}

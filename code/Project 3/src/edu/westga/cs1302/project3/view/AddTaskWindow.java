package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {
	@FXML
	private Button addTaskButton;

	@FXML
	private Button cancelButton;
	@FXML
	private TextArea descriptionTextArea;

	@FXML
	private TextField titleTextField;
	private MainWindowViewModel vm;

	public void bindToVM(MainWindowViewModel vm) {
		this.vm = vm;
		this.descriptionTextArea.textProperty().bindBidirectional(vm.getDescription());
		this.titleTextField.textProperty().bindBidirectional(vm.getTitle());

	}

	@FXML
	void cancel(ActionEvent event) {
		this.titleTextField.getParent().getScene().getWindow().hide();

	}

	@FXML
	void addTask(ActionEvent event) {
		if (this.titleTextField.getText() == null || this.titleTextField.getText().isBlank()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Title cannot be null");
			alert.setHeaderText("Input Error");
			alert.showAndWait();
		} else if (this.descriptionTextArea.getText() == null || this.descriptionTextArea.getText().isBlank()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Description cannot be null");
			alert.setHeaderText("Input Error");
			alert.showAndWait();
		} else {
			try {
				this.vm.addTask();
			} catch (Exception eE) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setContentText("Task cannot be a duplicate");
				alert.setHeaderText("Duplicate Task");
				alert.showAndWait();
				
			}
			this.titleTextField.getParent().getScene().getWindow().hide();
			this.titleTextField.clear();
			this.descriptionTextArea.clear();
		}
	}
}

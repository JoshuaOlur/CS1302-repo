package edu.westga.cs1302.cms.view;

import edu.westga.cs1302.cms.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Code behind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private TextField name;
	@FXML
	private TextField grade;
	@FXML
	private ListView<Student> students;

	@FXML
	void addStudent(ActionEvent event) {
		String studentName = this.name.getText();
		try {
			int grade = Integer.parseInt(this.grade.getText());
			Student student = new Student(studentName, grade);
			this.students.getItems().add(student);
		} catch (NumberFormatException errorThing) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorThing.getMessage() + ". Please reenter grade and try again.");
			errorPopup.showAndWait();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorObject.getMessage() + ". Please reenter name and try again.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void removeStudent(ActionEvent event) {
		Student student = this.students.getSelectionModel().getSelectedItem();
		if (student != null) {
			this.students.getItems().remove(student);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No student selected. Unable to remove.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void initialize() {
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.students != null : "fx:id=\"students\" was not injected: check your FXML file 'MainWindow.fxml'.";
		this.setupListeners();

	}

	private void setupListeners() {
		this.students.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			try {
				Alert infoPopup = new Alert(Alert.AlertType.INFORMATION);
				infoPopup.setContentText(Integer.toString(newVal.getGrade()));
				infoPopup.setTitle("Student Grade");
				infoPopup.showAndWait();

			} catch (Exception exception) {
				return;
			}
		});
	}

	@FXML
    void getAverageClicked(ActionEvent event) {
		if (this.students.getItems().isEmpty()) {
	        Alert errorPopup = new Alert(Alert.AlertType.ERROR);
	        errorPopup.setContentText("No students in the list to calculate the average.");
	        errorPopup.showAndWait();
	        return;
	    }

	    int totalGrades = 0;
	    int numberOfStudents = this.students.getItems().size();
	    
	    for (Student student : this.students.getItems()) {
	        totalGrades += student.getGrade();
	    }

	    double averageGrade = (double) totalGrades / numberOfStudents;

	    Alert infoPopup = new Alert(Alert.AlertType.INFORMATION);
	    infoPopup.setTitle("Average Grade");
	    infoPopup.setContentText("The average grade is: " + String.format("%.2f", averageGrade));
	    infoPopup.showAndWait();
    }

}

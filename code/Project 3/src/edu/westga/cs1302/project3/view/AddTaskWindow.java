package edu.westga.cs1302.project3.view;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {
	 	@FXML
	    private TextArea descriptionTextArea;

	    @FXML
	    private TextField titleTextField;

	public void bindToVM(MainWindowViewModel vm) {
		this.descriptionTextArea.textProperty().bindBidirectional(vm.getDescription());
		this.titleTextField.textProperty().bindBidirectional(vm.getTitle());
	}
	
}

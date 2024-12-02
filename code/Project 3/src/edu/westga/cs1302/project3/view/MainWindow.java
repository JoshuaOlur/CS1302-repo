package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private Button addButton;

	@FXML
	private MenuItem addPeopleMenuItem;

	@FXML
	private MenuItem addTasksMenuItem;

	@FXML
	private MenuItem closeMenu;

	@FXML
	private MenuItem loadTasksMenuItem;

	@FXML
	private Button removeButton;

	@FXML
	private MenuItem saveTasksMenuItem;

	@FXML
	private ListView<Task> taskListView;
	private MainWindowViewModel vm;

	@FXML
	void initialize() {
		this.vm = new MainWindowViewModel();
		this.setUpBinding();
	}

	private void setUpBinding() {
		this.taskListView.itemsProperty().bindBidirectional(this.vm.getTaskList());

	}

	@FXML
	void addTask(ActionEvent event) {

	}

	@FXML
	void removeTask(ActionEvent event) {

	}

}

package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.IOException;

import edu.westga.cs1302.project3.Main;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

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
	private AnchorPane pane;

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
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.PROPERTY_WINDOW));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage setPropertyStage = new Stage();
			setPropertyStage.setTitle(Main.PROPERTY_WINDOW_TITLE);
			setPropertyStage.setScene(scene);
			setPropertyStage.initModality(Modality.APPLICATION_MODAL);

			AddTaskWindow propertyCodebehind = (AddTaskWindow) loader.getController();
			propertyCodebehind.bindToVM(this.vm);

			setPropertyStage.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Unable to load properties window.");
			alert.showAndWait();
		}
	}

	@FXML
	void removeTask(ActionEvent event) {

	}

	@FXML
	void handleFileLoad(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open txt File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Window window = this.pane.getScene().getWindow();
		File selectedFile = fileChooser.showOpenDialog(window);
		if (selectedFile != null) {
			this.vm.loadData(selectedFile);
		}

	}

	@FXML
	void handleFileSave(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Saving .txt or csv File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Csv Files", "*.csv"));
		Window window = this.pane.getScene().getWindow();
		File selectedFile = fileChooser.showSaveDialog(window);
		if (selectedFile != null) {
			this.vm.saveData(selectedFile);
		}

	}
}

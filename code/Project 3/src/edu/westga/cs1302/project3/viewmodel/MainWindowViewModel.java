package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.PersistienceManager;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MainWindowViewModel {
	private ListProperty<Task> taskList;
	private TaskManager tm;
	private PersistienceManager pm;

	private StringProperty description;
	private StringProperty title;

	public MainWindowViewModel() {
		this.tm = new TaskManager();
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList());
		this.description = new SimpleStringProperty();
		this.title = new SimpleStringProperty();

		this.pm = new PersistienceManager();
		Task sampleTask = new Task("Cleaning", "Task of cleaning room");
		Task sampleTask2 = new Task("Eating", "Task of eating room");
		Task sampleTask3 = new Task("Vaccume", "Task of Vaccuming room");

		this.tm.addTask(sampleTask);
		this.tm.addTask(sampleTask2);
		this.tm.addTask(sampleTask3);
		this.updateDisplay();

	}

	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}

	public StringProperty getDescription() {
		return this.description;
	}

	public StringProperty getTitle() {
		return this.title;
	}

	private void updateDisplay() {
		this.taskList.setValue(FXCollections.observableArrayList(this.tm.getTasks()));
	}

	public void loadData(File selectedFile) {
		this.tm.getTasks().clear();
		this.taskList.clear();
		try {
			this.tm = this.pm.loadTasks(selectedFile);
			this.updateDisplay();
		} catch (Exception eE) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Invalid File");
			alert.setHeaderText("Something Went Wrong");
			alert.showAndWait();
		}
	}

	public void saveData(File selectedFile) {
		try {
			this.pm.saveTasks(this.tm, selectedFile);
			this.taskList.clear();
		} catch (IOException eE) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("file can’t be overwritten");
			alert.setHeaderText("FIX IT");
			alert.showAndWait();

		}
		this.updateDisplay();

	}

	public void addTask() {
		String title = this.title.get();
		String description = this.description.get();
		Task task = new Task(title, description);
		this.tm.addTask(task);
		this.taskList.add(task);

	}
	
	public void removeTask(Task task) {
		this.tm.removeTask(task);
		this.taskList.remove(task);

	}

}

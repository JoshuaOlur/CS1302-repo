package edu.westga.cs1302.project3.viewmodel;

import java.io.File;

import java.io.IOException;

import edu.westga.cs1302.project3.model.PersistienceManager;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import javafx.beans.property.ListProperty;

import javafx.beans.property.SimpleListProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

import javafx.scene.control.Alert;

/**
 * ViewModel for the main window of the task management application. Manages the
 * binding between the model and the view.
 * 
 * @author JO
 * @version Fall 2024
 */
public class MainWindowViewModel {
	private ListProperty<Task> taskList;
	private TaskManager tm;
	private PersistienceManager pm;

	private StringProperty description;
	private StringProperty title;

	/**
	 * Creates a new MainWindowViewModel and initializes the task list with sample
	 * tasks.
	 */
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

	/**
	 * Gets the list of tasks as a property.
	 * 
	 * @return the task list property
	 */
	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}

	/**
	 * Gets the description property.
	 * 
	 * @return the description property
	 */
	public StringProperty getDescription() {
		return this.description;
	}

	/**
	 * Gets the title property.
	 * 
	 * @return the title property
	 */
	public StringProperty getTitle() {
		return this.title;
	}

	/**
	 * Updates the displayed list of tasks based on the current task manager state.
	 */
	private void updateDisplay() {
		this.taskList.setValue(FXCollections.observableArrayList(this.tm.getTasks()));
	}

	/**
	 * Loads task data from a file and updates the task list.
	 * 
	 * @param selectedFile the file to load tasks from
	 */
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

	/**
	 * Saves task data to a file.
	 * 
	 * @param selectedFile the file to save tasks to
	 */
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

	/**
	 * Adds a new task to the task manager and the displayed task list.
	 */
	public void addTask() {
		String title = this.title.get();
		String description = this.description.get();
		Task task = new Task(title, description);
		this.tm.addTask(task);
		this.taskList.add(task);

	}

	/**
	 * Removes a task from the task manager and the displayed task list.
	 * 
	 * @param task the task to remove
	 */
	public void removeTask(Task task) {
		try {
		this.tm.removeTask(task);
		this.taskList.remove(task);
		} catch (IllegalArgumentException eE) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Cannot Remove Nothing");
			alert.setHeaderText("Something Went Wrong");
			alert.showAndWait();
		}
	}

}

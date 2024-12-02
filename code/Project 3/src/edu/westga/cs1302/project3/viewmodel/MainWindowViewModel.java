package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.PersistienceManager;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class MainWindowViewModel {
	private ListProperty<Task> taskList;
	private TaskManager tm;
	private PersistienceManager pm;

	public MainWindowViewModel() {
		this.tm = new TaskManager();
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList());
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

	private void updateDisplay() {
		this.taskList.setValue(FXCollections.observableArrayList(this.tm.getTasks()));
	}

	public void loadData(File selectedFile) {
			this.tm.getTasks().clear();
			try {
				this.tm = this.pm.loadTasks(selectedFile);
				this.updateDisplay();
			} catch (IOException eE) {
				System.out.println("Somethinw went wrong");// redo this as alert tommrow 
				eE.printStackTrace();
			}
	}
}
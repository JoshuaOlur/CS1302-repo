package edu.westga.cs1302.project3.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles saving and loading tasks to and from a file.
 * 
 * @author JO
 * @version Fall 2024
 */
public class PersistienceManager {

	/**
	 * Saves the tasks from the given TaskManager to the specified file.
	 * 
	 * @param taskManager the TaskManager containing tasks to save
	 * @param file        the file being saved
	 * @throws IllegalArgumentException if taskManager or filePath is null
	 * @throws IOException              if an I/O error occurs
	 */
	public void saveTasks(TaskManager taskManager, File file) throws IOException {
		if (taskManager == null) {
			throw new IllegalArgumentException("TaskManager cannot be null.");
		}
		if (file == null) {
			throw new IllegalArgumentException("File path cannot be null.");
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write("Task:");
			writer.newLine();
			for (Task task : taskManager.getTasks()) {
				writer.write(task.getTitle() + "," + task.getDescription());
				writer.newLine();
			}
		}
	}

	/**
	 * Loads tasks from the specified file into a new TaskManager.
	 * 
	 * @param file the file being loaded
	 * @return a TaskManager containing the loaded tasks
	 * @throws IllegalArgumentException if filePath is null
	 * @throws IOException              if an I/O error occurs
	 */
	public TaskManager loadTasks(File file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException();
		}

		TaskManager taskManager = new TaskManager();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			if (!reader.readLine().toUpperCase().equals("Task:".toUpperCase())) {
				System.out.println("Here");
				throw new IllegalArgumentException();
			}
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",", 2);
				if (parts.length == 2) {
					String title = parts[0];
					String description = parts[1];
					taskManager.addTask(new Task(title, description));
				}
			}
		}

		return taskManager;
	}
}

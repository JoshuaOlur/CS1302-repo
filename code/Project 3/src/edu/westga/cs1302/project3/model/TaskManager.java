package edu.westga.cs1302.project3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of tasks.
 * 
 * @author JO
 * @version Fall 2024
 */
public class TaskManager {
	private final List<Task> tasks;
	private Map<String, Task> taskMap;

	/**
	 * Creates a new TaskManager.
	 */
	public TaskManager() {
		this.tasks = new ArrayList<>();
		this.taskMap = new HashMap<String, Task>();
	}

	/**
	 * Adds a task to the manager.
	 * 
	 * @param task the task to add
	 * @throws IllegalArgumentException if the task is null
	 */
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		if (this.isDuplicate(task.getTitle())) {
			throw new IllegalArgumentException("Task is a duplicate");
		}
		this.tasks.add(task);
		this.taskMap.put(task.getTitle(), task);
	}

	private boolean isDuplicate(String title) {
		if (this.taskMap.get(title) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Removes a task from the manager.
	 * 
	 * @param task the task to remove
	 * @throws IllegalArgumentException if the task is null
	 * @return true if the task was removed, false if the task was not in the list
	 */
	public boolean removeTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		this.taskMap.remove(task.getTitle());
		return this.tasks.remove(task);
		
	}

	/**
	 * Gets all tasks in the manager.
	 * 
	 * @return a list of tasks
	 */
	public List<Task> getTasks() {
		return new ArrayList<>(this.tasks);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Task Manager:\n");
		for (Task task : this.tasks) {
			builder.append(task.toString()).append("\n");
		}
		return builder.toString();
	}
}

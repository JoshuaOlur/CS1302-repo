package edu.westga.cs1302.project3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of tasks.
 * 
 * @author JO
 * @version Fall 2024
 */
public class TaskManager {
    private final List<Task> tasks;

    /**
     * Creates a new TaskManager.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
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
        this.tasks.add(task);
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

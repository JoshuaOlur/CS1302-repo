package edu.westga.cs1302.project3.model;

/**
 * Represents a Task with a title and description.
 * 
 * @author JO
 * @version Fall 2024
 */
public class Task {
    private final String title;
    private final String description;

    /**
     * Creates a new Task.
     * 
     * @param title the title of the task
     * @param description the description of the task
     * @throws IllegalArgumentException if title or description is null or empty
     */
    public Task(String title, String description) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.title = title;
        this.description = description;
    }

    /**
     * Gets the title of the task.
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the description of the task.
     * 
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Task: " + this.title + " - " + this.description;
    }
}

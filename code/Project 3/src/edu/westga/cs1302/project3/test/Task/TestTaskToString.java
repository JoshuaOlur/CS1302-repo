package edu.westga.cs1302.project3.test.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

public class TestTaskToString {

    @Test
    void testToStringWithValidTitle() {
        Task task = new Task("Study", "Prepare for the exam");
        assertEquals("Task: Study", task.toString());
    }

    @Test
    void testToStringWithEmptyDescription() {
        Task task = new Task("Read", "Read the assigned chapters");
        assertEquals("Task: Read", task.toString());
    }

    @Test
    void testToStringWithLongTitle() {
        Task task = new Task("Complete JavaFX Assignment", "Finish all pending tasks for Project 3");
        assertEquals("Task: Complete JavaFX Assignment", task.toString());
    }

    @Test
    void testToStringWithSpecialCharactersInTitle() {
        Task task = new Task("Clean & Organize!", "Organize the bookshelf and clean the table");
        assertEquals("Task: Clean & Organize!", task.toString());
    }
}


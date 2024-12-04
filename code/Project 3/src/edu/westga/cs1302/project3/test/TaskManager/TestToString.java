package edu.westga.cs1302.project3.test.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestToString {

    @Test
    void testToStringWithNoTasks() {
        TaskManager taskManager = new TaskManager();
        String expected = "Task Manager:\n";
        assertEquals(expected, taskManager.toString());
    }

    @Test
    void testToStringWithOneTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task1", "Description1");
        taskManager.addTask(task);
        String expected = "Task Manager:\nTask: Task1\n";
        assertEquals(expected, taskManager.toString());
    }
}

package edu.westga.cs1302.project3.test.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestAddTask {

    @Test
    void addTaskShouldThrowExceptionForNullTask() {
        TaskManager taskManager = new TaskManager();
        assertThrows(IllegalArgumentException.class, () -> taskManager.addTask(null));
    }

    @Test
    void addTaskShouldAddSingleTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task1", "Description1");

        taskManager.addTask(task);

        assertEquals(1, taskManager.getTasks().size());
        assertEquals(task, taskManager.getTasks().get(0));
    }

    @Test
    void addTaskShouldAddMultipleTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Task1", "Description1");
        Task task2 = new Task("Task2", "Description2");

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        assertEquals(2, taskManager.getTasks().size());
        assertTrue(taskManager.getTasks().contains(task1));
        assertTrue(taskManager.getTasks().contains(task2));
    }

    @Test
    void addTaskShouldNotAddDuplicateTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task1", "Description1");

        taskManager.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> taskManager.addTask(task));
    }
}

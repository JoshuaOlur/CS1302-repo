package edu.westga.cs1302.project3.test.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestRemoveTask {

    @Test
    void removeTaskShouldThrowExceptionForNullTask() {
        TaskManager taskManager = new TaskManager();
        assertThrows(IllegalArgumentException.class, () -> taskManager.removeTask(null));
    }

    @Test
    void removeTaskShouldRemoveExistingTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task1", "Description1");
        taskManager.addTask(task);

        taskManager.removeTask(task);

        assertEquals(0, taskManager.getTasks().size());
        assertFalse(taskManager.getTasks().contains(task));
    }

    @Test
    void removeTaskShouldNotAffectListIfTaskNotPresent() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Task1", "Description1");
        Task task2 = new Task("Task2", "Description2");

        taskManager.addTask(task1);

        taskManager.removeTask(task2);

        assertEquals(1, taskManager.getTasks().size());
        assertTrue(taskManager.getTasks().contains(task1));
    }

    @Test
    void removeTaskShouldHandleRemovingMultipleTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Task1", "Description1");
        Task task2 = new Task("Task2", "Description2");

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeTask(task1);

        assertEquals(1, taskManager.getTasks().size());
        assertFalse(taskManager.getTasks().contains(task1));
        assertTrue(taskManager.getTasks().contains(task2));
    }
}


package edu.westga.cs1302.project3.test.PersistenceManager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.PersistienceManager;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestLoadData {

    @Test
    void loadTasksShouldThrowExceptionForNullFile() {
        PersistienceManager pm = new PersistienceManager();
        assertThrows(IllegalArgumentException.class, () -> pm.loadTasks(null));
    }

    @Test
    void loadTasksShouldThrowExceptionForInvalidFileFormat() throws IOException {
        File invalidFile = File.createTempFile("invalid", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(invalidFile))) {
            writer.write("Invalid Header");
            writer.newLine();
            writer.write("Task1,Description1");
        }
        invalidFile.deleteOnExit();

        PersistienceManager pm = new PersistienceManager();
        assertThrows(IllegalArgumentException.class, () -> pm.loadTasks(invalidFile));
    }

    @Test
    void loadTasksShouldLoadTasksFromValidFile() throws IOException {
        File validFile = File.createTempFile("valid", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(validFile))) {
            writer.write("Task:");
            writer.newLine();
            writer.write("Task1,Description1");
            writer.newLine();
            writer.write("Task2,Description2");
        }
        validFile.deleteOnExit();

        PersistienceManager pm = new PersistienceManager();
        TaskManager taskManager = pm.loadTasks(validFile);

        assertEquals(2, taskManager.getTasks().size());
        assertEquals("Task1", taskManager.getTasks().get(0).getTitle());
        assertEquals("Description1", taskManager.getTasks().get(0).getDescription());
        assertEquals("Task2", taskManager.getTasks().get(1).getTitle());
        assertEquals("Description2", taskManager.getTasks().get(1).getDescription());
    }

    @Test
    void loadTasksShouldReturnEmptyTaskManagerForEmptyFile() throws IOException {
        File emptyFile = File.createTempFile("empty", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emptyFile))) {
            writer.write("Task:");
        }
        emptyFile.deleteOnExit();

        PersistienceManager pm = new PersistienceManager();
        TaskManager taskManager = pm.loadTasks(emptyFile);

        assertTrue(taskManager.getTasks().isEmpty());
    }
}


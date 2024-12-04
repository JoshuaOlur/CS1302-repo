package edu.westga.cs1302.project3.test.PersistenceManager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.PersistienceManager;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

public class TestSaveData {

    @Test
    void saveTasksShouldThrowExceptionForNullTaskManager() {
        PersistienceManager pm = new PersistienceManager();
        File file = new File("test.txt");

        assertThrows(IllegalArgumentException.class, () -> pm.saveTasks(null, file));
    }

    @Test
    void saveTasksShouldThrowExceptionForNullFile() {
        PersistienceManager pm = new PersistienceManager();
        TaskManager tm = new TaskManager();

        assertThrows(IllegalArgumentException.class, () -> pm.saveTasks(tm, null));
    }

    @Test
    void saveTasksShouldSaveTasksToFile() throws IOException {
        TaskManager tm = new TaskManager();
        tm.addTask(new Task("Task1", "Description1"));
        tm.addTask(new Task("Task2", "Description2"));

        File file = File.createTempFile("tasks", ".txt");
        file.deleteOnExit();

        PersistienceManager pm = new PersistienceManager();
        pm.saveTasks(tm, file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals("Task:", reader.readLine());
            assertEquals("Task1,Description1", reader.readLine());
            assertEquals("Task2,Description2", reader.readLine());
        }
    }

    @Test
    void saveTasksShouldCreateEmptyFileForEmptyTaskManager() throws IOException {
        TaskManager tm = new TaskManager();

        File file = File.createTempFile("emptytasks", ".txt");
        file.deleteOnExit();

        PersistienceManager pm = new PersistienceManager();
        pm.saveTasks(tm, file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals("Task:", reader.readLine());
            assertNull(reader.readLine());
        }
    }
}

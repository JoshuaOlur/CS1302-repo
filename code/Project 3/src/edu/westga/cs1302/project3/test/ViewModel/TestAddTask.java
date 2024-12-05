package edu.westga.cs1302.project3.test.ViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

public class TestAddTask {

    private MainWindowViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new MainWindowViewModel();
    }

    @Test
    void testAddTaskSuccessfully() {
        String title = "New Task";
        String description = "Description of the new task";
        viewModel.getTitle().set(title);
        viewModel.getDescription().set(description);

        viewModel.addTask();

        assertEquals(4, viewModel.getTaskList().size());
        assertTrue(viewModel.getTaskList().stream().anyMatch(task -> task.getTitle().equals(title) && task.getDescription().equals(description)));
    }

    @Test
    void testAddDuplicateTask() {
        String title = "New Task";
        String description = "Description of the new task";
        viewModel.getTitle().set(title);
        viewModel.getDescription().set(description);

        viewModel.addTask();  

        assertThrows(IllegalArgumentException.class, () -> {
            viewModel.addTask();  
        });
    }
}

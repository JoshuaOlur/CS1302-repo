package edu.westga.cs1302.project3.test.ViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;
import edu.westga.cs1302.project3.model.Task;

public class TestRemoveTask {

    private MainWindowViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new MainWindowViewModel();
    }


    @Test
    void testRemoveNonExistentTask() {
        Task task = new Task("Non Existent Task", "Non Existent Description");

        assertFalse(viewModel.getTaskList().contains(task));

        viewModel.removeTask(task);

        assertFalse(viewModel.getTaskList().contains(task));
    }

    @Test
    void testRemoveTaskFromEmptyList() {
        Task task = new Task("Test Task", "Test Description");

        viewModel.removeTask(task);

        assertFalse(viewModel.getTaskList().contains(task));
    }
}

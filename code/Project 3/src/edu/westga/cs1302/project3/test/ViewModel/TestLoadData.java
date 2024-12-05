package edu.westga.cs1302.project3.test.ViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

public class TestLoadData {

    private MainWindowViewModel viewModel;
    private File mockFile;

    @BeforeEach
    void setUp() {
        viewModel = new MainWindowViewModel();
        mockFile = new File("testLoadData.txt");

        if (mockFile.exists()) {
            mockFile.delete();
        }
    }

    @Test
    void testLoadDataSuccessfully() {
        viewModel.saveData(mockFile);
        viewModel.loadData(mockFile);

        assertNotNull(viewModel.getTaskList());
        assertTrue(viewModel.getTaskList().size() > 0);
    }
}

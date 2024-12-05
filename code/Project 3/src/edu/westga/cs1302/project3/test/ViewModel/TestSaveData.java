package edu.westga.cs1302.project3.test.ViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.MainWindowViewModel;

public class TestSaveData {

    private MainWindowViewModel viewModel;
    private File testFile;

    @BeforeEach
    void setUp() {
        viewModel = new MainWindowViewModel();
        testFile = new File("test_tasks.txt");

        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testSaveDataToValidFile() {
        viewModel.saveData(testFile);

        assertTrue(testFile.exists());
        assertTrue(testFile.length() > 0);
    }


}

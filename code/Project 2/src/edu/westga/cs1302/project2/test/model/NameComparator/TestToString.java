package edu.westga.cs1302.project2.test.model.NameComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.NameComparator;


public class TestToString {

    @Test
     void testToString() {
        NameComparator comparator = new NameComparator();
        assertEquals("Name", comparator.toString());
    }
}

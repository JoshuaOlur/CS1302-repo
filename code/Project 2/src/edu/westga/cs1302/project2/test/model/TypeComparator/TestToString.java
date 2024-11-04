package edu.westga.cs1302.project2.test.model.TypeComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.TypeComparator;

public class TestToString {

	@Test
	void testToString() {
		TypeComparator comparator = new TypeComparator();
		assertEquals("Type", comparator.toString());
	}
}

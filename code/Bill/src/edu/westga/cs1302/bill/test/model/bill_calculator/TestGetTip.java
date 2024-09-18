package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class TestGetTip {

	private BillItem item1;
	private BillItem item2;
	private BillItem item3;
	private BillItem[] items;

	@BeforeEach
	public void setUp() {
		this.item1 = new BillItem("Item 1", 10.0);
		this.item2 = new BillItem("Item 2", 20.0);
		this.item3 = new BillItem("Item 3", 30.0);
		this.items = new BillItem[] { item1, item2, item3 };
	}

	@Test
	void testGetTip() {
		double result = BillCalculator.getTip(this.items);
		assertEquals(12.0, result, 0.001);
	}

	@Test
	void testGetTipWithNullItem() {
		BillItem[] itemsWithNull = new BillItem[] { item1, null, item3 };
		double result = BillCalculator.getTip(itemsWithNull);
		assertEquals(8.0, result, 0.001);
	}
}

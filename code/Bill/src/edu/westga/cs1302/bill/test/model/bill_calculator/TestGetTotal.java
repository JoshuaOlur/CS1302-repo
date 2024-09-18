package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class TestGetTotal {

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
	void testGetTotal() {
		double result = BillCalculator.getTotal(this.items);
		assertEquals(78.0, result, 0.001);
	}

	@Test
	void testGetTotalWithNullItem() {
		BillItem[] itemsWithNull = new BillItem[] { item1, null, item3 };
		double result = BillCalculator.getTotal(itemsWithNull);
		assertEquals(52.0, result, 0.001);
	}
}
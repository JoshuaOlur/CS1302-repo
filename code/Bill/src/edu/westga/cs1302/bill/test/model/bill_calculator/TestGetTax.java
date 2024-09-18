package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

public class TestGetTax {

	private BillItem item1;
	private BillItem item2;
	private BillItem item3;
	private BillItem[] items;

	@BeforeEach
	void setUp() {
		this.item1 = new BillItem("Item 1", 10.0);
		this.item2 = new BillItem("Item 2", 20.0);
		this.item3 = new BillItem("Item 3", 30.0);
		this.items = new BillItem[] { item1, item2, item3 };
	}

	@Test
	void testGetTax() {
		double result = BillCalculator.getTax(this.items);
		assertEquals(6.0, result, 0.001);
	}

	@Test
	void testGetTaxWithNullItem() {
		BillItem[] itemsWithNull = new BillItem[] { item1, null, item3 };
		double result = BillCalculator.getTax(itemsWithNull);
		assertEquals(4.0, result, 0.001);
	}
}
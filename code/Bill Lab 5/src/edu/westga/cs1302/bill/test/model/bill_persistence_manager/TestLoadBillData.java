package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillPersistenceManager;
import edu.westga.cs1302.bill.model.BillItem;

class TestLoadBillData {

	@BeforeEach
	void setUp() throws IOException {

		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("");
		}
	}

	@Test
	void testLoadEmptyBill() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("No Server Set\n");
		}

		Bill loadedBill = BillPersistenceManager.loadBillData();
		assertEquals("No Server Set", loadedBill.getServerName(), "checking server name");
		assertEquals(0, loadedBill.getSize(), "checking that no items are in the bill");
	}

	@Test
	void testLoadBillWithOneItem() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("Server A\n");
			writer.write("Item A,15.0\n");
		}

		Bill loadedBill = BillPersistenceManager.loadBillData();
		assertEquals("Server A", loadedBill.getServerName(), "checking server name");
		assertEquals(1, loadedBill.getSize(), "checking that one item is in the bill");
		BillItem[] items = loadedBill.getItems();
		assertEquals("Item A", items[0].getName(), "checking item name");
		assertEquals(15.0, items[0].getAmount(), 0.01, "checking item amount");
	}

	@Test
	void testLoadBillWithMultipleItems() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("Server B\n");
			writer.write("Item X,10.0\n");
			writer.write("Item Y,20.0\n");
		}

		Bill loadedBill = BillPersistenceManager.loadBillData();
		assertEquals("Server B", loadedBill.getServerName(), "checking server name");
		assertEquals(2, loadedBill.getSize(), "checking that two items are in the bill");
		BillItem[] items = loadedBill.getItems();
		assertEquals("Item X", items[0].getName(), "checking first item name");
		assertEquals(10.0, items[0].getAmount(), 0.01, "checking first item amount");
		assertEquals("Item Y", items[1].getName(), "checking second item name");
		assertEquals(20.0, items[1].getAmount(), 0.01, "checking second item amount");
	}

	@Test
	void testLoadBillWithInvalidAmount() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("Server C\n");
			writer.write("Item Z,invalidAmount\n");
		}

		IOException exception = assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
		assertTrue(exception.getMessage().contains("was not a valid NUM"), "checking for invalid amount error");
	}

	@Test
	void testLoadBillWithMissingFields() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("Server D\n");
			writer.write("Item W\n");
		}

		IOException exception = assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
		assertTrue(exception.getMessage().contains("Missing either name and/or amount"),
				"checking for missing fields error");
	}
}

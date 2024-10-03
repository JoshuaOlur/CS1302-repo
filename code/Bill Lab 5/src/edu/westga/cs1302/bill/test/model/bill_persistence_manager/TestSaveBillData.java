package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestSaveBillData {


	@Test
	void testEmptyBill() throws IOException {
		Bill emptyBill = new Bill();
		BillPersistenceManager.saveBillData(emptyBill);

		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("No Server Set", reader.nextLine(), "checking server name");
			assertFalse(reader.hasNextLine(), "checking that file is otherwise empty");
		}
	}

	@Test
	void testBillWithOneItem() throws IOException {
		Bill testBill = new Bill();
		testBill.setServerName("Server A");
		testBill.addItem(new BillItem("Item A", 15.0));
		BillPersistenceManager.saveBillData(testBill);

		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Server A", reader.nextLine(), "checking server name");
			assertEquals("Item A,15.0", reader.nextLine(), "checking bill item");
			assertFalse(reader.hasNextLine(), "checking that we are at the end of the file");
		}
	}


	@Test
	void testBillWithMultipleItems() throws IOException {
		Bill testBill = new Bill();
		testBill.setServerName("Server C");
		testBill.addItem(new BillItem("Item X", 10.0));
		testBill.addItem(new BillItem("Item Y", 20.0));
		BillPersistenceManager.saveBillData(testBill);

		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Server C", reader.nextLine(), "checking server name");
			assertEquals("Item X,10.0", reader.nextLine(), "checking first item");
			assertEquals("Item Y,20.0", reader.nextLine(), "checking second item");
			assertFalse(reader.hasNextLine(), "checking that we are at the end of the file");
		}
	}
}

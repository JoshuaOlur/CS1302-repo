package edu.westga.cs1302.bill.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillPersistenceManager {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @param bill the bill to save
	 * @throws IOException
	 */
	public static void saveBillData(Bill bill) throws IOException {
		try (FileWriter file = new FileWriter(DATA_FILE)) {
			String billLine = bill.getServerName() + "\n";
			for (BillItem currItem : bill.getItems()) {
				double amount = currItem.getAmount();
				billLine += currItem.getName() + ",";
				String.valueOf(amount);
				billLine += amount + "\n";
			}

			file.write(billLine);
		}

	}

	/**
	 * Load the bill!
	 * 
	 * Reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 */
	public static Bill loadBillData() throws IOException {
		Bill starterBill = new Bill();
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			String varName = reader.nextLine();
			starterBill.setServerName(varName);

			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				String baseLine = reader.nextLine();
				String strippedLine = baseLine.strip();
				String[] parts = strippedLine.split(",");
				try {

					String name = parts[0];
					double amount = Double.parseDouble(parts[1]);
					BillItem newBillItem = new BillItem(name, amount);
					starterBill.addItem(newBillItem);
				} catch (NumberFormatException numError) {
					throw new IOException(
							"Unable to read Bill (was not a valid NUM) on line " + lineNumber + " : " + strippedLine);
				} catch (IllegalArgumentException billError) {
					throw new IOException(
							"Unable to create Item, bad name/grade on line " + lineNumber + " : " + strippedLine);
				} catch (IndexOutOfBoundsException billError) {
					throw new IOException(
							"Missing either name and/or amount on line " + lineNumber + " : " + strippedLine);
				}
			}
		}

		return starterBill;
	}

}

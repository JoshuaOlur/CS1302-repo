package edu.westga.cs1302.bill.model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public abstract class BillPersistenceManager {

	/**
	 * Save the bill!
	 * 
	 * Writes the bill data to a file. The file format is as follows:
	 * serverName
	 * itemName,itemAmount
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @param bill the bill to save
	 * @throws IOException if an I/O error occurs during writing
	 */
	public abstract void saveBillData(Bill bill) throws IOException;

	/**
	 * Load the bill!
	 * 
	 * Reads the bill data from a file. The file format is as described in
	 * saveBillData.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded from the file
	 * @throws FileNotFoundException if the file does not exist
	 * @throws IOException if an I/O error occurs or the file has invalid data
	 */
	public abstract Bill loadBillData() throws FileNotFoundException, IOException;
}

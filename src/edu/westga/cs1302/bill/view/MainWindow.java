package edu.westga.cs1302.bill.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillItemAscendingAmountComparator;
import edu.westga.cs1302.bill.model.BillItemDescendingAmountComparator;

import edu.westga.cs1302.bill.model.CSVBillPersistenceManager;
import edu.westga.cs1302.bill.model.TSVBillPersistenceManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The codebehind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	public static final String DATA_FILE = "data.txt";
	private Bill bill;
	@FXML
	private TextField name;
	@FXML
	private TextField amount;
	@FXML
	private TextArea receiptArea;
	@FXML
	private ComboBox<String> serverName;
	@FXML
	private ComboBox<String> fileTypeComboBox;
	@FXML
    private ComboBox<String> sortComboBox;

	@FXML
	void addItem(ActionEvent event) {
		try {
			BillItem item = new BillItem(this.name.getText(), Double.parseDouble(this.amount.getText()));
			this.bill.addItem(item);
			this.name.clear();
			this.amount.clear();
			this.updateReceipt();
		} catch (NumberFormatException numError) {
			this.displayErrorPopup("Invalid amount provided, please correct and try again.");
		} catch (IllegalArgumentException argError) {
			this.displayErrorPopup("Unable to add new bill item");
		}
	}

	private void updateReceipt() {
		this.receiptArea.setText(BillTextifier.getText(this.bill));
	}

	@FXML
	void selectServer(ActionEvent event) {
		String name = this.serverName.getValue();
		if (name != null) {
			this.bill.setServerName(name);
			this.updateReceipt();
		}
	}
	
	@FXML
    void sortBillItems(ActionEvent event) {
        if (this.sortComboBox.getSelectionModel().getSelectedItem().equals("Ascending Order")) {
            this.bill.sortBill(new BillItemAscendingAmountComparator());
        } else if (this.sortComboBox.getSelectionModel().getSelectedItem().equals("Descending Order")) {
        	this.bill.sortBill(new BillItemDescendingAmountComparator());
        }
        this.updateReceipt();
    }

	@FXML
	void saveBillData(ActionEvent event) {
		try {
			if (this.fileTypeComboBox.getSelectionModel().getSelectedItem().equals("CSV")) {
				CSVBillPersistenceManager csvBill = new CSVBillPersistenceManager();
				csvBill.saveBillData(this.bill);
			} else if (this.fileTypeComboBox.getSelectionModel().getSelectedItem().equals("TSV")) {
				TSVBillPersistenceManager tsvBill = new TSVBillPersistenceManager();
				tsvBill.saveBillData(this.bill);
			}

		} catch (IOException writeError) {
			this.displayErrorPopup("Unable to save data to file!");
		}
	}

	private void displayErrorPopup(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	void initialize() {
		this.serverName.getItems().add("Bob");
		this.serverName.getItems().add("Alice");
		this.serverName.getItems().add("Trudy");
		
		this.sortComboBox.getItems().add("Ascending Order");
        this.sortComboBox.getItems().add("Descending Order");
        this.sortComboBox.setOnAction(this::sortBillItems);

		File file = new File(DATA_FILE);
		try (Scanner reader = new Scanner(file)) {
			reader.nextLine();
			String fileString = reader.nextLine();
			if (fileString.contains(",")) {
				CSVBillPersistenceManager csvBill = new CSVBillPersistenceManager();
				this.bill = csvBill.loadBillData();
			} else {
				TSVBillPersistenceManager tsvBill = new TSVBillPersistenceManager();
				this.bill = tsvBill.loadBillData();
			}
		} catch (Exception ex) {

		}

		this.updateReceipt();
		this.fileTypeComboBox.getItems().add("CSV");
		this.fileTypeComboBox.getItems().add("TSV");
	}
}

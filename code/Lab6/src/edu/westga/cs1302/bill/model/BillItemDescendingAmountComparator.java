package edu.westga.cs1302.bill.model;

import java.util.Comparator;

/**
 * Compares BillItems based on their amount in descending order.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillItemDescendingAmountComparator implements Comparator<BillItem> {

    @Override
    public int compare(BillItem o1, BillItem o2) {
        return Double.compare(o2.getAmount(), o1.getAmount());
    }

    @Override
    public String toString() {
        return "Descending Order";
    }
}

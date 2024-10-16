package edu.westga.cs1302.bill.model;

import java.util.Comparator;

/**
 * Compares BillItems based on their amount in ascending order.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillItemAscendingAmountComparator implements Comparator<BillItem> {

    @Override
    public int compare(BillItem o1, BillItem o2) {
        return Double.compare(o1.getAmount(), o2.getAmount());
    }

    @Override
    public String toString() {
        return "Ascending Order";
    }
}

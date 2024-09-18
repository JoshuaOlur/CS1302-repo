package edu.westga.cs1302.bill.model;

public class BillCalculator {

	/**
	 * Return the subtotal for the bill
	 * 
	 * @return the subtotal for the bill
	 */
	public static double getSubTotal(BillItem[] items) {
		double subTotal = 0.0;
		for (BillItem item : items) {
			if (item != null) {
				subTotal += item.getAmount();
			}
		}
		return subTotal;

	}

	/**
	 * Return the tax for the bill
	 * 
	 * @return the tax for the bill
	 */
	public static double getTax(BillItem[] items) {
		return getSubTotal(items) * 0.1;
	}

	/**
	 * Return the tip for the bill
	 * 
	 * @return the tip for the bill
	 */
	public static double getTip(BillItem[] items) {
		return getSubTotal(items) * 0.2;
	}

	/**
	 * Return the total for the bill
	 * 
	 * @return the total for the bill
	 */
	public static double getTotal(BillItem[] items) {
		return getSubTotal(items) + getTax(items) + getTip(items);
	}
}

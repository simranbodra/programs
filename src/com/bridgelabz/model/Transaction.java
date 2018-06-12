package com.bridgelabz.model;

public class Transaction {

	private String customerName;
	private int noOfShare;
	private String stockName;
	private int totalSharePrice;
	private String dateTime;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getTotalSharePrice() {
		return totalSharePrice;
	}
	public void setTotalSharePrice(int totalSharePrice) {
		this.totalSharePrice = totalSharePrice;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Transaction [customerName=" + customerName + ", noOfShare=" + noOfShare + ", stockName=" + stockName
				+ ", totalSharePrice=" + totalSharePrice + ", dateTime=" + dateTime + "]";
	}
}

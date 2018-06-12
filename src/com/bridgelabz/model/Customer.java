package com.bridgelabz.model;

public class Customer {

	private String name;
	private int noOfShare;
	private int amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", noOfShare=" + noOfShare + ", amount=" + amount + "]";
	}
	
}

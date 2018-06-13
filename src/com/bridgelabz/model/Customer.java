package com.bridgelabz.model;

public class Customer {

	private String name;
	private int id;
	private int noOfShare;
	private int amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Customer [name=" + name + ", id=" + id + ", noOfShare=" + noOfShare + ", amount=" + amount + "]";
	}
	
}

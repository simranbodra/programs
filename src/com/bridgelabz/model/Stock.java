package com.bridgelabz.model;

public class Stock {
	
	private String companySymbol;
	private int id;
	private int noOfShares;
	private int sharePrice;
	
	public String getCompanySymbol() {
		return companySymbol;
	}
	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	public int getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	@Override
	public String toString() {
		return "Stock [companySymbol=" + companySymbol + ", id=" + id + ", noOfShares=" + noOfShares + ", sharePrice="
				+ sharePrice + "]";
	}
}

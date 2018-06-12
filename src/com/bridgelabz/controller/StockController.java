package com.bridgelabz.controller;

import java.util.List;

import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.serviceimplementation.StockServiceImplementation;
import com.bridgelabz.utility.Utility;

public class StockController {
	
	private static final String STOCKS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Stock.json";
	private static final String CUSTOMERS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Customer.json";
	private static final String TRANSACTIONS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Transaction.json";
	
	private List<Stock> listOfStock;
	private List<Customer> listOfCustomer;
	private List<Transaction> listOfTransaction;
	
	public StockController() {
		if(listOfStock == null && listOfCustomer == null && listOfTransaction == null) {
			try {
				listOfStock = Utility.jsonToJavaStock(STOCKS_FILE_NAME);
				listOfCustomer = Utility.jsonToJavaCustomer(CUSTOMERS_FILE_NAME);
				listOfTransaction = Utility.jsonToJavaTransaction(TRANSACTIONS_FILE_NAME);
			}
			catch(Exception e) {
				System.out.println("List not initialized");
			}
		}
	}
	
	public List<Stock> getListOfStock() {
		return listOfStock;
	}

	public void setListOfStock(List<Stock> listOfStock) {
		this.listOfStock = listOfStock;
	}

	public List<Customer> getListOfCustomer() {
		return listOfCustomer;
	}

	public void setListOfCustomer(List<Customer> listOfCustomer) {
		this.listOfCustomer = listOfCustomer;
	}

	public List<Transaction> getListOfTransaction() {
		return listOfTransaction;
	}

	public void setListOfTransaction(List<Transaction> listOfTransaction) {
		this.listOfTransaction = listOfTransaction;
	}


	public static void main(String[] args) {
		
		StockController manager = new StockController();
		StockServiceImplementation stockService = new StockServiceImplementation();
		System.out.println("Welcome to Stock Market");
		manager.setListOfStock(stockService.addStock(manager.getListOfStock()));
	}

}

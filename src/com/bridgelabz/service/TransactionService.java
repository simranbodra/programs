package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;

public interface TransactionService {

	public Transaction buyShare(Customer customer, Stock stock);
	public List<Transaction> addTransaction(List<Transaction> transactionList, Transaction transaction);
	public void showCustomerDetails(List<Transaction> transactionList);
	public void showStockDetails(List<Transaction> transactionList);
	
}

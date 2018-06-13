package com.bridgelabz.serviceimplementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.service.TransactionService;
import com.bridgelabz.utility.Utility;

public class TransactionServiceImplementation implements TransactionService {

	private static final String TRANSACTIONS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Transaction.json";
	
	/**
	 * Function to by share from a company
	 * 
	 * @param customer contains the particular customer to by shares
	 * @param stock contains the particular company from where the share is to be bought
	 * @return transaction information
	 */
	@Override
	public Transaction buyShare(Customer customer, Stock stock) {
		Transaction transaction = new Transaction();
		System.out.println("Enter the number of shares to be purchased");
		int sharesToPurchase = Utility.integerInput();
		if((stock.getNoOfShares() - sharesToPurchase) >= 0 && customer.getAmount() >= (stock.getSharePrice() * sharesToPurchase)) {
			stock.setNoOfShares(stock.getNoOfShares() - sharesToPurchase);
			customer.setNoOfShare(sharesToPurchase);
			customer.setAmount(customer.getAmount() - (sharesToPurchase * stock.getSharePrice()));
			transaction.setCustomerName(customer.getName());
			transaction.setNoOfShare(sharesToPurchase);
			transaction.setStockName(stock.getCompanySymbol());
			transaction.setTotalSharePrice(sharesToPurchase * stock.getSharePrice());
			transaction.setDateTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
			System.out.println("Share purchased");
		}
		else {
			System.out.println("Not eligible To purchase share");
		}
		return transaction;
	}
	
	/**
	 * Function to add new transaction to the list
	 * 
	 * @param transactionList contains list of all the transaction done
	 * @param transaction contains the details of a transaction
	 * @return updated transaction list
	 */
	@Override
	public List<Transaction> addTransaction(List<Transaction> transactionList, Transaction transaction){
		List<Transaction> newTransactionList = new LinkedList<>();
		newTransactionList.add(transaction);
		System.out.println("Do you wish to save changes?  Enter Y/N");
		Utility.stringInput();
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")){
			Utility.javaObjectToJson(TRANSACTIONS_FILE_NAME, newTransactionList);
			System.out.println("Changes saved");
			return newTransactionList;
		}
		else {
			System.out.println("Changes not saved");
			return transactionList;
		}
	}

	/**
	 * Function to show all the transactions made by the customer
	 * 
	 * @param transactionList contains the list of the transactions made
	 */
	@Override
	public void showCustomerDetails(List<Transaction> transactionList) {
		List<String> stockList = new LinkedList<>();
		List<Integer> noOfShareList = new LinkedList<>();
		System.out.println("Enter Customer's Name:-");
		String customerName = Utility.stringInput();
		for(int i=0; i<transactionList.size(); i++) {
			if(transactionList.get(i).getCustomerName().equalsIgnoreCase(customerName)) {
				stockList.add(transactionList.get(i).getStockName());
				noOfShareList.add(transactionList.get(i).getNoOfShare());
			}
		}
		System.out.println("Details of all the transaction made:-");
		System.out.println();
		for(int i=0; i<stockList.size(); i++) {
			System.out.println("-------------------------------------------------");
			System.out.println("Company Name:- " + stockList.get(i));
			System.out.println("No. of share purchased:- " + noOfShareList.get(i));
			System.out.println("-------------------------------------------------");
		}
		
	}

	/**
	 * Function to show the list of customers with whom transaction is done
	 * 
	 * @param transactionList contains the list of all the transactions done
	 */
	@Override
	public void showStockDetails(List<Transaction> transactionList) {
		List<String> customerList = new LinkedList<>();
		List<Integer> noOfShareList = new LinkedList<>();
		System.out.println("Enter Company's Name:-");
		String companyName = Utility.stringInput();
		for(int i=0; i<transactionList.size(); i++) {
			if(transactionList.get(i).getStockName().equalsIgnoreCase(companyName)) {
				customerList.add(transactionList.get(i).getCustomerName());
				noOfShareList.add(transactionList.get(i).getNoOfShare());
			}
		}
		System.out.println("Details of all the transaction made:-");
		System.out.println();
		for(int i=0; i<customerList.size(); i++) {
			System.out.println("-------------------------------------------------");
			System.out.println("Company Name:- " + customerList.get(i));
			System.out.println("No. of share purchased:- " + noOfShareList.get(i));
			System.out.println("-------------------------------------------------");
		}
	}

}

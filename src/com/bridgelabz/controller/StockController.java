package com.bridgelabz.controller;

import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.serviceimplementation.CustomerServiceImplementation;
import com.bridgelabz.serviceimplementation.StockServiceImplementation;
import com.bridgelabz.serviceimplementation.TransactionServiceImplementation;
import com.bridgelabz.utility.Utility;

public class StockController {
	
	private static final String STOCKS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Stock.json";
	private static final String CUSTOMERS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Customer.json";
	private static final String TRANSACTIONS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Transaction.json";
	
	private List<Stock> listOfStock;
	private List<Customer> listOfCustomer;
	private List<Transaction> listOfTransaction;
	Queue<String>calendarQueue = new Queue<>();
	
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
		CustomerServiceImplementation customerService = new CustomerServiceImplementation();
		TransactionServiceImplementation transactionService = new TransactionServiceImplementation();
		System.out.println("Welcome to Stock Market");
		int choice = 0;
		while(choice <= 11) {
			System.out.println("1. Show Stock List");
			System.out.println("2. Add Stock");
			System.out.println("3. Delete Stock");
			System.out.println("4. Show Customer List");
			System.out.println("5. Add Customer");
			System.out.println("6. Delete Customer");
			System.out.println("7. Update Customer details");
			System.out.println("8. Buy Share");
			System.out.println("9. Show customer details");
			System.out.println("10. Show stock details");
			System.out.println("11. Exit");
			System.out.println("Enter your choice:-");
			choice = Utility.integerInput();
			Utility.stringInput();
			switch(choice) {
			case 1:
				stockService.showStockList(manager.getListOfStock());
				break;
				
			case 2:
				manager.setListOfStock(stockService.addStock(manager.getListOfStock()));
				stockService.showStockList(manager.getListOfStock());
				break;
				
			case 3:
				stockService.showStockList(manager.getListOfStock());
				System.out.println("Enter the id to be deleted:-");
				int id = Utility.integerInput();
				Utility.stringInput();
				manager.setListOfStock(stockService.deleteStock(id, manager.getListOfStock()));
				stockService.showStockList(manager.getListOfStock());
				break;
				
			case 4:
				customerService.showCustomerList(manager.getListOfCustomer());
				break;
				
			case 5:
				manager.setListOfCustomer(customerService.addCustomer(manager.getListOfCustomer()));
				customerService.showCustomerList(manager.getListOfCustomer());
				break;
				
			case 6:
				customerService.showCustomerList(manager.getListOfCustomer());
				System.out.println("Enter the id to be deleted:-");
				int customerId = Utility.integerInput();
				Utility.stringInput();
				manager.setListOfCustomer(customerService.deleteCustomer(customerId, manager.getListOfCustomer()));
				customerService.showCustomerList(manager.getListOfCustomer());
				break;
				
			case 7:
				customerService.showCustomerList(manager.getListOfCustomer());
				System.out.println("Enter the id to be updated:-");
				int updateId = Utility.integerInput();
				Utility.stringInput();
				manager.setListOfCustomer(customerService.updateCustomerDetails(updateId, manager.getListOfCustomer()));
				customerService.showCustomerList(manager.getListOfCustomer());
				break;
				
			case 8:
				Customer customer = new Customer();
				Customer transactionCustomer = new Customer();
				Stock stock = new Stock();
				Stock transactionStock = new Stock();
				Transaction transaction = new Transaction();
				List<Customer> newCustomerList = new LinkedList<>();
				newCustomerList = manager.getListOfCustomer();
				List<Stock> newStockList = new LinkedList<>();
				newStockList = manager.getListOfStock();
				System.out.println("Enter Customer's name:-");
				String customerName = Utility.stringInput();
				customer = customerService.searchCustomerByName(customerName, manager.getListOfCustomer());
				if(customer.getName() == null) {
					System.out.println("Customer not in the list");
					System.out.println("Customer must be added to buy share");
					manager.setListOfCustomer(customerService.addCustomer(manager.getListOfCustomer()));
					System.out.println("Customer added to the list");
					customer = customerService.searchCustomerByName(customerName, manager.getListOfCustomer());
				}
				stockService.showStockList(manager.getListOfStock());
				System.out.println("Enter Stock id to purchase share from:-");
				int stockId = Utility.integerInput();
				stock = stockService.searchStockById(stockId, manager.getListOfStock());
				if(stock.getCompanySymbol() == null) {
					System.out.println("Stock with this id is not present");
					break;
				}
				transaction = transactionService.buyShare(customer, stock);
				if(transaction.getCustomerName() != null) {
					manager.setListOfTransaction(transactionService.addTransaction(manager.getListOfTransaction(),transaction));
					String transactionCustomerName = transaction.getCustomerName();
					transactionCustomer = customerService.searchCustomerByName(transactionCustomerName, manager.getListOfCustomer());
					transactionCustomer.setName(customer.getName());
					transactionCustomer.setId(customer.getId());
					transactionCustomer.setAmount(customer.getAmount());
					transactionCustomer.setNoOfShare(customer.getNoOfShare());
					newCustomerList.add(transactionCustomer);
					transactionStock.setCompanySymbol(stock.getCompanySymbol());
					transactionStock.setId(stock.getId());
					transactionStock.setNoOfShares(stock.getNoOfShares());
					transactionStock.setSharePrice(stock.getSharePrice());
					newStockList.add(transactionStock);
					manager.setListOfCustomer(customerService.deleteCustomer(customer.getId(), manager.getListOfCustomer()));
					manager.setListOfStock(stockService.deleteStock(stock.getId(), manager.getListOfStock()));
					manager.setListOfCustomer(newCustomerList);
					manager.setListOfStock(newStockList);
					Utility.javaObjectToJson(CUSTOMERS_FILE_NAME, newCustomerList);
					Utility.javaObjectToJson(STOCKS_FILE_NAME, newStockList);
				}
				break;
				
			case 9:
				transactionService.showCustomerDetails(manager.getListOfTransaction());
				break;
				
			case 10:
				transactionService.showStockDetails(manager.getListOfTransaction());
				break;
				
			case 11:
				System.exit(0);
				break;
				
			default:
				System.out.println("Wrong choice, enter again");
				choice = Utility.integerInput();
			}
		}
	}

}

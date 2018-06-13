package com.bridgelabz.serviceimplementation;

import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.model.Stock;
import com.bridgelabz.service.StockService;
import com.bridgelabz.utility.Utility;

public class StockServiceImplementation implements StockService {
	
	private static final String STOCKS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Stock.json";
	

	/**
	 * Function to display all the stock details
	 * 
	 * @param stockList contains the list of the stock
	 */
	@Override
	public void showStockList(List<Stock> stockList) {
		List<Stock> listOfStock = new LinkedList<>();
		listOfStock = stockList;
		System.out.println("---------------------------");
		System.out.println("Stock List");
		System.out.println("---------------------------");
		for(int i=0; i<listOfStock.size(); i++) {
			System.out.println(listOfStock.get(i));
		}
	}

	/**
	 * Function to add a new stock to the list
	 * 
	 * @param stockList contains the list of the stocks
	 * @return updated list of Stock
	 */
	@Override
	public List<Stock> addStock(List<Stock> stockList) {
		List<Stock> newStockList = new LinkedList<>();
		newStockList = stockList;
		Stock stock = new Stock();
		System.out.println("Enter stock symbol:-");
		stock.setCompanySymbol(Utility.stringInput());
		System.out.println("Enter number of shares:-");
		stock.setNoOfShares(Utility.integerInput());
		System.out.println("Enter share price:-");
		stock.setSharePrice(Utility.integerInput());
		Utility.stringInput();
		stock.setId(stockList.size());
		newStockList.add(stock);
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")){
			Utility.javaObjectToJson(STOCKS_FILE_NAME, newStockList);
			System.out.println("Changes saved");
			return newStockList;
		}
		else {
			System.out.println("Changes not saved");
			return stockList;
		}
	}

	/**
	 * Function to delete a stock account from the list
	 * 
	 * @param index contains the id of the stock account to be deleted
	 * @param stockList contains the list of the stock
	 * @return updated list of STock Accounts
	 */
	@Override
	public List<Stock> deleteStock(int index, List<Stock> stockList) {
		List<Stock> newStockList = new LinkedList<>();
		stockList.remove(index);
		newStockList = stockList;
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")){
			Utility.javaObjectToJson(STOCKS_FILE_NAME, newStockList);
			System.out.println("Changes saved");
			return newStockList;
		}
		else {
			System.out.println("Changes not saved");
			return stockList;
		}
	}
	
	public Stock searchStockById(int index, List<Stock> stockList) {
		List<Stock> listOfStock = new LinkedList<>();
		Stock stock = new Stock();
		listOfStock = stockList;
		for(int i=0; i<listOfStock.size(); i++) {
			if(listOfStock.get(i).getId() == index) {
				stock = listOfStock.get(i);
			}
		}
		return stock;
	}
	
}







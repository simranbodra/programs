package com.bridgelabz.serviceimplementation;

import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.model.Stock;
import com.bridgelabz.service.StockService;
import com.bridgelabz.utility.Utility;

public class StockServiceImplementation implements StockService {

	@Override
	public void showStockList(List<Stock> stockList) {
		List<Stock> listOfStock = new LinkedList<>();
		listOfStock = stockList;
		for(int i=0; i<listOfStock.size(); i++) {
			System.out.println(listOfStock.get(i));
		}
	}

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
		newStockList.add(stock);
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		return newStockList;
	}

	@Override
	public List<Stock> deleteStock(int index, List<Stock> stockList) {
		List<Stock> newStockList = new LinkedList<>();
		stockList
	}
	
}

package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.Stock;

public interface StockService {
	
	public void showStockList(List<Stock> stockList);
	public List<Stock> addStock(List<Stock> stockList);
	public List<Stock> deleteStock(int index, List<Stock> stockList);
	public Stock searchStockById(int index, List<Stock> stockList);
	
}

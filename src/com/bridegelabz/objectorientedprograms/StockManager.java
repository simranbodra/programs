package com.bridegelabz.objectorientedprograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.utils.Utility;

public class StockManager {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter the number of Stock:-");
		int noOfStock = Utility.integerInput();
		List<Stock> stockList = new ArrayList<>();
		String fileName = "StockFile.json";
		
		for(int i=0; i<noOfStock; i++) {
			Stock stock = new Stock();
			System.out.println("Enter stock name:-");
			Utility.stringInput();
			stock.setStockName(Utility.stringInput());
			System.out.println("Enter number of share:-");
			stock.setNoOfShare(Utility.integerInput());
			System.out.println("Enter share price:-");
			stock.setSharePrice(Utility.integerInput());
			stockList.add(stock);
		}
		Utility.javaToJsonObject(fileName, stockList);
	}

}

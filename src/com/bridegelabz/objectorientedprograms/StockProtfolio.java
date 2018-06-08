package com.bridegelabz.objectorientedprograms;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockProtfolio {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			
			Object obj = parser.parse(new FileReader("/home/administrator/javaprograms/objectorientedprograms/StockFile.json"));
			JSONArray stockArray = (JSONArray) obj;
			long stockValue = 0;
			long totalValue = 0;
			for(Object object : stockArray) {
				JSONObject inventory = (JSONObject) object;
				String stockName = (String)inventory.get("stockName");
				System.out.println(stockName);
				long noOfShare = (long)inventory.get("noOfShare");
				long sharePrice = (long) inventory.get("sharePrice");
				stockValue = noOfShare * sharePrice;
				System.out.println("Stock Value:- " + stockValue);
				totalValue += stockValue;
					
			}
			System.out.println();
			System.out.println("Total value:- " + totalValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
	}

}

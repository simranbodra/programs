package com.bridegelabz.objectorientedprograms;

import java.io.FileReader;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InventoryManager {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			
			Object obj = parser.parse(new FileReader("/home/administrator/javaprograms/objectorientedprograms/InventoryFile.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			@SuppressWarnings("unchecked")
			Set<String> keys = jsonObject.keySet(); 
			
			for(String inventoryKeyArray : keys) {
				JSONArray inventoryArray = (JSONArray) jsonObject.get(inventoryKeyArray);
				long totalPrice = 0;
				long totalWeight = 0;
				for(Object object : inventoryArray) {
					JSONObject inventory = (JSONObject) object;
					long weight = (long)inventory.get("weight");
					long price = (long) inventory.get("price");
					totalWeight += weight;
					totalPrice += (weight * price);
					
				}
				System.out.println(inventoryKeyArray + ":");
				System.out.println("Total weight: " + totalWeight);
				System.out.println("Total price: " + totalPrice);
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
	}
}

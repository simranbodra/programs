package com.bridegelabz.objectorientedprograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bridgelabz.utils.Utility;

public class InventoryFactory {
	public static void main(String[] args) throws IOException {
		
		Map<String, List<Product>> inventory = new HashMap<>();
		
		String fileName = "InventoryFile.json";
		System.out.println("Enter the types of product:-");
		int typesOfProduct = Utility.integerInput();
		for(int i=0; i<typesOfProduct; i++) {
			System.out.println("Enter product type:-");
			Utility.stringInput();
			String productType = Utility.stringInput();
			List<Product> productList = new ArrayList<>();
			System.out.println("Enter the number of product:-");
			int noOfProduct = Utility.integerInput();
			
			for(int j=0; j<noOfProduct; j++) {
				Product product = new Product();
				System.out.println("Enter product name:-");
				Utility.stringInput();
				product.setName(Utility.stringInput());
				System.out.println("Enter weight:-");
				product.setWeight(Utility.integerInput());
				System.out.println("Enter price:-");
				product.setPrice(Utility.integerInput());
				productList.add(product);
			}
			inventory.put(productType, productList);
		}
		Utility.javaToJsonObject(fileName, inventory);
		
	}
}

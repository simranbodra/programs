package com.bridegelabz.objectorientedprograms;

//import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class Inventory {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("Inventory.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			//JSONObject rice = (JSONObject) jsonObject.get("Rice");
			
			String name = (String) jsonObject.get("Name");
			int weight = Integer.parseInt(jsonObject.get("Weight").toString());
			int price = Integer.parseInt(jsonObject.get("Price").toString());
			
			System.out.println("Name: " + name);
			System.out.println("Weight: " + weight);
			System.out.println("Price: " + price);
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
	}
}

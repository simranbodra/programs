package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;

public class Utility {

	/*
	 * Static Variable is declared to create static object of Scanner class
	 */
	static Scanner scanner = new Scanner(System.in);
	
	/****************************************************************************************
	 * Function to take String input from the user
	 ****************************************************************************************/
	public static String stringInput() {
		String n = scanner.nextLine();
		return n;
	}
	
	/*************************************************************************************
	 * Function to take valid integer input from the user
	 **************************************************************************************/
	public static int integerInput()
	{
		try
		{
			int number = scanner.nextInt();
			return number;
		}
		catch(Exception e)
		{
			scanner.nextLine();
			System.out.println("Invalid input, enter again");
			return integerInput();
		}
	}
	
	/*************************************************************************************
	 * Function to take valid long integer input from the user
	 **************************************************************************************/
	public static long longIntegerInput()
	{
		try
		{
			long number = scanner.nextLong();
			return number;
		}
		catch(Exception e)
		{
			scanner.nextLine();
			System.out.println("Invalid input, enter again");
			return integerInput();
		}
	}
	
	/****************************************************************************************
	 * Function to convert a java object to json file
	 * 
	 * @param fileName which stores the file location
	 * @param javaObject which is to be written in a json file
	 * @throws IOException 
	 ****************************************************************************************/
	public static void javaObjectToJson(String fileName, Object javaObject) {
		ObjectMapper mapper = new ObjectMapper();
		try {
		mapper.writeValue(new File(fileName), javaObject);
		//System.out.println("operation successful....");
		} 
		catch(IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}
	
	/****************************************************************************************
	 * Function to convert json file to Stock object 
	 * 
	 * @param fileName which stores the file location
	 * @throws IOException 
	 ****************************************************************************************/ 
    public static List<Stock> jsonToJavaStock(String filePath)
    {
        List<Stock> files = new LinkedList<>();
        ObjectMapper mapper=new ObjectMapper();
        try
        {
            files=mapper.readValue(new File(filePath), new TypeReference<LinkedList<Stock>>() {});
        }
        catch (IOException e)
        {
            System.out.println("Doctor's list is empty... first add some data");
            e.printStackTrace();
        }
        return files;
    }
    
    /****************************************************************************************
	 * Function to convert json file to Customer object 
	 * 
	 * @param fileName which stores the file location
	 * @throws IOException 
	 ****************************************************************************************/ 
    public static List<Customer> jsonToJavaCustomer(String filePath)
    {
        List<Customer> files = new LinkedList<>();
        ObjectMapper mapper=new ObjectMapper();
        try
        {
            files=mapper.readValue(new File(filePath), new TypeReference<LinkedList<Customer>>() {});
        }
        catch (IOException e)
        {
            System.out.println("Doctor's list is empty... first add some data");
            e.printStackTrace();
        }
        return files;
    }
    
    /****************************************************************************************
	 * Function to convert json file to Transaction object 
	 * 
	 * @param fileName which stores the file location
	 * @throws IOException 
	 ****************************************************************************************/ 
    public static List<Transaction> jsonToJavaTransaction(String filePath)
    {
        List<Transaction> files = new LinkedList<>();
        ObjectMapper mapper=new ObjectMapper();
        try
        {
            files=mapper.readValue(new File(filePath), new TypeReference<LinkedList<Transaction>>() {});
        }
        catch (IOException e)
        {
            System.out.println("Doctor's list is empty... first add some data");
            e.printStackTrace();
        }
        return files;
    }
}

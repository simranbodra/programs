package com.bridegelabz.addressbook;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.utils.Utility;

public class AddressBookUtility {
	
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
		System.out.println("operation successful....");
		}
		catch(IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}
	
	/****************************************************************************************
	 * Function to convert json file to String list 
	 * 
	 * @param fileName which stores the file location
	 * @throws IOException
	 ****************************************************************************************/
	public static List<String> jsonToJavaAddressBookList(String fileName) {
		JSONParser parser = new JSONParser();
		List<String> addressBookList = new LinkedList<>();
		try {
			
			Object obj = parser.parse(new FileReader(fileName));
			JSONArray personList = (JSONArray) obj;
			for(Object object : personList) {
				String addressBookName = object.toString();
				addressBookList.add(addressBookName);
			}
		}
		catch(Exception e) {
			System.out.println("Error in loading address book list");
		}
		return addressBookList;
	}

	/****************************************************************************************
	 * Function to convert json file to object 
	 * 
	 * @param fileName which stores the file location
	 * @throws IOException 
	 ****************************************************************************************/
	public static Addressbook jsonToJava(String fileName) {
		JSONParser parser = new JSONParser();
		Addressbook addressbook = new Addressbook();
		List<Person> personLinkedList = new LinkedList<>();
		try {
			
			Object obj = parser.parse(new FileReader(fileName));
			JSONObject addressBookDetails = (JSONObject) obj;
			
			JSONArray personList = (JSONArray) addressBookDetails.get("addressBook");
			for(Object object : personList) {
				JSONObject person = (JSONObject) object;
				String firstName = (String)person.get("firstName");
				String lastName = (String)person.get("lastName");
				String address = (String)person.get("address");
				String city = (String)person.get("city");
				String state = (String)person.get("state");
				String zipCode = (String)person.get("zipCode");
				String phoneNumber = (String)person.get("phoneNumber");
				Person personData = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
				personLinkedList.add(personData);
			}
			
			String addressBookName = (String)addressBookDetails.get("addressBookName");
			long count = (long)addressBookDetails.get("count");
			addressbook.setAddressBook(personLinkedList);
			addressbook.setAddressBookName(addressBookName);
			addressbook.setCount(count);
		}
		catch(Exception e) {
			System.out.println("Error in getting addrress book information");
			//e.printStackTrace();
		}
		return addressbook;
	}
	
	/****************************************************************************************
	 * Function to add new entry to the AddressBook 
	 * 
	 * @param addressBook contains the list of the people where the new entry is to be added
	 * @return 
	 * @throws IOException 
	 ****************************************************************************************/
	public static List<Person> addPersonToNewList() {
		
		List<Person> addressBook = new LinkedList<>();
		
		System.out.println("Enter no of entries to be added in the address book:-");
		int noOfEntriesToBeAdded = Utility.integerInput();
		for(int i=0; i<noOfEntriesToBeAdded; i++) {
			System.out.println("Enter person's details for new entry in address book:-");
			System.out.println("Enter First Name:-");
			String firstName = stringInput();
			System.out.println("Enter Last Name:-");
			String lastName = stringInput();
			System.out.println("Enter address:-");
			String address = stringInput();
			System.out.println("Enter city:-");
			String city = stringInput();
			System.out.println("Enter state:-");
			String state = stringInput();
			System.out.println("Enter zipcode:-");
			String zipCode = stringInput();
			System.out.println("Enter phone number:-");
			String phoneNumber = stringInput();
			Person person = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
			addressBook.add(person);
		}
		System.out.println("New entry added to the address book");
		return addressBook;
	}
	
	/****************************************************************************************
	 * Function to add new entry to the AddressBook 
	 * 
	 * @param addressBook contains the list of the people where the new entry is to be added
	 * @return List<Person> contains the updated list
	 ****************************************************************************************/
	public static List<Person> addPersonToList(List<Person> listOfPerson) {
		
		List<Person> addressBook = new LinkedList<>();
		for(int i=0; i<listOfPerson.size(); i++) {
			addressBook.add(listOfPerson.get(i));
		}
		
		System.out.println("Enter no of entries to be added in the address book:-");
		int noOfEntriesToBeAdded = Utility.integerInput();
		for(int i=0; i<noOfEntriesToBeAdded; i++) {
			System.out.println("Enter person's details for new entry in address book:-");
			System.out.println("Enter First Name:-");
			String firstName = stringInput();
			System.out.println("Enter Last Name:-");
			String lastName = stringInput();
			System.out.println("Enter address:-");
			String address = stringInput();
			System.out.println("Enter city:-");
			String city = stringInput();
			System.out.println("Enter state:-");
			String state = stringInput();
			System.out.println("Enter zipcode:-");
			String zipCode = stringInput();
			System.out.println("Enter phone number:-");
			String phoneNumber = stringInput();
			Person person = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
			addressBook.add(person);
		}
		System.out.println("New entry added to the address book");
		return addressBook;
	}

	/****************************************************************************************
	 * Function to print all the person details in the addressBook
	 * 
	 * @param addressBook contains the list of the person details
	 ****************************************************************************************/
	public static void printAddressBook(List<Person> addressBook) {
		Iterator<Person> iterator=addressBook.iterator();  
		if(addressBook.isEmpty()) {
			System.out.println("Address Book is empty");
		}
		else {
			while(iterator.hasNext()){  
				  Person person = iterator.next();
			   System.out.println(person.getFirstName());  
			   System.out.println(person.getLastName());
			   System.out.println(person.getAddress());
			   System.out.println(person.getCity());
			   System.out.println(person.getState());
			   System.out.println(person.getZipCode());
			   System.out.println(person.getPhoneNumber());
			   System.out.println();
			}
		}
	}

	public static Person getPersonDetails(int index, List<Person> addressBook) {
		Person person = new Person();
		if(addressBook.isEmpty()){
			person = null;
		}
		else {
			for(int i=0; i<=index; i++) {
				person = addressBook.get(i);
			}
		}
		return person;
	}

	public static void printPersonDetails(Person person) {
		System.out.println("Name:- " + person.getFirstName() + " " + person.getLastName());
		System.out.println("Address:- " + person.getAddress());
		System.out.println("City:- " + person.getCity());
		System.out.println("State:- " + person.getState());
		System.out.println("Zipcode:- " + person.getZipCode());
		System.out.println("Phone Number:- " + person.getPhoneNumber());
	}

	/****************************************************************************************
	 * Function to update a person's details 
	 * 
	 * @param addressBook contains the list of the person details
	 * @param index to get the particular person object
	 * @return List<Person> contains the updated list
	 ****************************************************************************************/
	public static List<Person> updatePersonDetails(int index, List<Person> addressBook) {
		Person person = addressBook.get(index);
		Person newPerson = new Person();
		addressBook.remove(index);
		System.out.println("Enter details to update:-");
		newPerson.setFirstName(person.getFirstName());
		newPerson.setLastName(person.getLastName());
		System.out.println("Enter Address:-");
		newPerson.setAddress(stringInput());
		System.out.println("Enter City:-");
		newPerson.setCity(stringInput());
		System.out.println("Enter State:-");
		newPerson.setState(stringInput());
		System.out.println("Enter Zipcode:-");
		newPerson.setZipCode(stringInput());
		System.out.println("Enter Phone Number:-");
		newPerson.setPhoneNumber(stringInput());
		addressBook.add(newPerson);
		System.out.println("Details updated....");
		return addressBook;
	}
	
	/****************************************************************************************
	 * Function to search for a person and get the index value
	 * 
	 * @param addressBook contains the list of the person details
	 * @return index which contains the index value of the person on the address book
	 ****************************************************************************************/
	public static int searchPerson(List<Person> addressBook) {
		System.out.println("Enter person's full name:-");
		String fullName = stringInput();
		String[] name = fullName.split(" ");
		Person person = new Person();
		int index = 0;
		if(addressBook.isEmpty()){
			person = null;
		}
		else {
			Iterator<Person> iterator = addressBook.iterator();  
			  while(iterator.hasNext()){  
				  person = iterator.next();
				  if(person.getFirstName().equalsIgnoreCase(name[0]) && person.getLastName().equalsIgnoreCase(name[1]))
					  break;
				  index++;
			  }
		}
		return index;
	}

	/****************************************************************************************
	 * Function to delete a particular persons details from the address book
	 * 
	 * @param addressBook contains the list of the person details
	 * @param index to get the particular person object
	 * @return List<Person> contains the updated list
	 ****************************************************************************************/
	public static List<Person> deletePersonDetails(int index, List<Person> addressBook) {
		addressBook.remove(index);
		return addressBook;
		
	}

	/****************************************************************************************
	 * Function to sort Address book by name
	 * 
	 * @param addressBook contains the list of the person details
	 * @return List<Person> contains the updated list
	 ****************************************************************************************/
	public static void sortByName(List<Person> listOfPerson) {
		for(int i=0; i<listOfPerson.size()-1; i++) {
			for(int j=0; j<listOfPerson.size()-1-i; j++) {
				if(listOfPerson.get(j).getFirstName().compareToIgnoreCase(listOfPerson.get(j+1).getFirstName()) > 0) {
					Person person = listOfPerson.get(j+1);
					listOfPerson.set(j+1,listOfPerson.get(j));
					listOfPerson.set(j, person);
				}
			}
		}
	}

	/****************************************************************************************
	 * Function to sort Address book by name
	 * 
	 * @param addressBook contains the list of the person details
	 * @return List<Person> contains the updated list
	 ****************************************************************************************/
	public static void sortByZipcode(List<Person> listOfPerson) {
		for(int i=0; i<listOfPerson.size()-1; i++) {
			for(int j=0; j<listOfPerson.size()-1-i; j++) {
				Long zipcode1 = Long.parseLong(listOfPerson.get(j).getZipCode());
				Long zipcode2 = Long.parseLong(listOfPerson.get(j+1).getZipCode());
				if(zipcode1.compareTo(zipcode2) > 0) {
					Person person = listOfPerson.get(j+1);
					listOfPerson.set(j+1,listOfPerson.get(j));
					listOfPerson.set(j, person);
				}
			}
		}
	}
}

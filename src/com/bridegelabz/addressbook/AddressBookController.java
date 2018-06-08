package com.bridegelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.utils.Utility;

public class AddressBookController {
	
	List<String> listOfAddressBook;
	int addressBookCount = 0;

	public AddressBookController(String fileName){
		if(listOfAddressBook == null) {
			try {
				listOfAddressBook =  AddressBookUtility.jsonToJavaAddressBookList(fileName);
			}
			catch(Exception e) {
				System.out.println("No address Book created");
				listOfAddressBook = new LinkedList<>();
			}
		}
	}
	
	public List<String> getListOfAddressBook() {
		return listOfAddressBook;
	}

	public void setListOfAddressBook(List<String> listOfAddressBook) {
		this.listOfAddressBook = listOfAddressBook;
	}
	
	public int getAddressBookCount() {
		return listOfAddressBook.size();
	}
	
	public String toString() {
		Iterator<String> iterator = listOfAddressBook.iterator();
		int index = 1;
		while(iterator.hasNext()) {
			System.out.println(index + ". " + iterator.next());
			index++;
		}
		return "";
	}
	
	/*public void saveToAddressList(String fileName) {
			try {
				AddressBookUtility.javaObjectToJson(fileName, listOfAddressBook);
			}
			catch(Exception e) {
				System.out.println("Error in saving File");
			}
	}*/
	
	/****************************************************************************************
	 * Function to createNewAddressBook
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	public void createNewAddressBook(String fileLocation) {
		File file = new File(fileLocation);
		try {
			if(file.createNewFile()) {
				System.out.println("New Address Book created..");
			}
		}
		catch(IOException e) {
			System.out.println("Error in creating new Address Book");
		}
	}
	
	/****************************************************************************************
	 * Function to add person to the new Address Book created
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	public void addPersonToNewAddressBook(String fileName, String addressBookName) {
		Addressbook addressBook = new Addressbook();
		List<Person> listOfPerson = new LinkedList<>();
		listOfPerson = AddressBookUtility.addPersonToNewList();
		addressBook.setAddressBook(listOfPerson);
		addressBook.setAddressBookName(addressBookName);
		addressBook.setCount(listOfPerson.size());
		AddressBookUtility.javaObjectToJson(fileName, addressBook);
	}
	
	/****************************************************************************************
	 * Function to add person to the existing Address Book
	 * 
	 * @param listOfPerson contains the list from the addressBook
	 ****************************************************************************************/
	public List<Person> addPersonToAddressBook(List<Person> listOfPerson) {
		return AddressBookUtility.addPersonToList(listOfPerson);
	}
	
	/****************************************************************************************
	 * Function to remove person from the existing Address Book
	 * 
	 * @param listOfPerson contains the list from the addressBook
	 ****************************************************************************************/
	private List<Person> removePersonFromAddressBook(List<Person> listOfPerson) {
		int index = AddressBookUtility.searchPerson(listOfPerson);
		return AddressBookUtility.deletePersonDetails(index, listOfPerson);
		
	}
	
	/****************************************************************************************
	 * Function to update person details from the existing Address Book
	 * 
	 * @param listOfPerson contains the list from the addressBook
	 ****************************************************************************************/
	private List<Person> upadtePersonDetailsInAddressBook(List<Person> listOfPerson) {
		int index = AddressBookUtility.searchPerson(listOfPerson);
		return AddressBookUtility.updatePersonDetails(index, listOfPerson);
	}
	
	/****************************************************************************************
	 * Function to a particular addressBook from the list of Address Book
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	private void getPersonDetailsFromAddressBook(List<Person> listOfPerson) {
		int index = AddressBookUtility.searchPerson(listOfPerson);
		Person person = AddressBookUtility.getPersonDetails(index, listOfPerson);
		AddressBookUtility.printPersonDetails(person);
	}
	
	/****************************************************************************************
	 * Function to sort address book by name
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	private void sortAddressBookByName(List<Person> listOfPerson) {
		AddressBookUtility.sortByName(listOfPerson);
	}
	
	/****************************************************************************************
	 * Function to sort address book by name
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	private void sortAddressBookByZipcode(List<Person> listOfPerson) {
		AddressBookUtility.sortByZipcode(listOfPerson);
	}

	/****************************************************************************************
	 * Function to a particular addressBook from the list of Address Book
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	public void openAddressBook(int addressBookIndex) {
		Addressbook addressBook = new Addressbook();
		String fileName = "";
		for(int i=0; i<addressBookIndex; i++) {
			fileName = listOfAddressBook.get(i);
		}
		//System.out.println(fileName);
		fileName = "/home/administrator/javaprograms/objectorientedprograms/" + fileName + ".json";
		addressBook = AddressBookUtility.jsonToJava(fileName);
		int option = 0;
		while(option <= 6) {
			AddressBookUtility.printAddressBook(addressBook.getAddressBook());
			System.out.println("1. Add person to the address book");
			System.out.println("2. Delete person from the address book");
			System.out.println("3. updtae person details");
			System.out.println("4. Get person's details");
			System.out.println("5. Sort by name");
			System.out.println("6. Sort by Zipcode");
			System.out.println("7. Save changes");
			System.out.println("8. Exit");
			option = Utility.integerInput();
			switch(option) {
			case 1: 
				addressBook.setAddressBook(addPersonToAddressBook(addressBook.getAddressBook()));
				break;
		
			case 2:
				addressBook.setAddressBook(removePersonFromAddressBook(addressBook.getAddressBook()));
				break;
			
			case 3:
				addressBook.setAddressBook(upadtePersonDetailsInAddressBook(addressBook.getAddressBook()));
				break;
			
			case 4:
				getPersonDetailsFromAddressBook(addressBook.getAddressBook());
				break;
			
			case 5:
				sortAddressBookByName(addressBook.getAddressBook());
				break;
				
			case 6:
				sortAddressBookByZipcode(addressBook.getAddressBook());
				break;
				
			case 7:
				AddressBookUtility.javaObjectToJson(fileName, addressBook);
				break;
				
			case 8:
				System.out.println("Save changes and exit ?");
				System.out.println("Enter Yes or No");
				String answer = Utility.stringInput();
				if(answer.compareToIgnoreCase("Yes") == 0) {
					AddressBookUtility.javaObjectToJson(fileName, addressBook);
					return;
				}
				else {
					return;
				}
			}
		}
	}
	
	/****************************************************************************************
	 * Function to delete a Address book from Address book list
	 * 
	 * @param fileLocation to store the file in the given location
	 ****************************************************************************************/
	public void deleteAddressBook(int addressBookIndex) {
		listOfAddressBook.remove(addressBookIndex - 1);
		
	}

	public void addToAddressBookList(String addressBookName, String listFileName) {
		listOfAddressBook.add(addressBookName);
		AddressBookUtility.javaObjectToJson(listFileName, listOfAddressBook);
	}


}

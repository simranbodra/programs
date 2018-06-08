package com.bridegelabz.addressbook;


import com.bridgelabz.utils.Utility;

public class UserInterface {

	public static void main(String[] args) {
		String listFileName = "/home/administrator/javaprograms/objectorientedprograms/AddressBookList.json";
		
		AddressBookController controller = new AddressBookController(listFileName);
		System.out.println("Welcome to My AddressBook....");
		int choice = 0;
		while(choice < 4) {
			System.out.println("Menu:-");
			System.out.println("1. View list of Address Book");
			System.out.println("2. create a new Address Book");
			System.out.println("3. Exit");
			System.out.println("Enter your choice:-");
			choice = Utility.integerInput();
			Utility.stringInput();
			switch(choice) {
			case 1:
				if(controller.getAddressBookCount() == 0) {
					System.out.println("No Address Book created");
				}
				else {
					System.out.println(controller);
					System.out.println("Menu:-");
					System.out.println("1. Open Address Book");
					System.out.println("2. Delete Address Book");
					System.out.println("Enter choice:-");
					int optionForAddressBook = Utility.integerInput();
					switch(optionForAddressBook) {
					case 1:
						System.out.println("Enter number to open the Address Book:-");
						int option = Utility.integerInput();
						controller.openAddressBook(option);
						break;
						
					case 2:
						System.out.println("Enter numbre to delete the Address Book:-");
						int optionForDelete = Utility.integerInput();
						controller.deleteAddressBook(optionForDelete);
					}
				}
				break;
			
			case 2: 
				System.out.println("Enter name for the address Book:-");
				String addressBookName = Utility.stringInput();
				while(controller.getListOfAddressBook().contains(addressBookName)) {
					System.out.println("Address Book with this name already exits");
					System.out.println("Enter new name:-");
					addressBookName = Utility.stringInput();
				}
				String fileLocation = "/home/administrator/javaprograms/objectorientedprograms/" + addressBookName + ".json";
				controller.addToAddressBookList(addressBookName, listFileName);
				controller.createNewAddressBook(fileLocation);
				int answer = 0;
				while(answer != 2) {
					System.out.println("1. Add to address book");
					System.out.println("2. exit");
					System.out.println("Enter your choice:-");
					answer = Utility.integerInput();
					if(answer == 1)
						controller.addPersonToNewAddressBook(fileLocation, addressBookName);
					else {
						System.exit(0);
					}
				}
					break;
			
			case 3:
				System.exit(0);
			
			default:
				break;
			}
		}
	}

}

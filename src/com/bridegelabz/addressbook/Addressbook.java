package com.bridegelabz.addressbook;

import java.util.LinkedList;
import java.util.List;

public class Addressbook {
	 private List<Person> addressBook;
	 String addressBookName;
	 long count = 0;
	 

	Addressbook(){
		addressBook = new LinkedList<>();
	 }

	public List<Person> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List<Person> addressBook) {
		this.addressBook = addressBook;
	}
	
	public long getCount() {
		return addressBook.size();
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String toString() {
		return getAddressBookName();
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}
	
}













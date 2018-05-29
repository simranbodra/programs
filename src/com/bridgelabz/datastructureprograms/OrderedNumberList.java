package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructures.OrderedLinkedList;
import com.bridgelabz.utils.Utility;

public class OrderedNumberList {

	public static void main(String[] args) {
		OrderedLinkedList list = new OrderedLinkedList();
		String numbers = Utility.readListFile("numberList.text");
		String[] stringArray = Utility.splitString(numbers);
		Integer[] integerArray = Utility.toIntegerArray(stringArray);
		System.out.println("Enter the element to be searched:-");
		Integer searchElement = new Integer(Utility.integerInput());
		list = Utility.addNumbersToList(integerArray);
		list = Utility.searchNumber(list, searchElement);
		list.display();
	}

}

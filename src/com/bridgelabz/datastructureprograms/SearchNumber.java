package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructures.HashSet;
import com.bridgelabz.utils.Utility;

public class SearchNumber {

	public static void main(String[] args) {
		String numbers = Utility.readListFile("HashSetNumberList.text");
		String[] stringArray = Utility.splitString(numbers);
		HashSet numberSet = Utility.addNumbersToSet(stringArray);
		System.out.println("Enter the element to be searched:-");
		int searchElement = Utility.integerInput();
		numberSet = Utility.searchNumberFromSet(numberSet, searchElement);
		Utility.addToFile("HashSetNumberList.text", numberSet);
	}

}

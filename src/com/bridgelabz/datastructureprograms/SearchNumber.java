package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructures.HashSet;
import com.bridgelabz.utils.Utility;

public class SearchNumber {

	public static void main(String[] args) {
		HashSet numberSet = new HashSet(10);
		String numbers = Utility.readListFile("HashSetNumberList.text");
		String[] stringArray = Utility.splitString(numbers);
		//System.out.println("Enter the element to be searched:-");
		//Integer searchElement = Utility.integerInput();
		numberSet = Utility.addNumbersToSet(stringArray);
		//numberSet.display();
		//numberSet = Utility.searchNumberFromSet(numberSet, searchElement);
		//numberSet.display();
	}

}

package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class SortSearchEfficiency {

	public static void main(String[] args) {
		System.out.println("Enter the number of elements to store:-");
		int noOfElements = Integer.parseInt(Utility.stringInput());
		//Utility.createObjectArray(noOfElements);
		//Utility.bubbleSort(Utility.createObjectArray(noOfElements));
		//System.out.println("Enter String:-");
		//Utility.bubbleSort(Utility.createStringArray(Utility.stringInput()));
		//Utility.insertionSort(Utility.createObjectArray(noOfElements));
		Utility.binarySearchChecker(Utility.createObjectArray(noOfElements));

	}
}

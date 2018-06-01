package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructures.UnorderedLinkedList;
import com.bridgelabz.utils.Utility;

public class PrimeNumberArray {

	public static void main(String[] args) {
		UnorderedLinkedList<UnorderedLinkedList<Integer>> numberSet = Utility.addPrimeNumbersToSet();
		Utility.printPrimeNumbers(numberSet);
	}

}

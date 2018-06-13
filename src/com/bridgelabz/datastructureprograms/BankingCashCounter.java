package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.utils.Utility;

public class BankingCashCounter {

	public static void main(String[] args) {
		System.out.println("Enter the number of person in the queue:-");
		int noOfPerson = Utility.integerInput();
		Queue<Integer> people = Utility.addToQueue(noOfPerson);
		Utility.cashCounter(people);
	}

}

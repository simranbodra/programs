package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utils.Utility;

public class PalindromChecker {
	public static void main(String[] args) {
		System.out.println("Enter the string to check palindrom or not:-");
		String string = Utility.stringInput();
		if(Utility.checkForPalindrom(string)) 
			System.out.println("String is palindrom");
		else
			System.out.println("String is not palindrom");
	}
}

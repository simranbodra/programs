/******************************************************************************
 *  
 *  Purpose: to check if the two given Strings are Anagram or not
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class Anagram {

	public static void main(String[] args) {
		System.out.println("To check if the two strings are anagram or not");
		System.out.println("Enter the first string:-");
		String string1 = Utility.stringInput();
		System.out.println("Enter the second string:-");
		String string2 = Utility.stringInput();
		if(Utility.checkAnagram(string1, string2)) {
			System.out.println(string1 + " and " + string2 + " are Anagram");
		}
		else
			System.out.println(string1 + " and " + string2 + " are not Anagram");
		
	}

}
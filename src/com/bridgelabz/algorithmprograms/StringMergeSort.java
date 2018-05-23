/******************************************************************************
 *  
 *  Purpose: to sort the given String using merge sort technique
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class StringMergeSort {

	public static void main(String[] args) {
		System.out.println("Enter the String:-");
		String string = Utility.stringInput();
		Utility.stringMergeSort(string);
	}

}

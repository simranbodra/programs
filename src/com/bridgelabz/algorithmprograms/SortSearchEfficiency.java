/******************************************************************************
 *  
 *  Purpose: to check the efficiency of different sorting and searching technique
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class SortSearchEfficiency {

	public static void main(String[] args) {
		int[] array = Utility.createIntegerArray();
		Utility.integerBinarySearchChecker(array);
		Utility.integerInsertionSort();
		Utility.integerBubbleSort();
		String string = Utility.stringInput();
		Utility.stringBinarySearch(string);
		Utility.stringInsertionSort(string);
		Utility.stringBubbleSort(string);
		
	}

}
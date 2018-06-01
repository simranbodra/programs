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
		
		//************************Integer Binary Search******************************************
		Integer[] array = Utility.createIntegerObjectArray();
		System.out.println("Enter the element to be searched:-");
		Integer searchElement = Utility.integerInput();
		Utility.binarySearchChecker(array, searchElement);
		
		//************************Integer Insertion Sort*****************************************
		
		Utility.insertionSort(array);
		
		//************************Integer Bubble Sort*****************************************
		
		Utility.bubbleSort(array);
		
		//*************************String Binary Search*******************************************
		Utility.stringInput();
		System.out.println("Enter String");
		String string = Utility.stringInput();
		String[] stringArray = Utility.splitString(string);
		System.out.println("Enter the element to be searched:-");
		String searchStringElement = Utility.stringInput();
		Utility.binarySearchChecker(stringArray, searchStringElement);
		
		//************************String Insertion Sort*****************************************
		
		Utility.insertionSort(stringArray);
		
		//************************String Bubble Sort***********************************************
		
		Utility.bubbleSort(stringArray);
		
	}

}
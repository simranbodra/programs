/******************************************************************************
 *  
 *  Purpose: to print a 2D array reading integers, doubles or booleans
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   18-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class TwoDArray {

	public static void main(String[] args) {
		System.out.println("Enter the number of rows:-");
		int noOfRows = Integer.parseInt(Utility.stringInput());
		System.out.println("Enter the number of columns:-");
		int noOfColumns = Integer.parseInt(Utility.stringInput());
		System.out.println("Enter the input :-");
		Utility.printAarray(noOfRows, noOfColumns);	
	}

}

/******************************************************************************
 *  
 *  Purpose: to find the square root of the number using Newton's method
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println("Enter a non negative number:-");
		int number = Utility.integerInput();
		double squareRoot = Utility.sqrt(number);
		System.out.println("SquareRoot is " + squareRoot);
	}

}

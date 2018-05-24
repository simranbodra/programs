/******************************************************************************
 *  
 *  Purpose: to convert from decimal to binary, swap the nibbles and 
	* check if the returned number is power of two
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class BinaryToDecimal {

	public static void main(String[] args) {
		System.out.println("Enter a value");
		int decimal = Utility.integerInput();
		Utility.toDecimal(decimal);
	}

}

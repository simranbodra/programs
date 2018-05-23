/******************************************************************************
 *  
 *  Purpose: to convert decimal number to binary representation
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println("Enter decimal number:-");
		int number = Utility.integerInput();
		System.out.println(Utility.toBinary(number));
	}

}

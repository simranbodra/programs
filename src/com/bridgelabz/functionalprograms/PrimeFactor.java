/******************************************************************************
 *  
 *  Purpose: to print the prime factorization of the given number
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class PrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number:-");
		String input = Utility.input();
		int number = Integer.parseInt(input);
		Utility.primeFactorsOfNumber(number);
		
	}

}

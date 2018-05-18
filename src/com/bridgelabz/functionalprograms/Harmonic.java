/******************************************************************************
 *  
 *  Purpose: to print the harmonic value of Nth number
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Harmonic {

	public static void main(String[] args) {
		System.out.println("Enter the value of N to get Nth harmonic number:-");
		int times = Utility.integerInput();
		Utility.harmonicValue(times);
		

	}

}
